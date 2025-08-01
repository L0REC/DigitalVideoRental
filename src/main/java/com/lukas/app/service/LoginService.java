package com.lukas.app.service;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.User;
import com.lukas.app.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final UserMapper userMapper;
	
	//check if provided login creds are valid
	public boolean checkIdAndPass(String loginId, String pass) {
		if(loginId == null || pass == null || 
			loginId.trim().isEmpty() || pass.trim().isEmpty()) {
			return false;
		}
		
		//find user with matching username and password
		User user = userMapper.findByUsernameAndPassword(loginId, pass);
		
		//null check
		if(user == null) {
			return false;
		} else {
			return true;
		}
	}

}
