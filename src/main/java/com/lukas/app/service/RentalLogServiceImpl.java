package com.lukas.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.RentalLog;
import com.lukas.app.domain.User;
import com.lukas.app.mapper.RentalLogMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentalLogServiceImpl implements RentalLogService {

	private final RentalLogMapper rentalLogMapper;
	
	@Override
	public void logRental(User user, String activityType, String details) {
		RentalLog log = new RentalLog(user.getId(), activityType, details, LocalDateTime.now());
		rentalLogMapper.insert(log);
	}

	@Override
	public List<RentalLog> getRecentRentals(User user, int limit) {
		return rentalLogMapper.findRecentByUserId(user.getId(), limit);
	}

}
