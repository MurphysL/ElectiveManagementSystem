package dao;

import bean.Admin;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员
 */
public class AdminDao {

    /**
     * 管理员登录
     * @param ano 管理号
     * @param aPassword 密码
     * @return 管理员实体类
     */
    public static Admin login(int ano, String aPassword){
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE ano = ? AND aPassword = ?";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, ano);
            ps.setString(2, aPassword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                admin = new Admin();
                admin.setAno(rs.getInt(1));
                admin.setaName(rs.getString(2));
                admin.setaPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
