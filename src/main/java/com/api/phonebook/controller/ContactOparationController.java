package com.api.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.phonebook.entities.Contact;
import com.api.phonebook.service.ContactService;

@Controller
public class ContactOparationController {
	
	private ContactService service;
	
	
	
	public ContactOparationController(ContactService service) {
		super();
		this.service = service;
	}



	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contactObj = this.service.getContactById(contactId);
		model.addAttribute("contact", contactObj);
		
		return "contact";
	}
	
	@GetMapping("/deleteContact")
	public String deleleContact(@RequestParam("cid") Integer contactId, Model model) {
		
		boolean isdeleted = this.service.deleteContact(contactId);
		if(isdeleted) {
			model.addAttribute("success","successfully deleted..." );
		}
		else {
			model.addAttribute("failure","fail to delete please try again..." );
		}
		return "redirect:view-contacts";
	}

}
