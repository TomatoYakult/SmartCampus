package com.zzti.zut.service;

import com.zzti.zut.dao.EquipmentDao;
import com.zzti.zut.dao.EquipmentDaoImpl;
import com.zzti.zut.entity.EquipmentInfo;

import java.sql.SQLException;
import java.util.List;

public class EquipmentInfoService {
    private EquipmentDao equipmentDao = new EquipmentDaoImpl();

    public List<EquipmentInfo> selectEquipmentInfoBy(String condition) {
        List<EquipmentInfo> equipmentInfoList = null;
        try {
            equipmentInfoList = equipmentDao.selectEquipmentInfoBy(condition);
        } catch (Exception e) {
            throw new RuntimeException("区域信息查询失败！");
        }
        return equipmentInfoList;
    }

    public boolean insert(EquipmentInfo equipmentInfo) {
        boolean insert = false;
        try {
            insert = equipmentDao.insert(equipmentInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public boolean update(EquipmentInfo equipmentInfo) {
        boolean update = false;
        try {
            update = equipmentDao.update(equipmentInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;

    }

    public boolean delete(int id) {
        boolean delete = false;
        try {
            delete = equipmentDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<EquipmentInfo> selectAll() {
        List<EquipmentInfo> equipmentInfoList = null;
        try {
            equipmentInfoList = equipmentDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentInfoList;
    }

    public EquipmentInfo selectById(int id) {
        EquipmentInfo equipmentInfo = null;
        try {
            equipmentInfo = equipmentDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentInfo;
    }

    public List<EquipmentInfo> selectByItems(String condition, int pageNum, int pageSize) {
        List<EquipmentInfo> equipmentInfoList = null;
        try {
            equipmentInfoList = equipmentDao.selectByItems(condition, pageNum, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentInfoList;
    }

    public int countRows(String condition) {
        int rows = 0;
        try {
            rows = equipmentDao.countRows(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
