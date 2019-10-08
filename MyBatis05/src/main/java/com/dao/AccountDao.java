package com.dao;

import com.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user", column = "uid",
                    one = @One(select = "com.dao.UserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户ID查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer uid);
}
