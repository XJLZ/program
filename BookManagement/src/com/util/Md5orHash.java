package com.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Md5orHash  {
    public static void main(String[] args) throws Exception {
        //check();
        md5(); //9003d1df22eb4d3820015070385194c8

        System.out.println(getHash("root","MD5")); // 63a9f0ea7bb98050796b649e85481845
        System.out.println(getHash("root","SHA")); // dc76e9f0c0006e8f919e0c515c66dbba

        System.out.println(getHash2("root","MD5")); // 63A9F0EA7BB98050796B649E85481845
        System.out.println(getHash2("root","SHA")); // DC76E9F0C0006E8F919E0C515C66DBBA3982F785

        System.out.println(getHash3("root","MD5")); // 63a9f0ea7bb98050796b649e85481845
        System.out.println(getHash3("root","SHA")); // dc76e9f0c0006e8f919e0c515c66dbba3982f785

        String plainText = "root";
        String encodedPassword = getDigest(encode(plainText));
        System.out.println(encodedPassword); // 60f9efa87aa40dd577962c2425191e2c
    }

    /**
     * 使用位运算符，将加密后的数据转换成16进制
     * @param source 需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash(String source, String hashType) {

        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            md.update(source.getBytes()); // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
            byte[] encryptStr = md.digest(); // 获得密文完成哈希计算,产生128 位的长整数
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            return new String(str); // 换后的结果转换为字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用格式化方式，将加密后的数据转换成16进制（推荐）
     * @param source 需要加密的字符串
     * @param hashType  加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash2(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用算法，将加密后的数据转换成16进制
     * @param source 需要加密的字符串
     * @param hashType  加密类型 （MD5 和 SHA）
     * @return
     */
    public static String getHash3(String source, String hashType) {

        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            byte[] encryptStr = md5.digest();
            for (int i = 0; i < encryptStr.length; i++) {
                int iRet = encryptStr[i];
                if (iRet < 0) {
                    iRet += 256;
                }
                int iD1 = iRet / 16;
                int iD2 = iRet % 16;
                sb.append(hexDigits[iD1] + "" + hexDigits[iD2]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 简单的md5加密
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static void md5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String x="pwd";
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(x.getBytes("UTF8"));
        byte s[ ]=m.digest( );
        String result="";
        for (int i=0; i<s.length;i++){
            result+=Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
        }
        System.out.println(result);
    }

    /**
     * 使用md5的算法进行加密
     * @param plainText 加密明文
     * @return 加密密文
     */
    public static String getDigest(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("error happens", e);
        }
        return new BigInteger(1, secretBytes).toString(16);
    }

    /**
     * 使用Base64进行编码
     * @param encodeContent 需要编码的内容
     * @return 编码后的内容
     */
    public static  String encode(String encodeContent) {
        if (encodeContent == null) {
            return null;
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encodeContent.getBytes());
    }

    private static void check() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入:");
        String str = in.nextLine();
        String regex = ""+str+".*|.*"+str+"";
        List<String> list = new ArrayList();
        list.add("中国北京");
        list.add("中国上海");
        list.add("中国湖北");
        list.add("中国湖南");
        list.add("上海浦东");
        list.add("美国纽约");
        for (String s : list) {
            if (s.matches(regex)){
                System.out.println(s);
            }
        }
    }
}
