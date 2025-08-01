package com.lukas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lukas.app.domain.Video;
import com.lukas.app.repository.VideoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

	private final VideoMapper videoMapper;
	
	@Override
	public List<Video> searchAll() {
		String title = "";
		return videoMapper.selectVideos(title);
	}

	@Override
	public List<Video> searchByTitle(String title) {
		return videoMapper.selectVideos(title);
	}

}
