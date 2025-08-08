package com.lukas.app.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Activity {

	private Integer id;
	private Integer userId;
	private String type;
	private String details;
	private LocalDateTime createdAt;

	public Activity(Integer userId, String type, String details, LocalDateTime createdAt) {
		this.userId = userId;
		this.type = type;
		this.details = details;
		this.createdAt = createdAt;
	}

}
