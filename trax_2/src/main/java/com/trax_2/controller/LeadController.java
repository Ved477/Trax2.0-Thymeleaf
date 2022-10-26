package com.trax_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trax_2.entities.Lead;
import com.trax_2.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping(value="/saveLead", method=RequestMethod.POST)
	public String saveLead(@ModelAttribute Lead lead, Model model) {
		try {
			leadService.saveLead(lead);
			model.addAttribute("msg", "Lead is Saved!!");
			model.addAttribute("lead", lead);
			return "lead_info";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg", "Lead is not Saved!!");
		return "create_lead";
	}
}
