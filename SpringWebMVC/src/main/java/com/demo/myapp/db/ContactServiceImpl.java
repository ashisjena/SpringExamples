package com.demo.myapp.db;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.myapp.db.inter.ContactRepository;
import com.demo.myapp.db.inter.ContactService;
import com.demo.myapp.db.pojo.Contact;
import com.google.common.collect.Lists;

@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {
	//@Autowired
	private ContactRepository contactRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
}