package com.lukas.app.service;

import java.util.List;

import com.lukas.app.domain.Video;

public interface VideoService {

	List<Video> searchAll();
	List<Video> searchByTitle(String title);
	
	//ページ分割機能用
	List<Video> getVideoListByPage(int page, int numPerPage);
	int getTotalPages(int numPerPage);
	
	void save(Video video);
}
