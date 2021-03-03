package com.au;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
	public static void main(String ags[]) throws ParseException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("Menu:\r\n"
				+ "1. Create employee\r\n"
				+ "2. Update all employee\r\n"
				+ "3. Update employee by id\r\n"
				+ "4. Delete employee \r\n"
				+ "5. Get all employee\r\n"
				+ "6. Get Employee by id\r\n"
				+ "7. exit");
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println ("Enter choice(1-7)");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				Transaction tx = session.beginTransaction();
				try {
				Employee p= new Employee();
				System.out.println("Enter first name");
				p.setFirstName(sc.next());
				System.out.println("Enter last name");
				p.setLastName(sc.next());
				System.out.println("Enter age");
				int age=sc.nextInt();
				if(age<10||age>100)
					throw new Exception();
				p.setAge(age);
				System.out.println("Enter dob");
				p.setDob(sc.next());
				System.out.println("Enter Designation");
				p.setDesignation(sc.next());
				System.out.println("Enter salary");
				p.setSalary(sc.nextInt());
				session.save(p);
				tx.commit();
				System.out.println("New employee created!"); }
				catch(Exception ex) {
					
					System.out.println("Exception occured, hence rolllback!");
					sc.next();
					tx.rollback();
					
					
				}
				break;
			case 2:
				tx = session.beginTransaction();
				try{
					Criteria ctrg = session.createCriteria(Employee.class);
				List<Employee> List = ctrg.list();
				for(Employee emp:List) {
					System.out.println("Updating ID="+emp.getId());
					System.out.println("Enter new first name");
					emp.setFirstName(sc.next());
					System.out.println("Enter new last name");
					emp.setLastName(sc.next());
					System.out.println("Enter new age");
					int age=sc.nextInt();
					if(age<10||age>100)
						throw new Exception();
					emp.setAge(age);			
					System.out.println("Enter new dob");
					emp.setDob(sc.next());
					System.out.println("Enter new Designation");
					emp.setDesignation(sc.next());
					System.out.println("Enter new salary");
					emp.setSalary(sc.nextInt());
					session.save(emp);
				}
				tx.commit();}
				catch(Exception ex) {
					
					System.out.println("Exception occured, hence rolllback!");
				//	sc.next();
					tx.rollback();
					
				}
				break;
			case 3:
				tx = session.beginTransaction();
				try {
				System.out.println("Enter ID of record to be updated");
				Employee p=session.load(Employee.class,sc.nextInt());
				System.out.println("Enter new first name");
				p.setFirstName(sc.next());
				System.out.println("Enter new last name");
				p.setLastName(sc.next());
				System.out.println("Enter new age");
				int age=sc.nextInt();
				if(age<10||age>100)
					throw new Exception();
				p.setAge(age);
				System.out.println("Enter new dob");
				p.setDob(sc.next());
				System.out.println("Enter new Designation");
				p.setDesignation(sc.next());
				System.out.println("Enter new salary");
				p.setSalary(sc.nextInt());
				session.save(p);
				tx.commit();}
				catch(Exception ex) {
					System.out.println("Exception occured, hence rolllback!");
					tx.rollback();
					sc.next();
				}
				break;
				
			case 4:
				System.out.println("Enter ID of record to be deleted");
				
				Employee p=session.load(Employee.class,sc.nextInt());
				System.out.println("Warning: Record once deleted cannot be recovered! Continue?(Y/N)");
				String Choice=sc.next();
				if(Choice.equals("Y")) {
				tx = session.beginTransaction();
				session.delete(p);
				tx.commit();}
				break;
			case 5:
				Criteria ctr = session.createCriteria(Employee.class);
				List<Employee> list = ctr.list();
				for(Employee emp:list) {
					System.out.println("ID: "+emp.getId());
					System.out.println("First Name: "+emp.getFirstName());
					System.out.println("Last Name: "+emp.getLastName());
					System.out.println("Age: "+emp.getAge());
					System.out.println("DOB: "+emp.getDob());
					System.out.println("Designation: "+emp.getDesignation());
					System.out.println("Salary: "+emp.getSalary());
					System.out.println();
				}
				break;
			case 6:
				System.out.println("Enter employee id");
				 Employee e = session.load(Employee.class, sc.nextInt());
				if (e != null)
				{
					System.out.println("First Name: "+e.getFirstName());
					System.out.println("Last Name: "+e.getLastName());
					System.out.println("Age: "+e.getAge());
					System.out.println("DOB: "+e.getDob());
					System.out.println("Designation: "+e.getDesignation());
					System.out.println("Salary: "+e.getSalary());
				} else
				{
					System.out.println("No record founds");
				}
				break;
			case 7:
				break;
			}
		}while(choice!=7);
		session.close();
		sc.close();
		
		
		
		
	}
}
