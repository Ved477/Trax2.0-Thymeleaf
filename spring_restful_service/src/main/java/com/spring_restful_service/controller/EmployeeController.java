package com.spring_restful_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_restful_service.entities.Employee;
import com.spring_restful_service.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return this.empService.getEmployee();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getOneEmployee(@PathVariable long empId) {
		return this.empService.getOneEmployee(empId);
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.empService.createEmployee(employee);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.empService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long empId){
		try {
			empService.deleteEmployee(empId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
