package ht.imageSearch.model;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ImageSearchDAOImple implements ImageSearchDAO {
	public List<ImageSearchDTO> imageSearch(String keyword){
		try {
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder parser = f.newDocumentBuilder();
			
			String keywordUrl = URLEncoder.encode(keyword,"utf-8");
			String url = "http://openapi.naver.com/search?key=15b87db391969adec2471eb0a6f9cae9&query="+keywordUrl+"&target=image&start=1&display=10";
			Document xml = parser.parse(url);
			
			Element root = xml.getDocumentElement();
			
			NodeList n = root.getElementsByTagName("item");
			
			List<ImageSearchDTO> list = new ArrayList<ImageSearchDTO>();
			
			for(int i = 0; i<n.getLength();i++){
				Element el = (Element)n.item(i);
				String title = el.getElementsByTagName("title").item(0).getTextContent();
				String link = el.getElementsByTagName("link").item(0).getTextContent();
				String thumbnail = el.getElementsByTagName("thumbnail").item(0).getTextContent();
				thumbnail.substring(35);
				ImageSearchDTO dto = new ImageSearchDTO(title, link, thumbnail);
				System.out.println("title:"+title+" link:"+link+" thumbnail:"+thumbnail);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
