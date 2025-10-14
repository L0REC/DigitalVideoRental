package com.lukas.app.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginLog {
	private Integer id;
	private Integer userId;
	private String details;
	private LocalDateTime createdAt;
	
	public LoginLog(Integer userId, String details, LocalDateTime createdAt) {
		this.userId = userId;
		this.details = details;
		this.createdAt = createdAt;
	}
}
