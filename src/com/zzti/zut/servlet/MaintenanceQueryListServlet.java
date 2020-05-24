package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.entity.MaintenanceInfo;
import com.zzti.zut.entity.ReturnData;
import com.zzti.zut.service.MaintenanceInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MaintenanceQueryListQueryListServlet", urlPatterns = "/servlet/maintenance/queryList")
public class MaintenanceQueryListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryStatus = null;
        String queryEquipmentName = null;
        String queryEquipmentType = null;
        String queryStatusA = request.getParameter("queryStatusA");
        String queryStatusB = request.getParameter("queryStatusB");
        String queryStatusC = request.getParameter("queryStatusC");
        String queryEquipmentNameA = request.getParameter("queryEquipmentNameA");
        String queryEquipmentTypeA = request.getParameter("queryEquipmentTypeA");
        String queryMaintenanceSN = request.getParameter("queryMaintenanceSN");
        String queryEquipmentNameC = request.getParameter("queryEquipmentNameC");
        String queryEquipmentTypeC = request.getParameter("queryEquipmentTypeC");
        if (queryStatusA != null && !queryStatusA.isEmpty()) {
            queryStatus = queryStatusA;
        }
        if (queryStatusB != null && !queryStatusB.isEmpty()) {
            queryStatus = queryStatusB;
        }
        if (queryStatusC != null && !queryStatusC.isEmpty()) {
            queryStatus = queryStatusC;
        }
        if (queryEquipmentNameA != null && !queryEquipmentNameA.isEmpty()) {
            queryEquipmentName = queryEquipmentNameA;
        }
        if (queryEquipmentNameC != null && !queryEquipmentNameC.isEmpty()) {
            queryEquipmentName = queryEquipmentNameC;
        }
        if (queryEquipmentTypeA != null && !queryEquipmentTypeA.isEmpty()) {
            queryEquipmentType = queryEquipmentTypeA;
        }
        if (queryEquipmentTypeC != null && !queryEquipmentTypeC.isEmpty()) {
            queryEquipmentType = queryEquipmentTypeC;
        }
        if (queryMaintenanceSN == null || queryMaintenanceSN.isEmpty()) {
            queryMaintenanceSN = "";
        }
        if (queryEquipmentName == null || queryEquipmentName.isEmpty()) {
            queryEquipmentName = "";
        }
        if (queryEquipmentType == null || queryEquipmentType.isEmpty()) {
            queryEquipmentType = "";
        }
        String pageNumber = request.getParameter("pageNumber");
        String offset = request.getParameter("offset");
        String pageSize = request.getParameter("pageSize");
        backPageing(queryStatus, queryEquipmentName, queryEquipmentType, queryMaintenanceSN, pageNumber, offset, pageSize, response);
    }

    private void backPageing(String queryStatus, String queryEquipmentName, String queryEquipmentType, String queryMaintenanceSN, String pageNumber, String offset, String pageSize, HttpServletResponse response) throws IOException {
        ReturnData<MaintenanceInfo> returnData = new ReturnData<>();

        MaintenanceInfoService maintenanceInfoService = new MaintenanceInfoService();
        if (queryStatus.equals("3")) {
            queryStatus = " AND 1=1";
        } else {
            queryStatus = " AND a.status like '%" + queryStatus + "%'";
        }
        if ((queryEquipmentName != null && !queryEquipmentName.isEmpty()) || (queryEquipmentType != null && !queryEquipmentType.isEmpty()) || (queryMaintenanceSN != null && !queryMaintenanceSN.isEmpty())) {
            queryEquipmentName = " AND d.equipmentName like '%" + queryEquipmentName + "%' AND d.equipmentType like '%" + queryEquipmentType + "%' AND a.maintenanceSN like '%" + queryMaintenanceSN + "%'";
            queryEquipmentName += queryStatus;
        } else {
            queryEquipmentName = queryStatus;
        }
        List<MaintenanceInfo> queryList = maintenanceInfoService.selectByItems(queryEquipmentName, Integer.parseInt(pageNumber), Integer.parseInt(pageSize));

        int countRows = maintenanceInfoService.countRows(queryEquipmentName);
        returnData.setTotal(countRows);
        returnData.setRows(queryList);

        String result = JSON.toJSONString(returnData);

        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
