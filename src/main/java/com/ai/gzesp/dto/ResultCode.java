package com.ai.gzesp.dto;

/**
 * 系统统一返回码及错误描述
 * @author xmh
 *
 */
public enum ResultCode {
	
	/**
	 * "成功", "0000"
	 */
	SUC0000("成功", "0000"),
	
	/**
	 * "cas-server获取tgt失败", "1001"
	 */
	ERR1001("cas-server获取tgt失败", "1001"),
	/**
	 * "cas-server获取st失败", "1002"
	 */
	ERR1002("cas-server获取st失败", "1002"),
	
	
	/**
	 * "接口关闭不允许调用", "2000"
	 */
	ERR2000("接口关闭不允许调用", "2000"),
	
	/**
	 * "接口请求参数为空", "2001"
	 */
	ERR2001("接口请求参数为空", "2001"),
	
	/**
	 * "接口请求参数reqParam不存在或者为空", "2002"
	 */
	ERR2002("接口请求参数reqParam不存在或者为空", "2002"),
	
	/**
	 * "接口请求参数merId为空", "2003"
	 */
	ERR2003("接口请求参数merId不存在或者为空", "2003"),
	
	/**
	 * "接口请求参数md5Desc为空", "2004"
	 */
	ERR2004("接口请求参数md5Desc不存在或者为空", "2004"),
	
	/**
	 * "merId非法未定义", "2005"
	 */
	ERR2005("merId非法未定义", "2005"),
	
	/**
	 * "des解密异常", "2006"
	 */
	ERR2006("des解密异常", "2006"),
	
	/**
	 * "md5校验失败", "2007"
	 */
	ERR2007("md5校验失败", "2007"),
	
	/**
	 * "intfType参数不存在或者为空", "2008"
	 */
	ERR2008("intfType参数不存在或者为空", "2008"),
	
	/**
	 * "intfType参数错误,值未找到", "2009"
	 */
	ERR2009("intfType参数错误,值未找到", "2009"),
	
	/**
	 * "一卡充接口调用异常", "2010"
	 */
	ERR2010("一卡充接口调用异常", "2010"),
	
	/**
	 * "目前只支持20,30,50,100 四种固定金额充值", "2011"
	 */
	ERR2011("目前只支持20,30，50,100 四种固定金额充值", "2011"),
	
	/**
	 * "卡库存不足，占用失败", "2012"
	 */
	ERR2012("卡库存不足，占用失败", "2012"),
	
	/**
	 * "接口调用失败！发送报文后未接收到一卡充响应", "2013"
	 */
	ERR2013("接口调用失败！发送报文后未接收到一卡充响应", "2013"),
	
	/**
	 * "outTradeId未找到充值记录", "2014"
	 */
	ERR2014("outTradeId未找到充值记录", "2014"),
	
	/**
	 * "log_id未找到充值记录", "2015"
	 */
	ERR2015("log_id未找到充值记录", "2015"),
	
	/**
	 * "其他异常", "9999"
	 */
	ERR9999("其他异常", "9999")
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
	
	  // 普通方法, 根据 4位返回码，查找返回描述
	public static String find(String resultCode) {
		for (ResultCode i : ResultCode.values()) {
			if (i.resultCode.equals(resultCode)) {
				return i.resultName;
			}
		}
		return "未定义编码";
	}

}
