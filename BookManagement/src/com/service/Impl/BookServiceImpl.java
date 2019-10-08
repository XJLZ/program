package com.service.Impl;

import com.dao.BookDao;
import com.domain.Books;
import com.domain.PageBean;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Books> findAll() {
        return bookDao.findAll();
    }

    @Override
    public PageBean<Books> findByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1 ;
        }
        //创建空的对象
        PageBean<Books> pb = new PageBean<Books>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用dao查询总记录数
        int totalCount = bookDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Books> list = bookDao.findByPage(start,rows);
        pb.setList(list);
        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows :(totalCount / rows) + 1 ;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void update(Books book) {
        bookDao.update(book);
    }

    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public void save(Books book) {
        bookDao.save(book);
    }

    @Override
    public PageBean<Books> searchByPage(String _currentPage, String _rows, String bookName) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1 ;
        }
        //创建空的对象
        PageBean<Books> pb = new PageBean<Books>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用dao查询总记录数
        int totalCount = bookDao.searchTotalCount(bookName);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Books> list = bookDao.searchByPage(start,rows,bookName);
        pb.setList(list);
        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows :(totalCount / rows) + 1 ;
        pb.setTotalPage(totalPage);
        return pb;
    }

}
