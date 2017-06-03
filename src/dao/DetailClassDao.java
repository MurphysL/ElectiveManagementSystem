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
     * 查询全部课程信息
     * @param page 页数
     * @return 课程包装类
     */
    public static DetailClasses queryPagingDetailClasses(int page){
        DetailClasses classes = new DetailClasses();
        List<DetailClass> list = new ArrayList<>();
        int num = 0;
        String sql = "SELECT * FROM clz_view LIMIT ?, ?";
        String sql2 = "SELECT count(*) FROM clz_view";
        int start = (page-1)* Config.ADMIN_PAGE_NUM;
        int end = Config.ADMIN_PAGE_NUM;
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass detailClass = new DetailClass();
                detailClass.setCname(rs.getString(2));
                detailClass.setCcredit(rs.getInt(3));
                detailClass.setCno(rs.getInt(1));
                detailClass.setTno(rs.getInt(4));
                detailClass.setTname(rs.getString(5));
                detailClass.setTsex(rs.getString(6));
                detailClass.setAddress(rs.getString(7));
                detailClass.setTime(rs.getLong(8));
                list.add(detailClass);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        classes.setList(list);
        classes.setNum(num);
        return classes;
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

    /**
     * 删除课程
     * @param cno 科目号
     * @param tno 教工号
     * @param time 开课时间
     * @return 是否删除成功
     */
    public static boolean deleteDetailClass(int cno, int tno, long time){
        String sql = "DELETE FROM class WHERE Cno = ? AND Tno = ? AND Time = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setLong(3, time);
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 更新详细课程
     * @param cno 课程号
     * @param cname 课程名
     * @param credit 学分
     * @param tno 教工号
     * @param tname 教师名
     * @param tsex 性别
     * @param address 上课地址
     * @param time 上课时间
     * @return 是否更新成功
     */
    public static boolean updateDetailClass(int cno, String cname, int credit, int tno, String tname,
                                            String tsex, String address, Long time){
        return true;
    }
}
