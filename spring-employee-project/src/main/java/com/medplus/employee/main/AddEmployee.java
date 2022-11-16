package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;


public class AddEmployee {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeService service=ctx.getBean("employeeServiceImpl",EmployeeServiceImpl.class);
		Employee emp=new Employee(106, "opti", 45000, "2010-3-29");
		String deptName="Software";
		
		int rows=service.addEmployee(emp, deptName);
		
		if (rows>0) {
			System.out.println("inserted");
			
		} else {
			System.out.println("not inserted");
		}
			
			
		

	}

}
