package com.medplus.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.beans.Department;
import com.medplus.employee.dao.DepartmentDao;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentDao dao;
	
	
	@Override
	public int addDepartment(Department department) {
		return dao.addDepartment(department);
	}

	@Override
	public String findDeptNameByNo(int deptno) {
		// TODO Auto-generated method stub
		return dao.findDeptNameByNo(deptno);
	}

	@Override
	public int findDeptNoByName(String deptname) {
		// TODO Auto-generated method stub
		
		return dao.findDeptNoByName(deptname);
	}

	@Override
	public int deleteDepartment(int deptno) {
		// TODO Auto-generated method stub
		return dao.deleteDepartment(deptno);
	}

	@Override
	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return dao.updateDepartment(department);
	}

	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		return dao.findAllDepartment();
	}

	@Override
	public Department findDeptByNo(int deptno) {
		// TODO Auto-generated method stub
		return dao.findDeptByNo(deptno);
	}

}
