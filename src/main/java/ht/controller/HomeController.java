package ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 첫 접속시 home으로 가게 하는 컨트롤러
	 * @return /home.do (홈 컨트롤러)
	 */
	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}

}
