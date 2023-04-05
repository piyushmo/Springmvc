package com.example.spring.mvc.service;

import com.example.spring.mvc.model.Login;
import com.example.spring.mvc.model.User;

public interface UserService {

	int register(User user);

	User validateUser(Login login);
}
