package ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ht.imageSearch.model.ImageSearchDAO;
import ht.imageSearch.model.ImageSearchDTO;

@Controller
public class ImageSearchController {
	@Autowired
	private ImageSearchDAO imageSearchDao;
	
	public ImageSearchDAO getImageSearchDao() {
		return imageSearchDao;
	}

	public void setImageSearchDao(ImageSearchDAO imageSearchDao) {
		this.imageSearchDao = imageSearchDao;
	}

	@RequestMapping("imageSearch.do")
	public ModelAndView ImageSearch(
			@RequestParam(value="subject")String subject
			){
		List<ImageSearchDTO> result = null;
		System.out.println("컨트롤러 실행"+subject);
		result=imageSearchDao.imageSearch(subject);
		ModelAndView mav = new ModelAndView("image");
		mav.addObject("list",result);

		return mav;
	}
}
