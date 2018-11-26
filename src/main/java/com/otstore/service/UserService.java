package com.otstore.service;

import com.otstore.domain.User;

public interface UserService {

	int insertUser(User user);
	Object login(User user);
}
