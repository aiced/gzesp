package com.ai.gzesp.recharge;

/**
 * 一卡充系统 接口类型 映射关系枚举类<br> 
 * 20161221 add bss充值接口的也加到这里
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
    check("010205", "充值对账接口"),
	//20161221 ximh add ，010206 是我自定义的，在一卡充接口文档里没有，该接口是调用bss系统的
    feeQry("010206", "应缴费用查询接口"),
    rechargeQryByDate("010207", "充值记录按开始结束日期查询接口");

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
	
	  // 普通方法
	public static String find(int interfaceCode) {
		for (InterfaceType i : InterfaceType.values()) {
			if (i.interfaceCode.equals(interfaceCode)) {
				return i.interfaceName;
			}
		}
		return "未定义编码";
	}

}
