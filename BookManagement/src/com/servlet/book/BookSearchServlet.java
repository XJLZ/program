package com.servlet.book;

import com.domain.Books;
import com.domain.PageBean;
import com.service.BookService;
import com.util.page;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        BookService bs = ac.getBean("BookService", BookService.class);
        request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        request.setAttribute("bookName",bookName);
        //获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows"); //每页显示的条数
        if (currentPage ==null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }
        request.setAttribute("row",rows);
        //调用service查询
        PageBean<Books> pb = bs.searchByPage(currentPage,rows,bookName);

        //存入request域
        request.setAttribute("pb",pb);
        List<Integer> pagination = page.Pagination(pb);
        request.setAttribute("begin", pagination.get(0));
        request.setAttribute("end", pagination.get(1));
        if (pb.getList() != null){
            request.getRequestDispatcher("/book/bookSearch.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
