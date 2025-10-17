package com.lukas.app.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukas.app.domain.User;
import com.lukas.app.service.ActivityService;
import com.lukas.app.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {

	private final LoginService service;
	private final ActivityService activityService;
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String loginId,
			@RequestParam String pass,
			HttpSession session,
			Model model) {
		User user = service.checkIdAndPass(loginId, pass);
		
		if (user == null) {
			model.addAttribute("errorMsg", "ログイン情報が不正です");
			return "login";
		}

		session.setAttribute("user", user);
		activityService.logActivity(user, "LOGIN", "ユーザーはログインしました");
		return "redirect:/dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
