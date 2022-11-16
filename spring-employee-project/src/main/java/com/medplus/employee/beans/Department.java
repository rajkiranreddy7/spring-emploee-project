package com.medplus.employee.beans;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private int deptno;
	private String deptname;
	private String location;
	

	public Department() {
		// TODO Auto-generated constructor stub
	}

	
	public Department(int deptno, String deptname, String location) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.location = location;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getDeptname() {
		return deptname;
	}


	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", location=" + location + "]";
	}

	

}
