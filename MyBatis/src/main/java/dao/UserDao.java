package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询所有
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
//    @Select("select * from user where id = #{id}")
    User findById( Integer id );

    /**
     * 添加数据
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 更新数据
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> findByName( String name);

    /**
     * 聚合函数
     * @return
     */
    int findTotal();

    /**
     * 动态查询
     * @param user
     * @return
     */
    List<User> findByDynamic(User user);
}
