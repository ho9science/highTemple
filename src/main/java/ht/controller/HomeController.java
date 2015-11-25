package ht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ht.content.model.ContentDAO;
import ht.content.model.ContentDTO;

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

	/**
	 * 첫 접속시 home으로 가게 하는 컨트롤러
	 * @return /home.do (홈 컨트롤러)
	 */

	
	@RequestMapping("/home.do")
	public ModelAndView homes(){
		ContentDTO result = null;
		List<ContentDTO> list = new ArrayList<ContentDTO>();
		ArrayList<String> imgArr = null;
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		int idx[] = new int[10];
		//난수생성
		for(int k =0; k<10; k++){
			idx[k] = (int) (Math.random()*10)%41+1;
			for(int l = 0; l<k; l++){
				if(idx[l]==idx[k]){
					k=k-1;
					break;
				}
			}
		}
		
		for(int k=0; k<10; k++){
			int value= idx[k];
			result = contentDao.getTempleInfo(value);
			
			
			
			String imgs = result.getImg();
			String img[] = imgs.split(".jpg");
			
			imgArr = new ArrayList<String>();
			for(int i=0 ; i<img.length ; i++) {
				//img[i] = img[i]+".jpg";
				
				String img2[] = img[i].split(".JPG");
				for(int j=0 ; j<img2.length ; j++) {
					
					img2[j] = img2[j]+".jpg";
					
					result.setImg(img2[j]);
					break;
				}
				break;
			}
			
			list.add(result);
		}
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("list",list);
		return mav;
	}
}
