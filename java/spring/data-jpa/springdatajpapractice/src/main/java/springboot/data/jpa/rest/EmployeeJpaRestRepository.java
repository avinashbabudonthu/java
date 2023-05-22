package springboot.data.jpa.rest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import springboot.data.jpa.model.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "/employeesList")
public interface EmployeeJpaRestRepository extends PagingAndSortingRepository<Employee, Integer> {

    List<Employee> findByName(@PathVariable("name") String name);

}