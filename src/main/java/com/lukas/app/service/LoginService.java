package com.lukas.app.service;

import com.lukas.app.domain.User;

public interface LoginService {

	User checkIdAndPass(String loginId, String pass);
	
}
