package com.trax_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax_2.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
