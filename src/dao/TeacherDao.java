package dao;

import bean.teacher.Teacher;
import bean.teacher.TeacherList;
import bean.clz.DetailClass;
import bean.clz.DetailClassList;
import config.Config;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 教师数据库管理类
 */
public class TeacherDao {

    /**
     * 教师登录类
     * @param tno 教工号
     * @param password 密码
     * @return 教师实体类
     */
    public static Teacher login(int tno, String password){
        Teacher teacher = null;
        String sql ="SELECT * FROM teacher WHERE tno = ? AND password = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, tno);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teacher = new Teacher();
                teacher.setTno(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setSex(rs.getString(3));
                teacher.setPassword(rs.getString(4));
                teacher.setAvatar(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    /**
     * 查询指定教师
     * @param tno 教工号
     * @return 教师实体类
     */
    public static Teacher query(int tno){
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE tno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, tno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                teacher = new Teacher();
                teacher.setTno(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setSex(rs.getString(3));
                teacher.setPassword(rs.getString(4));
                teacher.setAvatar(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }


    /**
     * 插入教师信息
     * @param name 教师名
     * @param sex 教师性别
     * @param password 密码
     * @return 是否成功
     */
    public static boolean insertTeacher(String name, String sex, String password){
        String sql = "INSERT INTO teacher(name, sex, password, avatar) VALUES(?, ?, ?, ?)";
        Random random = new Random();
        String avatar = String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000));
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, password);
            ps.setString(4, avatar);

            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新教师信息
     * @param tno 教工号
     * @param name 姓名
     * @param sex 性别
     * @param password 密码
     * @return 是否成功
     */
    public static boolean updateTeacher(int tno, String name, String sex, String password, String avatar){
        String sql = "UPDATE teacher SET name=?, sex=?, password=?, avatar = ? WHERE tno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, password);
            ps.setString(4, avatar);
            ps.setInt(5, tno);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除教师
     * @param tno 教师号
     * @return 是否删除成功
     */
    public static boolean deleteTeacher(int tno){
        String sql = "DELETE FROM teacher WHERE tno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, tno);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询教师总数
     * @return 教师总数
     */
    public static int queryTeacherCount(){
        int count = 0;
        String sql = "SELECT count(*) FROM teacher";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 查询所有教师信息（分页）
     * @param page 页数
     * @return 教师包装类
     */
    public static TeacherList queryPagingTeachers(int page){
        TeacherList teachers = new TeacherList();
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM teacher LIMIT ?, ?";
        int start = (page-1)* Config.ADMIN_PAGE_NUM;
        int num = Config.ADMIN_PAGE_NUM;

        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTno(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setSex(rs.getString(3));
                teacher.setPassword(rs.getString(4));
                teacher.setAvatar(rs.getString(5));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        teachers.setList(list);
        return teachers;
    }

}
