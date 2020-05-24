package com.zzti.zut.dao;

import com.zzti.zut.entity.MaintenanceInfo;
import com.zzti.zut.util.MyDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class MaintenanceDaoImpl implements MaintenanceDao {

    private QueryRunner queryRunner = new QueryRunner(MyDBUtils.getDataSource());
    private static boolean status = false;

    @Override
    public boolean insert(MaintenanceInfo maintenanceInfo) throws SQLException {
        // 对参数进行合法性校验
        if (maintenanceInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + maintenanceInfo);
        }

        String sql = "insert into t_maintenances(maintenanceSN,areaID,equipmentID,reportUserID,reportContent,imageURL,location) values(?,?,?,?,?,?,?)";
        Object[] params = {maintenanceInfo.getMaintenanceSN(), maintenanceInfo.getAreaID(), maintenanceInfo.getEquipmentID(), maintenanceInfo.getReportUserID(), maintenanceInfo.getReportContent(), maintenanceInfo.getImageURL(), maintenanceInfo.getLocation()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    //修改保修单
    @Override
    public boolean updateMaintenance(MaintenanceInfo maintenanceInfo) throws SQLException {
        // 对参数进行合法性校验
        if (maintenanceInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + maintenanceInfo);
        }

        String sql = "update t_maintenances set maintenanceSN=?,areaID=?,equipmentID=?,reportContent=?,imageURL=?,location=? where id=?";
        Object[] params = {maintenanceInfo.getMaintenanceSN(), maintenanceInfo.getAreaID(), maintenanceInfo.getEquipmentID(), maintenanceInfo.getReportContent(), maintenanceInfo.getImageURL(), maintenanceInfo.getLocation(), maintenanceInfo.getId()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    //分配维修人员
    @Override
    public boolean updateMaintenanceUser(MaintenanceInfo maintenanceInfo) throws SQLException {
        // 对参数进行合法性校验
        if (maintenanceInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + maintenanceInfo);
        }

        String sql = "update t_maintenances set status = 1, maintenanceUserID = ? where id = ?";
        Object[] params = {maintenanceInfo.getMaintenanceUserID(), maintenanceInfo.getId()};
        int update = queryRunner.update(sql, params);
        status = update == 1 ? true : false;
        return status;
    }

    //完成维修单
    @Override
    public boolean updateMaintenanceEnd(MaintenanceInfo maintenanceInfo) throws SQLException {
        // 对参数进行合法性校验
        if (maintenanceInfo == null) {
            throw new IllegalArgumentException("参数不正确：" + maintenanceInfo);
        }

        String sql = "update t_maintenances set status = 2,maintenanceContent = ? where id=?";
        Object[] params = {maintenanceInfo.getMaintenanceContent(), maintenanceInfo.getId()};
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

        String sql = "delete from t_maintenances where id = ?";
        int delete = queryRunner.update(sql, id);
        status = delete == 1 ? true : false;
        return status;
    }

    @Override
    public List<MaintenanceInfo> selectAll() throws SQLException {
        String sql = "SELECT\n" +
                "\ta.*,\n" +
                "\tb.username AS reportUserName,\n" +
                "\tc.building,\n" +
                "\tfloor,\n" +
                "\td.equipmentName,\n" +
                "\tequipmentType,\n" +
                "\te.username AS maintenanceUserName\n" +
                "FROM\n" +
                "\tt_maintenances a\n" +
                "\tINNER JOIN t_users b ON a.reportUserID = b.id\n" +
                "\tINNER JOIN t_areas c ON a.`areaID` = c.`id`\n" +
                "\tINNER JOIN t_equipments d ON a.`equipmentID` = d.`id`\n" +
                "\tLEFT JOIN t_users e ON a.`maintenanceUserID` = e.`id`";
        List<MaintenanceInfo> maintenanceInfoList = queryRunner.query(sql, new BeanListHandler<MaintenanceInfo>(MaintenanceInfo.class));
        return maintenanceInfoList;
    }

    @Override
    public MaintenanceInfo selectById(int id) throws SQLException {
        String sql = "select * from t_maintenances where id = ?";
        MaintenanceInfo query = queryRunner.query(sql, new BeanHandler<MaintenanceInfo>(MaintenanceInfo.class));
        return query;
    }

    @Override
    public List<MaintenanceInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException {
        String sql = "SELECT\n" +
                "\ta.*,\n" +
                "\tb.username AS reportUserName,\n" +
                "\tc.building,\n" +
                "\tfloor,\n" +
                "\td.equipmentName,\n" +
                "\tequipmentType,\n" +
                "\te.username AS maintenanceUserName\n" +
                "FROM\n" +
                "\tt_maintenances a\n" +
                "\tINNER JOIN t_users b ON a.reportUserID = b.id\n" +
                "\tINNER JOIN t_areas c ON a.`areaID` = c.`id`\n" +
                "\tINNER JOIN t_equipments d ON a.`equipmentID` = d.`id`\n" +
                "\tLEFT JOIN t_users e ON a.`maintenanceUserID` = e.`id` \n" +
                "\tWHERE 1=1";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        sql += " limit " + pageSize * (pageNum - 1) + ", " + pageSize;
        List<MaintenanceInfo> query = queryRunner.query(sql, new BeanListHandler<MaintenanceInfo>(MaintenanceInfo.class));
        return query;
    }

    @Override
    public int countRows(String condition) throws SQLException {
        String sql = "SELECT\n" +
                "\tcount( * ) \n" +
                "FROM\n" +
                "\tt_maintenances a,\n" +
                "\tt_users b,\n" +
                "\tt_areas c,\n" +
                "\tt_equipments d \n" +
                "WHERE\n" +
                "\ta.reportUserID = b.id \n" +
                "\tAND a.areaID = c.id \n" +
                "\tAND a.equipmentID = d.id";
        if (condition != null && !condition.isEmpty()) {
            sql += condition;
        }
        Object query = queryRunner.query(sql, new ScalarHandler<>());
        return Integer.parseInt(query.toString());
    }
}
