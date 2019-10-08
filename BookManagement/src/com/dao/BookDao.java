package com.dao;


import com.domain.Books;

import java.util.List;

public interface BookDao {

    List<Books> findAll();


    int findTotalCount();


    List<Books> findByPage(int start, int rows);

    void update(Books book);

    void deleteById(int id);

    void save(Books book);

    int searchTotalCount(String bookName);

    List<Books> searchByPage(int start, int rows, String bookName);
}
