package com.ai.gzesp.recharge;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

public class RechargeCodecFactory implements ProtocolCodecFactory {
	
/*	private RechargeDecoder decoder;
	private RechargeEncoder encoder;
	
	public RechargeCodecFactory(){
		decoder = new RechargeDecoder();
		encoder = new RechargeEncoder();
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}*/
	
	
	private TextLineEncoder encoder; 
	private TextLineDecoder decoder;  
	//private char endchar = 0x1a ; //所有数据包前增加”@”为包的开始标志，数据包尾加“0x1a”为包的结束标志
	private String endchar = "0x1a" ;
	private LineDelimiter enLineDelimiter = new LineDelimiter(endchar);  
	
	
	public RechargeCodecFactory(){
		//this(charset); 
		decoder = new TextLineDecoder(Charset.forName("UTF-8"), enLineDelimiter);
		encoder = new TextLineEncoder(Charset.forName("UTF-8"), enLineDelimiter);
	}

	@Override
	public TextLineEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	@Override
	public TextLineDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}
}
