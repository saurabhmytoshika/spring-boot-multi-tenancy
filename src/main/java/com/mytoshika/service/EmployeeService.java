package com.mytoshika.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytoshika.model.Employee;
import com.mytoshika.repository.EmployeeRepository;

@Service
public class EmployeeService  {

	private final EmployeeRepository employeeRepository;
	
	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional
	public List<Employee> listEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public Optional<Employee> getEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId);
	}

	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
