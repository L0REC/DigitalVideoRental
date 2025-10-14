package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.RentalLog;
import com.lukas.app.domain.User;

public interface RentalLogService {
	void logRental(User user, String activityType, String details);
	List<RentalLog> getRecentRentals(User user, int limit);
}
