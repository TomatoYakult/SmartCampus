package com.zzti.zut.dao;

import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(MyDBUtils.getDataSource());
    private static boolean status = false;

    @Override
    public int login(UserInfo userInfo) throws SQLException {
        if (userInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + userInfo);
        }

        String sql = "select * from t_users where username = ?";
        UserInfo query = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), userInfo.getUsername());
        if (query == null) {
            return 0;
        } else if (query.getPassword().equals(userInfo.getPassword())) {
            return query.getId();
        } else {
            return 0;
        }
    }

    @Override
    public boolean insert(UserInfo userInfo) throws SQLException {
        // 对参数进行合法性校验
        if (userInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + userInfo);
        }

        String sql = "insert into t_users(username,password) values(?,?)";
        Object[] params = {userInfo.getUsername(), userInfo.getPassword()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    @Override
    public boolean update(UserInfo userInfo) throws SQLException {
        // 对参数进行合法性校验
        if (userInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + userInfo);
        }

        String sql = "update t_users set username=?,password=? where id=?";
        Object[] params = {userInfo.getUsername(), userInfo.getPassword(), userInfo.getId()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // 对参数进行合法性校验
        if (id == 0) {
            throw new IllegalArgumentException("参数不正确：" + id);
        }

        String sql = "delete from t_users where id = ?";
        int delete = queryRunner.update(sql, id);
        status = delete == 1 ? true : false;
        return status;
    }

    @Override
    public List<UserInfo> selectAll() throws SQLException {
        String sql = "select * from t_users";
        List<UserInfo> userInfoList = queryRunner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
        return userInfoList;
    }

    @Override
    public UserInfo selectById(int id) throws SQLException {
        String sql = "select * from t_users where id = ?";
        UserInfo query = queryRunner.query(sql, new BeanHandler<UserInfo>(UserInfo.class), id);
        return query;
    }

    @Override
    public List<UserInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException {
        String sql = "select * from t_users";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        sql += " limit " + pageSize * (pageNum - 1) + ", " + pageSize;
        List<UserInfo> query = queryRunner.query(sql, new BeanListHandler<UserInfo>(UserInfo.class));
        return query;
    }

    @Override
    public int countRows(String condition) throws SQLException {
        String sql = "select count(*) from t_users";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        Object query = queryRunner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(query.toString());
    }

    @Override
    public List<String> selectAllMaintenanceUser() throws SQLException {
        String sql = "select username from t_users";
        List<String> list = queryRunner.query(sql, new ColumnListHandler<>());
        return list;
    }

    @Override
    public List<String> selectAllUserId() throws SQLException {
        String sql = "select id from t_users";
        List<String> list = queryRunner.query(sql, new ColumnListHandler<>());
        return list;
    }
}
