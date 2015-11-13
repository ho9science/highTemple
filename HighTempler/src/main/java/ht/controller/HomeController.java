package ht.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ht.content.model.ContentDAO;
import ht.content.model.ContentDTO;
import ht.mongo.MongoDB;

@Controller
public class HomeController {

	@Autowired
	private ContentDAO contentDao;
	
	public ContentDAO getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDAO contentDao) {
		this.contentDao = contentDao;
	}
	

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/test.do")
	public ModelAndView test() {
		
		MongoDB db = new MongoDB();
		db.searchTemple("금강");
		
		ModelAndView mav = new ModelAndView("jsonView");
		return mav;
	}
}
