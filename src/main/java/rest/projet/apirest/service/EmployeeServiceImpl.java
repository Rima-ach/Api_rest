package rest.projet.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import rest.projet.apirest.model.Employee;
import rest.projet.apirest.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertListOfEmployees(List<Employee> employees) {
        employeeRepository.insert(employees);
    }

    public List<Employee> listEmployeesByCriteria(String criteria, String value) {
        Query query = new Query();
        query.addCriteria(Criteria.where(criteria).is(value));
        List<Employee> employees = mongoTemplate.find(query, Employee.class);
        return employees;
    }


}
