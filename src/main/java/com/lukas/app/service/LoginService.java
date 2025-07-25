package com.lukas.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private Map<String, String> userTable;
	
	//placeholder until DB integration
	public LoginService() {
		userTable = new HashMap<>();
		userTable.put("user", "pass");
	}
	
	public boolean checkIdAndPass(String loginId, String pass) {
		String authPass = userTable.get(loginId);
		
		if(authPass == null) {
			System.out.println("不正なログイン ID");
			return false;
		}
		
		if(!pass.equals(authPass)) {
			return false;
		}
		
		return true;
    }
}
