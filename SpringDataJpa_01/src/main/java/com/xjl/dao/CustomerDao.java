package com.xjl.dao;

import com.xjl.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * JpaRepository<要操作实体类的类型，实体类中主键的类型>
 *     JpaSpecificationExecutor<要操作实体类的类型>
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
}
