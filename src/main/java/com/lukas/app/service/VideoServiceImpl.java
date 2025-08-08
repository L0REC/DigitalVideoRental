package com.lukas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lukas.app.domain.Video;
import com.lukas.app.mapper.VideoMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
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

	@Override
	public List<Video> getVideoListByPage(int page, int numPerPage) {
		int offset = numPerPage * (page - 1);
		return videoMapper.selectLimited(offset, numPerPage);
	}

	@Override
	public int getTotalPages(int numPerPage) {
		double totalNum =(double) videoMapper.count();
		return (int) Math.ceil(totalNum / numPerPage);
	}
	
	@Override
	public void save(Video video) {
		videoMapper.addVideo(video);
	}
	
	@Override
	public void remove(Integer id) {
		videoMapper.rmVideo(id);
	}

}
