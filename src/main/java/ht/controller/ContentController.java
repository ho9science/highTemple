package ht.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ht.content.model.ContentDAO;
import ht.content.model.ContentDTO;

@Controller
public class ContentController {

	@Autowired
	private ContentDAO contentDao;
		
	public ContentDAO getContentDao() {
		return contentDao;
	}
	public void setContentDao(ContentDAO contentDao) {
		this.contentDao = contentDao;
	}

	
	public ContentController() {
	}

	@RequestMapping("/content.do")
	public ModelAndView content(
			@RequestParam("idx")int idx) {
		
		ContentDTO result = contentDao.getTempleInfo(idx);
		
		ModelAndView mav = new ModelAndView("content");
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping("/search.do")
	public ModelAndView search(
			@RequestParam("query")String query) {
		
		ArrayList<ContentDTO> result = contentDao.searchTemple(query);
		
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping("/listall.do")
	public ModelAndView templeListALl() {
		
		ArrayList<ContentDTO> result = contentDao.getAllTempleInfo();
		
		
		ModelAndView mav = new ModelAndView("allList");
		mav.addObject("result", result);
		return mav;
	}
	
}
