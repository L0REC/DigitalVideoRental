package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.Activity;
import com.lukas.app.domain.User;

public interface ActivityService {

	void logActivity(User user, String type, String details);
	List<Activity> getUserActivities(User user);
}
