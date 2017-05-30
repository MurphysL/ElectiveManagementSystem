package dao;

import bean.Teacher;
import bean.clz.DetailClass;
import bean.clz.DetailClasses;
import config.Config;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师数据库管理类
 */
public class TeacherDao {
    /**
     * 教师登录类
     * @param tno 教师号
     * @param password 密码
     * @return 教师实体类
     */
    public static Teacher login(int tno, String password){
        Teacher teacher = null;
        String sql ="SELECT * FROM teacher WHERE Tno = ? AND password = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, tno);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teacher = new Teacher();
                teacher.setTno(rs.getInt(1));
                teacher.setTname(rs.getString(2));
                teacher.setTsex(rs.getString(3));
                teacher.setPassword(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }

    /**
     * 查询授课历史（包括本学期）（分页）（时间降序排列）
     * @param tno 教师号
     * @return 课程包装类
     */
    public static DetailClasses queryPagingClasses(int tno, int page){
        DetailClasses classes = new DetailClasses();
        List<DetailClass> list = new ArrayList<>();
        int num = 0;

        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        String sql = "SELECT * FROM clz_view WHERE Tno = ?  ORDER BY Time DESC  LIMIT ? , ?";
        String sql2 = "SELECT count(*) FROM clz_view WHERE Tno = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, tno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass clz = new DetailClass();
                clz.setCno(rs.getInt(1));
                clz.setCname(rs.getString(2));
                clz.setCcredit(rs.getInt(3));
                clz.setTno(rs.getInt(4));
                clz.setTname(rs.getString(5));
                clz.setTsex(rs.getString(6));
                clz.setTime(rs.getLong(8));
                clz.setAddress(rs.getString(7));
                list.add(clz);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(sql2);
            ps2.setInt(1, tno);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        classes.setNum(num);
        classes.setList(list);
        return classes;
    }
}
