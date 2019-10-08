package dao;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据列名和值查询
     * @param column
     * @param value
     * @return
     */
//    @Select("select * from user where id = #{id}")
//    User findById( Integer id );
    @Select("select * from user where ${column} = #{value}")
    User findByColumn(@Param("column") String column, @Param("value") String value);

    /**
     * 添加数据
     * @param user
     * @return
     */
    @Insert("insert into user(username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address})")
    int saveUser(User user);

    /**
     * 更新数据
     * @param user
     * @return
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    int updateUser(User user);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @Update("delete from user where id = #{id};")
    int deleteUser(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName( String name);

    /**
     * 聚合函数
     * @return
     */
    @Select("select count(id) from user")
    int findTotal();
}
