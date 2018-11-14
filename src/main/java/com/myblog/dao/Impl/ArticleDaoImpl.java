package com.myblog.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.myblog.dao.ArticleDao;
import com.myblog.model.Article;

public class ArticleDaoImpl implements ArticleDao{
	private static SessionFactory factory;
	Session session;
	Transaction tx;
	List<Article> articles;
	Criteria cr;
    public ArticleDaoImpl () {
    	 factory=new Configuration().configure().buildSessionFactory(); 
    }
	@Override
	public List<Article> getAllArticleMessages() {
		// TODO Auto-generated method stub
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		articles= session.createQuery("FROM Article").list();
		tx.commit();
	}catch(HibernateException e) {
		if(tx!=null) {
			tx.rollback();
			e.printStackTrace();
		}
	}finally{
		session.close();
	}
		return articles;	
	}


	@Override
	public List<Article> getSortArticleMessages(String sort) {
		// TODO Auto-generated method stub
		try {
			session=factory.openSession();
			tx=session.beginTransaction();	
			cr=session.createCriteria(Article.class);
            articles=cr.add(Restrictions.eq("sort",sort)).list();
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			session.close();
		}
			return articles;	
		
	}

	@Override
	public void writeArticle(Article article) {
		// TODO Auto-generated method stub
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.save(article);
		tx.commit();
	}
	catch(HibernateException e){
	   if(tx!=null) {
		   tx.rollback();
	   }
	}
	finally {
		session.close();
	}
	}

	@Override
	public Article getArticleContent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
