package com.ai.gzesp.unionpay;

/**
 * int、byte[] 相互转换的工具类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NumberUtil {
    /**
     * 将整型转换为字节数组~
     * @param integer
     * @return
     */
    public static byte[] int2bytes(int integer) {
/*      byte[] bytes = new byte[4];
      bytes[0] = (byte) (integer & 0xff); // 最低位
      bytes[1] = (byte) ((integer >> 8) & 0xff); // 次低位
      bytes[2] = (byte) ((integer >> 16) & 0xff); // 次高位
      bytes[3] = (byte) (integer >>> 24); // 最高位，无符号右移。
*/      
      byte[] bytes = new byte[4];
      bytes[0] = (byte)(integer >> 24);
      bytes[1] = (byte)(integer >> 16);
      bytes[2] = (byte)(integer >> 8);
      bytes[3] = (byte)(integer >> 0);
      return bytes;
    }
    

    /**
     * 将字节数组转换为整型~
     * @param bytes
     * @return
     */
    public static int bytes2int(byte[] bytes) {
      // 一个 byte 数据左移 24 位变成 0x??000000，再右移 8 位变成 0x00??0000（| 表示按位或）
/*      int integer = (bytes[0] & 0xff) 
          | ((bytes[1] << 8) & 0xff00) 
          | ((bytes[2] << 24) >>> 8) 
          | (bytes[3] << 24);
      return integer;*/
      
      int integer = (bytes[3] << 24)
              | ((bytes[2] << 24) >>> 8) 
              | ((bytes[1] << 8) & 0xff00)
              | (bytes[0] & 0xff);
          return integer;
        
/*        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) <<  8) |
                (((int)bytes[3] & 0xff) <<  0));*/
        

    }
    
    public byte[] int2bytes(int a, boolean isHighFirst)
    {
        byte[] result = new byte[4];

        if (isHighFirst)
        {
            result[0] = (byte)(a >> 24 & 0xff);
            result[1] = (byte)(a >> 16 & 0xff);
            result[2] = (byte)(a >> 8 & 0xff);
            result[3] = (byte)(a & 0xff);
        }
        else
        {
            result[3] = (byte)(a >> 24 & 0xff);
            result[2] = (byte)(a >> 16 & 0xff);
            result[1] = (byte)(a >> 8 & 0xff);
            result[0] = (byte)(a & 0xff);
        }
        return result;
    }


}
