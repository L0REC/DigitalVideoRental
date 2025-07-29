package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.User;

@Mapper
public interface UserMapper {

	List<User> selectUsers();
}
