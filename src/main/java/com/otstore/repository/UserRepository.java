package com.otstore.repository;

import com.otstore.domain.User;

public interface UserRepository {

	int insert(User user);
	
	Object selectOne(User user);
}
