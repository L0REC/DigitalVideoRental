package com.lukas.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.lukas.app.domain.User;
import com.lukas.app.mapper.UserMapper;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final UserMapper userMapper;
	
	
	public User checkIdAndPass(String loginId, String pass) {
		if(StringUtils.isBlank(loginId) || StringUtils.isBlank(pass)) {
			return null;
		}
		
		User user = userMapper.findByUsername(loginId);
		if(user != null && BCrypt.checkpw(pass, user.getPassword())) {
			return user;
		}
		return null;
	}
}
