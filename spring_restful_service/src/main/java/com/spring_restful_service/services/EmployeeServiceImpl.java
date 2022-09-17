package com.spring_restful_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_restful_service.entities.Employee;
import com.spring_restful_service.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getEmployee() {
		return this.empRepo.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return this.empRepo.save(employee);
	}

	@Override
	public Employee getOneEmployee(long empId) {
		Optional<Employee> findById = empRepo.findById(empId);
		Employee employee = findById.get();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.empRepo.save(employee);
	}

	@Override
	public void deleteEmployee(long empId) {
		empRepo.deleteById(empId);
	}

}
