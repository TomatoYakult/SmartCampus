package com.zzti.zut.service;

import com.zzti.zut.dao.*;
import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.entity.MaintenanceInfo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintenanceInfoService {
    private MaintenanceDao maintenanceDao = new MaintenanceDaoImpl();

    public Map<String, List> queryEditDataList(String building, String equipmentType) {
        Map<String, List> map = new HashMap<>();
        AreaDao areaDao = new AreaDaoImpl();
        EquipmentDao equipmentDao = new EquipmentDaoImpl();
        try {
            List<String> allBuilding = areaDao.selectAllBuilding();
            building = " and building = '" + building + "'";
            List<AreaInfo> allFloor = areaDao.selectAreaInfoBy(building);
            List<String> allEquipmentType = equipmentDao.selectAllEquipmentType();
            equipmentType = " and equipmentType = '" + equipmentType + "'";
            List<EquipmentInfo> allEquipmentName = equipmentDao.selectEquipmentInfoBy(equipmentType);
            map.put("building", allBuilding);
            map.put("equipmentType", allEquipmentType);
            map.put("areaInfo", allFloor);
            map.put("equipmentName", allEquipmentName);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            return map;
        }
    }

    public Map<String, List> queryAreaAndEquipList() {
        Map<String, List> map = new HashMap<>();
        AreaDao areaDao = new AreaDaoImpl();
        EquipmentDao equipmentDao = new EquipmentDaoImpl();
        UserDao userDao = new UserDaoImpl();
        try {
            List<String> allBuilding = areaDao.selectAllBuilding();
            List<String> allEquipmentType = equipmentDao.selectAllEquipmentType();
            List<String> allMaintenanceUser = userDao.selectAllMaintenanceUser();
            List<String> maintenanceUserId = userDao.selectAllUserId();
            map.put("building", allBuilding);
            map.put("equipmentType", allEquipmentType);
            map.put("maintenanceUser", allMaintenanceUser);
            map.put("maintenanceUserId", maintenanceUserId);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            return map;
        }
    }

    public boolean insert(MaintenanceInfo maintenanceInfo) {
        boolean insert = false;
        try {
            insert = maintenanceDao.insert(maintenanceInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public boolean updateMaintenance(MaintenanceInfo maintenanceInfo) {
        boolean update = false;
        try {
            update = maintenanceDao.updateMaintenance(maintenanceInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean updateMaintenanceUser(MaintenanceInfo maintenanceInfo) {
        boolean update = false;
        try {
            update = maintenanceDao.updateMaintenanceUser(maintenanceInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean updateMaintenanceEnd(MaintenanceInfo maintenanceInfo) {
        boolean update = false;
        try {
            update = maintenanceDao.updateMaintenanceEnd(maintenanceInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean delete(int id) {
        boolean delete = false;
        try {
            delete = maintenanceDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<MaintenanceInfo> selectAll() {
        List<MaintenanceInfo> maintenanceInfoList = null;
        try {
            maintenanceInfoList = maintenanceDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceInfoList;
    }

    public MaintenanceInfo selectById(int id) {
        MaintenanceInfo maintenanceInfo = null;
        try {
            maintenanceInfo = maintenanceDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceInfo;
    }

    public List<MaintenanceInfo> selectByItems(String condition, int pageNum, int pageSize) {
        List<MaintenanceInfo> maintenanceInfoList = null;
        try {
            maintenanceInfoList = maintenanceDao.selectByItems(condition, pageNum, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceInfoList;
    }

    public int countRows(String condition) {
        int rows = 0;
        try {
            rows = maintenanceDao.countRows(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
