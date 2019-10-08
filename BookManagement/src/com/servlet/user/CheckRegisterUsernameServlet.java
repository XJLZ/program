package com.servlet.user;

import com.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkRegisterUsername")
public class CheckRegisterUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService cs = ac.getBean("userService", UserService.class);
        String username = request.getParameter("registerUsername");
        System.out.println(username);
//        User user = null;
//        try {
//            user = cs.findOne(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
