package com.servlet.book;

import com.domain.Books;
import com.domain.PageBean;
import com.service.BookService;
import com.servlet.BaseServlet;
import com.util.page;
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
import java.util.List;
import java.util.Map;

@WebServlet("/bookManager/*")
public class BookServlet extends BaseServlet {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    BookService bs = ac.getBean("BookService", BookService.class);
    public void bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        PageBean<Books> pb = bs.findByPage(currentPage,rows);

        //存入request域
        request.setAttribute("pb",pb);

//        for (Product product : pb.getList()) {
//            System.out.println(product);
//        }
        List<Integer> pagination = page.Pagination(pb);
        request.setAttribute("begin", pagination.get(0));
        request.setAttribute("end", pagination.get(1));
        if (pb.getList() != null){
            request.getRequestDispatcher("/book/bookList.jsp").forward(request,response);
        }
    }

    public void bookInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            bs.save(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/bookList").forward(request,response);
    }

    public void bookSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        request.setAttribute("bookName", bookName);
        //获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows"); //每页显示的条数
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        request.setAttribute("row", rows);
        //调用service查询
        PageBean<Books> pb = bs.searchByPage(currentPage, rows, bookName);

        //存入request域
        request.setAttribute("pb", pb);
        List<Integer> pagination = page.Pagination(pb);
        request.setAttribute("begin", pagination.get(0));
        request.setAttribute("end", pagination.get(1));
        if (pb.getList() != null) {
            request.getRequestDispatcher("/book/bookSearch.jsp").forward(request, response);
        }
    }

    public void bookDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
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
            System.out.println(referer.split("/")[3]);
            response.sendRedirect(request.getContextPath()+ "/" + referer.split("/")[3] + "/" + referer.split("/")[4] );

        }
    }

    public void bookUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.sendRedirect(request.getContextPath()+ "/" + referer.split("/")[3] + "/" + referer.split("/")[4] );
        }
/*
        if (referer.contains("/productSearch")){
            String path = referer.split("/")[4];
            System.out.println(path);
            request.getRequestDispatcher("/" + path).forward(request,response);
        }
         */
    }

}
