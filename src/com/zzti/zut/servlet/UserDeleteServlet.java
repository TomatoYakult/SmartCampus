package com.zzti.zut.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.service.UserInfoService;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

@WebServlet(name = "UserDeleteServlet", urlPatterns = "/servlet/user/delete")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfoService userInfoService = new UserInfoService();
        boolean delete = userInfoService.delete(id);
        //response.setContentType("text/json;charset=utf-8");
        JSONObject result = new JSONObject();
        if (delete) {
            result.put("message", "删除用户成功！");
            result.put("status", "success");
        } else {
            result.put("message", "删除用户失败！");
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
