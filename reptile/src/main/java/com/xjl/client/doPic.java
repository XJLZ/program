package com.xjl.client;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjl.domain.Cos;
import com.xjl.service.PictureService;
import com.xjl.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("doPic")
public class doPic {

    @Autowired
    private HttpUtil httpUtil;
    @Autowired
    private PictureService pictureService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，相隔多久进行下一次任务
    @Scheduled(fixedDelay = 100 * 1000 )
    public void task()throws Exception{
        //声明需要解析的url
//        String url = "https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=sifu&type=hot&page_size=20&page_num=";

        String url = "https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=cos&type=new&page_size=20&page_num=";
        //遍历，按照页码
        for (int i = 0; i < 3; i++) {
            System.out.println("url -->" + url+i);
            String json = httpUtil.doGetHtml(url );
            //解析页面，获取商品数据并储存
//            System.out.println("html --->" + json);
            parse(json);
        }

        System.out.println("手机数据抓取成功。。。。。");
    }

    /**
     * 解析页面，获取商品数据并储存
     * @param json
     * @throws Exception
     */
    private void parse (String json) throws Exception {

        JsonNode info = MAPPER.readTree(json).get("data").get("items");
        int items_size = info.size();
        for (int i = 0; i < items_size; i++) {
            //用户信息
            String uid = info.get(i).get("user").get("uid").toString();

            String name = strTrim(info.get(i).get("user").get("name").toString());

            String title = strTrim(info.get(i).get("item").get("title").toString());

            String category = strTrim(info.get(i).get("item").get("category").toString());
            //图片信息
            int pictures_size = info.get(i).get("item").get("pictures").size();
            JsonNode pictures = info.get(i).get("item").get("pictures");
            for (int j = 0; j < pictures_size; j++) {
                Cos cos = new Cos();
                String img_src = strTrim(pictures.get(j).get("img_src").toString());
                String picName = httpUtil.doGetImage(img_src,title + "_" + j);
                cos.setUid(uid);
                cos.setName(name);
                cos.setTitle(title + "_" + j);
                cos.setCategory(category);
                cos.setImgSrc(img_src);
                //保存数据到数据库
                pictureService.save(cos);
            }
        }


    }


    /**
     * 去除多余的引号
     * @param s
     * @return
     */
    public String strTrim (String s){
        return s.substring(1,s.lastIndexOf('\"'));

    }
}
