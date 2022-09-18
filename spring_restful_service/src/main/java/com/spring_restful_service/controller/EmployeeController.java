package com.spring_restful_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_restful_service.entities.Employee;
import com.spring_restful_service.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/home")
	public String registrationPage() {
		return "registration";
	}

	@RequestMapping("/getEmployee")
	public String getEmployee(ModelMap model){
		List<Employee> employee = empService.getEmployee();
		model.addAttribute("employee", employee);
		return "listEmployee";
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getOneEmployee(@PathVariable long empId) {
		return this.empService.getOneEmployee(empId);
	}
	
	@RequestMapping("/empReg")
	public String createEmployee(@ModelAttribute Employee employee, ModelMap model) {
		empService.createEmployee(employee);
		model.addAttribute("msg", "Registration is successful!!");
		return "registration";
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
