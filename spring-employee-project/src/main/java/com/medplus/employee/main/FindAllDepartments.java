package com.medplus.employee.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class FindAllDepartments {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-jdbc.xml");
		DepartmentService service=(DepartmentService) ctx.getBean("departmentServiceImpl",DepartmentServiceImpl.class);
				
		List<Department> deptlist=service.findAllDepartment();
		deptlist.forEach((dept)->System.out.println(dept));
		
	
	}
}
