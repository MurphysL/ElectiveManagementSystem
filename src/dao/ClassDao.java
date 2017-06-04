package dao;

import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public static boolean updateClz(int clzno, int cno, int tno, long start, String address){
        String sql = "UPDATE class SET cno = ?, tno = ?, start=?, address=? WHERE clzno = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, cno);
            ps.setInt(2, tno);
            ps.setLong(3, start);
            ps.setString(4, address);
            ps.setInt(5, clzno);
            if(ps.executeUpdate() > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
