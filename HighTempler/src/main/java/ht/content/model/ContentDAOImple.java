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
public class ContentDAOImple implements ContentDAO {

	private String apiKey;
	
	public ContentDAOImple() {
		this.apiKey = Key.API_KEY;
	}

	public Object getTempleInfo(int idx) {
		
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
				
				HashMap<String, String> temple = (HashMap<String, String>)row.get(0);
				
				String govNm = temple.get("GOV_NM");
				String ctgryNm = temple.get("CTGRY_NM");
				String seqNum = temple.get("SEQ_NUM");
				String img = temple.get("IMG");
				String subject = temple.get("SUBJECT");
				String addr = temple.get("NEW_ADDR");
				String contact = temple.get("CONTACT");
				String homepage = temple.get("HOMPAGE");
				String tourInfm = temple.get("TOUR_INFM");
				String usefulCharge = temple.get("USEFULL_CHARGE");
				String carparkUsefullGuide = temple.get("CARPARK_USEFULL_GUIDE");
				String courseInfm = temple.get("COURSE_INFM");
				String surroundingsAttraction = temple.get("SURROUNDINGS_ATTRACTION");
				String usefullGuide = temple.get("USEFULL_GUIDE");
				String runDe = temple.get("RUN_DE");
				String operTime = temple.get("OPER_TIME");
				String runPd = temple.get("RUN_PD");
				String trafficGuide = temple.get("TRAFFIC_GUIDE");
				String mountiontrail = temple.get("MOUNTIONTRAIL");
				String regDt = temple.get("REG_DT");
				String edtDt = temple.get("EDT_DT");
				 
				dto = new ContentDTO(idx, govNm, ctgryNm, seqNum, img, subject, addr, contact, homepage, tourInfm, usefulCharge, carparkUsefullGuide, courseInfm, surroundingsAttraction, usefullGuide, runDe, operTime, runPd, trafficGuide, mountiontrail, regDt, edtDt);
				System.out.println("절 이름 : "+subject+" DTO 생성 완료!");
				 
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
				HashMap<String, String> temple = (HashMap<String, String>)row.get(i);
				String govNm = temple.get("GOV_NM");
				String ctgryNm = temple.get("CTGRY_NM");
				String seqNum = temple.get("SEQ_NUM");
				String img = temple.get("IMG");
				String subject = temple.get("SUBJECT");
				String addr = temple.get("NEW_ADDR");
				String contact = temple.get("CONTACT");
				String homepage = temple.get("HOMPAGE");
				String tourInfm = temple.get("TOUR_INFM");
				String usefulCharge = temple.get("USEFULL_CHARGE");
				String carparkUsefullGuide = temple.get("CARPARK_USEFULL_GUIDE");
				String courseInfm = temple.get("COURSE_INFM");
				String surroundingsAttraction = temple.get("SURROUNDINGS_ATTRACTION");
				String usefullGuide = temple.get("USEFULL_GUIDE");
				String runDe = temple.get("RUN_DE");
				String operTime = temple.get("OPER_TIME");
				String runPd = temple.get("RUN_PD");
				String trafficGuide = temple.get("TRAFFIC_GUIDE");
				String mountiontrail = temple.get("MOUNTIONTRAIL");
				String regDt = temple.get("REG_DT");
				String edtDt = temple.get("EDT_DT");
				
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

}
