package dao;

import bean.course.Course;
import bean.course.Courses;
import config.Config;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 科目查询类
 */
@Deprecated
public class CourseDao {

    /**
     * 查询已先科目
     * @param sno 学号
     * @return 课程包装类
     */
    /*public static Courses quertSeletedCourses(int sno){
        Courses courses = new Courses();
        List<Course> list = new ArrayList<>();
        int num = 0;
        String sql = "SELECT * FROM course , sc WHERE course.Cno = sc.Cno AND Sno = ? ";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setCcredit(rs.getInt(3));
                course.setCname(rs.getString(2));
                list.add(course);
                num ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        courses.setNum(num);
        courses.setCourses(list);
        return courses;
    }*/

    /*public static Courses quertSeletedPagingCourses(int sno, int page){
        Courses courses = new Courses();
        List<Course> list = new ArrayList<>();
        int num = 0;

        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        String sql = "SELECT * FROM course , sc WHERE course.Cno = sc.Cno AND Sno = ? LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM course , sc WHERE course.Cno = sc.Cno AND Sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCcredit(rs.getInt(3));
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                list.add(course);
            }

            PreparedStatement ps2 = ConnUtil.getConn().prepareStatement(sql2);
            ps2.setInt(1, sno);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        courses.setNum(num);
        courses.setCourses(list);
        return courses;
    }*/

    /**
     * 查询学生目前可选科目（分页)
     * @param sno 学生学号
     * @param page 页数
     * @return 科目包装类
     */
    /*public static Courses queryPagingCourses(int sno, int page){
        Courses courses = new Courses();
        int num = 0;
        List<Course> list = new ArrayList<>();
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        String sql = "SELECT * FROM course WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?) LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM course WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?)";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setCno(rs.getInt(1));
                course.setCname(rs.getString(2));
                course.setCcredit(rs.getInt(3));
                list.add(course);
            }

            PreparedStatement ps2 = ConnUtil.getConn().prepareStatement(sql2);
            ps2.setInt(1, sno);

            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        courses.setCourses(list);
        courses.setNum(num);

        return courses;
    }*/
}
