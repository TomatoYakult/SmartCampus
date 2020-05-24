package com.zzti.zut.test;

import com.zzti.zut.util.MyDBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {

    @Test
    public void method1() throws SQLException {
        Connection con = MyDBUtils.getConnection();
        System.out.println(con);
    }
}
