package com.lukas.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lukas.app.domain.Rental;
import com.lukas.app.domain.RentalStatus;
import com.lukas.app.mapper.RentalMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final RentalMapper rentalMapper;
	
	@Override
	public boolean canUserRentVideo(Integer userId, Integer videoId) {
		Rental rental = rentalMapper.findRentalByUserVideoAndStatus(userId, videoId, RentalStatus.ACTIVE);
		if (rental == null) {
		return true;
		}
		return LocalDateTime.now().isAfter(rental.getExpiresAt());
	}

	@Override
	public List<Rental> getUserRentals(Integer userId) {
		return rentalMapper.findRentalByUserId(userId);
	}
	
	@Override
	public void insertRental(Integer userId, Integer videoId) {
		rentalMapper.insertRental(userId, videoId);
	}

	

}
