package com.korea.newapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	final HttpServletRequest request;
	final HttpSession session;
	
	// DI = Dependency Injection(의존성 주입)
	
	public HomeController(HttpServletRequest request, HttpSession session) {
		this.request = request;
		this.session = session;
	}
	
	// request 2
	@GetMapping("/home")
	public String home(Model model) {
		if(session != null) {
			System.out.println("세션 널 아니에요!");
		}
		
		model.addAttribute("data","홍길동");
		System.out.println(request.getMethod());
		//Dispatcher dis ...
		//request 2
//		String rData = "request 데이터";
//		String sData = "session 데이터";
//		request.setAttribute("data", rData);
//		session.setAttribute("data", sData);
		
		return "home";
	}
	
	
	//request 1
	@GetMapping("/post")
	public String post() {
		//sendredirect..
		//request 2 -30X
		return "redirect:/home";
	}
}
