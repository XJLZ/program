package com.controller;

import com.domain.Account;
import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class pramrController {

    @RequestMapping("/testparam")
    public String testparam(String username, String password){
        System.out.println("执行了......");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "success";
    }

    /**
     * 请求参数封装到JavaBean类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了......");
        System.out.println(account);
        System.out.println("......");
//        System.out.println(account.getUser());
        System.out.println(account.getList());
        System.out.println("............");
        System.out.println(account.getMap());
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了......");
        System.out.println(user);
        return "success";
    }
}
