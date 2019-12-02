package com.mytoshika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytoshika.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
