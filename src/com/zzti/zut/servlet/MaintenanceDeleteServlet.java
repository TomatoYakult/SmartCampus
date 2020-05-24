package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.service.MaintenanceInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MaintenanceDeleteServlet", urlPatterns = "/servlet/maintenance/delete")
public class MaintenanceDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        boolean delete = maintenanceInfoService.delete(id);
        JSONObject result = new JSONObject();
        if (delete) {
            result.put("message", "删除报修单成功！");
            result.put("status", "success");
        } else {
            result.put("message", "删除报修单失败！");
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
