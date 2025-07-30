package com.lukas.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lukas.app.domain.User;

@Mapper
public interface UserMapper {

	User findByUsernameAndPassword(@Param("loginId") String username,
			@Param("pass") String pass);
}
