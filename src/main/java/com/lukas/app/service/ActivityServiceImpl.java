package com.lukas.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.Activity;
import com.lukas.app.domain.User;
import com.lukas.app.mapper.ActivityMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

	private final ActivityMapper activityMapper;

	@Override
	public void logActivity(User user, String type, String details) {
		Activity activity = new Activity(user.getId(), type, details, LocalDateTime.now());
		activityMapper.insertActivity(activity);
	}

	@Override
	@Deprecated
	public List<Activity> getUserActivities(User user) {
		return activityMapper.findByUserId(user.getId());
	}

	@Override
	public List<Activity> getUserRecentActivities(User user, int limit) {
		return activityMapper.findRecentByUserId(user.getId(), limit);
	}

}
