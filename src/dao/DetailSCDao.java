package dao;

import bean.sc.DetailSc;
import bean.sc.DetailSCList;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/6/4.
 */
public class DetailSCDao {

    /**
     * 获取选课情况
     * @param clzno 课程号
     * @return DetailSC列表
     */
    public static DetailSCList quertSelectScs(int clzno){
        DetailSCList scs = new DetailSCList();
        List<DetailSc> list = new ArrayList<>();
        String sql = "SELECT * FROM sc_view WHERE clzno=?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, clzno);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DetailSc sc = new DetailSc();
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


}
