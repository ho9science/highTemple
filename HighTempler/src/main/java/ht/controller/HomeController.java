package ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ht.mongo.MongoDB;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/test.do")
	public ModelAndView test() {
		
		MongoDB md = new MongoDB();
		md.test();
		
		ModelAndView mav = new ModelAndView("jsonView");
		return mav;
	}
}
