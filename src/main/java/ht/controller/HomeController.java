package ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}

}
