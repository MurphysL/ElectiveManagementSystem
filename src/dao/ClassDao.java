package dao;

import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 课程实体类
 */
public class ClassDao {

    /**
     * 更新课程
     * @param clzno 课程号
     * @param cno 科目号
     * @param tno 教工号
     * @param start 开始时间
     * @param address 地址
     * @return 更新是否完成
     */
    public static boolean updateClz(int clzno, int cno, int tno, String start, String address){
        String sql = "UPDATE class SET cno = ?, tno = ?, start=?, address=? WHERE clzno = ?";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long time = 0L;
        try {
            Date date = format.parse(start);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setLong(3, time);
            ps.setString(4, address);
            ps.setInt(5, clzno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加课程
     * @param cno 课程号
     * @param tno 教工号
     * @param start 开始时间
     * @param address 地址
     * @return 是否插入成功
     */
    public static boolean insertClz(int cno , int tno, String start , String address){
        String sql = "INSERT INTO class(cno, tno, start, address) VALUES(?, ?, ?, ?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long time = 0L;
        try {
            Date date = format.parse(start);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setLong(3, time);
            ps.setString(4, address);

            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
