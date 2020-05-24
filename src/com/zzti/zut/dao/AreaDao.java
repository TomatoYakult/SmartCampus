package com.zzti.zut.dao;

import com.zzti.zut.entity.AreaInfo;

import java.sql.SQLException;
import java.util.List;

public interface AreaDao {

    boolean insert(AreaInfo areaInfo) throws SQLException;

    boolean update(AreaInfo areaInfo) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<AreaInfo> selectAll() throws SQLException;

    AreaInfo selectById(int id) throws SQLException;

    List<AreaInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException;

    int countRows(String condition) throws SQLException;

    public List<String> selectAllBuilding() throws SQLException;

    public List<AreaInfo> selectAreaInfoBy(String building) throws SQLException;
}
