package com.ai.gzesp.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 使用 commons-codec 进行 BASE64编解码
 * @author xmh
 *
 */
public class Base64Utils {

	/**
     * 使用Base64加密算法加密字符串
     * @param plainText
     * @return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }
    
    /**
     * 使用Base64解码
     * @param encodeStr
     * @return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }
    
    public static void main(String[] args) {
		System.out.println(encodeStr("ximinhui"));
		System.out.println(decodeStr(encodeStr("ximinhui")));
	}
}
