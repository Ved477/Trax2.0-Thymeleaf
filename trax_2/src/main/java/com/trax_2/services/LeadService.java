package com.trax_2.services;

import java.util.List;

import com.trax_2.entities.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public Lead findLeadById(long id);

	public void deleteLeadById(long id);
	
	public List<Lead> getAllLeads();

	public List<Lead> searchLead(String query);

}
