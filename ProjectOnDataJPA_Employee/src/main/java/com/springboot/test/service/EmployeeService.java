package com.springboot.test.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.test.jpa.EmployeeRepository;
import com.springboot.test.object.Employee;
@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
//	public EmployeeService(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//	}

	Employee emp1=new Employee(123,"Suresh","Bbsr",35450.00);
	Employee emp2=new Employee(234,"Soubhagya","Bbsr",23400.00);
	Employee emp3=new Employee(134,"Surya","Khordha",25000.00);
	
	List<Employee> listoEmployees = Arrays.asList(emp1,emp2,emp3);
	List<Integer> listofId=Arrays.asList(123,234,134);
	
	public void addEmployee()
	{
		 employeeRepository.save(emp2);
		 System.out.println("Employee added successfully....");
		
	}
	
	public void addAllEmployee()
	{
		
		employeeRepository.saveAll(listoEmployees);
		System.out.println("EmployeeService.addAllEmployee()  : all the employee added..");
		
	}
	
	public void findingById()
	{
		Optional<Employee> findEmployeebyId = employeeRepository.findById(134);
		if(!findEmployeebyId.isEmpty())
		{
			Employee employee = findEmployeebyId.get();
			System.out.println("Yes it's Available in the database");
			System.out.println(employee.toString());
		}
		else 
		{
			System.out.println("Invalid Id...please check the input");
		}
		
	}
	
	
	
	public void findingByMoreId()
	{
		
		Iterable<Employee> allById = employeeRepository.findAllById(listofId);
		allById.forEach(s->System.out.println(s));
		
	}
	
	public void findingAll()
	{
		Iterable<Employee> findAllEmployee= employeeRepository.findAll();
		findAllEmployee.forEach(System.out::println);
		
	}
	
	public void checkExistance()
	{
		boolean existsById = employeeRepository.existsById(123);
		if(existsById)
		{
			System.out.println(" Available in the database.");
		}
		else 
		{
			System.out.println("Not available in the database.");
		}
		
	}
	
	
	
	public void countTheEmployee()
	{
		long countTheEmployees = employeeRepository.count();
		System.out.println("Total employees available in the database : "+countTheEmployees);
		
	}
	
	
	public void deletebyId()
	{
		employeeRepository.deleteById(234);
		System.out.println("Employee table successfully deleted from the database");
		showTableEmployee();
	}
	
	public void showTableEmployee()
	{
		Iterable<Employee> listOfEmp = employeeRepository.saveAll(listoEmployees);
		System.out.println();
		System.out.println("Employee List :");
		listOfEmp.forEach(System.out::println);
		
		
	}
	
	
	public void deleteAllEmpTable()
	{
		employeeRepository.deleteAll();
		System.out.println("all the records are deleted.");
		
	}
	
	
	public void deleteAllById()
	{
		employeeRepository.deleteAllById(listofId);
		System.out.println("Delete successfully");
	}
	
	public void deleteEmpByEntity() 
	{
		employeeRepository.delete(emp1);
		showTableEmployee();
	}
	
	
	
	public void deleteAllEmpByEntities()
	{
		employeeRepository.deleteAll(listoEmployees);
		showTableEmployee();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void employeeSalary(Double sal)
	{
		List<Employee> empSalGreaterThanEqual = employeeRepository.findByEmpSalGreaterThan(sal);
		empSalGreaterThanEqual.forEach(s->System.out.println(s));
	}
	
	
	
	public void employeeBasedOnAddress(String add)
	{
		List<Employee> byEmpAddress = employeeRepository.findByEmpAddress(add);
		byEmpAddress.forEach(s->System.out.println(s));
	}
	
	public void employeeBasedOnSalAndAddress(Double sal,String add)
	
	{
		List<Employee> salAndAddressEmployees=employeeRepository.findByEmpSalAndEmpAddress(sal, add);
		salAndAddressEmployees.forEach(System.out::println);
	}
	
	
	public void customeQueryEmpDetails()
	{
		List<Employee> empDetails=employeeRepository.getAllEmployees();
		empDetails.forEach(s->System.out.println(s));
	}
	public void CustomFindById(Integer id)
	{
		Optional<Employee> employeesById = employeeRepository.getEmployeesById(id);
		System.out.println( employeesById);
	}
	
	
	
	
	
	
	
	public void customeNativeQueryFindAllEmployee()
	{
		List<Employee> allEmployeesByQuery = employeeRepository.getAllEmployeesByQuery();
		allEmployeesByQuery.forEach(System.out::println);
	}
	public void customeQueryDeleteEmpById(Integer Id)
	
	{
		employeeRepository.deleteEmployeeByIdInCustomeQuery(Id);
		showTableEmployee();
	}
	
	
	
	
	
	public void empSorting(String empname)
	{
		Sort sort= Sort.by(empname).descending();
		List<Employee> all = employeeRepository.findAll(sort);
		all.forEach(System.out::println);
		
	}
	
	
	
	public void pagination(int pageSize,int pageNo)
	{
		PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);
	    Page<Employee> pageAll = employeeRepository.findAll(pageRequest);
	    List<Employee> content = pageAll.getContent();
	    content.forEach(s->System.out.println(s));
	    
	}
	
	
	
	public void getEmployeebyQBE()
	{
		Employee employee=new Employee();
		employee.setEmpAddress("Bbsr");
		Example<Employee> example=Example.of(employee);
		List<Employee> listOfEmp = employeeRepository.findAll(example);
		listOfEmp.forEach(s->System.out.println(s));
		
	}
}
