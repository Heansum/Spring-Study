package com.cos.secondapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 컴포넌트 스캔시에 @RestController, @Controller를 IoC에 등록한다.
// 디스패쳐는 위 두개를 관리한다.
// 차이점은 @RestController는 데이터를 응답, @Controller는 View를 응답한다.

@Controller
public class ViewController {

	@GetMapping("/home")
	public String home() {
		System.out.println("나 호출됐냐?");
		return "home"; // ViewResolver 가 발동 => src/main/webapp/WEB-INF/views/home.jsp => prefix 와 suffix 위치 중요
	}
	
}
