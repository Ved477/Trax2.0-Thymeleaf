package com.trax_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax_2.entities.Contact;
import com.trax_2.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public void saveContact(Contact contact) {
		contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contact findContactById(long id) {
		Optional<Contact> findById = contactRepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

	@Override
	public List<Contact> searchContact(String query) {
		List<Contact> contacts = contactRepo.searchContact(query);
		return contacts;
	}

}
