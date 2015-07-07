package com.ai.gzesp.recharge;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class RechargeEncoder extends ProtocolEncoderAdapter {

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
      byte[] dataBytes = (byte[])message;
      //byte[] sizeBytes = NumberUtil.int2bytes(dataBytes.length);
      
      IoBuffer buffer = IoBuffer.allocate(256); 
      buffer.setAutoExpand(true);
      //buffer.order(ByteOrder.BIG_ENDIAN);
      
      //buffer.put(sizeBytes);
      buffer.put(dataBytes);
      
      buffer.flip();
      out.write(buffer);
      out.flush();
      
      buffer.free();
    }

}
