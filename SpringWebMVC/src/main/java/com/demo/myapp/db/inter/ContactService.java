package com.demo.myapp.db.inter;

import java.util.List;

import com.demo.myapp.db.pojo.Contact;

public interface ContactService {
	List<Contact> findAll();

	Contact findById(Long id);

	Contact save(Contact contact);
}