package com.spring_restful_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_restful_service.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
