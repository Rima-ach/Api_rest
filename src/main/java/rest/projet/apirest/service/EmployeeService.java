package rest.projet.apirest.service;  
import rest.projet.apirest.model.Employee;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;





public interface EmployeeService {
	
	
	public void insertListOfEmployees(List<Employee> employees);
    
    public List<Employee> listEmployeesByCriteria(String criteria, String value);
}