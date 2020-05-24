package com.zzti.zut.service;

import com.zzti.zut.dao.UserDao;
import com.zzti.zut.dao.UserDaoImpl;
import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.util.MD5Utils;

import java.sql.SQLException;
import java.util.List;

public class UserInfoService {
    private UserDao userDao = new UserDaoImpl();

    public int login(UserInfo userInfo) {
        int login = 0;
        try {
            userInfo.setPassword(MD5Utils.getMD5(userInfo.getPassword(), 32));
            login = userDao.login(userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public boolean insert(UserInfo userInfo) {
        boolean insert = false;
        try {
            userInfo.setPassword(MD5Utils.getMD5(userInfo.getPassword(), 32));
            insert = userDao.insert(userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public boolean update(UserInfo userInfo) {
        boolean update = false;
        try {
            userInfo.setPassword(MD5Utils.getMD5(userInfo.getPassword(), 32));
            update = userDao.update(userInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;

    }

    public boolean delete(int id) {
        boolean delete = false;
        try {
            delete = userDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<UserInfo> selectAll() {
        List<UserInfo> userInfoList = null;
        try {
            userInfoList = userDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfoList;
    }

    public UserInfo selectById(int id) {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public List<UserInfo> selectByItems(String condition, int pageNum, int pageSize) {
        List<UserInfo> userInfoList = null;
        try {
            userInfoList = userDao.selectByItems(condition, pageNum, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfoList;
    }

    public int countRows(String condition) {
        int rows = 0;
        try {
            rows = userDao.countRows(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
