package com.ai.gzesp.recharge;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class RechargeDecoder extends CumulativeProtocolDecoder {
	private static Logger log = Logger.getLogger(RechargeDecoder.class);

	/**
	 * 这个方法的返回值是重点： 1、当内容刚好时，返回false，告知父类接收下一批内容
	 * 2、内容不够时需要下一批发过来的内容，此时返回false，这样父类 CumulativeProtocolDecoder
	 * 会将内容放进IoSession中，等下次来数据后就自动拼装再交给本类的doDecode
	 * 3、当内容多时，返回true，因为需要再将本批数据进行读取，父类会将剩余的数据再次推送本类的doDecode
	 */
	public boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		log.debug("【一卡充：esp收到数据包解码开始。。。】");

		if (in.remaining() > 0) {
			log.debug("【一卡充：esp收到数据包解码， IoBuffer.remaining()= " + in.remaining() + "】");
			
			// 标记当前位置，以便 reset
			in.mark();
			
			// 有数据时，读取@后 5 字节判断消息长度
			// 所有数据包前增加”@”为包的开始标志，数据包尾加“0x1a”为包的结束标志。
			// 数据包头中的包长字段不包含这两个字符在内
            byte prefix = in.get(); //获取第一个@数据包前缀
			byte[] sizeBytes = new byte[5];
			// 读取@后 5 个字节
			in.get(sizeBytes);

			log.debug("【一卡充：esp收到数据包解码， sizeBytes = new byte[5];size= "
					+ new String(sizeBytes).trim() + "】");
			int size = Integer.parseInt(new String(sizeBytes).trim()); //注意要trim，因为报文里不足5位右补空格的

			//如果后续字节数< size-5(A1数据包size)+1(数据包后还加了0x1a结尾)
			if ((size-5+1) > in.remaining()) {
				// 如果消息内容的长度不够，则重置（相当于不读取 size），返回 false
				log.debug("【一卡充：esp收到数据包解码， (size-5+1) > in.remaining(),消息内容的长度不够，则重置（相当于不读取 size），返回 false】");
				in.reset();
				// 接收新数据，以拼凑成完整的数据~
				return false;

			} else {
				log.debug("【一卡充：esp收到数据包解码， (size-5+1) <= in.remaining(),消息内容的长度足够，开始读取byte[size-5+1]】");
				byte[] otherBytes = new byte[size-5+1]; //从包头里A2开始+后缀0x1a ，全都从IoBuffer读取出来
				in.get(otherBytes, 0, size-5+1);
				
				byte[] allBytes = new byte[size]; //完整的数据包，不包括前缀"@" 和后缀 "0x1a"
				System.arraycopy(sizeBytes, 0, allBytes, 0, sizeBytes.length); //包头里A1部分
				System.arraycopy(otherBytes, 0, allBytes, sizeBytes.length, otherBytes.length-1); //从包头里A2开始，到包体结束，不包括后缀0x1a
				out.write(allBytes); //输出，流转到后续的 RechargeClientHandler

				if (in.remaining() > 0) {
					// 如果读取内容后还粘了包，就让父类把剩下的数据再给解析一次~
					return true;
				}
			}
		}
		return false; // 处理成功，让父类进行接收下个包

		/*
		 * int size = in.remaining(); byte[] dataBytes = new byte[size];
		 * in.get(dataBytes, 0, size); out.write(dataBytes); // 处理成功，让父类进行接收下个包
		 * return false;
		 */
	}

}
