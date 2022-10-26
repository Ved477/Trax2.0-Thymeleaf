package com.trax_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax_2.utility.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("text") String text, Model model) {
		emailService.sendSimpleMessage(to, subject, text);
		model.addAttribute("msg", "Email Sent!!");
		return "compose_email";
	}
}
