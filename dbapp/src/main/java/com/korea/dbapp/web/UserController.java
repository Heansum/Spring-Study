package com.korea.dbapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

@Controller
public class UserController {
	
	private final UserRepository userRepository;

	// 의존성 주입(DI)
	public UserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@GetMapping("/auth/joinForm")
	public String joinFrom(User user) {
		return "/auth/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginFrom(User user) {
		return "auth/loginForm";
	}
	
	@PostMapping("/auth/join")
	public String join(User user) {
		userRepository.save(user);
		return "redirect:/auth/loginForm";
	}
	
	
	
	
	
	
}
