package com.demo.myapp;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.myapp.model.Community;
import com.demo.myapp.model.Country;
import com.demo.myapp.model.User;

@Controller
@RequestMapping("/inputForm")
public class SpringFormController {
	private static final Logger logger = Logger.getLogger(SpringFormController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String form(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "springForm";
	}

	// BindingResult is for validating and error checking
	/*validator.validate(modelObject, bindingResult);  
	if (bindingResult.hasErrors()) {  
	    // do something  
	}*/
	@RequestMapping(method = RequestMethod.POST)
	public String form(@Valid @ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
		System.out.println(user.getName());
		System.err.println(user);
		return "home";
	}

	@ModelAttribute("countryList")
	public List<Country> getCountries() {
		List<Country> countries = new ArrayList<>();
		countries.add(new Country(1, "India"));
		countries.add(new Country(2, "Srilanka"));
		return countries;
	}

	@ModelAttribute("communityList")
	public List<Community> getCommunities() {
		List<Community> communities = new ArrayList<>();
		communities.add(new Community("key1", "Oriya"));
		communities.add(new Community("key2", "Marathi"));
		return communities;
	}
}