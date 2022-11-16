package com.medplus.employee.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dto.EmployeeDto;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class FindAllEmployees {

	public static void main(String[] args) {


		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeService service=ctx.getBean("employeeServiceImpl",EmployeeServiceImpl.class);

		List<EmployeeDto> empList=service.findAll();

		for(EmployeeDto emp:empList)
		{
			System.out.println(emp);
		}



	}





}



