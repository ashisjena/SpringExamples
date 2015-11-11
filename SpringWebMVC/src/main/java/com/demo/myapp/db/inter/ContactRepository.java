package com.demo.myapp.db.inter;

import org.springframework.data.repository.CrudRepository;

import com.demo.myapp.db.pojo.Contact;


public interface ContactRepository extends CrudRepository<Contact, Long> {
}