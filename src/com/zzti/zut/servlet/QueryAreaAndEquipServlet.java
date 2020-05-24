package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.service.MaintenanceInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QueryAreaAndEquipServlet", urlPatterns = "/servlet/maintenance/queryAreaAndEquipList")
public class QueryAreaAndEquipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        Map<String , List> stringListMap = maintenanceInfoService.queryAreaAndEquipList();
        //List转json
        String result = JSON.toJSONString(stringListMap);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
