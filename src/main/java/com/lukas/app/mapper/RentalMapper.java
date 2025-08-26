package com.lukas.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.Rental;
import com.lukas.app.domain.RentalStatus;

@Mapper
public interface RentalMapper {

	public Rental findRentalByUserVideoAndStatus(Integer userId, Integer videoId, RentalStatus status);
	
	void insertRental(Integer userId, Integer videoId);
}
