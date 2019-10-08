package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException se = null;
        try {
            if (e instanceof SysException){
                se = (SysException)e;
            }else {
                new SysException("系统维护中。。。。。");
            }
            ModelAndView mv = new ModelAndView();
            mv.addObject("errorMsg",se.getMsg());
            mv.setViewName("ErrorPage");
            return mv;
        }catch (Throwable t){
            throw new RuntimeException(t);
        }
    }
}
