package com.starylwu.mybatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @Author: WuYuLong
 * @Date: Create in 18:47 2018/8/27
 * @DESC:
 */
public class PoolConnection {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String CLASSDRIVER;

    static {
        InputStream resource = Thread.currentThread().getClass().getResourceAsStream(ClassLoader.getSystemResource("") + "jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            URL = properties.getProperty("url");
            USER = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            CLASSDRIVER = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()throws Exception{
        //1.加载驱动程序
        try {
            Class.forName(CLASSDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获得数据库链接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
