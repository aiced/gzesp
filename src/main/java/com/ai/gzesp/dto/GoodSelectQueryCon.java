package com.ai.gzesp.dto;

/**
 * 商品选择列表页面 查询条件dto类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GoodSelectQueryCon {
    
    
    /**
     * 商品类型
     */
    private String goodType;
    
    /**
     * 输入的关键字
     */
    private String keyword;
    

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public GoodSelectQueryCon(){
        //空构造，spring转换对象时，进行初始化
    }
}
