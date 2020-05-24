package com.zzti.zut.dao;

import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class AreaDaoImpl implements AreaDao {

    private QueryRunner queryRunner = new QueryRunner(MyDBUtils.getDataSource());
    private static boolean status = false;

    @Override
    public boolean insert(AreaInfo areaInfo) throws SQLException {
        // 对参数进行合法性校验
        if (areaInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + areaInfo);
        }

        String sql = "insert into t_areas(building,floor) values(?,?)";
        Object[] params = {areaInfo.getBuilding(), areaInfo.getFloor()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    @Override
    public boolean update(AreaInfo areaInfo) throws SQLException {
        // 对参数进行合法性校验
        if (areaInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + areaInfo);
        }

        String sql = "update t_areas set building=?,floor=? where id=?";
        Object[] params = {areaInfo.getBuilding(), areaInfo.getFloor(), areaInfo.getId()};
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

        String sql = "delete from t_areas where id = ?";
        int delete = queryRunner.update(sql, id);
        status = delete == 1 ? true : false;
        return status;
    }

    @Override
    public List<AreaInfo> selectAll() throws SQLException {
        String sql = "select * from t_areas";
        List<AreaInfo> areaInfoList = queryRunner.query(sql, new BeanListHandler<AreaInfo>(AreaInfo.class));
        return areaInfoList;
    }

    @Override
    public AreaInfo selectById(int id) throws SQLException {
        String sql = "select * from t_areas where id = ?";
        AreaInfo query = queryRunner.query(sql, new BeanHandler<AreaInfo>(AreaInfo.class));
        return query;
    }

    @Override
    public List<AreaInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException {
        String sql = "select * from t_areas";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        sql += " limit " + pageSize * (pageNum - 1) + ", " + pageSize;
        List<AreaInfo> query = queryRunner.query(sql, new BeanListHandler<AreaInfo>(AreaInfo.class));
        return query;
    }

    @Override
    public int countRows(String condition) throws SQLException {
        String sql = "select count(*) from t_areas";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        Object query = queryRunner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(query.toString());
    }

    @Override
    public List<String> selectAllBuilding() throws SQLException {
        String sql = "select DISTINCT building from t_areas";
        List<String> list = queryRunner.query(sql, new ColumnListHandler<>());
        return list;
    }

    @Override
    public List<AreaInfo> selectAreaInfoBy(String building) throws SQLException {
        String sql = "select * from t_areas where 1=1 ";
        // 对参数进行合法性校验
        if (building != null && !building.isEmpty()) {
            sql += building;
        }
        List<AreaInfo> areaInfoList = queryRunner.query(sql,new BeanListHandler<AreaInfo>(AreaInfo.class));
        return areaInfoList;
    }
}
