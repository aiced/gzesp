package com.ai.gzesp.unionpay;

/**
 * 银联接口 业务类型 枚举类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum BusiType {
    type001("001", "购买电子产品"),
    type002("002", "购买理财产品"),
    type003("003", "电力缴费"),
    type004("004", "话费"),
    type005("005", "餐饮"),
    type006("006", "游戏点卡"),
    type007("007", "自来水缴费"),
    type008("008", "有线电视缴费"),
    //009~998：保留
    type999("999", "其他");
    
    private String code;
    
    private String name;
    
    private BusiType(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
