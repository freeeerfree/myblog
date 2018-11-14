package com.myblog.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.dao.SortDao;
import com.myblog.model.Sort;
@Repository
@Transactional
public class SortDaoImpl implements SortDao{
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
/*	public SortDaoImpl() {
		factory=new Configuration().configure().buildSessionFactory();
	}*/
	@SuppressWarnings("deprecation")
	@Override
	public List<String> getLeftSort(String headLeft) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("select sort.leftSort FROM Sort sort where sort.headSort=:headSort");
		query.setString("headSort",headLeft);
		return query.list();
	}

	@Override
	public List<String> getAllSort() {
		// TODO Auto-generated method stub
			sorts= getSession().createQuery("FROM Sort").list();
		return sorts;
	}
	@Override
	public void addSort(Sort sort) {
		// TODO Auto-generated method stub
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(sort);
			tx.commit();
		}catch(HibernateException e) {
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			session.close();
		}
		
	}
      
}

