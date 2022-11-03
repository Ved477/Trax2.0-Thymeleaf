package com.trax_2.services;

import org.springframework.stereotype.Service;

import com.trax_2.entities.Billing;
import com.trax_2.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

	private BillingRepository billRepo;
	
	public BillingServiceImpl(BillingRepository billRepo) {
		this.billRepo = billRepo;
	}
	
	@Override
	public void saveBill(Billing bill) {
		billRepo.save(bill);
	}

}
