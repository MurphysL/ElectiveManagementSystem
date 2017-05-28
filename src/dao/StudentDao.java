package dao;

import bean.Student;
import com.sun.istack.internal.NotNull;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
