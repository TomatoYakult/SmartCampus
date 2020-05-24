package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.service.AreaInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AreaAddServlet", urlPatterns = "/servlet/area/add")
public class AreaAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");

        String building = request.getParameter("building");
        String floor = request.getParameter("floor");

        AreaInfoService areaInfoService = new AreaInfoService();
        boolean insert = areaInfoService.insert(new AreaInfo(building, floor));
        //response.setContentType("text/json;charset=utf-8");
        JSONObject result = new JSONObject();
        if (insert) {
            result.put("message", "增加区域成功！");
            result.put("status", "success");
        } else {
            result.put("message", "增加区域失败！");
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
