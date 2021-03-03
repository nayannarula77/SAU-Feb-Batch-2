package com.au.Q3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student student = new Student(); 

    	Book b1 = new Book(); 
    	Book b2 = new Book(); 

    	b1.setBookName("The White Tiger");
    	b1.setStudent(student); 

    	b2.setBookName("C++ Primer");
    	b2.setStudent(student);

    	student.setStudentName("Nayan");

    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.save(b1);
    	session.save(b2);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	System.out.println("Done!");
    	
    }
}
