package com.api.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.phonebook.entities.Contact;
import com.api.phonebook.entities.rapo.PhonebookRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private PhonebookRepository repository;

	public ContactServiceImpl(PhonebookRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public boolean saveOrUpdateContact(Contact c) {
		Contact savedobj = repository.save(c);

		return savedobj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {

		return this.repository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = this.repository.findById(contactId);

		if (findById.isPresent()) {

			return findById.get();

		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		boolean isDeleted = false;
		try {

			this.repository.deleteById(contactId);
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
}
