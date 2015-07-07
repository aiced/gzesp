package com.ai.gzesp.recharge;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class RechargeCodecFactory implements ProtocolCodecFactory {
	
	private RechargeDecoder decoder;
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
	}

}
