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
     * 这个方法的返回值是重点： 
     * 1、当内容刚好时，返回false，告知父类接收下一批内容 
     * 2、内容不够时需要下一批发过来的内容，此时返回false，这样父类 CumulativeProtocolDecoder 
     *    会将内容放进IoSession中，等下次来数据后就自动拼装再交给本类的doDecode 
     * 3、当内容多时，返回true，因为需要再将本批数据进行读取，父类会将剩余的数据再次推送本类的doDecode 
     */
    public boolean doDecode(IoSession session, IoBuffer in,  ProtocolDecoderOutput out) throws Exception {
        log.debug("【一卡充：esp收到数据包解码开始。。。】");
        
        CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();  
          if (in.remaining() > 0) {
              log.debug("【一卡充：esp收到数据包解码， IoBuffer.remaining()= " +in.remaining()+ "】");
            // 有数据时，读取 4 字节判断消息长度
            byte[] sizeBytes = new byte[4];

            // 标记当前位置，以便 reset
            in.mark();

            // 读取钱 4 个字节
            in.get(sizeBytes);
            in.getString(cd);

            log.debug("【一卡充：esp收到数据包解码， sizeBytes = new byte[4];size= "+ new String(sizeBytes) +"】");
            //log.debug("【银联支付：esp收到数据包解码， size= "+ NumberUtil.bytesToInt(sizeBytes, 0) + "|"+ NumberUtil.bytesToInt2(sizeBytes, 0)  +"】");
            // NumberUtil 是自己写的一个 int 转 byte[] 的工具类
            //int size = NumberUtil.bytes2int(sizeBytes);
            int size = Integer.parseInt(new String(sizeBytes));

            if (size > in.remaining()) {
              // 如果消息内容的长度不够，则重置（相当于不读取 size），返回 false
              log.debug("【一卡充：esp收到数据包解码， size > in.remaining(),消息内容的长度不够，则重置（相当于不读取 size），返回 false】");
              in.reset();
              // 接收新数据，以拼凑成完整的数据~
              return false;

            } else {
              log.debug("【一卡充：esp收到数据包解码， size < in.remaining(),消息内容的长度足够，开始读取byte[size]】");
              byte[] dataBytes = new byte[size];
              in.get(dataBytes, 0, size);
              out.write(dataBytes);
              
              if (in.remaining() > 0) {
                // 如果读取内容后还粘了包，就让父类把剩下的数据再给解析一次~
                return true;
              }
            }
          }
          return false; // 处理成功，让父类进行接收下个包
          
/*        int size = in.remaining();
        byte[] dataBytes = new byte[size];
        in.get(dataBytes, 0, size);
        out.write(dataBytes);
          // 处理成功，让父类进行接收下个包
          return false;*/
        }

}
