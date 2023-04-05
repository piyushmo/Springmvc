package com.example.spring.mvc.dao;

import com.example.spring.mvc.model.Login;
import com.example.spring.mvc.model.User;

public interface UserDao {

	int register(User user);

	User validateUser(Login login);
}
