package com.zzti.zut.dao;

import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.entity.EquipmentInfo;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentDao {
    boolean insert(EquipmentInfo equipmentInfo) throws SQLException;

    boolean update(EquipmentInfo equipmentInfo) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<EquipmentInfo> selectAll() throws SQLException;

    EquipmentInfo selectById(int id) throws SQLException;

    List<EquipmentInfo> selectByItems(String condition, int pageNum, int pageSize) throws SQLException;

    int countRows(String condition) throws SQLException;

    public List<String> selectAllEquipmentType() throws SQLException;

    public List<EquipmentInfo> selectEquipmentInfoBy(String equipmentType) throws SQLException;
}
