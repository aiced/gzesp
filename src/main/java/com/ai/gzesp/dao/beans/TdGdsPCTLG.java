package com.ai.gzesp.dao.beans;

import java.io.Serializable;

/**
 * 商品展现的目录
 */
/**
 * @ClassName: TdGdsPCTLG
* @Description: GDS_P_CTLG表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class TdGdsPCTLG implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品目录编码
     */
    /**
     * @Fields GDS_P_CTLG.GOODS_CTLG_CODE :商品目录编码
     */
    private Long goodsCtlgCode;

    /**
     * 商品目录名称
     */
    /**
     * @Fields GDS_P_CTLG.GOODS_CTLG_NAME :商品目录名称
     */
    private String goodsCtlgName;

    /**
     * 商品目录说明
     */
    /**
     * @Fields GDS_P_CTLG.GOODS_CTLG_EXPLAIN :商品目录说明
     */
    private String goodsCtlgExplain;

    /**
     * 父目录编码
     */
    /**
     * @Fields GDS_P_CTLG.PARENT_CTLG_CODE :父目录编码
     */
    private Integer parentCtlgCode;

    /**
     * 此目录下是否有目录属性<br>
	 * 1－有<br>
	 * 0－无
     */
    /**
     * @Fields GDS_P_CTLG.CTLG_ATTR_TAG :此目录下是否有目录属性
1－有
0－无
     */
    private String ctlgAttrTag;

    /**
     * 对应跳转页面编码
     */
    /**
     * @Fields GDS_P_CTLG.REDIRECT_CODE :对应跳转页面编码
     */
    private String redirectCode;

    /**
     * @Fields GDS_P_CTLG.SHOW_ORDER :null
     */
    private Short showOrder;

    /**
     * @Fields GDS_P_CTLG.VALUES1 :null
     */
    private String values1;

    /**
     * @Fields GDS_P_CTLG.VALUES2 :null
     */
    private String values2;

    /**
     * @return 商品目录编码
     */
    /**
     * @return GDS_P_CTLG.GOODS_CTLG_CODE : 返回 商品目录编码
     */
    public Long getGoodsCtlgCode() {
        return goodsCtlgCode;
    }

    /**
     * @param goodsCtlgCode 
	 *            商品目录编码
     */
    /**
     * @param goodsCtlgCode of GDS_P_CTLG : 设置 商品目录编码
     */
    public void setGoodsCtlgCode(Long goodsCtlgCode) {
        this.goodsCtlgCode = goodsCtlgCode;
    }

    /**
     * @return 商品目录名称
     */
    /**
     * @return GDS_P_CTLG.GOODS_CTLG_NAME : 返回 商品目录名称
     */
    public String getGoodsCtlgName() {
        return goodsCtlgName;
    }

    /**
     * @param goodsCtlgName 
	 *            商品目录名称
     */
    /**
     * @param goodsCtlgName of GDS_P_CTLG : 设置 商品目录名称
     */
    public void setGoodsCtlgName(String goodsCtlgName) {
        this.goodsCtlgName = goodsCtlgName == null ? null : goodsCtlgName.trim();
    }

    /**
     * @return 商品目录说明
     */
    /**
     * @return GDS_P_CTLG.GOODS_CTLG_EXPLAIN : 返回 商品目录说明
     */
    public String getGoodsCtlgExplain() {
        return goodsCtlgExplain;
    }

    /**
     * @param goodsCtlgExplain 
	 *            商品目录说明
     */
    /**
     * @param goodsCtlgExplain of GDS_P_CTLG : 设置 商品目录说明
     */
    public void setGoodsCtlgExplain(String goodsCtlgExplain) {
        this.goodsCtlgExplain = goodsCtlgExplain == null ? null : goodsCtlgExplain.trim();
    }

    /**
     * @return 父目录编码
     */
    /**
     * @return GDS_P_CTLG.PARENT_CTLG_CODE : 返回 父目录编码
     */
    public Integer getParentCtlgCode() {
        return parentCtlgCode;
    }

    /**
     * @param parentCtlgCode 
	 *            父目录编码
     */
    /**
     * @param parentCtlgCode of GDS_P_CTLG : 设置 父目录编码
     */
    public void setParentCtlgCode(Integer parentCtlgCode) {
        this.parentCtlgCode = parentCtlgCode;
    }

    /**
     * @return 此目录下是否有目录属性<br>
	 *         1－有<br>
	 *         0－无
     */
    /**
     * @return GDS_P_CTLG.CTLG_ATTR_TAG : 返回 此目录下是否有目录属性
1－有
0－无
     */
    public String getCtlgAttrTag() {
        return ctlgAttrTag;
    }

    /**
     * @param ctlgAttrTag 
	 *            此目录下是否有目录属性<br>
	 *            1－有<br>
	 *            0－无
     */
    /**
     * @param ctlgAttrTag of GDS_P_CTLG : 设置 此目录下是否有目录属性
1－有
0－无
     */
    public void setCtlgAttrTag(String ctlgAttrTag) {
        this.ctlgAttrTag = ctlgAttrTag == null ? null : ctlgAttrTag.trim();
    }

    /**
     * @return 对应跳转页面编码
     */
    /**
     * @return GDS_P_CTLG.REDIRECT_CODE : 返回 对应跳转页面编码
     */
    public String getRedirectCode() {
        return redirectCode;
    }

    /**
     * @param redirectCode 
	 *            对应跳转页面编码
     */
    /**
     * @param redirectCode of GDS_P_CTLG : 设置 对应跳转页面编码
     */
    public void setRedirectCode(String redirectCode) {
        this.redirectCode = redirectCode == null ? null : redirectCode.trim();
    }

    /**
     * @return GDS_P_CTLG.SHOW_ORDER : 返回 null
     */
    public Short getShowOrder() {
        return showOrder;
    }

    /**
     * @param showOrder of GDS_P_CTLG : 设置 null
     */
    public void setShowOrder(Short showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * @return GDS_P_CTLG.VALUES1 : 返回 null
     */
    public String getValues1() {
        return values1;
    }

    /**
     * @param values1 of GDS_P_CTLG : 设置 null
     */
    public void setValues1(String values1) {
        this.values1 = values1 == null ? null : values1.trim();
    }

    /**
     * @return GDS_P_CTLG.VALUES2 : 返回 null
     */
    public String getValues2() {
        return values2;
    }

    /**
     * @param values2 of GDS_P_CTLG : 设置 null
     */
    public void setValues2(String values2) {
        this.values2 = values2 == null ? null : values2.trim();
    }
}