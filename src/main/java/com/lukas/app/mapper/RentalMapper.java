package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.Rental;
import com.lukas.app.domain.RentalStatus;

@Mapper
public interface RentalMapper {

	Rental findRentalByUserVideoAndStatus(Integer userId, Integer videoId, RentalStatus status);
	List<Rental> findRentalByUserId(Integer userId);
	void insertRental(Integer userId, Integer videoId);
}
