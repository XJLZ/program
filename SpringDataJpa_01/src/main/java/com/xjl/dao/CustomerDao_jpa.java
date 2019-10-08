package com.xjl.dao;

import com.xjl.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository<要操作实体类的类型，实体类中主键的类型>
 *     JpaSpecificationExecutor<要操作实体类的类型>
 */
public interface CustomerDao_jpa extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    //@Query 使用jpql的方式查询。
    @Query(value="from Customer")
    List<Customer> findAllCustomer();

    //@Query 使用jpql的方式查询。?1代表参数的占位符，其中1对应方法中的参数索引
    @Query(value="from Customer where custName = ?1")
    Customer findCustomer(String custName);

    //用 @Modifying 来将该操作标识为修改查询，这样框架最终会生成一个更新的操作，而非查询
    @Query(value="update Customer set custName = ?1 where custId = ?2")
    @Modifying
    void updateCustomer(String custName, Long custId);


    /**
     * nativeQuery : 使用本地sql的方式查询
     */
    @Query(value="select * from cst_customer",nativeQuery=true)
    void findSql();

}
