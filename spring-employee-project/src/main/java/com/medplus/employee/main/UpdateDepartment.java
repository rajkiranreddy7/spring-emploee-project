package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class UpdateDepartment {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DepartmentService service=(DepartmentService) ctx.getBean("departmentServiceImpl",DepartmentServiceImpl.class);
		
		Department department=new Department(6,"R&D","Balanagar");

		int rows=service.updateDepartment(department);

		if (rows>0) {
			System.out.println("updated");

		} else {
			System.out.println("not updated");
		}

	}

}
