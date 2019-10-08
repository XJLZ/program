package com.service;

import com.domain.Books;
import com.domain.PageBean;

import java.util.List;

public interface BookService {

    List<Books> findAll();


    PageBean<Books> findByPage(String currentPage, String rows);

    void update(Books book);

    void deleteById(int parseInt);

    void save(Books book);

    PageBean<Books> searchByPage(String currentPage, String rows, String bookName);

}
