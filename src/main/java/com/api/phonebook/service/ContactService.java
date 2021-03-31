package com.api.phonebook.service;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import com.api.phonebook.entities.Contact;

@Component
public interface ContactService {

	// Save contact details
	public boolean saveOrUpdateContact(Contact c);

	// Display or find all contacts
	public List<Contact> getAllContacts();
	
	//get contact by id
	public Contact getContactById(Integer contactId);

	// delete contact 
	public boolean deleteContact(Integer contactId);



}
