package com.ai.gzesp.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;

import com.ai.gzesp.recharge.RechargeCons;
import com.ai.gzesp.unionpay.UnionPayCons;

/**
 * 3DES加密解密工具<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DESUtil {

    /**
     * 银联用的算法
     */
    private static final String Algorithm = "DESede"; // 定义 加密算法,可用 DES,DESede,Blowfish
    
    /**
     * 一卡充系统的算法：3des对称加密算法，算法模式ECB，密钥长度128位（16个字符）。
     * 加密数据补码方式：Pkcs5Padding。加密结果编码方式base64。
     */
    private static final String Algorithm2 = "DESede/ECB/PKCS5Padding"; 
    
    //private static final byte[] keybyte = "e143cc8236aed7f7786da932".getBytes();//keybyte为加密密钥，长度为24字节

    /**
     * 银联接口用的加密
     * @param src
     * @return
     */
    public static byte[] encryptMode(byte[] src) {
        return encryptMode(UnionPayCons.desKey.getBytes(), src);
    }
    
    /**
     * 银联接口用的加密
     * src为被加密的数据缓冲区（源）
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
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
     * 一卡充接口用的加密
     * 一卡充给的16位秘钥，不足24位的 右补足 0x0
     * @param src
     * @return
     */
    public static byte[] encryptModeRecharge(byte[] src) {
    	String newKey = StringUtils.rightPad(RechargeCons.desKey, 24, RechargeCons.keyPadChar); //
        return encryptModeRecharge(newKey.getBytes(), src);
    }
    
    /**
     * 一卡充接口用的加密
     * src为被加密的数据缓冲区（源）
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] encryptModeRecharge(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); //  "DESede"

            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm2);
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
     * 银联接口的解密
     * @param src
     * @return
     */
    public static byte[] decryptMode(byte[] src) {
        return decryptMode(UnionPayCons.desKey.getBytes(), src);
    }

    /**
     * 银联接口的解密
     * keybyte为加密密钥，长度为24字节
     * src为加密后的缓冲区
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
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
     * 一卡充接口的解密
     * @param src
     * @return
     */
    public static byte[] decryptModeRecharge(byte[] src) {
        return decryptMode(RechargeCons.desKey.getBytes(), src);
    }

    /**
     * 一卡充接口的解密
     * keybyte为加密密钥，长度为16字节
     * src为加密后的缓冲区
     * @param keybyte
     * @param src
     * @return
     */
    public static byte[] decryptModeRecharge(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm2); //  "DESede"

            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm2);
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

    // 转换成十六进制字符串
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static void main(String[] args) {
        // 添加新安全算法,如果用JCE就要把它添加进去
        //Security.addProvider(new com.sun.crypto.provider.SunJCE());

        // 24字节的密钥
        /*final byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10, 0x40, 0x38, 0x28, 0x25, 0x79, 0x51,
                (byte) 0xCB, (byte) 0xDD, 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36, (byte) 0xE2 }; */
/*        String szSrc = "This is a 3DES test. 测试";

        System.out.println("加密前的字符串:" + szSrc);

        byte[] encoded = encryptMode(UnionPayCons.desKey.getBytes(), szSrc.getBytes());
        System.out.println("加密后的字符串:" + new String(encoded));

        byte[] srcBytes = decryptMode(UnionPayCons.desKey.getBytes(), encoded);
        System.out.println("解密后的字符串:" + (new String(srcBytes)));*/
    	
//        String szSrc = "1234567890123456";
//
//        System.out.println("加密前的字符串:" + szSrc);
//
//        byte[] encoded = encryptMode(UnionPayCons.desKey.getBytes(), szSrc.getBytes());
//        System.out.println("加密后的字符串:" + new String(encoded));
//
//        byte[] srcBytes = decryptMode(UnionPayCons.desKey.getBytes(), encoded);
//        System.out.println("解密后的字符串:" + (new String(srcBytes)));
    	
        String szSrc = "1234567890123456";

        System.out.println("加密前的字符串:" + szSrc);

        byte[] encoded = encryptModeRecharge(szSrc.getBytes());
        System.out.println("加密后的字符串:" + new String(encoded));

        byte[] srcBytes = encryptModeRecharge(encoded);
        System.out.println("解密后的字符串:" + (new String(srcBytes)));
        
        
    }

    //byte[] 转 字符串 
    //主要为了应对数据库中字段为字符串的情况下如果单纯的new String(byte[])转换成字符串再插入数据库是不可行的。
    //因为当String().getBytes()的时候 再解密的话是不到原始数据
    public static String Bytes2HexString(byte[] b) { 
        String ret = ""; 
        for (int i = 0; i < b.length; i++) { 
            String hex = Integer.toHexString(b[i] & 0xFF); 
            if (hex.length() == 1) { 
                hex = '0' + hex; 
            } 
            ret += hex.toUpperCase(); 
        } 
        return ret; 
    } 
    //字符串 转byte[]
    public static byte[] HexString2Bytes(String src){ 
        byte[] ret = new byte[src.length()/2]; 
        byte[] tmp = src.getBytes(); 
        for(int i=0; i<(src.length()/2); i++){ 
         ret[i] = uniteBytes(tmp[i*2], tmp[i*2+1]); //这个函数在下面
        } 
        return ret; 
    }
    
    public static byte uniteBytes(byte src0, byte src1) { 
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue(); 
        _b0 = (byte)(_b0 << 4); 
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue(); 
        byte ret = (byte)(_b0 ^ _b1); 
        return ret; 
    } 
    
    
    
}
