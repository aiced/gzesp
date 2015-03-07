package com.ai.wx.entity.response;

import java.util.List;

/**
 * 响应消息之图文消息<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class ResponseNewsMessage extends ResponseBaseMessage {

    // 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;  
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
  
    public List<Article> getArticles() {  
        return Articles;  
    }  
  
    public void setArticles(List<Article> articles) {  
        Articles = articles;  
    } 
}
