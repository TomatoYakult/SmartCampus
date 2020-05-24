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

@WebServlet(name = "EquipmentAddServlet", urlPatterns = "/servlet/equipment/add")
public class EquipmentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int equipmentSN = Integer.parseInt(request.getParameter("equipmentSN"));
        String equipmentName = request.getParameter("equipmentName");
        String equipmentType = request.getParameter("equipmentType");
        String responsiblePerson = request.getParameter("responsiblePerson");
        String remark = request.getParameter("remark");

        EquipmentInfoService equipmentInfoService = new EquipmentInfoService();
        boolean insert = equipmentInfoService.insert(new EquipmentInfo(equipmentSN, equipmentName, equipmentType, responsiblePerson, remark));
        JSONObject result = new JSONObject();
        if (insert) {
            result.put("message", "增加设备成功！");
            result.put("status", "success");
        } else {
            result.put("message", "增加设备失败！");
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
