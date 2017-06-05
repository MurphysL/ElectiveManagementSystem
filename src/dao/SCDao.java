package dao;

import util.ConnUtil;
import util.TimeUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 选课信息类
 */
public class SCDao {

    /**
     * 查询当前选课状态
     * @param sno 学号
     * @return 是否已选课
     */
    public static boolean queryThisTerm(int sno){
        long[] term = TimeUtil.getTermTimeStamp();
        System.out.println("term" + term[0] + " " + term[1]);
        String sql = "SELECT * FROM sc_view WHERE sno = ? AND start >= ? AND start <= ?";
        try {
            PreparedStatement ps  = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setLong(2, term[0]);
            ps.setLong(3, term[1]);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 选课
     * @param clzno 课程号
     * @param sno 学号
     * @return 更改条数
     */
    public static boolean insertClass(int clzno, int sno){
        if(queryThisTerm(sno)){ // 已选课程
            if(deleteClass(sno)){ // 删除课程
                System.out.println("删除成功");
                String sql = "INSERT sc(clzno, sno) VALUES (?, ?)";
                try {
                    PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
                    ps.setInt(1, clzno);
                    ps.setInt(2, sno);
                    if(ps.executeUpdate() > 0)
                        return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 退课（本学期）
     * @param sno 学号
     * @return 是否更改成功
     */
    private static boolean deleteClass(int sno){
        long[] terms = TimeUtil.getTermTimeStamp();
        if(queryThisTerm(sno)){
            String sql1 = "SELECT clzno FROM sc_view WHERE sno = ? AND start >= ? AND start <= ?";
            String sql = "DELETE FROM sc WHERE clzno =?";
            try {
                PreparedStatement ps1 = ConnUtil.getConn().prepareStatement(sql1);
                ps1.setInt(1, sno);
                ps1.setLong(2, terms[0]);
                ps1.setLong(3, terms[1]);
                ResultSet rs = ps1.executeQuery();
                if(rs.next()){
                    int clzno = rs.getInt(1);

                    PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
                    ps.setInt(1, clzno);
                    if (ps.executeUpdate() > 0)
                        return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
