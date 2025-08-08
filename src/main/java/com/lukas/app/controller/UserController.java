package com.lukas.app.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lukas.app.domain.Activity;
import com.lukas.app.domain.User;
import com.lukas.app.service.ActivityService;
import com.lukas.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

	private final UserService service;
	private final ActivityService activityService;

	@GetMapping("/dashboard")
	public String showDashboard(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Activity> activities = activityService.getUserRecentActivities(user, 10);
		model.addAttribute("activities", activities);
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
