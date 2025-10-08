package com.lukas.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lukas.app.domain.Activity;
import com.lukas.app.domain.Rental;
import com.lukas.app.domain.User;
import com.lukas.app.domain.Video;
import com.lukas.app.service.ActivityService;
import com.lukas.app.service.RentalService;
import com.lukas.app.service.UserService;
import com.lukas.app.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

	private final UserService service;
	private final ActivityService activityService;
	private final RentalService rentalService;
	private final VideoService videoService;

	@GetMapping("/dashboard")
	public String showDashboard(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		List<Activity> activities = activityService.getUserRecentActivities(user, 10);
		List<Rental> userRentals = rentalService.getUserRentals(user.getId());
		
		List<Video> rentalVideos = new ArrayList<>();
		for(Rental rental : userRentals) {
			rentalVideos.add(videoService.getVideoById(rental.getVideoId()));
		}
				
				
		Map<Integer, String> checkThumbnailMap = videoService.createSafeThumbnailMap(rentalVideos);
		
		model.addAttribute("activities", activities);
		model.addAttribute("userRentals", userRentals);
		model.addAttribute("checkThumbnailMap", checkThumbnailMap);
		
		return "dashboard";
	}

	@GetMapping("/registration")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping("/registration")
	public String register(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			return "registration";
		}

		service.save(user);
		return "redirect:/login";
	}
}
