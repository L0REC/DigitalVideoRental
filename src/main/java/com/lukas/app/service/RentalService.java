package com.lukas.app.service;

public interface RentalService {

	boolean isRentalExpired(Integer userId, Integer videoId);
	
	boolean isRentalPossible(Integer userId, Integer videoId);
	
	void insertRental(Integer userId, Integer videoId);
}
