package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.service.UserInfoService;
import com.zzti.zut.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet", urlPatterns = "/servlet/user/add")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserInfoService userInfoService = new UserInfoService();
        boolean insert = userInfoService.insert(new UserInfo(username, password));
        //response.setContentType("text/json;charset=utf-8");
        JSONObject result = new JSONObject();
        if (insert) {
            result.put("message", "增加用户成功！");
            result.put("status", "success");
        } else {
            result.put("message", "增加用户失败！");
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
