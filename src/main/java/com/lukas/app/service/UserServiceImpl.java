package com.lukas.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lukas.app.domain.User;
import com.lukas.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	private final UserMapper userMapper;
	
	@Override
	public void save(User user) {
		
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		
		userMapper.addUser(user);
	}
}
