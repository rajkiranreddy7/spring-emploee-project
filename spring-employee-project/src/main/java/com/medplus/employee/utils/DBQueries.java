package com.medplus.employee.utils;

public class DBQueries {
	//Employee
	public static final String ADDEMP="insert into employee values(:empcode,:empname,:salary,:doj,:deptno)";
	public static final String DELETEEMP="delete from employee where empcode=:empcode";	
	public static final String UPDATEEMP="update employee set empname=:empname,salary=:salary,doj=:doj,deptno=:deptno where empcode=:empcode";	
	public static final String FINDALL="select * from employee";
	public static final String FINDBYCODE="select * from employee where empcode=:empcode";

	//Department
	public static final String ADDDEPT="insert into department values(:deptno,:deptname,:location)";
	public static final String UPDATEDEPT="update department set deptname=:deptname,location=:location where deptno=:deptno";
	public static final String DELETEDEPT="delete from department where deptno=:deptno";	
	
	public static final String FINDDEPTNOBYNAME="select deptno from department where deptname=:deptname";
	public static final String FINDDEPTNAMEBYNO="select deptname from department where deptno=:deptno";
	public static final String FINDDEPTBYNO="select * from department where deptno=:deptno";
	public static final String FINDALLDEPT="select * from department";

	//Users
	public static final String FINDUSER="select * from user where username=:username";
	
	
}
