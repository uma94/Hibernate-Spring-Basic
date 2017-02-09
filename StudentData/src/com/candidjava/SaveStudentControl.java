package com.candidjava;
import java.sql.*;
import java.util.List;
import java.io.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class SaveStudentControl  {

	private static  SessionFactory sessionFactory;
	  private Session getSession()
	  {
	  Session s =null;
	     try{
		 		sessionFactory = new Configuration().configure().buildSessionFactory();
	 		s=sessionFactory.openSession();
	 		}catch(HibernateException e){
					System.out.println(e.getMessage());
	}
		   return s;
	  }
	public  void addNewStudent(String stuid,String sturegno,String stuname,String sCollege,String degree,String mobileno,String mailid) throws Exception
	 {
	   try{
	 		Session s =getSession();
	 		Transaction tx= s.beginTransaction();
			Student stu=new Student();
	stu.setId(1);
			stu.setStuid(stuid);
			stu.setSturegno(sturegno);
			stu.setStuname(stuname);
			stu.setsCollege(sCollege);
			
			stu.setDegree(degree);
			stu.setMobileno(mobileno);
			stu.setMailid(mailid);
	 		s.save(stu);
				
	 		tx.commit();
	 		System.out.println("\n\n Details Added \n");
			}catch(HibernateException e){
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	 
	}

}//end of class