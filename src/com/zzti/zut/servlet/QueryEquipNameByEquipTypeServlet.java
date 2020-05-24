package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.service.EquipmentInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryEquipNameByEquipTypeServlet", urlPatterns = "/servlet/maintenance/queryEquipNameByEquipType")
public class QueryEquipNameByEquipTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentType = request.getParameter("equipmentType");
        EquipmentInfoService equipmentInfoService = new EquipmentInfoService();
        String condition = "";
        if (equipmentType != null && !equipmentType.isEmpty()) {
            condition += " and equipmentType = '" + equipmentType + "'";
        }
        List<EquipmentInfo> list = equipmentInfoService.selectEquipmentInfoBy(condition);
        String result = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
