package com.zzti.zut.service;

import com.zzti.zut.dao.AreaDao;
import com.zzti.zut.dao.AreaDaoImpl;
import com.zzti.zut.entity.AreaInfo;

import java.awt.geom.Area;
import java.sql.SQLException;
import java.util.List;

public class AreaInfoService {
    private AreaDao areaDao = new AreaDaoImpl();

    public List<AreaInfo> selectAreaInfoBy(String condition) {
        List<AreaInfo> areaInfoList = null;
        try {
            areaInfoList = areaDao.selectAreaInfoBy(condition);
        } catch (Exception e) {
            throw new RuntimeException("区域信息查询失败！");
        }
        return areaInfoList;
    }

    public boolean insert(AreaInfo areaInfo) {
        boolean insert = false;
        try {
            insert = areaDao.insert(areaInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public boolean update(AreaInfo areaInfo) {
        boolean update = false;
        try {
            update = areaDao.update(areaInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean delete(int id) {
        boolean delete = false;
        try {
            delete = areaDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }

    public List<AreaInfo> selectAll() {
        List<AreaInfo> areaInfoList = null;
        try {
            areaInfoList = areaDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areaInfoList;
    }

    public AreaInfo selectById(int id) {
        AreaInfo areaInfo = null;
        try {
            areaInfo = areaDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areaInfo;
    }

    public List<AreaInfo> selectByItems(String condition, int pageNum, int pageSize) {
        List<AreaInfo> areaInfoList = null;
        try {
            areaInfoList = areaDao.selectByItems(condition, pageNum, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areaInfoList;
    }

    public int countRows(String condition) {
        int rows = 0;
        try {
            rows = areaDao.countRows(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
