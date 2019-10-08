## com.xjl.client.doPic

String url = "https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=cos&type=hot&page_size=20&page_num=";

按照页码遍历，url可以更换下方提供的API



## com.xjl.util.HttpUtil

下载图片的位置

 File file = new File("C:\\Users\\root\\Desktop\\Photos\\sifu1008\\" + pName + exName);

可以更改自己的下载目录

## com.xjl.domain.Cos

数据库表字段

------

-- Table structure for cos

------

DROP TABLE IF EXISTS `cos`;
CREATE TABLE `cos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_src` varchar(200) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



## 一些API

*ps:在放入url中可以更改“page_size”的数值，并且把”page_num=“放置最后*

### 排行

#### 排行-摄影

https://api.vc.bilibili.com/link_draw/v2/Doc/rank?biz=2&category=cos&rank_type=day&page_size=5  &rank_type=week/month

#### 排行-画友

https://api.vc.bilibili.com/link_draw/v2/Doc/rank?biz=1&rank_type=month&page_size=5  &rank_type=week/month

### 摄影

#### 摄影-私服

https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=sifu&type=new&page_num=0&page_size=20
https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=sifu&type=hot&page_num=0&page_size=20

#### 摄影-cosplay

https://api.vc.bilibili.com/link_draw/v2/Photo/index?type=recommend&page_num=0&page_size=45   
https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=cos&type=hot&page_num=0&page_size=20
https://api.vc.bilibili.com/link_draw/v2/Photo/list?category=cos&type=new&page_num=0&page_size=20

### 画友

#### 画友-漫画

https://api.vc.bilibili.com/link_draw/v2/Doc/index?type=recommend&page_num=0&page_size=45   

可选参数（acg   &type=hot）
https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=comic&type=hot&page_num=0&page_size=20
https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=comic&type=new&page_num=0&page_size=20

#### 画友-插画

https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=illustration&type=hot&page_num=0&page_size=20
https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=illustration&type=new&page_num=0&page_size=20

#### 画友-其他

https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=draw&type=hot&page_num=0&page_size=20
https://api.vc.bilibili.com/link_draw/v2/Doc/list?category=draw&type=new&page_num=0&page_size=20