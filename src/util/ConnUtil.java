package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class ConnUtil {

    private static String URL ;
    private static String USER ;
    private static String PASSWORD ;
    private static String DRIVER ;

    /**
     * 加载数据库配置
     */
    private static void loadConfig(){
        try {
            InputStream is = ConnUtil.class.getResourceAsStream("../config/jdbc.properties");
            Properties prop = new Properties();
            prop.load(is);
            USER = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
            URL = prop.getProperty("jdbc.url");
            DRIVER = prop.getProperty("jdbc.driver");
        } catch (Exception e) {
            throw new RuntimeException("=================加载配置文件出错！==================",e);
        }
    }

    /**
     * 获取数据库连接
     * @return 数据库连接
     * @throws SQLException SQLException
     */
    public static Connection getConn() throws SQLException {
        Connection conn = null;
        loadConfig();
        try {
            Class.forName(DRIVER);//加载数据库驱动
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * sql语句预处理
     * @param conn 数据库连接
     * @param sql sql语句
     * @return PreparedStatement
     */
    public static PreparedStatement getPre(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * close Connection
     * @param conn Connection
     */
    public static void close(Connection conn) {
        try {
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * close PreparedStatement
     * @param ps PreparedStatement
     */
    public static void close(PreparedStatement ps) {
        try {
            if (null != ps) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * close ResultSet
     * @param rs ResultSet
     */
    public static void close(ResultSet rs) {
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
