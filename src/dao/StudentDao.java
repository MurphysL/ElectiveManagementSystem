package dao;

import bean.Student;
import bean.StudentWrapper;
import com.sun.istack.internal.NotNull;
import config.Config;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "SELECT * FROM student WHERE Sno=? AND password=?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                student = new Student();
                student.setSno(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setSsex(rs.getString(3));
                student.setSdept(rs.getString(4));
                student.setPassword(rs.getString(5));
                student.setAvatar(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 插入学生信息
     * @param student 学生实体
     * @return 学生实体
     */
    public static Student insertStudent(@NotNull Student student){
        Student stu = null;
        String sql = "INSERT student VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, student.getSno());
            ps.setString(2, student.getSname());
            ps.setString(3, student.getSsex());
            ps.setString(4, student.getSdept());
            ps.setString(5, student.getPassword());
            ps.setString(6, student.getAvatar());

            if(ps.executeUpdate() > 0){
                stu = student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stu;
    }

    /**
     *
     * @param sno
     * @return
     */
    public static Student queryStudentById(int sno){
        Student student = null;
        String sql = "SELECT * FROM student WHERE Sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                student = new Student();
                student.setSno(sno);
                while (rs.next()){
                    student.setSname(rs.getString(2));
                    student.setSsex(rs.getString(3));
                    student.setSdept(rs.getString(4));
                }
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
    public static StudentWrapper queryPagingStudent(int page){
        StudentWrapper students = new StudentWrapper();
        List<Student> list = new ArrayList<>();
        int sum = 0;

        String sql = "SELECT * FROM student LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM student";
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int num = Config.PAGE_BLOG_NUM;
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setSsex(rs.getString(3));
                student.setSdept(rs.getString(4));
                student.setPassword(rs.getString(5));
                student.setAvatar(rs.getString(6));
                list.add(student);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(sql2);
            sum = ps2.executeQuery().getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        students.setList(list);
        students.setNum(sum);
        return students;
    }

    /**
     * 学生信息更新
     * @param sno 学号
     * @param sname 姓名
     * @param ssex 性别
     * @param sdept 院系
     * @param password 密码
     * @return 是否更新成功
     */
    public static boolean updateStudent(int sno, String sname, String ssex, String sdept, String password){
        String sql = "UPDATE student SET Sname=?, Ssex=?, Sdept=?, password=? WHERE Sno=?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setString(1, sname);
            ps.setString(2, ssex);
            ps.setString(3, sdept);
            ps.setString(4, password);
            ps.setInt(5, sno);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteStudent(int sno){
        String sql = "DELETE FROM student WHERE Sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
