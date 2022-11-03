package com.trax_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trax_2.entities.Billing;
import com.trax_2.entities.Contact;
import com.trax_2.services.BillingService;
import com.trax_2.services.ContactService;

@Controller
public class BillingController {
	
	private ContactService contactService;
	
	private BillingService billingService;
	
	public BillingController(ContactService contactService, BillingService billingService) {
		this.contactService = contactService;
		this.billingService = billingService;
	}

	@RequestMapping("/createBill/{bid}/bill")
	public String createBill(@PathVariable("bid") long id, Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "create_bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute Billing bill, Model model) {
		billingService.saveBill(bill);
		return "bill";
	}
}
