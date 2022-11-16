package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class AddDepartment {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DepartmentService service=(DepartmentService) ctx.getBean("departmentServiceImpl",DepartmentServiceImpl.class);
		
		Department department=new Department(6,"Research","Madhapur");

		int rows=service.addDepartment(department);

		if (rows>0) {
			System.out.println("inserted");

		} else {
			System.out.println("not inserted");
		}

	}

}
