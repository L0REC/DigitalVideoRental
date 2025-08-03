package com.lukas.app.service;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.User;
import com.lukas.app.repository.UserMapper;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final UserMapper userMapper;
	
	public boolean checkIdAndPass(String loginId, String pass) {
		if(StringUtils.isBlank(loginId) || StringUtils.isBlank(pass)) {
			return false;
		}
		
		User user = userMapper.findByUsernameAndPassword(loginId, pass);
		
		return user != null;
		
	}

}
