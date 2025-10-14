package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.RentalLog;

@Mapper
public interface RentalLogMapper {
	void insert(RentalLog rentalLog);
	List<RentalLog> findRecentByUserId(Integer userId, int limit);
}
