package com.myblog.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myblog.dao.ArticleDao;
import com.myblog.dao.SortDao;
import com.myblog.dao.Impl.ArticleDaoImpl;
import com.myblog.dao.Impl.SortDaoImpl;
import com.myblog.model.Article;
import com.myblog.model.Sort;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	private static SessionFactory factory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*  List list=new ArrayList();
           SortService ss=new SortService();
           list=ss.showSort("首页");
           for(int i=0;i<list.size();i++) {
        	   System.out.println(list.get(i));
           }*/
		
		/*JSONObject jo=new JSONObject();
		jo.put("name","java");
		JSONArray ja=new JSONArray();
		ja.add(jo);
		System.out.print(ja);*/
/*	ArticleDao ad=new ArticleDao();
	List<Article> list=new ArrayList<Article>();
	list =ad.getAllArticle();
	Article article=list.get(0);
	System.out.println(article.getTitle());*/
/*		JSONArray ja=new JSONArray();
		ArticleService as=new ArticleService();
		ja=as.getSortArticle("css");
		System.out.println(ja);*/
/*		String sort="所有";
		String str="所有";
		System.out.println(sort);
		System.out.println(str);
		System.out.println(sort==str);
		System.out.println(sort.equals(str));*/
/*		Date date=new Date();
		Article article=new Article(5,date,"java","title4","showMessage","article4");
		ArticleDao ad=new ArticleDao();
		ad.writeArticle(article);*/
/*		SortDao sd=new SortDao();
		List<String> sort=new ArrayList<String>(); 
		sort=sd.getAllSort();
		for(int i=0;i<sort.size();i++)
		System.out.println(sort.get(i));*/
/*		ArticleDao ad=new ArticleDao();
		Article article=ad.getOnceArticle(1);
		System.out.println(article);
		System.out.println(article.getDate());*/
/*		ArticleService as=new ArticleService();
		
		System.out.println(as.showOnceArticle(1));*/
/*	    factory=new Configuration().configure().buildSessionFactory();
        Test test=new Test();
        test.listSort();
        
	    
	}
    public void listSort() {
    	Session session=factory.openSession();
    	Transaction ts=null;
    	ts=session.beginTransaction();
    	List articles=session.createQuery("FROM Article").list();
    	for(Iterator it=articles.iterator();it.hasNext();) {
    		 Article article=(Article) it.next();
            System.out.println(article.getArticle());
    	}
    	ts.commit();*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		/*SortDaoImpl sdi=new SortDaoImpl();*/
		/*ArticleDaoImpl adi=new ArticleDaoImpl();*/
/*		List<Article> articles=adi.getSortArticleMessages("sort");
        System.out.println(articles.get(0).getArticle());
        int id,Date date,String sort,String title,String showMessage,String article*/
/*		Date date=new Date();
		java.sql.Date date1=new java.sql.Date(date.getTime());
		Article article=new Article(date1,"sort","title","showMessage","article",1,1,"comment");
		adi.writeArticle(article);*/
      
/*	List<Sort> sorts=sdi.getAllSort();
		System.out.println(sorts.get(0).getLeftSort());*/
        SortDaoImpl sdi=(SortDaoImpl) ac.getBean("sortDaoImpl");
        System.out.println(sdi.getLeftSort("frontend").get(0));
        
/*		Sort sort=new Sort(15,"2","3");
		sdi.addSort(sort);*/
		
	}
	
}
