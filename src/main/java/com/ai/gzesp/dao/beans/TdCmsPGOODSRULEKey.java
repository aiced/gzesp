package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * @ClassName: TdCmsPGOODSRULEKey
* @Description: CMS_P_GOODS_RULE表对应的java bean主键类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdCmsPGOODSRULEKey implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    /**
     * @Fields CMS_P_GOODS_RULE.GOODS_ID :商品ID
     */
    private Long goodsId;

    /**
     * 规则ID
     */
    /**
     * @Fields CMS_P_GOODS_RULE.RULE_ID :规则ID
     */
    private Long ruleId;

    /**
     * @return 商品ID
     */
    /**
     * @return CMS_P_GOODS_RULE.GOODS_ID : 返回 商品ID
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId 
	 *            商品ID
     */
    /**
     * @param goodsId of CMS_P_GOODS_RULE : 设置 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return 规则ID
     */
    /**
     * @return CMS_P_GOODS_RULE.RULE_ID : 返回 规则ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * @param ruleId 
	 *            规则ID
     */
    /**
     * @param ruleId of CMS_P_GOODS_RULE : 设置 规则ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
}