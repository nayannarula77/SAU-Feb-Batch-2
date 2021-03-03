package com.au.HibernateAssignment2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
    	
    	Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();

		Categories c1 = new Categories();
		Categories c2 = new Categories();
		Categories c3 = new Categories();

		Supplier s1 = new Supplier();
		Supplier s2 = new Supplier();
		Supplier s3 = new Supplier();
		
		p1.setPid(1);
		p1.setPname("Product 1");
		p2.setPid(2);
		p2.setPname("Product 2");	
		p3.setPid(3);
		p3.setPname("Product-3");
		
		c1.setCid(11);
		c1.setCname("Category 1");
		c2.setCid(22);
		c2.setCname("Category 2");
		c3.setCid(33);
		c3.setCname("Category 3");
		
		s1.setSid(111);
		s1.setSname("Supplier 1");
		s2.setSid(222);
		s2.setSname("Supplier 2");
		s3.setSid(333);
		s3.setSname("Supplier 3");
		
		Set<Categories> set1 = new HashSet<>();
		set1.add(c1);
		set1.add(c3);
		
		p1.setCategories(set1);
		
		Set<Categories> set2 = new HashSet<>();
		set2.add(c2);
		
		p2.setCategories(set2);
		
		Set<Categories> set3 = new HashSet<>();
		set3.add(c1);
		set3.add(c2);
		
		p3.setCategories(set3);
		
		c1.setProduct(p1);
		c2.setProduct(p2);
		c3.setProduct(p1);
		
		Set<Supplier> set4 = new HashSet<>();
		set4.add(s1);
		set4.add(s3);
		
		Set<Supplier> set5 = new HashSet<>();
		set4.add(s2);
		
		s1.setCategories(set1);
		s2.setCategories(set2);
		s3.setCategories(set1);
		
		c1.setSupplier(set4);
		c2.setSupplier(set5);
		c3.setSupplier(set4);
		

		Transaction tx = session.beginTransaction();

		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(s1);
		session.save(s2);
		session.save(s3);
	
		tx.commit();
		session.close();
		System.out.println("Association Mapping Done!");
		
    }
}
