package dao;

import bean.sc.DetailSC;
import bean.sc.DetailSCList;
import config.Config;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DetailSCDao {

    /**
     * 获取选课情况
     * @param clzno 课程号
     * @return DetailSC列表
     */
    public static DetailSCList quertSelectScs(int clzno){
        DetailSCList scs = new DetailSCList();
        List<DetailSC> list = new ArrayList<>();
        String sql = "SELECT * FROM sc_view WHERE clzno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, clzno);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailSC sc = new DetailSC();
                sc.setClzno(rs.getInt(1));
                sc.setStart(rs.getLong(2));
                sc.setAddress(rs.getString(3));
                sc.setCno(rs.getInt(4));
                sc.setCname(rs.getString(5));
                sc.setCredit(rs.getInt(6));
                sc.setDuration(rs.getInt(7));
                sc.setTno(rs.getInt(8));
                sc.setTname(rs.getString(9));
                sc.setTsex(rs.getString(10));
                sc.setSno(rs.getInt(11));
                sc.setSname(rs.getString(12));
                sc.setSsex(rs.getString(13));
                sc.setDept(rs.getString(14));
                sc.setAvatar(rs.getString(15));
                sc.setGrade(rs.getInt(16));
                list.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scs.setList(list);
        return scs;
    }

    /**
     * 查询已选课程（分页）
     * @param sno 学号
     * @param page 页数
     * @return 详细课程包装类
     */
    public static DetailSCList querySelectedPagingDetailSC(int sno, int page){
        DetailSCList detailSCList = new DetailSCList();
        List<DetailSC> list = new ArrayList<>();
        String sql = "SELECT * FROM sc_view WHERE sno = ? LIMIT ?, ?";
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = Config.PAGE_BLOG_NUM;
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailSC sc = new DetailSC();
                sc.setClzno(rs.getInt(1));
                sc.setStart(rs.getLong(2));
                sc.setAddress(rs.getString(3));
                sc.setCno(rs.getInt(4));
                sc.setCname(rs.getString(5));
                sc.setCredit(rs.getInt(6));
                sc.setDuration(rs.getInt(7));
                sc.setTno(rs.getInt(8));
                sc.setTname(rs.getString(9));
                sc.setTsex(rs.getString(10));
                sc.setSno(rs.getInt(11));
                sc.setSname(rs.getString(12));
                sc.setSsex(rs.getString(13));
                sc.setDept(rs.getString(14));
                sc.setAvatar(rs.getString(15));
                sc.setGrade(rs.getInt(16));
                list.add(sc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        detailSCList.setList(list);
        return detailSCList;
    }

    /**
     * 查询已选课程数目
     * @param sno 学号
     * @return 课程数目
     */
    public static int getSelectedSCCount(int sno){
        int num = 0;
        String sql = "SELECT count(*) FROM sc_view WHERE sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                num = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    /**
     * 查询选课详细
     * @param clzno 课程号
     * @param sno 学号
     * @return 选课详细
     */
    public static DetailSC queryDetailSC(int clzno, int sno){
        DetailSC sc = null;
        String sql = "SELECT * FROM sc_view WHERE clzno=? AND sno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, clzno);
            ps.setInt(2, sno);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sc = new DetailSC();
                sc.setClzno(rs.getInt(1));
                sc.setStart(rs.getLong(2));
                sc.setAddress(rs.getString(3));
                sc.setCno(rs.getInt(4));
                sc.setCname(rs.getString(5));
                sc.setCredit(rs.getInt(6));
                sc.setDuration(rs.getInt(7));
                sc.setTno(rs.getInt(8));
                sc.setTname(rs.getString(9));
                sc.setTsex(rs.getString(10));
                sc.setSno(rs.getInt(11));
                sc.setSname(rs.getString(12));
                sc.setSsex(rs.getString(13));
                sc.setDept(rs.getString(14));
                sc.setAvatar(rs.getString(15));
                sc.setGrade(rs.getInt(16));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sc;
    }


}
