package com.domain;

import com.service.AccountService;

import java.util.Date;

public class bean2 {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println(name+","+age+","+birthday);
    }
}
