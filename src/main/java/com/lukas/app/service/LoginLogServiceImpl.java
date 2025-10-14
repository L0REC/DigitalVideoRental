package com.lukas.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.LoginLog;
import com.lukas.app.domain.User;
import com.lukas.app.mapper.LoginLogMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {

	private final LoginLogMapper loginLogMapper;
	
	@Override
	public void logLogin(User user, String details) {
		LoginLog log = new LoginLog(user.getId(), details, LocalDateTime.now());
		loginLogMapper.insert(log);

	}

	@Override
	public List<LoginLog> getRecentLogins(User user, int limit) {
		return loginLogMapper.findRecentByUserId(user.getId(), limit);
	}

}
