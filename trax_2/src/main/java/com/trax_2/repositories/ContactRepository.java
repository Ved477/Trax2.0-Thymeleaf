package com.trax_2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trax_2.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	@Query("SELECT p FROM Contact p WHERE p.firstName LIKE CONCAT('%', :query, '%')")
	List<Contact> searchContact(@Param("query") String query);

}
