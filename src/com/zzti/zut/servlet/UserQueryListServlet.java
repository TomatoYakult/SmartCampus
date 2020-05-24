package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.entity.ReturnData;
import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.service.UserInfoService;
import com.zzti.zut.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserQueryListServlet", urlPatterns = "/servlet/user/queryList")
public class UserQueryListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryName = request.getParameter("queryName");
        String pageNumber = request.getParameter("pageNumber");
        String offset = request.getParameter("offset");
        String pageSize = request.getParameter("pageSize");
        backPageing(queryName, pageNumber, offset, pageSize, response);
    }

    private void backPageing(String queryName, String pageNumber, String offset, String pageSize, HttpServletResponse response) throws IOException {
        //response.setContentType("text/json;charset=utf-8");

        ReturnData<UserInfo> returnData = new ReturnData<>();

        UserInfoService userInfoService = new UserInfoService();
        if (queryName != null && !queryName.isEmpty()) {
            queryName = " where username like '%" + queryName + "%'";
        }
        List<UserInfo> queryList = userInfoService.selectByItems(queryName, Integer.parseInt(pageNumber), Integer.parseInt(pageSize));

        int countRows = userInfoService.countRows(queryName);
        returnData.setTotal(countRows);
        returnData.setRows(queryList);

        String result = JSON.toJSONString(returnData);

        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }
}
