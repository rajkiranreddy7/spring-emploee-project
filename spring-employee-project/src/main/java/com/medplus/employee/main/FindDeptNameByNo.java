package com.medplus.employee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class FindDeptNameByNo {

	public static void main(String[] args) {

		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DepartmentService service=(DepartmentService) ctx.getBean("departmentServiceImpl",DepartmentServiceImpl.class);
		
		String deptname=service.findDeptNameByNo(5);

		if (deptname!=null) {
			System.out.println("Found: "+deptname);

		} else {
			System.out.println("Not Found");
		}

	}

}
