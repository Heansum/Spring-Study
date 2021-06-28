package com.korea.dbapp.web;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.korea.dbapp.domain.user.User;
import com.korea.dbapp.domain.user.UserRepository;

@RestController
public class UserController {
	
	private final UserRepository userRepository;

	// 의존성 주입(DI)
	public UserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	// 주소에 동사를 안적음 명사만 적음
	@PostMapping("/user")
	public String save(User user) {
		userRepository.save(user);
		
		return "save ok";
	}
	
	@GetMapping("/user")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	// http://localhost:8000/user/2
	@GetMapping("/user/{id}")
	public User findById(@PathVariable int id) {
		userRepository.findById(id).get();
		return null;
	}
	
	@GetMapping("/user/username/{username}")
	public User findByUsername(@PathVariable String username) {
		return userRepository.mFindByUsername(username);
	}
	
	@PostMapping("/login")
	public String login(String username, String password) {
		
		User user = userRepository.mLogin(username, password);
		
		if(user == null) {
			return  "login fail";
		} else {
			return "login success";
		}
	}
	
	@PostMapping("/loginjson")
	public String login(@RequestBody User user) {
		
		User userEntity = userRepository.mLogin(user.getUsername(), user.getPassword());
		if(user == null) {
			return "login fail";
		} else {
			return "login success";
		}
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteById(@PathVariable int id) {
		userRepository.deleteById(id);
		return "delete ok";
	}
	
}
