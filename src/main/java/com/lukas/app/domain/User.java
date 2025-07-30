package com.lukas.app.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer id;
	private String username;
	private String email;
	private String passwordHash;
	private Role role;
	private LocalDateTime created;
	private LocalDateTime lastLogin;

}
