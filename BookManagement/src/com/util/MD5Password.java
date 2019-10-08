package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Password {
//	public static String privateKey = "this_is_a_private_key";
	public static String myMD5(String orginString) {
//		orginString = orginString + privateKey;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(orginString.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 测试
	 */
	public static void main(String[] args) {
		System.out.println(myMD5("admin999").length());
	}
}
