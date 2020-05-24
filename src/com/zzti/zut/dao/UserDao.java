package com.zzti.zut.dao;

import com.zzti.zut.entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    int login(UserInfo userInfo) throws SQLException;

    boolean insert(UserInfo userInfo) throws SQLException;

    boolean update(UserInfo userInfo) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<UserInfo> selectAll() throws SQLException;

    UserInfo selectById(int id) throws SQLException;

    List<UserInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException;

    int countRows(String condition) throws SQLException;

    public List<String> selectAllMaintenanceUser() throws SQLException;

    public List<String> selectAllUserId() throws SQLException;
}
