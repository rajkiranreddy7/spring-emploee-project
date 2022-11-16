package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;

public interface DepartmentService {
	
	int addDepartment(Department department);
	int deleteDepartment(int deptno);
	int updateDepartment(Department department);
	
	List<Department> findAllDepartment();
	Department findDeptByNo(int deptno);
	String findDeptNameByNo(int deptno);
	int findDeptNoByName(String deptname);
	
}
