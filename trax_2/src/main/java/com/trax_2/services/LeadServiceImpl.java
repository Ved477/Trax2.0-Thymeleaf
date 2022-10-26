package com.trax_2.services;

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

}
