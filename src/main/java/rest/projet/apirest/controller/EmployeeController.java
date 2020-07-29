package rest.projet.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import rest.projet.apirest.model.Employee;
import rest.projet.apirest.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
@Autowired
private EmployeeService employeeService;


@PostMapping("/insert")
@ResponseStatus(HttpStatus.OK)
public void insertListOfEmployees(@RequestBody List<Employee> employees) {
	employeeService.insertListOfEmployees(employees);
}

@PostMapping("/list")
@ResponseStatus(HttpStatus.OK)
public List<Employee> listEmployeesByCriteria(@RequestParam String criteria, @RequestParam String value) {
	
  return employeeService.listEmployeesByCriteria(criteria, value);
}

}