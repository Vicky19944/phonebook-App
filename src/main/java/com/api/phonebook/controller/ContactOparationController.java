package com.api.phonebook.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.api.phonebook.entities.Contact;
import com.api.phonebook.prop.AppProperties;
import com.api.phonebook.service.ContactService;

@Controller
public class ContactOparationController {
	
	private ContactService service;
	
	private AppProperties props;
	
	
	public ContactOparationController(ContactService service, AppProperties props) {
		super();
		this.service = service;
		this.props=props;
	}



	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contactObj = this.service.getContactById(contactId);
		model.addAttribute("contact", contactObj);
	
		
		return "contact";
	}
	
	@GetMapping("/deleteContact")
	public String deleleContact(@RequestParam("cid") Integer contactId, RedirectAttributes rd) {
		
		boolean isdeleted = this.service.deleteContact(contactId);
		Map<String, String> massages=props.getMassages();
		
		if(isdeleted) {
			rd.addFlashAttribute("successDelete",massages.get("contactDeleteSucc"));
		}
		else {
		rd.addFlashAttribute("failDelete",massages.get("contactDeleteFail") );
		}
		return "redirect:view-contacts";
		}
	}


