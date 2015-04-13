package com.ai.gzesp.unionpay;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * 字节码数组 解码器<br> 
 * 编写编码器的注意事项：
 * 1、 mina 为 IoSession 写队列里的每个对象调用 ProtocolEncode.encode 方法。
 * 因为业务处理器里写出的都是与编码器对应高层对象，所以可以直接进行类型转换。
 * 2、从 jvm 堆分配 IoBuffer，最好避免使用直接缓存，因为堆缓存一般有更好的性能。
 * 3、开发人员不需要释放缓存， mina 会释放。
 * 4、在 dispose 方法里可以释放编码所需的资源。
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ByteArrayDecoder extends CumulativeProtocolDecoder {
    
    public boolean doDecode(IoSession session, IoBuffer in,  ProtocolDecoderOutput out) throws Exception {
          if (in.remaining() > 0) {
            // 有数据时，读取 4 字节判断消息长度
            byte[] sizeBytes = new byte[4];

            // 标记当前位置，以便 reset
            in.mark();

            // 读取钱 4 个字节
            in.get(sizeBytes);

            // NumberUtil 是自己写的一个 int 转 byte[] 的工具类
            int size = NumberUtil.bytes2int(sizeBytes);

            if (size > in.remaining()) {
              // 如果消息内容的长度不够，则重置（相当于不读取 size），返回 false
              in.reset();
              // 接收新数据，以拼凑成完整的数据~
              return false;

            } else {
              byte[] dataBytes = new byte[size];
              in.get(dataBytes, 0, size);
              out.write(dataBytes);
              
              if (in.remaining() > 0) {
                // 如果读取内容后还粘了包，就让父类把剩下的数据再给解析一次~
                return true;
              }
            }
          }
          // 处理成功，让父类进行接收下个包
          return false;
        }

}
