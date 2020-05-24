package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.MaintenanceInfo;
import com.zzti.zut.service.MaintenanceInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MaintenanceAddServlet", urlPatterns = "/servlet/maintenance/add")
public class MaintenanceAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int maintenanceSN = Integer.parseInt(request.getParameter("maintenanceSN"));
        int areaID = Integer.parseInt(request.getParameter("floor"));
        int equipmentID = Integer.parseInt(request.getParameter("equipmentName"));
        int reportUserID = (int) request.getSession().getAttribute("loginID");
        String reportContent = request.getParameter("reportContent");
        String image = request.getParameter("imageURL");
        String location = request.getParameter("location");

        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        boolean insert = maintenanceInfoService.insert(new MaintenanceInfo(maintenanceSN, areaID, equipmentID, reportUserID, reportContent, image, location));
        JSONObject result = new JSONObject();
        if (insert) {
            result.put("message", "增加报修信息成功！");
            result.put("status", "success");
        } else {
            result.put("message", "增加报修信息失败！");
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
