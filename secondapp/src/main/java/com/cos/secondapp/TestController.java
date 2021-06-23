package com.cos.secondapp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8000
@RestController
// 요청하면 다 일로 들어온다
public class TestController {

	//http://localhost:8000/
	@GetMapping("/")
	public String get() {
		return "get"; // MessageConverter -> String -> text/plain
	}

	//http://localhost:8000/
	@PostMapping("/")
	public User post(User data) {
		System.out.println(data.getUsername());
		System.out.println(data.getPassword());
		return data;  // MessageConverter -> User(오브젝트) -> application/json
	}

	//http://localhost:8000/
	@PutMapping("/")
	public String put(@RequestBody User data) { // x-www-form-urlencoded 기본전략 ( 오브젝트로 받으면 자동 파싱 ),  (jsp로 치면 request.getparameter 같은 것임)
		System.out.println(data.getUsername());  // @RequestBody => BufferedReader ( 오브젝트로 받으면 자동 파싱 )
		System.out.println(data.getPassword());
		return "put"; // MessageConverter -> String -> text/plain
	}

	//http://localhost:8000/
	@DeleteMapping("/")
	public String delete() {
		return "delete"; // MessageConverter -> String -> text/plain
	}

		
	
}
