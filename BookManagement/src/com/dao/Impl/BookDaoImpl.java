package com.dao.Impl;

import com.dao.BookDao;
import com.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate template;
    @Override
    public List<Books> findAll() {
        List<Books> books = null;
        try {
            String sql = "select * from books";
            books = template.query(sql, new BeanPropertyRowMapper<Books>(Books.class));
            return books;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from books ";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Books> findByPage(int start, int rows) {
        String sql = "select * from books limit ?, ? ";
        return template.query(sql,new BeanPropertyRowMapper<Books>(Books.class),start,rows);
    }

    @Override
    public void update(Books book) {
        String sql = "update books set bookName = ?, bookAuthor = ?, bookPress = ?, price = ?, pic = ? where bookId = ?";
        template.update(sql,book.getBookName(),book.getBookAuthor(), book.getBookPress(), book.getPrice(), book.getPic(), book.getBookId());

    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from books where bookId = ?";
        template.update(sql,id);
    }

    @Override
    public void save(Books book) {
        String sql = "insert into books(bookId,bookName,bookAuthor, bookPress, price, pic ) values (?,?,?,?,?,?) ";
        template.update(sql,book.getBookId(), book.getBookName(), book.getBookAuthor(), book.getBookPress(), book.getPrice(), book.getPic());
    }

    @Override
    public int searchTotalCount(String bookName) {
        String sql = "select count(*) from books where bookName like  ?";
        return template.queryForObject(sql,Integer.class,"%"+bookName+"%");
    }

    @Override
    public List<Books> searchByPage(int start, int rows, String bookName) {
        String sql = "select * from books where bookName like ? limit ?, ? ";
        return template.query(sql,new BeanPropertyRowMapper<Books>(Books.class),"%"+bookName+"%",start,rows);
    }

}
