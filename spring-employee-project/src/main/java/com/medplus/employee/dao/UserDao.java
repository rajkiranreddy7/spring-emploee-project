package com.medplus.employee.dao;

import com.medplus.employee.beans.User;

public interface UserDao {
	User findUser(String userName);

}
