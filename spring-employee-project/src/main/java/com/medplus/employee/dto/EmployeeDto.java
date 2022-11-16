package com.medplus.employee.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
	private int empcode;
	private String empname;
	private double salary;
	private String doj;
	private String deptname;
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empcode=" + empcode + ", empname=" + empname + ", salary=" + salary + ", doj=" + doj
				+ ", deptname=" + deptname + "]";
	}

	
}
