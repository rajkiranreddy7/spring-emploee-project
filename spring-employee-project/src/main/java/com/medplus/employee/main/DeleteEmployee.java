package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class DeleteEmployee {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		EmployeeService service=ctx.getBean("employeeServiceImpl",EmployeeServiceImpl.class);
	
		//Scanner sc=new Scanner(System.in);
		int rows=service.deleteEmployee(110);
		
		if (rows>0) {
			System.out.println("deleted");
			
		} else {
			System.out.println("not deleted");
		}
		
	}

}
