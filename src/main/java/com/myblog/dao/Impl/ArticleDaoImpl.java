package com.myblog.dao.Impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.dao.ArticleDao;
import com.myblog.model.Article;
@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	private  SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	List<String> sorts;
	Criteria cr;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Article> getAllArticleMessages() {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM Article").list();	
	}
	@Override
	public List<Article> getSortArticleMessages(String leftSort) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("FROM Article article where article.sort=:leftSort");
		query.setString("leftSort", leftSort);
		return query.list();
	}
	@Override
	public void writeArticle(Article article) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Map> getArticleContent(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Query query=getSession().createSQLQuery("select id,article,date,sort FROM Article where id=:id").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setInteger("id", id);
		return query.list();
	}


}
