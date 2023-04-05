package com.example.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring.mvc.dao.UserDao;
import com.example.spring.mvc.model.Login;
import com.example.spring.mvc.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public int register(User user) {
		return userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
