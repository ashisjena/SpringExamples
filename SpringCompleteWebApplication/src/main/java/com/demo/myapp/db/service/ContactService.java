package com.demo.myapp.db.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.myapp.db.pojo.Contact;

public interface ContactService {
	List<Contact> findAll();

	Contact findById(Long id);

	Contact save(Contact contact);

	Page<Contact> findAllByPage(Pageable pageable);
}
