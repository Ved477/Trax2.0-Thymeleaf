package com.trax_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trax_2.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}
