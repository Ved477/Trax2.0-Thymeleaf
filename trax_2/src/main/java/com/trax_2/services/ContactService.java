package com.trax_2.services;

import java.util.List;

import com.trax_2.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);
	
	public List<Contact> getAllContacts();

	public Contact findContactById(long id);

	public List<Contact> searchContact(String query);
}
