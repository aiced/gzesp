package com.ai.gzesp.dto;

/**
 * 号码选择列表页面 查询条件dto类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SelectNumberQueryCon {
    
    
    /**
     * 3位地市
     */
    private String eparchy_code;
    
    /**
     * 靓号规则
     */
    private String nice_rule;
    
    /**
     * 靓号预存范围起始
     */
    private int nice_fee_start;
    
    /**
     * 靓号预存范围结束
     */
    private int nice_fee_end;
    
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

    
    public String getEparchy_code() {
        return eparchy_code;
    }


    public void setEparchy_code(String eparchy_code) {
        this.eparchy_code = eparchy_code;
    }


    public String getNice_rule() {
        return nice_rule;
    }


    public void setNice_rule(String nice_rule) {
        this.nice_rule = nice_rule;
    }


    public int getNice_fee_start() {
        return nice_fee_start;
    }


    public void setNice_fee_start(int nice_fee_start) {
        this.nice_fee_start = nice_fee_start;
    }


    public int getNice_fee_end() {
        return nice_fee_end;
    }


    public void setNice_fee_end(int nice_fee_end) {
        this.nice_fee_end = nice_fee_end;
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


    public SelectNumberQueryCon(){
        //空构造，spring转换对象时，进行初始化
    }
}
