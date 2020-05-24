package com.zzti.zut.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "PermissionFilter", urlPatterns = {"/servlet", "*.jsp"}, initParams = {
        @WebInitParam(name = "ignores", value = "/login.jsp;/servlet/LoginServlet;/servlet/LogoutServlet;/css;/assets;/js;/img;/equipment;/system"
        )})
public class PermissionFilter implements Filter {
    private String excludePage;
    private String[] excludePages;

    @Override
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        boolean flag = false;
        for (String page : excludePages) {
            if (servletPath.contains(page)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object loginUser = session.getAttribute("loginUser");
            if (loginUser == null) {
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
        excludePage = config.getInitParameter("ignores");
        if (excludePage != null && excludePage.length() > 0) {
            excludePages = excludePage.split(";");
        }
    }

}
