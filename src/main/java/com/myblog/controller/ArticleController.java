package com.myblog.controller;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.model.Article;
import com.myblog.service.ArticleService;



@RestController
public class ArticleController {
	  @Autowired
	   private ArticleService articleService;
	   public void setArticleService(ArticleService articleService) {
		    this.articleService=articleService;  
	   }
	   @RequestMapping(value="/blog/{leftSort}",method=RequestMethod.POST)
	   public List<Article> getSortArticleMessages(@PathVariable String leftSort) {
		return articleService.getSortArticleMessages(leftSort);                   
	   }
	   @RequestMapping(value="/main",method=RequestMethod.POST)
	   public List<Article> getAllArticleMessages() {
		return articleService.getAllArticleMessages();                   
	   }
	   @RequestMapping(value="/article/id/{id}",method=RequestMethod.POST)
	   public List<Map> getArticleContent(@PathVariable int id) {
		return articleService.getArticleContent(id);                 
	   }
	   
}