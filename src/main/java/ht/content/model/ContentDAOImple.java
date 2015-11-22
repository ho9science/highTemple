package ht.content.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ht.mongo.MongoDB;

public class ContentDAOImple implements ContentDAO {
 
	private String apiKey;
	
	public ContentDAOImple() {
		this.apiKey = ht.security.Key.API_KEY;
	}

	public ContentDTO getTempleInfo(int idx) {
		
		String uri = "http://data.gwd.go.kr/apiservice/"+apiKey+"/json/cybergt-travel-temples/"+idx+"/"+idx;
		
		System.out.println("강원API 요청 URi:" + uri);
		
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri).request(MediaType.TEXT_PLAIN_TYPE).get();
		
		int status = response.getStatus();
		Map headers = response.getHeaders();
		String body = response.readEntity(String.class);
		
		System.out.println("API 요청 결과 : "+status);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HashMap<String, Object> result = null; 
		ContentDTO dto = null;
		
		try {
			result = mapper.readValue(body, HashMap.class);
			
			HashMap<String, Object> temples = (HashMap<String, Object>)result.get("cybergt-travel-temples");
			ArrayList<Object> row = (ArrayList<Object>)temples.get("row");
			
			if (row.size()>0) {
				
				HashMap<String, Object> temple = (HashMap<String, Object>)row.get(0);
				
				String govNm = (String) temple.get("GOV_NM");
				String ctgryNm = (String) temple.get("CTGRY_NM");
				double seqNum_d = (Double) temple.get("SEQ_NUM");
				String seqNum = ""+seqNum_d;
				String img = (String) temple.get("IMG");
				String subject = (String) temple.get("SUBJECT");
				String addr = (String) temple.get("NEW_ADDR");
				
				String contact = (String) temple.get("CONTACT");
				String homepage = (String) temple.get("HOMPAGE");
				
				String tourInfm = (String) temple.get("TOUR_INFM");
				tourInfm = tourInfm.replaceFirst("▒", "");
				tourInfm = tourInfm.replaceAll("▒", "\n\n");
				
				String usefulCharge = (String) temple.get("USEFULL_CHARGE");
				if (usefulCharge==null || usefulCharge.equals("")) {
					usefulCharge = "요금 없음";
				} else {
					usefulCharge = usefulCharge.replaceFirst("▒", "");
					usefulCharge = usefulCharge.replaceAll("▒", "\n");
				}
				
				String carparkUsefullGuide = (String) temple.get("CARPARK_USEFULL_GUIDE");
				if (carparkUsefullGuide==null || carparkUsefullGuide.equals("")) {
					carparkUsefullGuide = "없음";
				} else {
					carparkUsefullGuide = carparkUsefullGuide.replaceFirst("▒", "");
					carparkUsefullGuide = carparkUsefullGuide.replaceAll("▒", "\n");
				}
				
				String courseInfm = (String) temple.get("COURSE_INFM");
				if (courseInfm==null || courseInfm.equals("")) {
					courseInfm = "없음";
				} else {
					courseInfm = courseInfm.replaceFirst("▒", "");
					courseInfm = courseInfm.replaceAll("▒", "\n");
				}
				
				String surroundingsAttraction = (String) temple.get("SURROUNDINGS_ATTRACTION");
				
				String usefullGuide = (String) temple.get("USEFULL_GUIDE");
				if (usefullGuide==null || usefullGuide.equals("")) {
					usefullGuide = "없음";
				} else {
					usefullGuide = usefullGuide.replaceFirst("▒", "");
					usefullGuide = usefullGuide.replaceAll("▒", "\n");					
				}
				
				String runDe = (String) temple.get("RUN_DE");
				if (runDe==null || runDe.equals("")) {
					runDe = "상시 이용 가능";
				}
				
				String operTime = (String) temple.get("OPER_TIME");
				String runPd = (String) temple.get("RUN_PD");
				
				String trafficGuide = (String) temple.get("TRAFFIC_GUIDE");
				trafficGuide = trafficGuide.replaceFirst("▒", "");
				trafficGuide = trafficGuide.replaceAll("▒", "\n");
				
				String mountiontrail = (String) temple.get("MOUNTIONTRAIL");
				mountiontrail = mountiontrail.replaceFirst("▒", "");
				mountiontrail = mountiontrail.replaceAll("▒", "\n");
				
				String regDt = (String) temple.get("REG_DT");
				regDt = regDt.substring(0, 10);
				
				String edtDt = (String) temple.get("EDT_DT");
				edtDt = edtDt.substring(0, 10);
				 
				dto = new ContentDTO(idx, govNm, ctgryNm, seqNum, img, subject, addr, contact, homepage, tourInfm, usefulCharge, carparkUsefullGuide, courseInfm, surroundingsAttraction, usefullGuide, runDe, operTime, runPd, trafficGuide, mountiontrail, regDt, edtDt);
				System.out.println(subject+" DTO 생성 완료!");
				 
			}
			
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return dto;
	}

	public ArrayList<ContentDTO> getAllTempleInfo() {
		

		String uri = "http://data.gwd.go.kr/apiservice/"+apiKey+"/json/cybergt-travel-temples/1/41";
		
		System.out.println("강원 api 요청 URi:" + uri);
		
		Client client = ClientBuilder.newClient();
		Response response = client.target(uri).request(MediaType.TEXT_PLAIN_TYPE).get();
		
		int status = response.getStatus();
		Map headers = response.getHeaders();
		String body = response.readEntity(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HashMap<String, Object> result = null; 
		
		ArrayList<ContentDTO> resultList = new ArrayList<ContentDTO>();
		try {
			result = mapper.readValue(body, HashMap.class);
			
			HashMap<String, Object> temples = (HashMap<String, Object>)result.get("cybergt-travel-temples");
			ArrayList<Object> row = (ArrayList<Object>)temples.get("row");
			
			for (int i=0 ; i<row.size() ; i++) {
				HashMap<String, Object> temple = (HashMap<String, Object>)row.get(i);
				
				String govNm = (String) temple.get("GOV_NM");
				String ctgryNm = (String) temple.get("CTGRY_NM");
				double seqNum_d = (Double) temple.get("SEQ_NUM");
				String seqNum = ""+seqNum_d;
				String img = (String) temple.get("IMG");
				String subject = (String) temple.get("SUBJECT");
				String addr = (String) temple.get("NEW_ADDR");
				String contact = (String) temple.get("CONTACT");
				String homepage = (String) temple.get("HOMPAGE");
				String tourInfm = (String) temple.get("TOUR_INFM");
				String usefulCharge = (String) temple.get("USEFULL_CHARGE");
				String carparkUsefullGuide = (String) temple.get("CARPARK_USEFULL_GUIDE");
				String courseInfm = (String) temple.get("COURSE_INFM");
				String surroundingsAttraction = (String) temple.get("SURROUNDINGS_ATTRACTION");
				String usefullGuide = (String) temple.get("USEFULL_GUIDE");
				String runDe = (String) temple.get("RUN_DE");
				String operTime = (String) temple.get("OPER_TIME");
				String runPd = (String) temple.get("RUN_PD");
				String trafficGuide = (String) temple.get("TRAFFIC_GUIDE");
				String mountiontrail = (String) temple.get("MOUNTIONTRAIL");
				String regDt = (String) temple.get("REG_DT");
				String edtDt = (String) temple.get("EDT_DT");
				
				ContentDTO dto = new ContentDTO(i+1, govNm, ctgryNm, seqNum, img, subject, addr, contact, homepage, tourInfm, usefulCharge, carparkUsefullGuide, courseInfm, surroundingsAttraction, usefullGuide, runDe, operTime, runPd, trafficGuide, mountiontrail, regDt, edtDt);
				
				resultList.add(dto);
			}
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	
	public ArrayList<ContentDTO> searchTemple(String query) {
		
		MongoDB db = new MongoDB();
		
		ArrayList<ContentDTO> searchArr = db.searchTemple(query);
				
//		ArrayList<ContentDTO> resultArr = new ArrayList<ContentDTO>();
//		for (int i=0 ; i<searchArr.size() ; i++) {
//			
//			int idx = searchArr.get(i);
//			
//			ContentDTO dto = getTempleInfo(idx);
//			
//			resultArr.add(dto);
//		}
		
		
		
		return searchArr;
	}

}
