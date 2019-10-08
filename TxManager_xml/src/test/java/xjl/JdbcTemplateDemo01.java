package xjl;

import com.xjl.domain.TxAccount;
import com.xjl.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateDemo01 {

    @Autowired
    private AccountService service;

   @Test
    public void findAll(){
       List<TxAccount> accounts = service.findAll();
       System.out.println(accounts);
   }

   @Test
    public void change(){
       service.change("Tom","Jack",100);
   }
}
