package com.api.phonebook.entities.rapo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.phonebook.entities.Contact;

@Repository
public interface PhonebookRepository extends JpaRepository<Contact, Integer>{
	
	
}
