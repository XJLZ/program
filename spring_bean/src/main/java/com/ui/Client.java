package com.ui;

import com.domain.bean1;
import com.domain.bean2;
import com.domain.bean3;
import com.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * 两个核心容器：
     * ApplicationContext：单例  开发采用此接口
     *          在构建核心容器时，立即加载，
     * BeanFactory:     多例
     *          在构建核心容器时，延迟加载，什么时候获取id，什么时候创建
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        //据id获取对象
        bean1 service = as.getBean("bean1", bean1.class);
        service.saveAccount();

        //set注入
        bean2 service2 = as.getBean("bean2", bean2.class);
        service2.saveAccount();

        System.out.println("====================");
        //集合数据注入
        bean3 service3 = as.getBean("bean3", bean3.class);
        service3.saveAccount();





//        手动销毁
        ((ClassPathXmlApplicationContext) as).close();

    }
}
