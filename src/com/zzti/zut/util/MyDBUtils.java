package com.zzti.zut.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.*;

public class MyDBUtils {
    /**
     * 数据库连接池
     */
    private static DataSource dataSource;

    //静态代码块 - 随着该类的字节码文件加载而加载，整个类的生命周期中，只记载一次。
    static {
        // 左边是接口
        URL resource = MyDBUtils.class.getResource("/hikaricp.properties");
        //System.out.println(resource);
        HikariConfig configuration = new HikariConfig(resource.getPath());
        dataSource = new HikariDataSource(configuration);
    }

    public static Connection getConnection() throws SQLException {
        // 第二步 创建连接对象
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

}
