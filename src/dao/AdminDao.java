package dao;

import bean.admin.Admin;
import util.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDao {

    /**
     * 管理员登录
     * @param ano 管理号
     * @param password 密码
     * @return 管理员实体类
     */
    public static Admin login(int ano, String password){
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE ano = ? AND password = ?";
        try {
            PreparedStatement ps = ConnUtil.getConn().prepareStatement(sql);
            ps.setInt(1, ano);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                admin = new Admin();
                admin.setAno(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
