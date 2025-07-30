package com.lukas.app.domain;

import lombok.Data;

@Data
public class Video {

	private Integer id;
	private String title;
	private String description;
	private String genre;
	private String director;
	private String cast; 
	private Integer release;
	private Integer duration;
	private Float rating;
	
}
