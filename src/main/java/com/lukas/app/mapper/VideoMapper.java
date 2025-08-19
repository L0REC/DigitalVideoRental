package com.lukas.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lukas.app.domain.Video;

@Mapper
public interface VideoMapper {

	List<Video> selectVideos();
	
	List<Video> selectVideos(String title);
	
	//ページ分割機能用
	List<Video> selectLimited(@Param("offset") int offset,
							  @Param("limit") int limit);
	Long count();
	
	Video selectVideoById(Integer id);
	
	void addVideo(Video video);
	
	void rmVideo(Integer id);
}
