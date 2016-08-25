package com.ai.gzesp.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.Charsets;

/**
 * 加解密 工具类
 * @author xmh
 *
 */
public class EncryptUtil {
	
    /**
     * DESede:3des算法
     */
    private static final String DesMode = "DESede"; 
	
//	private static final String DesKey = "e143cc8236aed7f7786da932";
    
    /**
     * 3des对称加密算法，算法模式ECB，密钥长度（24个字符）。加密数据补码方式：Pkcs5Padding
     */
    private static final String DesAlgorithm = "DESede/ECB/PKCS5Padding"; //DESede/ECB/PKCS5Padding
    
//    public static String encryptByDes(String keybyte, String src) {
//    	byte[] temp = encryptByDes(keybyte.getBytes(Charsets.UTF_8), src.getBytes(Charsets.UTF_8));
//    	return new String(temp);
//    }
    
    
    /**
     * des 加密，默认 utf-8，返回字节数组
     * 不能把加密后的字节数组直接转换成字符串，得用Base64Utils.encode(buf)
     * 解密时会报javax.crypto.IllegalBlockSizeException: Input length must be multiple of 8 when decrypting with padded cipher异常
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] encryptByDes(String keybyte, String src) {
    	return encryptByDes(keybyte.getBytes(Charsets.UTF_8), src.getBytes(Charsets.UTF_8));
    }
    
    /**
     * des加密
     * src为被加密的数据缓冲区（源）
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] encryptByDes(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, DesMode); //"DESede"

            // 加密
            Cipher c1 = Cipher.getInstance(DesAlgorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }
    
    /**
     * des 解密
     * @param keybyte
     * @param src
     * @return
     */
//    public static byte[] decryptByDes(String keybyte, String src) {
//    	return decryptModeRecharge(keybyte.getBytes(Charsets.UTF_8), src.getBytes(Charsets.UTF_8));
//    }
    
    /**
     * des解密
     * keybyte为加密密钥
     * src为加密后的缓冲区
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] decryptByDes(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, DesMode); //"DESede"

            // 解密
            Cipher c1 = Cipher.getInstance(DesAlgorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }
    
    /**
     * md5加密
     * @param key
     * @param src
     * @return
     */
    public static String encryptByMd5(String key, String src)
    {
      return encryptByMd5(src + key);
    }

    /**
     * md5加密 ，不带key
     * @param src
     * @return
     */
    public static String encryptByMd5(String src)
    {
      StringBuffer buf = new StringBuffer();
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(src.getBytes(Charsets.UTF_8));
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
    
    
    
    public static void main(String[] args) {
    	String desKey = "e143cc8236aed7f7786da932";
		String src = "{\"phone_number\":\"18651885060\", \"fee\":\"50\", \"order_id\":\"123\", \"req_time\":\"20160204120000\"}";

		System.out.println("----加密前---");
		System.out.println(src);
		
		System.out.println("----加密后---");
		byte[] tarArray = encryptByDes(desKey, src);
		String tar = Base64Utils.encode(tarArray);
		System.out.println(tar);
		
		System.out.println("----解密后---");
		byte[] respArray = Base64Utils.decode(tar.getBytes(Charsets.UTF_8));
		System.out.println(new String(decryptByDes(desKey.getBytes(Charsets.UTF_8), respArray)));
	    
    }

}
