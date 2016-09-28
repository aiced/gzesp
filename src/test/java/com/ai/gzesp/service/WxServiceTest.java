package com.ai.gzesp.service;

import org.junit.Test;

import com.ai.wx.util.HttpClientUtil;

public class WxServiceTest extends BaseTest {
	
	
	
	@Test
	public void test1(){
        // 拼装 获取 access_token的 https的url
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=");
        url.append("12345");
        url.append("&secret=");
        url.append("abcde");
        //获取返回的 json，并转换成bean
        String respJson = HttpClientUtil.sendGetSSLRequest(url.toString(), null);
	}

}
