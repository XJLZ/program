package xjl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xjl.domain.User;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

}
