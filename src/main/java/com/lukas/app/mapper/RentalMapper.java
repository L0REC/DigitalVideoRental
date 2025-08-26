package com.lukas.app.mapper;

import com.lukas.app.domain.Rental;
import com.lukas.app.domain.RentalStatus;

public interface RentalMapper {

	public Rental findRentalsByUserId(Integer id);
	
	public Rental findRentalByUserVideoAndStatus(Integer userId, Integer videoId, RentalStatus status);
	
	void insertRental(Integer userId, Integer videoId);
}
