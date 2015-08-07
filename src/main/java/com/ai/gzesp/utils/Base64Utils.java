package com.ai.gzesp.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 使用 commons-codec 进行 BASE64编解码
 * @author xmh
 *
 */
public class Base64Utils {

/*	*//**
     * 使用Base64加密算法加密字符串
     * @param plainText
     * @return
     *//*
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }
    
	*//**
     * 使用Base64加密算法加密byte[]
     * @param plainText
     * @return
     *//*
    public static String encodeStr(byte[] plain){
        Base64 base64=new Base64();
        byte[] target = base64.encode(plain);
        String s=new String(target);
        return s;
    } 
    
    
    *//**
     * 使用Base64解码
     * @param encodeStr
     * @return
     *//*
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }*/
    
    /** 
     * 解密
     * @param bytes 
     * @return 
     */  
    public static byte[] decode(final byte[] bytes) {  
        return Base64.decodeBase64(bytes);  
    }  
  
    /** 
     * 二进制数据编码为BASE64字符串 
     * 加密
     * @param bytes 
     * @return 
     * @throws Exception 
     */  
    public static String encode(final byte[] bytes) {  
        return new String(Base64.encodeBase64(bytes));  
    } 
    
    public static void main(String[] args) {
		//System.out.println(encodeStr("ximinhui"));
		//System.out.println(decodeStr(encodeStr("ximinhui")));
		
/*		byte[] plain = "ximinhui".getBytes();
		System.out.println(plain);
        Base64 base64=new Base64();
        byte[] target = base64.encode(plain);
        System.out.println(target);
        String s=new String(target);
        System.out.println(s);
        
        System.out.println(decodeStr(s));*/
    	
    	String plain = "oRssR3iFHV7wWtevSHyqXl4Bo9Gs8klO";
    	System.out.println(plain.getBytes().length);
    	
    	String target = encode(plain.getBytes());
    	System.out.println(target.getBytes().length);
        
    	byte[] news = decode(target.getBytes());
    	System.out.println(new String(news));
	}
}
