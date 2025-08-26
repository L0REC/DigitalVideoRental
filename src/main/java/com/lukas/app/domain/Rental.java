package com.lukas.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Rental {

	private Integer id;
	
	private Integer userId;
	
	private Integer videoId;
	
	private LocalDateTime rentalAt;
	
	private LocalDateTime expiresAt;
	
	private RentalStatus status;
	
}
