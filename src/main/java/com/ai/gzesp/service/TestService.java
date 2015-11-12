package com.ai.gzesp.service;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import com.ai.gzesp.utils.SmsUtils;

@Service
public class TestService {
	
	public void sendMsg() throws UnsupportedEncodingException{
		SmsUtils.doSendMessage("13655169732", "MB-2015052754", "@1@=" + "测试产品");
		
		SmsUtils.doSendMessage("13655169732", "MB-2015111119", "@1@=" + "测试产品" + ",@2@=" + "9");
		SmsUtils.doSendMessage("18651885060", "MB-2015111119", "@1@=" + "测试产品" + ",@2@=" + "9");
		//SmsUtils.doSendMessage("18651885060", "MB-2015111119", "@1@=" + new String("测试产品1".getBytes("utf-8"), "gbk") + ",@2@=" + "9");
		//SmsUtils.doSendMessage("18651885060", "MB-2015111119", "@1@=" + new String("测试产品2".getBytes("gbk"), "gbk") + ",@2@=" + "9");
		//SmsUtils.doSendMessage("18651885060", "MB-2015111119", "@1@=" + new String("测试产品3".getBytes("gbk"), "utf-8") + ",@2@=" + "9");
		//SmsUtils.doSendMessage("18651885060", "MB-2015111119", "@1@=" + new String("测试产品4".getBytes("utf-8"), "utf-8") + ",@2@=" + "9");
		
		SmsUtils.doSendMessage("13770330525", "MB-2015111119", "@1@=" + "测试产品" + ",@2@=" + "9");
		SmsUtils.doSendMessage("18551855717", "MB-2015111119", "@1@=" + "测试产品" + ",@2@=" + "9");
	}

}
