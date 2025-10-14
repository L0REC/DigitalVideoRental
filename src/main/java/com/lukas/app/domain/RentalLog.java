package com.lukas.app.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RentalLog {
	private Integer id;
	private Integer userId;
	private String activityType;
	private String details;
	private LocalDateTime createdAt;
	
	public RentalLog(Integer userId, String activityType, String details, LocalDateTime createdAt) {
		this.userId = userId;
		this.activityType = activityType;
		this.details = details;
		this.createdAt = createdAt;
	}
}
