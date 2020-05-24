package com.zzti.zut.test;

import com.zzti.zut.dao.AreaDao;
import com.zzti.zut.dao.AreaDaoImpl;
import com.zzti.zut.entity.AreaInfo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class AreaInfoDaoTest {
    @Test
    public void selectAll() throws SQLException {
        AreaDao areaDao = new AreaDaoImpl();
        List<AreaInfo>  areaInfoList = areaDao.selectAll();
        System.out.println(areaInfoList);
    }
}
