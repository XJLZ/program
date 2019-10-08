package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @return
     */
    @Insert("insert into user values (#{id}, #{username}, #{birthday}, #{sex},  #{address})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(User user);

    /**
     * 查询用户
     * @param user
     */
    @Select("select * from user where id = #{id}")
    User select(User user);

    /**
     * 模糊查询
     * @param user
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName(User user);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(id) from user")
    int findTotal();
}
