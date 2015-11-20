package ht.mongo;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import ht.content.model.ContentDTO;

public class MongoDB {

	private String uri;
	private MongoClient client;
	
	public MongoDB() {
		this.uri = ht.security.Key.MONGODB_URI;
		
		
	}
	
	/**
	 * MongoDB를 다 사용하고 나면 closeDB를 사용해서 닫아줍니다.
	 * Spring의 경우 정상 작동 안 할수도있음!
	 */
	public void closeDB(){
		client.close();
	}
	
	/**
	 * 컬렉션 이름을 넣어주면 해당 컬렉션을 반환함
	 * @param collection
	 * @return
	 */
	public MongoCollection<Document> getCollection(String collection) {
		
			
		MongoClientURI mongoUri = new MongoClientURI(uri);
		
		client = new MongoClient(mongoUri);
		
		MongoDatabase db = client.getDatabase("hightempler");
		
		MongoCollection<Document> coll = db.getCollection(collection);
		
		return coll;
			
	}
	
	/**
	 * 맵 객체를 받아서 몽고디비에 값(도큐멘트)를 저장하는 메서드
	 * 
	 * 추후 쓰일일이없음
	 * @param map
	 */
	public void createDocument (HashMap<String, Object> map) {
		
		
			
		MongoClientURI mongoUri = new MongoClientURI(uri);
		
		client = new MongoClient(mongoUri);
		
		MongoDatabase db = client.getDatabase("hightempler");
		
		MongoCollection<Document> coll = db.getCollection("temple");
		
		
		Document doc = new Document(map);
		
		coll.insertOne(doc);
			
				
			
		
	}
	
	/**
	 * 사찰 검색 기능
	 * 
	 * 검색어를 입력하면, 검색어에 해당하는 사찰의 idx들을 ArrayList로 반환함
	 * @param query 검색어
	 * @return 검색 결과 사찰들의 idx
	 */
	public ArrayList<ContentDTO> searchTemple (String query) {
		
		//몽고DB 연결, hightempler데이터베이스 내의 temple 컬렉션 가져오기 
		MongoClientURI mongoUri = new MongoClientURI(uri);
		client = new MongoClient(mongoUri);
		MongoDatabase db = client.getDatabase("hightempler");
		MongoCollection<Document> coll = db.getCollection("temple");
		
		
		//검색어 정확도를 높이기 위한 정규 표현식
		StringBuffer keyword = new StringBuffer(".*");
		for (int i=0 ; i<query.length() ; i++) {
			keyword.append(query.substring(i, i+1));
			keyword.append(".*");
		}
		System.out.println("검색어 : "+query);
		System.out.println("치환 : "+keyword);
		
		
		//find 명령어를 위한 BSON 생성 {SUBJECT:{$regex:검색어}}
		Document regex = new Document("$regex", keyword.toString());
		Document doc = new Document("SUBJECT", regex);
		
		
		//검색 (위의 BSON 객체를 이용함)
		FindIterable<Document> result = coll.find(doc);
		
		
		//Iterator로 반환 (While문으로 돌리기 위해서)
		MongoCursor<Document> cursor = result.iterator();
		
		
		//Iterator를 이용하여 값이 있는지 확인하고 while문으로 검색 결과의 idx들을 가져옴
		ArrayList<ContentDTO> searchResultIdx = new ArrayList<ContentDTO>();
		if (!cursor.hasNext()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			while (cursor.hasNext()) {
				Document search = cursor.next();
				int idx = (Integer) search.get("idx");
				String subject = (String)search.get("SUBJECT");
				System.out.println(subject);
				//이미지 가져오기
				String imgs = (String) search.get("IMG");
				String img[] = imgs.split(".jpg");
				String imgResult = null;
				String img2[] = img[0].split(".JPG");
				img2[0] = img2[0]+".jpg";
				imgResult = img2[0];
				/////////////////
				
				
				
				ContentDTO dto = new ContentDTO(idx, null, null, null, imgResult, subject, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				
				searchResultIdx.add(dto);
			}
		}
		
		
		return searchResultIdx;
	}
	
}
