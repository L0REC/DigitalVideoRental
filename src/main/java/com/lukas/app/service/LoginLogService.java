package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.LoginLog;
import com.lukas.app.domain.User;

public interface LoginLogService {
	void logLogin(User user, String details);
	List<LoginLog> getRecentLogins(User user, int limit);
}
