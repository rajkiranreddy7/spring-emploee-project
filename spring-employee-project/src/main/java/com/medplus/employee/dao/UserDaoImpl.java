package com.medplus.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.medplus.employee.beans.User;
import com.medplus.employee.utils.DBQueries;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	

	@Override
	public User findUser(String userName) {
		// TODO Auto-generated method stub
		User user=null;
		String query=DBQueries.FINDUSER;
		
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("userName", userName);
		
		
		try {
			
		user=namedParameterJdbcTemplate.queryForObject(query, params, new BeanPropertyRowMapper<User>(User.class));
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return user;

	}

}
