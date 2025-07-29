package com.lukas.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

	private Integer id;

	@NotBlank
	@Size(max = 10)
	private String username;
	private String email;
	private String passwordHash;
	private Role role;
	private LocalDateTime created;

}
