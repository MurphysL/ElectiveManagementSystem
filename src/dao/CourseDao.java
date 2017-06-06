package dao;

import bean.course.Course;
import bean.course.CourseList;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 科目查询类
 */
public class CourseDao {

    /**
     * 查询全部科目
     * @return 科目列表
     */
    public static CourseList queryCourse(){
        CourseList courseList = new CourseList();
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setName(rs.getString(2));
                course.setCredit(rs.getInt(3));
                course.setDuration(rs.getInt(4));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        courseList.setList(list);
        return courseList;
    }

    /**
     * 查询科目总数
     * @return 科目总数
     */
    public static int queryCourseCount(){
        int count = 0;
        String sql = "SELECT count(*) FROM course";
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
     * 插入科目
     * @param name 科目名
     * @param credit 学分
     * @param duration 持续周长
     * @return 是否添加成功
     */
    public static boolean insertCourse(String name, int credit, int duration){
        String sql = "INSERT INTO course(name, credit, duration) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, credit);
            ps.setInt(3, duration);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新科目
     * @param cno 科目号
     * @param name 科目名
     * @param credit 学分
     * @param duration 周数
     * @return 是否更新成功
     */
    public static boolean updateCourse(int cno, String name, int credit, int duration){
        String sql = "UPDATE course SET name=?, credit=?, duration=? WHERE cno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, credit);
            ps.setInt(3, duration);
            ps.setInt(4, cno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除科目
     * @param cno 科目号
     * @return 是否删除成功
     */
    public static boolean deleteCourse(int cno){
        String sql = "DELETE FROM course WHERE cno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, cno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
