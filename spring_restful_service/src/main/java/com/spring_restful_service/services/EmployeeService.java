package com.spring_restful_service.services;

import java.util.List;

import com.spring_restful_service.entities.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public void createEmployee(Employee employee);

	public Employee getOneEmployee(long empId);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployee(long empId);
}
