package ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ht.mongo.MongoDB;

@Controller
public class ContentController {

	public ContentController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("test.do")
	public ModelAndView test() {
		
		MongoDB md = new MongoDB();
		
		String result = (String)md.test();
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("result", result);
		return mav;
	}
}
