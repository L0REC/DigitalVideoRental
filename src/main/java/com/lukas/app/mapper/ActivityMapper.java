package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lukas.app.domain.Activity;

@Mapper
public interface ActivityMapper {

	void insertActivity(Activity activity);
	List<Activity>findByUserId(Integer userId);
	List<Activity>findRecentByUserId(@Param("userId") Integer userId,
									 @Param("limit") Integer limit);
}
