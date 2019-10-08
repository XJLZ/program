package com.servlet.user;

import com.domain.User;
import com.service.Impl.UserServiceImpl;
import com.service.UserService;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService cs = ac.getBean("userService", UserService.class);
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
        boolean user = cs.register(registeruser);
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
