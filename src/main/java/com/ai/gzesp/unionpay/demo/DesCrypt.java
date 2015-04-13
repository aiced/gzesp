package com.lyhf.tools;

import java.io.IOException;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class DesCrypt {
	
	private static Cipher cipherInstance = null;

	private static Cipher getCipherInstance(){
		try{
			if(cipherInstance==null)
				cipherInstance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		}catch(Exception e)
		{
			e.printStackTrace();
		}   
		return cipherInstance;
	}
	/**
	 * BASE64编码
	 *
	 * @param inputByte 待编码数据
	 * @return 解码后的数据
	 * @throws IOException
	 */
	public static byte[] base64Encode(byte[] inputByte) throws IOException {
		return Base64.encodeBase64(inputByte);
	}
	
	public static final byte[] Key = "e143cc8236aed7f7786da932".getBytes();
    private static final String Algorithm = "DESede";  //定义 加密算法
    //加密字符串
    public static byte[] encrypt(byte[] data,String key) throws Exception{
    	return encryptMode(key.getBytes(),data);
    }
    public static byte[] encrypt(String data,String key) throws Exception{ 
    	return encrypt(data.getBytes("GBK"),key);
    }
    /*public static byte[] encrypt(String data) throws Exception{
    	return encryptMode(Key,data.getBytes("GBK"));
    }
    public static byte[] encrypt(byte[] data) throws Exception{
    	return encryptMode(Key,data);
    }*/
    //解密字符串
    public static byte[] decrypt(byte[] data,String key){
    	return decryptMode(key.getBytes(),data);
    }
    /*public static byte[] decrypt(String data) throws Exception{
    	return decryptMode(Key,data.getBytes("GBK"));
    }
    public static byte[] decrypt(byte[] data) throws Exception{
    	return decryptMode(Key,data);
    }*/
    // 加密字符串
    public static byte[] encryptMode(byte[] keybyte, byte[] src) throws Exception{
        try { // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); // 加密
            Cipher cipherInstance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//            cipherInstance = getCipherInstance();
            cipherInstance.init(Cipher.ENCRYPT_MODE, deskey);
            return cipherInstance.doFinal(src);
        }  catch (java.lang.Exception e3) {
            throw e3;
        }
    }
 
    // 解密字符串
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try { // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); // 解密
            Cipher cipherInstance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//            cipherInstance = getCipherInstance();
            cipherInstance.init(Cipher.DECRYPT_MODE, deskey);
            return cipherInstance.doFinal(src);
        }  catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }
  
	public static void main(String[] args) throws Exception{
		 
	}
}
