package rest.projet.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import rest.projet.apirest.model.Employee;
import rest.projet.apirest.service.EmployeeService;
import rest.projet.apirest.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.OK)
    public void insertListOfEmployees(@RequestBody List<Employee> employees) {
        employeeServiceImpl.insertListOfEmployees(employees);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> listEmployeesByCriteria(@RequestParam String criteria, @RequestParam String value) {
        return employeeServiceImpl.listEmployeesByCriteria(criteria, value);
    }

}