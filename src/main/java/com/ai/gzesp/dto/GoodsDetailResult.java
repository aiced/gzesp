package com.ai.gzesp.dto;

/**
 * 数据库查询出的商品详情对象dto<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodsDetailResult {
    
    
    /**
     * 商品id
     */
    private String GOODS_ID;
    
    /**
     * 商品类目
     */
    private String CTLG_CODE;
    
    /**
     * 商品名称
     */
    private String GOODS_NAME;
    
    /**
     * 图文详情blob字段转换成的string
     */
    private String CONTENT;
    
    /**
     * 商品价格
     */
    private String GOODS_PRICE;
    
    /**
     * 自定义活动
     */
    private String ATY_TITLE;

    public String getGOODS_ID() {
        return GOODS_ID;
    }

    public void setGOODS_ID(String gOODS_ID) {
        GOODS_ID = gOODS_ID;
    }

    public String getCTLG_CODE() {
        return CTLG_CODE;
    }

    public void setCTLG_CODE(String cTLG_CODE) {
        CTLG_CODE = cTLG_CODE;
    }

    public String getGOODS_NAME() {
        return GOODS_NAME;
    }

    public void setGOODS_NAME(String gOODS_NAME) {
        GOODS_NAME = gOODS_NAME;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String cONTENT) {
        CONTENT = (cONTENT == null ? "" : cONTENT);
    }

    public String getGOODS_PRICE() {
        return GOODS_PRICE;
    }

    public void setGOODS_PRICE(String gOODS_PRICE) {
        GOODS_PRICE = gOODS_PRICE;
    }

    public String getATY_TITLE() {
        return ATY_TITLE;
    }

    public void setATY_TITLE(String aTY_TITLE) {
        ATY_TITLE = (aTY_TITLE == null ? "" : aTY_TITLE);
    }



}
