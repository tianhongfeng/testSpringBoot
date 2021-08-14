package util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbcpUtils {

//    private static String driver = null;
//    private static String url = null;
//    private static String usename = null;
//    private static String pws = null;

    private static DataSource datasource = null;


    static{
        try {

            ClassLoader classLoader = DbcpUtils.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("dbcp.properties");
            Properties properties = new Properties();
            properties.load(in);

            // 创建数据源
            datasource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 获取连接
    public static Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    // 释放连接
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if(statement != null){
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DbcpUtils dbcpUtils = new DbcpUtils();
    }
}
