package com.ui;

import com.dao.AccountDao;
import com.dao.Impl.AccountDaoImpl;
import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
//        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext as = new ClassPathXmlApplicationContext("bean_annotation.xml");
        //据id获取对象
        //据id获取对象
        AccountService service = as.getBean("service", AccountService.class);

        service.saveAccount();

    }
}
