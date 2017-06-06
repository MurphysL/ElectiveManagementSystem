package dao;

import bean.stu.Student;
import bean.stu.StudentList;
import config.Config;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 学生查询类
 */
public class StudentDao {

    /**
     * 登录
     * @param sno 学号
     * @param password 密码
     * @return 学生实体类
     */
    public static Student login(int sno, String password){
        Student student = null;
        String sql = "SELECT * FROM student WHERE sno=? AND password=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                student = new Student();
                student.setSno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setSex(rs.getString(3));
                student.setDept(rs.getString(4));
                student.setPassword(rs.getString(5));
                student.setAvatar(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 查询学生总数
     * @return 学生总数
     */
    public static int queryStudentCount(){
        int num = 0 ;
        String sql = "SELECT count(*) FROM student";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                num = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 添加学生信息
     * @param sno 学号
     * @param name 姓名
     * @param sex 性别
     * @param dept 院系
     * @param password 密码
     * @return 是否添加成功
     */
    public static boolean insertStudent(int sno, String name, String sex, String dept, String password){
        String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?)";
        Random random = new Random();
        String avatar = String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)); // 头像
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setString(2, name);
            ps.setString(3, sex);
            ps.setString(4, dept);
            ps.setString(5, password);
            ps.setString(6, avatar);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 通过学号查找学生
     * @param sno
     * @return
     */
    public static Student queryStudentById(int sno){
        Student student = null;
        String sql = "SELECT * FROM student WHERE Sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                student = new Student();
                student.setSno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setSex(rs.getString(3));
                student.setDept(rs.getString(4));
                student.setPassword(rs.getString(5));
                student.setAvatar(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    /**
     * 查询全部学生信息（分页）
     * @param page 页数
     * @return 学生包装类
     */
    public static StudentList queryPagingStudent(int page){
        StudentList students = new StudentList();
        List<Student> list = new ArrayList<>();
        int sum = 0;

        String sql = "SELECT * FROM student LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM student";
        int start = (page-1)* Config.ADMIN_PAGE_NUM;
        int num = Config.ADMIN_PAGE_NUM;
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setSex(rs.getString(3));
                student.setDept(rs.getString(4));
                student.setPassword(rs.getString(5));
                student.setAvatar(rs.getString(6));
                list.add(student);
            }

            PreparedStatement ps2 = ConnUtil.getConn().prepareStatement(sql2);
            sum = ps2.executeQuery().getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        students.setList(list);
       /* students.setNum(sum);*/
        return students;
    }

    /**
     * 学生信息更新
     * @param sno 学号
     * @param name 姓名
     * @param sex 性别
     * @param dept 院系
     * @param password 密码
     * @param avatar 头像
     * @return 是否更新成功
     */
    public static boolean updateStudent(int sno, String name, String sex, String dept, String password, String avatar){
        String sql = "UPDATE student SET name=?, sex=?, dept=?, password=?, avatar=? WHERE sno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, dept);
            ps.setString(4, password);
            ps.setString(5, avatar);
            ps.setInt(6, sno);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除学生信息
     * @param sno 学号
     * @return 是否删除成功
     */
    public static boolean deleteStudent(int sno){
        String sql = "DELETE FROM student WHERE sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
