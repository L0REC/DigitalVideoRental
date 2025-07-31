package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lukas.app.domain.Video;

@Mapper
public interface VideoMapper {

	List<Video> selectVideos();
	
	List<Video> selectVideos(String title);
}
