package com.ai.gzesp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.ai.gzesp.unionpay.UnionPayCons;

/**
 * md5加密解密工具<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MD5Util {
    
    private static final Logger log = Logger.getLogger(MD5Util.class); 
    
    /*** 
     * MD5加码 生成32位md5码 ，银联需要有秘钥，把原报文后面加个秘钥字符串
     */  
    public static String str2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            log.debug("【MD5加密：生成32位MD5码异常】");
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = (inStr+UnionPayCons.md5Key).toCharArray();  //原字符串后加个秘钥
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        
        log.debug("【MD5加密：生成32位MD5码，" + hexValue.toString() + "】");
        return hexValue.toString();  
  
    }  
  
    /** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
    
    /**
     * 银联冯工给的md5算法，需要加密秘钥
     * 
     * @param plainText 待加密字符串
     * @param key 签名密钥
     * @return 加密后字符串
     */
    public static String md5s(String plainText, String key) {
        plainText = plainText + key; //等于把原报文后面加个秘钥字符串
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        
        return buf.toString();
    }
    
    /**
     * 功能描述: 银联袁静给的md5加密摘要<br>
     * 〈功能详细描述〉
     *
     * @param plainText
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String md5s2(String plainText, String key)
    {
      return md5s2(plainText + key);
    }

    public static String md5s2(String plainText)
    {
      StringBuffer buf = new StringBuffer("");
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try {
          md.update(plainText.getBytes(UnionPayCons.charCode));
        }
        catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
        byte[] b = md.digest();

        for (int offset = 0; offset < b.length; offset++) {
          int i = b[offset];
          if (i < 0)
            i += 256;
          if (i < 16)
            buf.append("0");
          buf.append(Integer.toHexString(i));
        }
        return buf.toString();
      }
      catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }

      return buf.toString();
    }    
  
    // 测试主函数  
    public static void main(String args[]) {  
        String s = new String("<requestData><charCode></charCode></requestData>");  
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + str2MD5(s));  
        System.out.println("加密的：" + convertMD5(s));  
        System.out.println("解密的：" + convertMD5(convertMD5(s)));  
  
    }  
}
