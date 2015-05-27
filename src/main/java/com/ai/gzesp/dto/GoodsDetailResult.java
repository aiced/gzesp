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
     * 相册标识
     */
    private String ALBUM_ID;   
    
    /**
     * 版本号
     */
    private String VER_NO;
    
    /**
     * 商户标识
     */
    private String MERCHANT_ID;  
    
    /**
     * 生成时间
     */
    private String CREATE_TIME;
    
    /**
     * 生成员工
     */
    private String CREATE_STAFF_ID;
    
    /**
     * 商品状态
     */
    private String GOODS_STATE;
    
    /**
     * 推荐标记
     */
    private String RECOM_TAG;
    
    /**
     * 定价规则
     */
    private String PRICE_RULE;
    
    /**
     * 开始时间
     */
    private String BEGIN_TIME;
    
    /**
     * 结束时间
     */
    private String END_TIME;
    
    /**
     * 商品简单描述
     */
    private String SIMP_DESC;
    
    /**
     * 商品原始价格
     */
    private String ORIGINAL_PRICE;
    
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

	public String getORIGINAL_PRICE() {
		return ORIGINAL_PRICE;
	}

	public void setORIGINAL_PRICE(String oRIGINAL_PRICE) {
		ORIGINAL_PRICE = oRIGINAL_PRICE;
	}

	public String getALBUM_ID() {
		return ALBUM_ID;
	}

	public void setALBUM_ID(String aLBUM_ID) {
		ALBUM_ID = aLBUM_ID;
	}

	public String getVER_NO() {
		return VER_NO;
	}

	public void setVER_NO(String vER_NO) {
		VER_NO = vER_NO;
	}

	public String getMERCHANT_ID() {
		return MERCHANT_ID;
	}

	public void setMERCHANT_ID(String mERCHANT_ID) {
		MERCHANT_ID = mERCHANT_ID;
	}

	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(String cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}

	public String getCREATE_STAFF_ID() {
		return CREATE_STAFF_ID;
	}

	public void setCREATE_STAFF_ID(String cREATE_STAFF_ID) {
		CREATE_STAFF_ID = cREATE_STAFF_ID;
	}

	public String getGOODS_STATE() {
		return GOODS_STATE;
	}

	public void setGOODS_STATE(String gOODS_STATE) {
		GOODS_STATE = gOODS_STATE;
	}

	public String getRECOM_TAG() {
		return RECOM_TAG;
	}

	public void setRECOM_TAG(String rECOM_TAG) {
		RECOM_TAG = rECOM_TAG;
	}

	public String getPRICE_RULE() {
		return PRICE_RULE;
	}

	public void setPRICE_RULE(String pRICE_RULE) {
		PRICE_RULE = pRICE_RULE;
	}

	public String getBEGIN_TIME() {
		return BEGIN_TIME;
	}

	public void setBEGIN_TIME(String bEGIN_TIME) {
		BEGIN_TIME = bEGIN_TIME;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}

	public String getSIMP_DESC() {
		return SIMP_DESC;
	}

	public void setSIMP_DESC(String sIMP_DESC) {
		SIMP_DESC = sIMP_DESC;
	}



}
