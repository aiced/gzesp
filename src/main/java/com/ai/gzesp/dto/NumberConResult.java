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
    
    /**
     * 靓号预存
     */
    private String nice_fee;
    
    
    /**
     * 网络类型
     */
    private String netType;  
    
    /**
     * 商品类目
     */
    private String ctlg_code;
    
    
    /**
     * 能人id
     */
    private String user_id; 

    public String getSerial_number() {
        return serial_number;
    }

    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

    public String getNice_fee() {
        return nice_fee;
    }

    public void setNice_fee(String nice_fee) {
        this.nice_fee = nice_fee;
    }

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getCtlg_code() {
		return ctlg_code;
	}

	public void setCtlg_code(String ctlg_code) {
		this.ctlg_code = ctlg_code;
	}
    

}
