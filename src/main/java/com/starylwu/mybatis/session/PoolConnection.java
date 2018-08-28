package com.starylwu.mybatis.session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
        String fileName = "/jdbc.properties";
        InputStream resource = Thread.currentThread().getClass().getResourceAsStream(fileName);
        Properties properties = new Properties();
        try {
            if (resource == null){
                throw new FileNotFoundException(fileName + " file is not found");
            }
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
