package ht.content.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import ht.mongo.MongoDB;
public class ContentDAOImple implements ContentDAO {
 
	@Autowired
	private MongoDB mongoDB;
	
	public MongoDB getMongoDB() {
		return mongoDB;
	}

	public void setMongoDB(MongoDB mongoDB) {
		this.mongoDB = mongoDB;
	}

	
	private String apiKey;
	
	public ContentDAOImple() {
		this.apiKey = ht.security.Key.API_KEY;
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

}
