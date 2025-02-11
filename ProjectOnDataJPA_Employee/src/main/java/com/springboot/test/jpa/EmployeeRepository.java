package com.springboot.test.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.test.object.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	public List<Employee> findByEmpSalGreaterThan(Double Sal);
	
	
	public List<Employee>  findByEmpAddress(String empAddress);
	
	public List<Employee> findByEmpSalAndEmpAddress(Double empSal, String empAddress);
	
	
	@Query("from Employee")
	public List<Employee> getAllEmployees();
	
	
	@Query("from Employee where empId=:Id")
	public Optional<Employee> getEmployeesById(Integer Id);
	
	@Query(value="select * from Employee", nativeQuery=true)
	public List<Employee> getAllEmployeesByQuery();
	
	@Transactional
	@Modifying
	@Query("delete from Employee where empId=:Id")
	public void deleteEmployeeByIdInCustomeQuery(Integer Id);
}
