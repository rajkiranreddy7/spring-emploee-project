package com.medplus.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.beans.User;
import com.medplus.employee.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;
	@Override
	public User findUser(String userName) {
		// TODO Auto-generated method stub
		return dao.findUser(userName);
	}

}
