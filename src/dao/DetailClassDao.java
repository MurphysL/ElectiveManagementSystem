package dao;

import bean.clz.DetailClass;
import bean.clz.DetailClassList;
import config.Config;
import util.ConnUtil;

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
     * 查询教师授课记录（分页）（时间降序排列）
     * @param tno 教工号
     * @return 课程列表
     */
    public static DetailClassList queryPagingClass4Teacher(int tno, int page){
        DetailClassList classes = new DetailClassList();
        List<DetailClass> list = new ArrayList<>();

        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int num = Config.PAGE_BLOG_NUM;
        String sql = "SELECT * FROM detail_clz WHERE tno = ?  ORDER BY start DESC  LIMIT ? , ?";

        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, tno);
            ps.setInt(2, start);
            ps.setInt(3, num);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass clz = new DetailClass();
                clz.setClzno(rs.getInt(1));
                clz.setStart(rs.getLong(2));
                clz.setAddress(rs.getString(3));
                clz.setCno(rs.getInt(4));
                clz.setCname(rs.getString(5));
                clz.setCredit(rs.getInt(6));
                clz.setDuration(rs.getInt(7));
                clz.setTno(rs.getInt(8));
                clz.setTname(rs.getString(9));
                clz.setSex(rs.getString(10));
                list.add(clz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        classes.setList(list);
        return classes;
    }

    /**
     * 查询教师授课记录数量
     * @param tno 教工号
     * @return 记录数量
     */
    public static int getClzCount4Teacher(int tno){
        int num = 0;
        String sql = "SELECT count(*) FROM detail_clz WHERE tno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, tno);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                num = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 查询课程详细信息
     * @param clzno 课程号
     * @return 课程信息
     */
    public static DetailClass queryDetailClass(int clzno){
        DetailClass clz = null;
        String sql ="SELECT * FROM detail_clz WHERE clzno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, clzno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clz = new DetailClass();
                clz.setClzno(rs.getInt(1));
                clz.setStart(rs.getLong(2));
                clz.setAddress(rs.getString(3));
                clz.setCno(rs.getInt(4));
                clz.setCname(rs.getString(5));
                clz.setCredit(rs.getInt(6));
                clz.setDuration(rs.getInt(7));
                clz.setTno(rs.getInt(8));
                clz.setTname(rs.getString(9));
                clz.setSex(rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clz;
    }

    /**
     * 查询课程数量
     * @return 返回课程总数量
     */
    public static int getClzCount(){
        int num = 0;
        String sql = "SELECT count(*) FROM detail_clz";
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
     * 查询全部课程信息
     * @param page 页数
     * @return 课程包装类
     */
    public static DetailClassList queryPagingDetailClasses(int page){
        DetailClassList classes = new DetailClassList();
        List<DetailClass> list = new ArrayList<>();
        String sql = "SELECT * FROM detail_clz LIMIT ?, ?";
        int start = (page-1)* Config.ADMIN_PAGE_NUM;
        int end = Config.ADMIN_PAGE_NUM;
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass detailClass = new DetailClass();
                detailClass.setClzno(rs.getInt(1));
                detailClass.setStart(rs.getLong(2));
                detailClass.setAddress(rs.getString(3));
                detailClass.setCno(rs.getInt(4));
                detailClass.setCname(rs.getString(5));
                detailClass.setCredit(rs.getInt(6));
                detailClass.setDuration(rs.getInt(7));
                detailClass.setTno(rs.getInt(8));
                detailClass.setTname(rs.getString(9));
                detailClass.setSex(rs.getString(10));
                list.add(detailClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        classes.setList(list);
        return classes;
    }

    /**
     * 删除课程
     * @param clzno 课程号
     * @return 是否删除成功
     */
    public static boolean deleteDetailClass(int clzno){
        String sql = "DELETE FROM class WHERE clzno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, clzno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取可选课程数目
     * @param sno 学号
     * @return 可选课程数目
     */
    public static int getClass4StudentCount(int sno){
        int num = 0;
        String sql = "SELECT * FROM detail_clz WHERE clzno NOT IN (SELECT clzno FROM sc WHERE sno= ?)";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ResultSet rs2 = ps.executeQuery();
            if(rs2.next()){
                num = rs2.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    /**
     * 查询可选课程（分页）
     * @param sno 学号
     * @param page 页数
     * @return 详细课程包装类
     */
    public static DetailClassList queryPagingClass4Student(int sno, int page){
        DetailClassList detailClassList = new DetailClassList();
        List<DetailClass> list = new ArrayList<>();
        String sql = "SELECT * FROM detail_clz WHERE clzno NOT IN (SELECT clzno FROM sc WHERE sno= ?) LIMIT ?, ?";
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = Config.PAGE_BLOG_NUM;
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailClass detailClass = new DetailClass();
                detailClass.setClzno(rs.getInt(1));
                detailClass.setStart(rs.getLong(2));
                detailClass.setAddress(rs.getString(3));
                detailClass.setCno(rs.getInt(4));
                detailClass.setCname(rs.getString(5));
                detailClass.setCredit(rs.getInt(6));
                detailClass.setDuration(rs.getInt(7));
                detailClass.setTno(rs.getInt(8));
                detailClass.setTname(rs.getString(9));
                detailClass.setSex(rs.getString(10));
                list.add(detailClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        detailClassList.setList(list);
        return detailClassList;
    }
}
