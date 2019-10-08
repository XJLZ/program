package dao;

import domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据列名和值查询
     * @param column
     * @param value
     * @return
     */
    List<User> findByColumn(@Param("column") String column, @Param("value") String value);

    User findById(Integer id);

    Integer insertUser(User user);

    Integer updateById(User user);

    Integer deleteById (Integer id);

    List<User> findAccounts();

    List<User> findByIds (Integer [] ids);
}
