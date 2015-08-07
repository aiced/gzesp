package com.ai.gzesp.recharge;

/**
 * 一卡充返回错误码
 * @author xmh
 *
 */
public enum ResultCode {
	
    //响应码
	E01("成功", "00000"),
	E02("系统故障", "01001"),
	E03("系统忙", "01002"),
	E04("操作超时", "01003"),
	E05("操作失败", "01004"),
	E06("托收失败", "01008"),
	E07("应急期间不支持此业务", "09000"),
	E08("托收交易中", "01009"),
	E09("交易模式代码错误", "01010"),
	E10("原交易已成功", "01007"),
	E11("包参数格式错误", "10000"),
	E12("缴费卡密码错误", "20001"),
	E13("缴费卡归属地区不匹配", "20002"),
	E14("缴费卡序列号错误", "20003"),
	E15("缴费卡未激活", "21001"),
	E16("缴费卡被锁定", "21002"),
	E17("缴费卡已被使用", "21003"),
	E18("缴费卡已过期", "21004"),
	E19("缴费卡已注销", "21005"),
	E20("专卡专用不提供跨省充值", "22001"),
	E21("卡业务类型受限", "22002"),
	E22("卡使用区域范围受限", "22003"),
	E23("被充值帐号不存在", "05021"),
	E24("缴费帐号不能用于缴费", "05022"),
	E25("帐务系统操作超时", "05023"),
	E26("不在缴费时段", "05024"),
	E27("被充值帐号处于冷冻期", "30002"),
	E28("被充值帐号处于挂失状态", "30004"),
	E29("跨省后付费用户暂时不提供余额查询", "30007"),
	E30("超过帐户金额最大限额", "30009"),
	E31("交易流水号已存在", "01030"),
	E32("接入IP错误", "01024"),
	E33("接口权限认证失败", "01025"),
	E34("接入密码验证失败", "01026"),
	E35("流量超过阀值", "01027"),
	E36("系统连接达到最大连接数", "01028"),
	E37("非本省号码", "01029"),
	E38("用户处于黑名单中", "10200"),
	E39("第三方网关系统处理超时", "10201")
	;
	
    private ResultCode(String resultName, String resultCode){
        this.resultCode = resultCode;
        this.resultName = resultName;
    }

	
    private String resultCode;
    
    private String resultName;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	
	  // 普通方法
	public static String find(String resultCode) {
		for (ResultCode i : ResultCode.values()) {
			if (i.resultCode.equals(resultCode)) {
				return i.resultName;
			}
		}
		return "未定义编码";
	}

}
