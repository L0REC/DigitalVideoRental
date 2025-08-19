package com.lukas.app.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lukas.app.domain.Video;
import com.lukas.app.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class VideoController {

	private final VideoService service;
	
	// 1 ページ当たりの表示人数
	private final int NUM_PER_PAGE = 9;
	
	
	@GetMapping
	public String all(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("videos", service.getVideoListByPage(page, NUM_PER_PAGE));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", service.getTotalPages(NUM_PER_PAGE));
		return "catalog";
	}
	
	@GetMapping("/search")
	public String search(
			@RequestParam String title,
			@RequestParam(required = false) String titleButton,
			Model model) {
		if(titleButton != null) {
			if(title.isBlank()) {
				return "redirect:/catalog";
			}
			model.addAttribute("searchedBy", title);
			model.addAttribute("videos", service.searchByTitle(title));
		} 
		return "catalog";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Video video = new Video();
		model.addAttribute("video", video);
		return "add_video";
	}
	
	@GetMapping("/details/{id}")
	public String showDetails(@PathVariable Integer id,
							   RedirectAttributes ra,
							   Model model) {
		Video video = service.getVideoById(id);
		
		if(video==null) {
			ra.addFlashAttribute("statusMessage", "動画を見つけませでした");
			return "redirect:/catalog";
		}
		
		model.addAttribute("video", video);
		return "details";
	}
	
	@PostMapping("/add")
	public String add(@Valid Video video, Errors errors) {
		if (errors.hasErrors()) {
			return "add_video";
		}
		
		service.save(video);
		return "redirect:/catalog";
	}
	
	@GetMapping("/remove/{id}")
	public String delete(@PathVariable Integer id,
						 RedirectAttributes rd) {
		service.remove(id);
		rd.addFlashAttribute("statusMessage", "動画は、削除済");
		return "redirect:/catalog";
		
	}
}






