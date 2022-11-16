package com.medplus.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medplus.employee.beans.Department;
import com.medplus.employee.utils.DBQueries;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public int addDepartment(Department department) {
		int  rows=0;
		
		String query=DBQueries.ADDDEPT;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptno", department.getDeptno())
			  .addValue("deptname", department.getDeptname())
			  .addValue("location", department.getLocation());
		
		try {
			
			rows=namedParameterJdbcTemplate.update(query, params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		
		
		return rows;
	}

	@Override
	public String findDeptNameByNo(int deptno) {

		String  deptname=null;
		String query=DBQueries.FINDDEPTNAMEBYNO;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptno", deptno);
		
		try {
			 deptname = namedParameterJdbcTemplate.queryForObject(query, params, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		return deptname;
	}

	@Override
	public int findDeptNoByName(String deptname) {
		int deptno=0;
		String query=DBQueries.FINDDEPTNOBYNAME;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptname", deptname);
		
		try {
			 deptno = namedParameterJdbcTemplate.queryForObject(query, params, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		return deptno;

	}

	@Override
	public int deleteDepartment(int deptno) {
		
		int  rows=0;
		
		String query=DBQueries.DELETEDEPT;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptno", deptno);
		try {
			
			rows=namedParameterJdbcTemplate.update(query, params);
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		
		
		return rows;
	}

	@Override
	public int updateDepartment(Department department) {
		int  rows=0;
		
		String query=DBQueries.UPDATEDEPT;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptno", department.getDeptno())
			  .addValue("deptname", department.getDeptname())
			  .addValue("location", department.getLocation());
		
		try {
			
			rows=namedParameterJdbcTemplate.update(query, params);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		
		
		return rows;

	}

	@Override
	public List<Department> findAllDepartment() {
		List<Department> deptList=new ArrayList<>();

		
		String query=DBQueries.FINDALLDEPT;
		
		
		try {
			
			
			deptList=namedParameterJdbcTemplate.query(query, new
					ResultSetExtractor<List<Department>>() {

						@Override
						public List<Department> extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<Department> deptList=new ArrayList<Department>();
							
							while(rs.next()) { 
								Department dept=new Department();

								dept.setDeptno(rs.getInt(1)); 
								dept.setDeptname(rs.getString(2));
								dept.setLocation(rs.getString(3)); 
								deptList.add(dept);
							}


							return deptList;
						}
				
				
				
			});
			
			
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return deptList;
	}

	@Override
	public Department findDeptByNo(int deptno) {
		Department department=null;
		String query=DBQueries.FINDDEPTBYNO;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("deptno", deptno);
		
		try {
			 department  = namedParameterJdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<Department>(Department.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		
		return department;

	}

}
