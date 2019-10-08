package com.controller;

import com.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class execptionController {

    @RequestMapping("/error")
    public String toErrorPage() throws SysException {
        System.out.println("toErrorPage执行了。。。。");
        try {
            //模拟异常
            int i = 1/0;
        }catch (Exception e){
            System.out.println("出错了。。。。");
            throw new SysException("你的操作导致服务器炸了。。。。");
        }
        return "success";
    }
}
