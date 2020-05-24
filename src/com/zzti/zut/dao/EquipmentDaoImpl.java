package com.zzti.zut.dao;

import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EquipmentDaoImpl implements EquipmentDao {

    private QueryRunner queryRunner = new QueryRunner(MyDBUtils.getDataSource());
    private static boolean status = false;

    @Override
    public boolean insert(EquipmentInfo equipmentInfo) throws SQLException {
        // 对参数进行合法性校验
        if (equipmentInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + equipmentInfo);
        }

        String sql = "insert into t_equipments(equipmentSN,equipmentName,equipmentType,responsiblePerson,remark) values(?,?,?,?,?)";
        Object[] params = {equipmentInfo.getEquipmentSN(), equipmentInfo.getEquipmentName(), equipmentInfo.getEquipmentType(), equipmentInfo.getResponsiblePerson(), equipmentInfo.getRemark()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    @Override
    public boolean update(EquipmentInfo equipmentInfo) throws SQLException {
        // 对参数进行合法性校验
        if (equipmentInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + equipmentInfo);
        }

        String sql = "update t_equipments set equipmentSN=?,equipmentName=?,equipmentType=?,responsiblePerson=?,remark=? where id=?";
        Object[] params = {equipmentInfo.getEquipmentSN(), equipmentInfo.getEquipmentName(), equipmentInfo.getEquipmentType(), equipmentInfo.getResponsiblePerson(), equipmentInfo.getRemark(), equipmentInfo.getId()};
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

        String sql = "update t_equipments set del = 1 where id = ?";
        int delete = queryRunner.update(sql, id);
        status = delete == 1 ? true : false;
        return status;
    }

    @Override
    public List<EquipmentInfo> selectAll() throws SQLException {
        String sql = "select * from t_equipments where del = 0";
        List<EquipmentInfo> equipmentInfoList = queryRunner.query(sql, new BeanListHandler<EquipmentInfo>(EquipmentInfo.class));
        return equipmentInfoList;
    }

    @Override
    public EquipmentInfo selectById(int id) throws SQLException {
        String sql = "select * from t_equipments where id = ?";
        EquipmentInfo query = queryRunner.query(sql, new BeanHandler<EquipmentInfo>(EquipmentInfo.class));
        return query;
    }

    @Override
    public List<EquipmentInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException {
        String sql = "select * from t_equipments";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
            sql += " and del = 0";
        }
        sql += " limit " + pageSize * (pageNum - 1) + ", " + pageSize;
        List<EquipmentInfo> query = queryRunner.query(sql, new BeanListHandler<EquipmentInfo>(EquipmentInfo.class));
        return query;
    }

    @Override
    public int countRows(String condition) throws SQLException {
        String sql = "select count(*) from t_equipments";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        Object query = queryRunner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(query.toString());
    }

    @Override
    public List<String> selectAllEquipmentType() throws SQLException {
        String sql = "select DISTINCT equipmentType from t_equipments";
        List<String> list = queryRunner.query(sql, new ColumnListHandler<String>("equipmentType"));
        return list;
    }

    @Override
    public List<EquipmentInfo> selectEquipmentInfoBy(String equipmentType) throws SQLException {
        String sql = "select * from t_equipments where del = 0 ";
        // 对参数进行合法性校验
        if (equipmentType != null && !equipmentType.isEmpty()) {
            sql += equipmentType;
        }
        List<EquipmentInfo> equipmentInfoList = queryRunner.query(sql, new BeanListHandler<EquipmentInfo>(EquipmentInfo.class));
        return equipmentInfoList;
    }
}
