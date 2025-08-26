package com.lukas.app.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukas.app.service.RentalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

	private final RentalService rentalService;
	
	@PostMapping
	public String createRental(@RequestParam Integer videoId, 
											 HttpSession session,
											 Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null) {
			model.addAttribute("error", "ユーザーはログインしてません");
			return "redirect:/login";
		}
		
		rentalService.insertRental(userId, videoId);
		
		model.addAttribute("success", "レンタル済みです");
		return "redirect:/videos/" + videoId;
	}
}
