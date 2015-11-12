package com.demo.myapp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.myapp.db.inter.ContactService;
import com.demo.myapp.db.pojo.Contact;

@RequestMapping("/contacts")
@Controller
public class ContactController {
	private static final Logger logger = Logger.getLogger(ContactController.class);
	
	@Autowired(required = true)
	@Qualifier("contactService")
	private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing contacts");
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);
		logger.info("No. of contacts: " + contacts.size());
		return "list";
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}