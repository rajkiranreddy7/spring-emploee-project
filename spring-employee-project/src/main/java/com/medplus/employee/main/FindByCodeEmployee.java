package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dto.EmployeeDto;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class FindByCodeEmployee {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeService service=ctx.getBean("employeeServiceImpl",EmployeeServiceImpl.class);

		EmployeeDto emp=service.findByCode(102);
		
		
		if (emp!=null) {
		System.out.println(emp);
			
		} else {
			System.out.println("Code Doesn't exist");
		}
		
	}

}
