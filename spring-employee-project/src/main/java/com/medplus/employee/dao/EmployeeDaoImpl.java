package com.medplus.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.utils.DBQueries;



@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	

	@Override
	public int addEmployee(Employee employee) {

		String query=DBQueries.ADDEMP;//"insert into employee values(:empcode,:empname,:salary,:doj,:deptno)";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("empcode", employee.getEmpcode())
			  .addValue("empname", employee.getEmpname())
			  .addValue("salary", employee.getSalary())
			  .addValue("doj", employee.getDoj())
			  .addValue("deptno", employee.getDeptno());
	
		int rows=0;
		try {
			rows=namedParameterJdbcTemplate.update(query, params);

		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		
		return rows;

	}

	@Override
	public int deleteEmployee(int empcode) {

		String query=DBQueries.DELETEEMP;
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("empcode", empcode);
	
		int rows=0;
		rows=namedParameterJdbcTemplate.update(query, params);

		try {
		
		} catch (DataAccessException e) {
			// TODO: handle exception
		}		
		return rows;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String query=DBQueries.UPDATEEMP;
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("empcode", employee.getEmpcode())
			  .addValue("empname", employee.getEmpname())
			  .addValue("salary", employee.getSalary())
			  .addValue("doj", employee.getDoj())
			  .addValue("deptno", employee.getDeptno());
	
		int rows=0;

		try {
			rows=namedParameterJdbcTemplate.update(query, params);

		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return rows;

	}

	@Override
	public List<Employee> findAll() {
			
		String query=DBQueries.FINDALL;
		List<Employee> empList=new ArrayList<>();
 
		try {
			empList= namedParameterJdbcTemplate.query(query,new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Employee emp=new Employee();
					
					emp.setEmpcode(rs.getInt(1));
					emp.setEmpname(rs.getString(2));
					emp.setSalary(rs.getDouble(3));
					emp.setDoj(rs.getString(4));
					emp.setDeptno(rs.getInt(5));
					
					return emp;
				}
			});
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		return empList;
	}

	@Override
	public Employee findByCode(int empcode) {

		String query= DBQueries.FINDBYCODE;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("empcode", empcode);
		
		Employee emp=null;
		
		
		try {	 
			emp = namedParameterJdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Employee>(Employee.class));
				 
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		 
		return emp;
	}

}
