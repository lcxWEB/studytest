package com.star.springboot.utils;


import java.nio.charset.Charset;
import java.security.MessageDigest;



//入口时HashUtil.MD5ex(password);

/*** Hash 及 加解密 工具集 */

public class HashUtil {
	
	public final static String HashSeed = "KESN Kit Framework";
	public final static String HashOpenId = "WX OPENID INFO";

	private final static String MD_MD5 = "MD5";

	
	
	private static String MD(byte[] stream, String type){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(type);
			md.update(stream);
			return HexCoder(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String HexCoder(byte[] stream){
		StringBuilder sb = new StringBuilder();
        for (byte b: stream) {
        	String ss = "00" + Integer.toHexString(b&0xff);
        	sb.append(ss.substring(ss.length()-2));
         }
        return sb.toString();
	}
 
	
	//=================================================================================MD5
	
	public static final String MD5(byte[] stream){
		return MD(stream,MD_MD5);
	}
	
	public static final String MD5(Charset charset, String ...str){
		String s = AryUtil.Join(str);
		return MD(s.getBytes(charset),MD_MD5);
	}
 
	public static final String MD5(String key ,Charset charset, String ...str){
		String s = AryUtil.Join(str) + key;
		return MD(s.getBytes(charset),MD_MD5);
	}	
	
	public static final String MD5ex(String ...str){
		return MD5(HashUtil.HashSeed,StrUtil.UTF8,str);
	}

	public static final String MD5OpenId(String ...str){
		return MD5(HashUtil.HashOpenId,StrUtil.UTF8,str);
	}

}
