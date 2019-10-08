package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串 底层使用ModelAndView
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了。。。。。");
        //模拟查询数据库
        User user = new User();
        user.setName("张三");
        user.setAge(32);
        user.setDate(new Date());
        //存入request域
        model.addAttribute("one",user);
        return "success";
    }

    /**
     * 无返回值，请求一次转发
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了。。。。。");
        //使用原生servlet
        request.setAttribute("name","李四");
        request.getSession().setAttribute("name2","王五");
//        request.getRequestDispatcher("/pages/success.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }

    /**
     * 返回值是ModelAndView,
     * @return
     */
    @RequestMapping("/ModelAndView")
    public ModelAndView ModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("ModelAndView执行了。。。。。");
        //模拟查询数据库
        User user = new User();
        user.setName("赵六");
        user.setAge(62);
        user.setDate(new Date());
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字进行 转发 和 重定向
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/testKey")
    public String key(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testKey执行了。。。。。");

        //转发
//        return "forward:/pages/success.jsp";

        //重定向
        return "redirect:/pages/success.jsp";
    }

    @RequestMapping("/ajax")
    public @ResponseBody User testAjax(@RequestBody User body){
        System.out.println("ajax执行了。。。。。");
        System.out.println(body);
        User user = new User();
        user.setName("Rose");
        user.setAge(23);
        user.setDate(new Date());
        return user;
    }
}
