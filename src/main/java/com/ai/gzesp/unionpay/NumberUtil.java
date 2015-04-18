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
      byte[] bytes = new byte[4];
      bytes[0] = (byte) (integer & 0xff); // 最低位
      bytes[1] = (byte) ((integer >> 8) & 0xff); // 次低位
      bytes[2] = (byte) ((integer >> 16) & 0xff); // 次高位
      bytes[3] = (byte) (integer >>> 24); // 最高位，无符号右移。
      
/*      byte[] bytes = new byte[4];
      bytes[0] = (byte)(integer >> 24);
      bytes[1] = (byte)(integer >> 16);
      bytes[2] = (byte)(integer >> 8);
      bytes[3] = (byte)(integer >> 0);*/
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
        
/*        int b0 = bytes[0] & 0xFF;  
        int b1 = bytes[1] & 0xFF;  
        int b2 = bytes[2] & 0xFF;  
        int b3 = bytes[3] & 0xFF;  
        return b0 + (b1 << 8) + (b2 << 16) + (b3 << 24); */ 

      
/*      int integer = (bytes[3] << 24)
              | ((bytes[2] << 24) >>> 8) 
              | ((bytes[1] << 8) & 0xff00)
              | (bytes[0] & 0xff);
          return integer;*/
        
        return ((((int)bytes[0] & 0xff) << 24) |
                (((int)bytes[1] & 0xff) << 16) |
                (((int)bytes[2] & 0xff) <<  8) |
                (((int)bytes[3] & 0xff) <<  0));
        

    }
    
    /**  
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用 
     * @param value  
     *            要转换的int值 
     * @return byte数组 
     */    
 public static byte[] intToBytes( int value )   
 {   
     byte[] src = new byte[4];  
     src[3] =  (byte) ((value>>24) & 0xFF);  
     src[2] =  (byte) ((value>>16) & 0xFF);  
     src[1] =  (byte) ((value>>8) & 0xFF);    
     src[0] =  (byte) (value & 0xFF);                  
     return src;   
 }  
  /**  
     * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和bytesToInt2（）配套使用 
     */    
 public static byte[] intToBytes2(int value)   
 {   
     byte[] src = new byte[4];  
     src[0] = (byte) ((value>>24) & 0xFF);  
     src[1] = (byte) ((value>>16)& 0xFF);  
     src[2] = (byte) ((value>>8)&0xFF);    
     src[3] = (byte) (value & 0xFF);       
     return src;  
 }  

 /**  
  * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用 
  *   
  * @param src  
  *            byte数组  
  * @param offset  
  *            从数组的第offset位开始  
  * @return int数值  
  */    
public static int bytesToInt(byte[] src, int offset) {  
  int value;    
  value = (int) ((src[offset] & 0xFF)   
          | ((src[offset+1] & 0xFF)<<8)   
          | ((src[offset+2] & 0xFF)<<16)   
          | ((src[offset+3] & 0xFF)<<24));  
  return value;  
}  

/**  
  * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用 
  */  
public static int bytesToInt2(byte[] src, int offset) {  
  int value;    
  value = (int) ( ((src[offset] & 0xFF)<<24)  
          |((src[offset+1] & 0xFF)<<16)  
          |((src[offset+2] & 0xFF)<<8)  
          |(src[offset+3] & 0xFF));  
  return value;  
}  


}
