package dao;

import bean.Sc;
import db.ConnUtil;
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
     * @return 选课信息
     */
    public static Sc queryThisTerm(int sno){
        Sc sc = null;
        long[] term = TimeUtil.getTermTimeStamp();
        System.out.println(term[0] + " " + term[1]);
        String sql = "SELECT * FROM sc WHERE Sno = ? AND Time >= ? AND Time <= ?";
        try {
            PreparedStatement ps  = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setLong(2, term[0]);
            ps.setLong(3, term[1]);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sc = new Sc();
                sc.setCno(rs.getInt(1));
                sc.setTno(rs.getInt(2));
                sc.setSno(rs.getInt(3));
                sc.setGrade(rs.getInt(4));
                sc.setTime(rs.getLong(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sc;
    }

    /**
     * 查询成绩
     * @param cno 科目号
     * @param tno 教师号
     * @param sno 学号
     * @return 成绩
     */
    public static int queryGrade(int cno, int tno, int sno){
        int grade = 0;
        String sql = "SELECT Grade FROM sc WHERE Cno = ? AND Tno = ? AND  Sno = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setInt(3, sno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                grade = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    /**
     * 选课
     * @param cno 科目号
     * @param tno 教师号
     * @param sno 学号
     * @return 更改条数
     */
    public static int insertClass(int cno, int tno, int sno){
        int result = 0;
        long now = System.currentTimeMillis()/1000;

        if(queryThisTerm(sno) != null){
            deleteClass(sno);
        }

        String sql = "INSERT sc(Cno, Tno, Sno, Time) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setInt(3, sno);
            ps.setLong(4, now);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 退课（本学期）
     * @param sno 学号
     * @return 更改条数
     */
    public static int deleteClass(int sno){
        int num = 0;
        Sc sc = queryThisTerm(sno);
        long[] terms = TimeUtil.getTermTimeStamp();
        if(sc != null){
            String sql = "DELETE FROM sc WHERE Sno=? AND Time BETWEEN ? AND ?";
            try {
                PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
                ps.setInt(1, sno);
                ps.setLong(2, terms[0]);
                ps.setLong(3, terms[1]);
                num = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}
