package com.lukas.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
	private final ResourceLoader resourceLoader;
	
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
	public Video getVideoById(Integer id) {
		return videoMapper.selectVideoById(id);
	} 
	
	
	@Override
	public void save(Video video) {
		videoMapper.addVideo(video);
	}
	
	@Override
	public void remove(Integer id) {
		videoMapper.rmVideo(id);
	}

	@Override
	public boolean checkFileExists(String databasePath) {
		Resource resource = resourceLoader.getResource("classpath:static" + databasePath);
		return resource.exists();
	}

	@Override
	public Map<Integer, String> createSafeThumbnailMap(List<Video> videos) {
		Map<Integer, String> checkThumbnailMap = new HashMap<>();
		for(Video video : videos) {
			String checkThumbnail = checkFileExists(video.getThumbnailUrl()) ? 
					video.getThumbnailUrl() : "/thumbs/default.jpg";
			checkThumbnailMap.put(video.getId(), checkThumbnail);
		}
		return checkThumbnailMap;
	}

	
}
