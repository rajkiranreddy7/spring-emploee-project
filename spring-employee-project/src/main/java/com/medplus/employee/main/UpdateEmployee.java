package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class UpdateEmployee {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeService service=ctx.getBean("employeeServiceImpl",EmployeeServiceImpl.class);
		
		Employee emp=new Employee(101, "optival", 42000, "2010-1-29");
		String deptname="HR";
		int rows=service.updateEmployee(emp,deptname);
		
		if (rows>0) {
			System.out.println("updated");
			
		} else {
			System.out.println("not updated");
		}
			
	}

}
