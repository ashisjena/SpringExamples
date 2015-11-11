package com.demo.myapp.db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.demo.myapp.db.pojo.Contact;

public class TestClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Contact contact = session.load(Contact.class, 5);
		System.out.println(contact);
		session.close();
	}
}
