package com.servlet.book;

import com.domain.Books;
import com.service.BookService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/bookUpdate")
public class BookUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        BookService bs = ac.getBean("BookService", BookService.class);
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Books book = new Books();
        try {
            BeanUtils.populate(book,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            bs.update(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        request.getRequestDispatcher("/bookList").forward(request,response);

        String referer = request.getHeader("referer");
        System.out.println("从哪来点的:" + referer);
        if(referer.contains("/bookList")){
            System.out.println(referer.split("/")[3]);
            response.sendRedirect(request.getContextPath()+"/" +referer.split("/")[3]);
        }

        if (referer.contains("/bookSearch")){
//            request.getRequestDispatcher("/" + referer.split("/")[3]).forward(request,response);
            System.out.println(referer.split("/")[3]);
            response.sendRedirect(request.getContextPath()+ "/" + referer.split("/")[3]);
        }
/*
        if (referer.contains("/productSearch")){
            String path = referer.split("/")[4];
            System.out.println(path);
            request.getRequestDispatcher("/" + path).forward(request,response);
        }
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
