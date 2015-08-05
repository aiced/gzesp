package com.ai.gzesp.recharge;

/**
 * 一卡充系统 接口类型 映射关系枚举类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum InterfaceType {
    //请求
    recharge("010202", "充值接口"),
    rechargeQry("010204", "充值记录查询接口"),
    rechargeCheck("010201", "充值号码验证接口"),
    active("010203", "卡激活接口"),
    check("010205", "充值对账接口");

    private String interfaceCode;
    
    private String interfaceName;
    
    private InterfaceType(String interfaceCode, String interfaceName){
        this.interfaceCode = interfaceCode;
        this.interfaceName = interfaceName;
    }

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

    
}
