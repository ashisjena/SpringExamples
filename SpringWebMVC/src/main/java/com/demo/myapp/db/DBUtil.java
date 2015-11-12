package com.demo.myapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("dbUtil")
@Scope("singleton")
@Lazy(false)
public class DBUtil {

	@Autowired(required = true)
	@Qualifier("dataSource")
	private DataSource dataSource = null;

	@Autowired(required = true)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}