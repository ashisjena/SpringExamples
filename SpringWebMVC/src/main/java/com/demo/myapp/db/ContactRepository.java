package com.demo.myapp.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.myapp.db.pojo.Contact;

@Repository
@Service("contactRepository")
public class ContactRepository implements CrudRepository<Contact, Long> {

	@Autowired(required = true)
	private DBUtil util;

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Contact> S save(S entity) {
		return (S) util.getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Contact> findAll() {
		return util.getSession().createQuery("FROM Contact").list();
	}

	@Override
	public Contact findOne(Long id) {
		return (Contact) util.getSession().get(Contact.class, id.intValue());
	}

	@Override
	public <S extends Contact> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Contact> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Contact entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Contact> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}