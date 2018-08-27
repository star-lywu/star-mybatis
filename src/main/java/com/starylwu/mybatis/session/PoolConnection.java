package com.starylwu.mybatis.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: WuYuLong
 * @Date: Create in 18:47 2018/8/27
 * @DESC:
 */
public class PoolConnection {

    public Connection getConnection()throws Exception{
        String URL="jdbc:mysql://127.0.0.1:3306/star-mybatis?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String USER="root";
        String PASSWORD="root";
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.获得数据库链接
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
