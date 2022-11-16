package com.medplus.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dto.EmployeeDto;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Autowired
	DepartmentService service;
	
	//EmployeeDao dao=new EmployeeDaoImpl();
	
	
	@Override
	public int addEmployee(Employee employee,String deptName) {
		
		int deptNo= service.findDeptNoByName(deptName);
		
		employee.setDeptno(deptNo);	
		return dao.addEmployee(employee);
	}

	@Override
	public int deleteEmployee(int empcode) {
		return dao.deleteEmployee(empcode);
	}

	@Override
	public int updateEmployee(Employee employee,String deptName) {
		int deptNo= service.findDeptNoByName(deptName);
		employee.setDeptno(deptNo);
		
		return dao.updateEmployee(employee);
	}

	@Override
	public List<EmployeeDto> findAll() {
		
		List<Employee> empList=dao.findAll();
		List<EmployeeDto>  empDtoList=new ArrayList<EmployeeDto>();
	
		for(Employee  emp:empList)
		{
			String deptName= service.findDeptNameByNo(emp.getDeptno());
			EmployeeDto empDto=new EmployeeDto();

			empDto.setEmpcode(emp.getEmpcode());
			empDto.setEmpname(emp.getEmpname());
			empDto.setSalary(emp.getSalary());
			empDto.setDoj(emp.getDoj());
			empDto.setDeptname(deptName);
			empDtoList.add(empDto);
		}
					
		return empDtoList;
	}

	@Override
	public EmployeeDto findByCode(int empcode) {
		Employee  emp= dao.findByCode(empcode);
		
		if(emp==null)
			return null;
		
		EmployeeDto empdto=new EmployeeDto();
		
		String deptName= service.findDeptNameByNo(emp.getDeptno());
		
		
		empdto.setEmpcode(emp.getEmpcode());
		empdto.setEmpname(emp.getEmpname());
		empdto.setSalary(emp.getSalary());
		empdto.setDoj(emp.getDoj());
		empdto.setDeptname(deptName);
		
		
		return empdto;
	}

}
