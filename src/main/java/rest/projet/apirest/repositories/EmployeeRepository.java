package rest.projet.apirest.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rest.projet.apirest.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

}
