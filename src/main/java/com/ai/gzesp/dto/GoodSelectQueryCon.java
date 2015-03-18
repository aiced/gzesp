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
    
    /**
     * 页数
     */
    private int pageNum;
    
    /**
     * 每页条目数
     */
    private int pageSize;
    
    /**
     * 排序升序asc还是降序 desc
     */
    private String sort;
    
    /**
     * 排序字段
     */
    private String sortCol;
    

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
    
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortCol() {
        return sortCol;
    }

    public void setSortCol(String sortCol) {
        this.sortCol = sortCol;
    }

    public GoodSelectQueryCon(){
        //空构造，spring转换对象时，进行初始化
    }
}
