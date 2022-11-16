package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class FindDeptNoByName {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DepartmentService service=(DepartmentService) ctx.getBean("departmentServiceImpl",DepartmentServiceImpl.class);
		
		int deptno=service.findDeptNoByName("Diagnostics");

		if (deptno!=0) {
			System.out.println("Found: "+deptno);

		} else {
			System.out.println("Not Found");
		}


	}

}
