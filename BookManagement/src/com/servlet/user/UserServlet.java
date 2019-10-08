package com.servlet.user;

import com.domain.User;
import com.service.UserService;
import com.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    UserService us = ac.getBean("userService", UserService.class);
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Map<String, String[]> map = request.getParameterMap();
        //创建对象
        User registeruser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(registeruser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UserService的register方法
        boolean user = us.register(registeruser);
        if (user){
            //注册成功
            session.setAttribute("registerMsg","恭喜您！注册成功！");
            response.sendRedirect(request.getContextPath()+"/book/registerSuccess.jsp");
//            request.getRequestDispatcher("/admin/registerSuccess.jsp").forward(request,response);
        }else {
            //注册失败
            session.setAttribute("registerMsg","您注册的用户名已经存在，请重新注册！");
            response.sendRedirect(request.getContextPath()+"/book/registerFail.jsp");

//            request.getRequestDispatcher("/admin/registerFail.jsp").forward(request,response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        //判断用户名和密码是否一致
        Map<String, String[]> map = request.getParameterMap();
        //创建对象
        User loginuser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginuser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UserService的login方法
        User user = us.login(loginuser);
        //判断user
        if (user != null) {
            //登录成功
            //存储信息，用户信息
            session.setAttribute("username", username);
            //重定向到index.jsp
            response.sendRedirect(request.getContextPath() + "/book/index.jsp");
        } else {
            //登录失败
            //存储提示信息到request
            session.setAttribute("login_error", "用户名或密码错误");
            //转发到登录页面
            response.sendRedirect(request.getContextPath() + "/book/login.jsp");
//            request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        }
    }

    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/book/login.jsp");
    }
}
