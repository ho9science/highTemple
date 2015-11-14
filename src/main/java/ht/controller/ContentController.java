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

	/**
	 * 사찰 검색 번호를 받아서
	 * 사찰 상세정보를 보여주는 페이지로 이동
	 * @param idx 사찰 번호
	 * @return 사찰 상세정보
	 */
	@RequestMapping("/content.do")
	public ModelAndView content(
			@RequestParam("idx")int idx) {
		
		ContentDTO result = contentDao.getTempleInfo(idx);
		
		ModelAndView mav = new ModelAndView("content");
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 검색어를 받아서
	 * 검색 결과 목록을 보여주는 페이지로 이동
	 * @param query 검색어
	 * @return 검색 결과 
	 */
	@RequestMapping("/search.do")
	public ModelAndView search(
			@RequestParam("query")String query) {
		
		ArrayList<ContentDTO> result = contentDao.searchTemple(query);
		
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 모든 사찰 정보를 보여주는 페이지로 이동
	 * @return 모든 사찰 정보 리스트
	 */
	@RequestMapping("/listall.do")
	public ModelAndView templeListALl() {
		
		ArrayList<ContentDTO> result = contentDao.getAllTempleInfo();
		
		
		ModelAndView mav = new ModelAndView("allList");
		mav.addObject("result", result);
		return mav;
	}
	
}
