package com.myblog.service;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.myblog.dao.Impl.ArticleDaoImpl;
import com.myblog.dao.Impl.SortDaoImpl;
import com.myblog.model.Article;

public class ArticleService {
	@Autowired
	private ArticleDaoImpl articleDaoImpl;
	public void setSortDaoImpl(SortDaoImpl sortDaoImpl) {
	             this.articleDaoImpl=articleDaoImpl;
	}
    public List<Article> getSortArticleMessages(String leftSort) {
    	 return articleDaoImpl.getSortArticleMessages(leftSort);
    }
    public List<Article> getAllArticleMessages() {
   	 return articleDaoImpl.getAllArticleMessages();
   }
    public List<Map> getArticleContent(int id){
     return articleDaoImpl.getArticleContent(id);
    }
}
