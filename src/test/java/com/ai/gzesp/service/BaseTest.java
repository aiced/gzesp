package com.ai.gzesp.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.gzesp.unionpay.UnionPayCons;
import com.ai.gzesp.utils.MD5Util;
import com.ai.wxpay.common.MD5;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext-test.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {
	
	@Test
	public void test1(){
		String right = "BD6660EE405673BFC3BB01F918D60B9D";
		System.out.println("微信网页：" + right);
		
		String old = "appid=wx52db41a405183edb&body=【一年卡】12GB上网卡 含2GB全国流量 10GB省内流量 ！&device_info=WEB&mch_id=1241798102&nonce_str=5nniy9lekkrj8q6m2eu7ru2iz7z8ryhr&notify_url=http://wap.woboss.gz186.com/esp/pay/wxPay/callback&openid=okhDVstTJONDmyjrXBnIt44cryrc&out_trade_no=1331439346849965&spbill_create_ip=182.131.12.12&total_fee=15900&trade_type=JSAPI&key=0sbd781d015ca667d6eba25e609fuck3";
		
		String newStr1 = MD5.MD5Encode(old);
		System.out.println("徐总加密：" + newStr1);
		
		String newStr2 = MD5Util.md5s2(old);
		System.out.println("银联加密：" + newStr2);
		
		String newStr3 = MD5Util.md5s2(old, "0sbd781d015ca667d6eba25e609fuck3");
		System.out.println("银联加密：" + newStr3);
		
		String newStr4 = md5s2(old);
		System.out.println("银联加密：" + newStr4);
		
		String newStr5 = md5s3(old);
		System.out.println("银联加密：" + newStr5);
	}
	
    public String md5s2(String plainText)
    {
      StringBuffer buf = new StringBuffer("");
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try {
          md.update(plainText.getBytes("utf-8"));
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
    
    public String md5s3(String plainText)
    {
      StringBuffer buf = new StringBuffer("");
      try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
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

}
