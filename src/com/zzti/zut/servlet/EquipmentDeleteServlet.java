package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.service.EquipmentInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EquipmentDeleteServlet", urlPatterns = "/servlet/equipment/delete")
public class EquipmentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        EquipmentInfoService equipmentInfoService = new EquipmentInfoService();
        boolean delete = equipmentInfoService.delete(id);
        JSONObject result = new JSONObject();
        if (delete) {
            result.put("message", "删除设备信息成功！");
            result.put("status", "success");
        } else {
            result.put("message", "删除设备信息失败！");
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
