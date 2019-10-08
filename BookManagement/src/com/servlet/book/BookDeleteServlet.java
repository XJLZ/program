package com.servlet.book;

import com.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookDel")
public class BookDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        BookService bs = ac.getBean("BookService", BookService.class);
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        System.out.println(id);
        try {
            bs.deleteById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
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
            request.getRequestDispatcher("/" + referer.split("/")[3]).forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
