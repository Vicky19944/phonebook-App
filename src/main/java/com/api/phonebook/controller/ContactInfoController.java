package com.api.phonebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.phonebook.entities.Contact;
import com.api.phonebook.service.ContactServiceImpl;

@Controller
public class ContactInfoController {

	private ContactServiceImpl service;

	public ContactInfoController(ContactServiceImpl service) {
		super();
		this.service = service;
	}

	/*
	 * this method use to load the form
	 */
	// Model use to send data from controller to ui

	@GetMapping("/load-form")
	public String loadForm(Model model) {

		// here created empty contact object and sending from controller to ui for data
		// banding
		Contact cobj = new Contact();

		// sending data from controller to ui.
		model.addAttribute("contact", cobj);

		// returning logical view name
		return "contact";

	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(Contact contact, Model model) {
		boolean isSave = this.service.saveOrUpdateContact(contact);

		if (isSave) {
			model.addAttribute("sucMsg", "Contact is saved Successfully");
		} else {
			model.addAttribute("failed", "failed to save please try again...");
		}
		return "contact";
	}

	@GetMapping("/view-contacts")
	public String handleViewContactHyperlink(Model model) {
		List<Contact> allContacts = this.service.getAllContacts();
		model.addAttribute("contacts", allContacts);

		return "contact-display";
	}

}
