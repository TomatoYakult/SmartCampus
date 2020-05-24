package com.zzti.zut.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/servlet/logoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //invalidate()用于销毁当前用户的session对象，并解绑所有关联的对象数据
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
