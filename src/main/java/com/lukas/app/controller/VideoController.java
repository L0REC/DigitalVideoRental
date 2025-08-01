package com.lukas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukas.app.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cataloque")
public class VideoController {

	private final VideoService service;
	
	// 1 ページ当たりの表示人数
	private final int NUM_PER_PAGE = 3;
	
	
	@GetMapping
	public String all(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("videos", service.getVideoListByPage(page, NUM_PER_PAGE));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", service.getTotalPages(NUM_PER_PAGE));
		return "cataloque";
	}
	
	@GetMapping("/search")
	public String search(
			@RequestParam String title,
			@RequestParam(required = false) String titleButton,
			Model model) {
		if(titleButton != null) {
			if(title.isBlank()) {
				return "redirect:/cataloque";
			}
			model.addAttribute("searchedBy", title);
			model.addAttribute("videos", service.searchByTitle(title));
		} 
		return "cataloque";
	}
}






