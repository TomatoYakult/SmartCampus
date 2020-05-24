package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.entity.EquipmentInfo;
import com.zzti.zut.entity.ReturnData;
import com.zzti.zut.service.EquipmentInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EquipmentQueryListQueryListServlet", urlPatterns = "/servlet/equipment/queryList")
public class EquipmentQueryListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryName = request.getParameter("queryName");
        String queryType = request.getParameter("queryType");
        String pageNumber = request.getParameter("pageNumber");
        String offset = request.getParameter("offset");
        String pageSize = request.getParameter("pageSize");

        backPageing(queryName, queryType, pageNumber, offset, pageSize, response);
    }

    private void backPageing(String queryName, String queryType, String pageNumber, String offset, String pageSize, HttpServletResponse response) throws IOException {

        ReturnData<EquipmentInfo> returnData = new ReturnData<>();

        EquipmentInfoService equipmentInfoService = new EquipmentInfoService();
        if ((queryName != null && !queryName.isEmpty()) || (queryType != null && !queryType.isEmpty())) {
            queryName = " where equipmentName like '%" + queryName + "%' and equipmentType like '%" + queryType + "%' and del = 0";

        } else {
            queryName = " where del = 0";
        }
        List<EquipmentInfo> queryList = equipmentInfoService.selectByItems(queryName, Integer.parseInt(pageNumber), Integer.parseInt(pageSize));

        int countRows = equipmentInfoService.countRows(queryName);
        returnData.setTotal(countRows);
        returnData.setRows(queryList);

        String result = JSON.toJSONString(returnData);

        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
