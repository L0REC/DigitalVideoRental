package com.lukas.app.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lukas.app.domain.User;

@Mapper
public interface UserMapper {

	User findByUsername(@Param("loginId") String username);
	
	void addUser(User user);
}
