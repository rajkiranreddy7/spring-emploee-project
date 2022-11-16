package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dto.EmployeeDto;

public interface EmployeeService {

	int addEmployee(Employee employee,String deptname);
	int deleteEmployee(int empcode);
	int updateEmployee(Employee employee,String deptname);
	List<EmployeeDto> findAll();
	EmployeeDto findByCode(int empcode); 
}
