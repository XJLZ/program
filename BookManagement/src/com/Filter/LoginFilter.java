package com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  登录过滤
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取请求路径
        String uri = request.getRequestURI();
        //排除登录资源
        if ( uri.contains("/login.jsp") || uri.contains("/login") || uri.contains("/css/") || uri.contains("/js/") ||  uri.contains("/CheckCod") ||
                uri.contains("/register") || uri.contains("/img")){
            chain.doFilter(req, resp);
        } else {
            //需要验证用户是否登录
            Object user = request.getSession().getAttribute("username");
            if (user != null){
                //登录过，放行
                chain.doFilter(req, resp);
            } else {
                //没有登录，跳转到登录页面
//                request.setAttribute("login_msg" ,"您还没有登录，请登录！！");
//                request.getRequestDispatcher("/login.jsp").forward(request,resp);
                request.getSession().setAttribute("login_error" ,"您还没有登录，请登录！！");
                response.sendRedirect(request.getContextPath()+"/book/login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }
}
