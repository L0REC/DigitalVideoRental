package com.lukas.app.service;

public interface RentalService {

	boolean canUserRentVideo(Integer userId, Integer videoId);
	
	void insertRental(Integer userId, Integer videoId);
}
