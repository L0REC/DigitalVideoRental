package com.lukas.app.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private Map<String, String> userTable;
	
	//placeholder until DB integration
	public LoginService() {
		userTable = new HashMap<>();
		userTable.put("user", "pass");
	}
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public boolean checkIdAndPass(String loginId, String pass) {
		String authPass = userTable.get(loginId);
		
		if(authPass == null) {
			logger.warn("不正なログイン ID");
			return false;
		}
		
		if(!pass.equals(authPass)) {
			logger.warn("不正なパスワード");
			return false;
		}
		
		return true;
    }
}
