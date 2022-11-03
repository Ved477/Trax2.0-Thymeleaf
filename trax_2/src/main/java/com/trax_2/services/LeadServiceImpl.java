package com.trax_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax_2.entities.Lead;
import com.trax_2.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) throws RuntimeException {
		leadRepo.save(lead);
	}

	@Override
	public Lead findLeadById(long id) {
		Lead lead = leadRepo.findById(id).get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public List<Lead> searchLead(String query) {
		List<Lead> leads = leadRepo.searchLead(query);
		return leads;
	}
		

}
