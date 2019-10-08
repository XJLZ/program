package com.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {

    /**
     * 传进来的字符串
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        if (s == null){
            System.out.println("请传入数据");
            throw new RuntimeException("请传入数据");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        try {
            System.out.println("原数据: "+s);
            System.out.println("转换后的数据: "+sdf.parse(s));
            return sdf.parse(s);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换错误");
        }
    }
}
