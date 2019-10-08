package com.xjl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String url = "\"https://i0.hdslb.com/bfs/album/6ad839330e4cbf9626e498498dd41fea14f974b6.jpg\"";
        url = url.substring(1,url.lastIndexOf('\"'));
        System.out.println(url);

        String regEx="[`~!@#$%^&*()\\-+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}‘；：”“’。，、？]";
        Pattern   p   =   Pattern.compile(regEx);
        String searchKeyWord = "【Moon】_0.jpg";
        Matcher m   =   p.matcher(searchKeyWord);
        searchKeyWord =  m.replaceAll("").trim();
        System.out.println(searchKeyWord);
    }
}
