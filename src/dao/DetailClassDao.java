package dao;

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
 * 详细课程类
 */
public class DetailClassDao {

    /**
     * 查询详细课程（分页）
     * @param sno 学号
     * @param page 页数
     * @return 详细课程包装类
     */
    public static DetailClasses queryPagingDetailClasses(int sno, int page){
        DetailClasses detailClasses = new DetailClasses();
        int num = 0;
        List<DetailClass> list = new ArrayList<>();
        String sql = "SELECT * FROM clz_view WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?) LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM clz_view WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?)";
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass detailClass = new DetailClass();
                detailClass.setCno(rs.getInt(1));
                detailClass.setCname(rs.getString(2));
                detailClass.setCcredit(rs.getInt(3));
                detailClass.setTno(rs.getInt(4));
                detailClass.setTname(rs.getString(5));
                detailClass.setTsex(rs.getString(6));
                detailClass.setAddress(rs.getString(7));
                detailClass.setTime(rs.getLong(8));
                list.add(detailClass);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(sql2);
            ps2.setInt(1, sno);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        detailClasses.setNum(num);
        detailClasses.setList(list);
        return detailClasses;
    }

    /**
     * 查询已选课程（分页）
     * @param sno 学号
     * @param page 页数
     * @return 详细课程包装类
     */
    public static DetailClasses querySelectedPagingDetailClasses(int sno, int page){
        DetailClasses detailClasses = new DetailClasses();
        int num = 0;
        List<DetailClass> list = new ArrayList<>();
        String sql = "SELECT * FROM clz_view,sc WHERE clz_view.Cno = sc.Cno AND clz_view.Tno = sc.Tno AND Sno = ? LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM clz_view,sc WHERE clz_view.Cno = sc.Cno AND clz_view.Tno = sc.Tno AND Sno = ?";
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(2, start);
            ps.setInt(1, sno);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass detailClass = new DetailClass();
                detailClass.setCname(rs.getString(2));
                detailClass.setCno(rs.getInt(1));
                detailClass.setCcredit(rs.getInt(3));
                detailClass.setTno(rs.getInt(4));
                detailClass.setTname(rs.getString(5));
                detailClass.setTsex(rs.getString(6));
                detailClass.setAddress(rs.getString(7));
                detailClass.setTime(rs.getLong(8));
                list.add(detailClass);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(sql2);
            ps2.setInt(1, sno);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        detailClasses.setNum(num);
        detailClasses.setList(list);
        return detailClasses;
    }

    /**
     * 查询课程详细信息
     * @param cno 科目号
     * @param tno 教师号
     * @return 课程信息
     */
    public static DetailClass queryDetailClass(int cno, int tno){
        DetailClass detailClass = null;
        String sql ="SELECT * FROM clz_view WHERE cno = ? AND tno = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                detailClass = new DetailClass();
                detailClass.setCno(rs.getInt(1));
                detailClass.setCname(rs.getString(2));
                detailClass.setCcredit(rs.getInt(3));
                detailClass.setTno(rs.getInt(4));
                detailClass.setTname(rs.getString(5));
                detailClass.setTsex(rs.getString(6));
                detailClass.setAddress(rs.getString(7));
                detailClass.setTime(rs.getLong(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailClass;
    }
}
