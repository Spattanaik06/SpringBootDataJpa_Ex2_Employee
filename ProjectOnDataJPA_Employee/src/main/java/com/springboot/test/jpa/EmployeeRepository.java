package com.springboot.test.jpa;

import org.springframework.data.repository.CrudRepository;
import com.springboot.test.object.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
