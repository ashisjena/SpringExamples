package com.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myapp.db.inter.ContactService;
import com.demo.myapp.db.pojo.Contact;
import com.demo.myapp.model.ContactModel;

@RestController
// @Path("test")
public class ContactsRest {

	@Autowired(required = true)
	@Qualifier("contactService")
	private ContactService contactService;

	// @GET
	// @Path("contact")
	// @Produces("application/json")
	// @ResponseBody
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactModel getContact(@PathVariable long id) {
		Contact result = contactService.findById(id);
		return new ContactModel(result);
	}
}