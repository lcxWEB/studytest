package com.star.springboot.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/*** 字符串工具集 */

public class StrUtil {
	
	public final static Charset ASCII = Charset.forName("US-ASCII");
	public final static Charset UNICODE = Charset.forName("unicode");
	public final static Charset UTF8 = Charset.forName("UTF-8");
	public final static Charset UTF16 = Charset.forName("UTF-16");
	public final static Charset UTF16BE = Charset.forName("UTF-16BE");
	public final static Charset UTF16LE = Charset.forName("UTF-16LE");
	public final static Charset UTF32 = Charset.forName("UTF-32");
	public final static Charset GBK = Charset.forName("gbk");
	public final static Charset GB2312 = Charset.forName("gb2312");
	public final static Charset GB18030 = Charset.forName("gb18030");
	public final static Charset BIG5 = Charset.forName("big5");
	public final static Charset ISO_LATIN = Charset.forName("ISO8859-1");
	public final static Charset ISO8859_1 = Charset.forName("ISO8859-1");
	
	public final static Charset LocaleDefault = Charset.defaultCharset();
	
	public final static Charset TomcatDefault = ISO8859_1;
	
	public static String ChangeCharset(String value, Charset oldCharset, Charset newCharset){
		return new String(value.getBytes(oldCharset),newCharset);
	}  
 
    public static String escape(String src) {  
        int i;  
        char j;  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length() * 6);  
        for (i = 0; i < src.length(); i++) {  
            j = src.charAt(i);  
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j) || j == '@' || j == '*' || j == '_'|| j == '+'|| j == '-' || j == '.'|| j == '/')  
                tmp.append(j);  
            else if (j < 256) {
                tmp.append("%");  
                if (j < 16)  
                    tmp.append("0");  
                tmp.append(Integer.toString(j, 16).toUpperCase());  
            } else {  
                tmp.append("%u");  
                tmp.append(Integer.toString(j, 16).toUpperCase());  
            }  
        }  
        return tmp.toString();  
    } 
    
    public static String unescape(String src) {  
        StringBuffer tmp = new StringBuffer();  
        tmp.ensureCapacity(src.length());  
        int lastPos = 0, pos = 0;  
        char ch;  
        while (lastPos < src.length()) {  
            pos = src.indexOf("%", lastPos);  
            if (pos == lastPos) {  
                if (src.charAt(pos + 1) == 'u') {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 2, pos + 6), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 6;  
                } else {  
                    ch = (char) Integer.parseInt(src  
                            .substring(pos + 1, pos + 3), 16);  
                    tmp.append(ch);  
                    lastPos = pos + 3;  
                }  
            } else {  
                if (pos == -1) {  
                    tmp.append(src.substring(lastPos));  
                    lastPos = src.length();  
                } else {  
                    tmp.append(src.substring(lastPos, pos));  
                    lastPos = pos;  
                }  
            }  
        }  
        return tmp.toString();  
    } 
    
	public static String encodeURI(String value){
		return encodeURI(value,Charset.forName("utf8"));
	}	
	public static String decodeURI(String value){
		return decodeURI(value,Charset.forName("utf8"));
	}
	
	public static String encodeURI(String value,Charset charset){
		try {
			String v = new String(value);
			v = v.replace("~", "***hh***");
			v = v.replace("!", "***gt***");
			v = v.replace("@", "***at***");
			v = v.replace("#", "***jh***");
			v = v.replace("$", "***dl***");
			v = v.replace("&", "***ad***");
			v = v.replace("(", "***lk***");
			v = v.replace(")", "***rk***");
			v = v.replace("+", "***ah***");
			v = v.replace("=", "***eh***");
			v = v.replace(":", "***mh***");
			v = v.replace(";", "***fh***");
			v = v.replace("'", "***yh***");
			v = v.replace("?", "***wh***");
			v = v.replace(",", "***dh***");
			v = v.replace("/", "***xh***");
			String rt = URLEncoder.encode(v, charset.toString());
			rt = rt.replace("+", "%20");
			rt = rt.replace("***hh***", "~");
			rt = rt.replace("***gt***", "!");
			rt = rt.replace("***at***", "@");
			rt = rt.replace("***jh***", "#");
			rt = rt.replace("***dl***", "$");
			rt = rt.replace("***ad***", "&");
			rt = rt.replace("***lk***", "(");
			rt = rt.replace("***rk***", ")");
			rt = rt.replace("***ah***", "+");
			rt = rt.replace("***eh***", "=");
			rt = rt.replace("***mh***", ":");
			rt = rt.replace("***fh***", ";");
			rt = rt.replace("***yh***", "'");
			rt = rt.replace("***wh***", "?");
			rt = rt.replace("***dh***", ",");
			rt = rt.replace("***xh***", "/"); 
			return rt;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
	}	
	public static String decodeURI(String value ,Charset charset){
		try {
			String v = new String(value);
			v = v.replace("+", "***ah***"); 
			String rt = URLDecoder.decode(v, charset.toString());
			return rt.replace("***ah***", "+");					
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
 
	public static String encodeURIComponent(String value){
		return encodeURIComponent(value,Charset.forName("utf8"));
	}	
	public static String decodeURIComponent(String value){
		return decodeURIComponent(value,Charset.forName("utf8"));
	}
	
	public static String encodeURIComponent(String value,Charset charset){
		try {
			String v = new String(value);
			v = v.replace("~", "***hh***");
			v = v.replace("!", "***gt***"); 
			v = v.replace("(", "***lk***");
			v = v.replace(")", "***rk***");
			v = v.replace("+", "***ah***");
			v = v.replace("-", "***sh***"); 
			v = v.replace("'", "***yh***");
			v = v.replace(".", "***jh***"); 
			String rt = URLEncoder.encode(v, charset.toString());
			rt = rt.replace("+", "%20");
			rt = rt.replace("***hh***", "~");
			rt = rt.replace("***gt***", "!"); 
			rt = rt.replace("***lk***", "(");
			rt = rt.replace("***rk***", ")");
			rt = rt.replace("***ah***", "%2B");
			rt = rt.replace("***sh***", "-"); 
			rt = rt.replace("***yh***", "'");
			rt = rt.replace("***jh***", "."); 
			return rt;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}		
		
	}	
	public static String decodeURIComponent(String value,Charset charset){
		try {
			String v = new String(value);
			v = v.replace("+", "***ah***"); 
			String rt = URLDecoder.decode(v, charset.toString());
			return rt.replace("***ah***", "+");					
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
