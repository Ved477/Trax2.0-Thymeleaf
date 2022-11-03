package com.trax_2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trax_2.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

	@Query("SELECT p FROM Lead p WHERE p.firstName LIKE CONCAT('%', :query, '%')")
	List<Lead> searchLead(@Param("query") String query);

}
