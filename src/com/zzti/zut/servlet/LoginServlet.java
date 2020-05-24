package com.zzti.zut.servlet;

import com.zzti.zut.entity.UserInfo;
import com.zzti.zut.service.UserInfoService;
import com.zzti.zut.util.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("userName");
        String psw = request.getParameter("psw");
        String tryCode = request.getParameter("tryCode");

        UserInfoService userInfoService = new UserInfoService();
        int login = userInfoService.login(new UserInfo(userName, psw));

        String googleVerifyCode = request.getSession().getAttribute("googleVerifyCode").toString();
        if (!tryCode.equals(googleVerifyCode)) {
            //输入的验证码不正确，请重新输入
            request.getSession().setAttribute("msg", "输入的验证码不正确，请重新输入");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        if (login == 0) {
            // 输入的用户名或密码不存在，请重新输入。
            request.getSession().setAttribute("msg", "输入的用户名或密码不存在，请重新输入");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        request.getSession().setAttribute("loginUser", userName);
        request.getSession().setAttribute("loginID",login);
        response.sendRedirect(request.getContextPath() + "/main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
