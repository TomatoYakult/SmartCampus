package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.entity.AreaInfo;
import com.zzti.zut.service.AreaInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryFloorByBuildingServlet", urlPatterns = "/servlet/maintenance/queryFloorByBuilding")
public class QueryFloorByBuildingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String building = request.getParameter("building");
        AreaInfoService areaInfoService = new AreaInfoService();
        String condition = "";
        if (building != null && !building.isEmpty()) {
            condition += " and building = '" + building + "'";
        }
        List<AreaInfo> list = areaInfoService.selectAreaInfoBy(condition);
        String result = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
