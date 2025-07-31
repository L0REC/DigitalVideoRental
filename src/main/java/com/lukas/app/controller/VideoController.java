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
	
	@GetMapping
	public String all(Model model) {
		model.addAttribute("videos", service.searchAll());
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






