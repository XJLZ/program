package com.util;

import com.domain.Books;
import com.domain.PageBean;

import java.util.ArrayList;
import java.util.List;

public class page {

    public static List<Integer> Pagination(PageBean<Books> pb){
        List<Integer> list = new ArrayList<Integer>();
         /*
                    1.一共展示10个页码，能够达到前5后4的效果
                    2.如果前边不够5个，后边补齐10个
                    3.如果后边不足4个，前边补齐10个
                */
        // 定义开始位置begin,结束位置 end
        int begin; // 开始位置
        int end ; //  结束位置

        //1.要显示5个页码
        if(pb.getTotalPage() < 5){
            //总页码不够10页
            begin = 1;
            end = pb.getTotalPage();
        }else{
            //总页码超过10页
            begin = pb.getCurrentPage() - 2 ;
            end = pb.getCurrentPage() + 2 ;
            //2.如果前边不够5个，后边补齐10个
            if(begin < 1){
                begin = 1;
                end = begin + 4;
            }
            //3.如果后边不足4个，前边补齐10个
            if(end > pb.getTotalPage()){
                end = pb.getTotalPage();
                begin = end - 4 ;
            }
        }
        list.add(begin);
        list.add(end);
        return list;
    }
}
