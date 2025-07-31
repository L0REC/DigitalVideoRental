package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.Video;

public interface VideoService {

	List<Video> searchAll();
	List<Video> searchByTitle(String title);
	
}
