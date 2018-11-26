package com.otstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otstore.domain.User;
import com.otstore.repository.UserRepository;
import com.otstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;

	@Override
	public int insertUser(User user) {
		return userRepository.insert(user);
	}

	@Override
	public Object login(User user) {
		System.out.println("+=+=+ service start +=+=+");
		return userRepository.selectOne(user);
	}
}
