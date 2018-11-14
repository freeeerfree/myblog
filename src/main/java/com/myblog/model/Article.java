package com.myblog.model;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name= "article")
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	@Column(name="date")
    private Date date;
	@Column(name="sort")
    private String sort;
	@Column(name="title")
    private String title;
	@Column(name="showMessage")
    private String showMessage;
	@Column(name="article")
    private String article;
	@Column(name="praise")
    private int praise;
	@Column(name="access")
    private int access;
    public Article() {}
    public Article(Date date,String sort,String title,String showMessage,String article,int praise,int access) {
   	   this.date=date;
   	   this.sort=sort;
       this.title=title;
       this.showMessage=showMessage;
       this.article=article;
       this.praise=praise;
       this.access=access;
    }
    public int getId() {
   	 return this.id;
    }
    public void setId(int aid) {
       this.id=aid;
    }
    public Date getDate() {
   	 return date;
    }
    public void setDate(Date date) {
   	 this.date=date;
    }
    public void setSort(String sort) {
   	 this.sort=sort;
    }
    public String getSort() {
   	 return this.sort;
    }
       public String getTitle() {
   	 return title;
    }
    public void setTitle(String title) {
   	 this.title=title;
    }
        public String getShowMessage() {
   	 return showMessage;
    }
    public void setShowMessage(String showMessage) {
   	 this.showMessage=showMessage;
    }
       public String getArticle() {
   	 return article;
    }
    public void setArticle(String article) {
   	 this.article=article;
    }
    public int getPraise() {
    	return praise;
    }
    public void setPraise(int praise) {
    	this.praise=praise;
    }
    public int getAccess() {
    	return access;
    }
    public void setAccess(int access) {
    	this.access=access;
    }

}
