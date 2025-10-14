package com.lukas.app.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.LoginLog;

@Mapper
public interface LoginLogMapper {
	void insert(LoginLog loginLog);
	List<LoginLog> findRecentByUserId(Integer userId, int limit);
	void deleteOlderThan(LocalDateTime cutoff);
}
