package dao;

import domain.Account;
import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface Annoation {

    @Select("select * from user")
    @Results(id = "userMap", value ={
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "address", property = "address"),
            @Result(column = "id", property = "accounts",
                    many = @Many(select = "dao.AccountDao.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();



    @Select("select * from account")
    @Results(id = "accountMap", value ={
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user",
                    one = @One(select = "dao.UserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAccounts();
}
