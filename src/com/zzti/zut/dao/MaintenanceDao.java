package com.zzti.zut.dao;

import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.entity.MaintenanceInfo;

import java.sql.SQLException;
import java.util.List;

public interface MaintenanceDao {
    boolean insert(MaintenanceInfo maintenanceInfo) throws SQLException;

    boolean updateMaintenance(MaintenanceInfo maintenanceInfo) throws SQLException;

    boolean updateMaintenanceUser(MaintenanceInfo maintenanceInfo) throws SQLException;

    boolean updateMaintenanceEnd(MaintenanceInfo maintenanceInfo) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<MaintenanceInfo> selectAll() throws SQLException;

    MaintenanceInfo selectById(int id) throws SQLException;

    List<MaintenanceInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException;

    int countRows(String condition) throws SQLException;
}
