package dao;

import bean.clz.Class;
import bean.clz.Classes;
import config.Config;
import db.ConnUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程实体类
 */
@Deprecated
public class ClassDao {

    /**
     * 课程查询类（分页）
     * @param sno 学号
     * @param page 页数
     * @return 课程包装类
     */
    public static Classes queryPagingClass(int sno, int page){
        Classes classes = new Classes();
        int num = 0;
        List<Class> list = new ArrayList<>();
        int start = (page-1)* Config.PAGE_BLOG_NUM;
        int end = start+4;
        String sql = "SELECT * FROM class WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?) LIMIT ?, ?";
        String num_sql = "SELECT count(*) FROM class WHERE Cno NOT IN (SELECT Cno FROM sc WHERE Sno= ?)";
        try {
            PreparedStatement ps = ConnUtil.getInstance().prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setInt(2, start);
            ps.setInt(3, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Class clz = new Class();
                clz.setCno(rs.getInt(1));
                clz.setTno(rs.getInt(2));
                clz.setAddress(rs.getString(3));
                clz.setTime(rs.getLong(4));
                list.add(clz);
            }

            PreparedStatement ps2 = ConnUtil.getInstance().prepareStatement(num_sql);
            ps2.setInt(1, sno);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                num = rs2.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        classes.setNum(num);
        classes.setList(list);
        return classes;
    }
}
