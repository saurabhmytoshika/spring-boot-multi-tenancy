package com.mytoshika.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.model.Employee;
import com.mytoshika.service.EmployeeService;

@RestController
@RequestMapping(value = "/mytoshika")
public class EmployeeController {

  private final EmployeeService employeeService;

  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/getall")
  public List<Employee> listEmployees() {
    return employeeService.listEmployees();
  }

  @PostMapping("/savedata")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping("/getbyid/{id}")
  public Optional<Employee> getEmployee(@PathVariable("id") Integer employeeId) {
    return employeeService.getEmployee(employeeId);
  }

  @DeleteMapping("/deletebyid/{id}")
  public void deleteEmployee(@PathVariable("id") Integer employeeId) {
    employeeService.deleteEmployee(employeeId);
  }

}
