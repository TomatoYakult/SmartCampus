package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.MaintenanceInfo;
import com.zzti.zut.service.MaintenanceInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MaintenanceUpdateUserServlet", urlPatterns = "/servlet/maintenance/updateMaintenanceUser")
public class MaintenanceUpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int maintenanceUserID = Integer.parseInt(request.getParameter("maintenanceUserName"));
        System.out.println(maintenanceUserID);
        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        boolean update = maintenanceInfoService.updateMaintenanceUser(new MaintenanceInfo(id, maintenanceUserID));
        JSONObject result = new JSONObject();
        if (update) {
            result.put("message", "分派维修人员成功！");
            result.put("status", "success");
        } else {
            result.put("message", "分派维修人员失败！");
            result.put("status", "error");
        }
        PrintWriter writer = response.getWriter();
        writer.println(result.toString());
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
