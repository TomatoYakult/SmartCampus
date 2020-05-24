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

@WebServlet(name = "MaintenanceUpdateServlet", urlPatterns = "/servlet/maintenance/update")
public class MaintenanceUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int maintenanceSN = Integer.parseInt(request.getParameter("maintenanceSN"));
        System.out.println("areaID:" + request.getParameter("areaID"));
        System.out.println("floor:" + request.getParameter("floor"));
        int areaID = Integer.parseInt(request.getParameter("areaID"));
        int equipmentID = Integer.parseInt(request.getParameter("equipmentID"));
        int reportUserID = (int) request.getSession().getAttribute("loginID");
        String reportContent = request.getParameter("reportContent");
        String imageURL = request.getParameter("imageURL");
        String location = request.getParameter("location");

        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        boolean update = maintenanceInfoService.updateMaintenance(new MaintenanceInfo(id, maintenanceSN, areaID, equipmentID, reportUserID, reportContent, imageURL, location));
        JSONObject result = new JSONObject();
        if (update) {
            result.put("message", "修改报修单成功！");
            result.put("status", "success");
        } else {
            result.put("message", "修改报修单失败！");
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
