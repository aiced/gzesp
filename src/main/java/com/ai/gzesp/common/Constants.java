package com.ai.gzesp.common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Constants {
 
    /**
     * 自定义类型：新号入网-套餐
     */
    public static final String GOOD_TYPE_PLAN = "plan";
    
    /**
     * 自定义类型：合约购机-合约机
     */
    public static final String GOOD_TYPE_PHONE = "phone";
    
    /**
     * 自定义类型：上网卡-上网卡
     */
    public static final String GOOD_TYPE_CARD = "card";
    
    /**
     * 自定义类型：宽带续费-宽带
     */
    public static final String GOOD_TYPE_BAND = "band";
    
    /**
     * 自定义类型：特色流量包-特色
     */
    public static final String GOOD_TYPE_FLOW = "flow";
    
    /**
     * 商品类目：新号入网-总部
     */
    public static final String CTLG_CODE_XHRW_5 = "5";
    
    /**
     * 商品类目：新号入网-省份
     */
    public static final String CTLG_CODE_XHRW_10 = "10";
    
    /**
     * 商品类目：合约购机-总部
     */
    public static final String CTLG_CODE_HYGJ_4 = "4";
    
    /**
     * 商品类目：合约购机-省份
     */
    public static final String CTLG_CODE_HYGJ_9 = "9";
    
    /**
     * 商品类目：上网卡-总部
     */
    public static final String CTLG_CODE_SWK_6 = "6";
    
    /**
     * 商品类目：上网卡-省份
     */
    public static final String CTLG_CODE_SWK_11 = "11";
    
    /**
     * 商品类目：宽带-总部
     */
    public static final String CTLG_CODE_KD_7 = "7";
    
    /**
     * 商品类目：宽带-省份
     */
    public static final String CTLG_CODE_KD_12 = "12";
    
    /**
     * 商品类目：流量包-总部
     */
    public static final String CTLG_CODE_LLB_8 = "8";
    
    /**
     * 商品类目：流量包-省份
     */
    public static final String CTLG_CODE_LLB_13 = "13";

    
    /**
     * 字段名:物品属性类别
     */
    public static final String COL_ATTR_CODE = "ATTR_CODE";
    
    /**
     * 字段名:物品属性值
     */
    public static final String COL_ATTR_VAL_CODE = "ATTR_VAL_CODE";
    
    /**
     * 状态-成功
     */
    public static final String STATUS_SUCCESS = "SUCCESS";
    
    /**
     * 状态-失败
     */
    public static final String STATUS_FAILD = "FAILD";
    
    //账户——md5加密key
    public static final String md5key="0aad787d015ca667d67ba25e68952c23";
    
    //银行卡-卡号 加密key
    public static final String desKey = "e036wlqtcueakxn8tjwhu9gs";  //测试：yvo0sovt414fakqwvchs70b3 正式：e036hlqtculakx38tjw2u9gs
    
    //宽带续约，md5加密用到的key
    public static final String md5key_bbs="gzecsts20141016223600";
    //宽带续约，BSS接口xml头
    public static final String xmlhead="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
}
