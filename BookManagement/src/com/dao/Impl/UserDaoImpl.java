package com.dao.Impl;

import com.dao.UserDao;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate template;

    public User login(User loginuser) {
        User user = null;
        try {
            String sql = "select username,password  from `user` where username = ? and password = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginuser.getUsername(), loginuser.getPassword());
            return user;
        }catch (Exception e){
            return null;
        }
    }

    public boolean register(User registeruser) {
        //可以注册
        if(findOne(registeruser.getUsername()) == null){
            try {
                String sql = "insert into `user`(username, password) values (?, ?)";
                template.update(sql,registeruser.getUsername(), registeruser.getPassword());
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            //用户已存在
            return false;
        }
    }

    public User findOne(String username) {
        User user = null;
        try {
            String sql = "select username,password  from `user` where username = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
