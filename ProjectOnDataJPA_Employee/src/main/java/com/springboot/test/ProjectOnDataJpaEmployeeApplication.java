package com.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.test.service.EmployeeService;

@SpringBootApplication
public class ProjectOnDataJpaEmployeeApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context = SpringApplication.run(ProjectOnDataJpaEmployeeApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		//employeeService.addEmployee();
		//employeeService.addAllEmployee();
		//employeeService.findingById();
		//employeeService.findingByMoreId();
		//employeeService.findingAll();
		//employeeService.checkExistance();
		//employeeService.deletebyId();
		//employeeService.showTableEmployee();
		//employeeService.deleteAllById();
		//employeeService.deleteEmpByEntity();
		//employeeService.deleteAllEmpByEntities();
		
	}

}
