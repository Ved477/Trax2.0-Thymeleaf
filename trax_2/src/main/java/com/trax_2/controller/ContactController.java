package com.trax_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax_2.entities.Contact;
import com.trax_2.entities.Lead;
import com.trax_2.services.ContactService;
import com.trax_2.services.LeadService;

@Controller
public class ContactController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;

	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, ModelMap model) {
		System.out.println(id);
		Lead lead = leadService.findLeadById(id);
		
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setLeadSource(lead.getLeadSource());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		
		contactService.saveContact(contact);
		
		leadService.deleteLeadById(id);
		
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		
		return "list_all_contacts";
		
	}
	
	@RequestMapping("/allContacts")
	public String viewAllContacts(ModelMap model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_all_contacts";
	}
	
	@RequestMapping("/contactInfo/{id}/info")
	public String contactInfo(@PathVariable("id") long id, ModelMap model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
	
	@RequestMapping("/searchContact")
	public String searchContact(@RequestParam("query") String query, ModelMap model) {
		List<Contact> contacts = contactService.searchContact(query);
		model.addAttribute("contacts", contacts);
		return "list_all_contacts";
	}
}
