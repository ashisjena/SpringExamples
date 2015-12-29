package com.demo.myapp.db;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.myapp.db.pojo.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
