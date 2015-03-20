package com.ai.gzesp.dto;

/**
 * 选择号码页面点击号码后 触发预占号码请求，这个类既是查询条件bean又是返回结果bean<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NumberConResult {
    
    /**
     * 手机号码
     */
    private String serial_number;
    
    /**
     * 号码预占 是否成功 SUCCESS FAILD
     */
    private String status;

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
