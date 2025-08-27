package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.Rental;

public interface RentalService {

	boolean canUserRentVideo(Integer userId, Integer videoId);
	
	List<Rental> getUserRentals(Integer userId);
	
	void insertRental(Integer userId, Integer videoId);
}
