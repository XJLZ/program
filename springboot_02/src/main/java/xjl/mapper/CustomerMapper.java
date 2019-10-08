package xjl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xjl.domain.Customer;

import java.util.List;

@Mapper
public interface CustomerMapper {

//    @Select("select * from customer")
    List<Customer> findAll();
}
