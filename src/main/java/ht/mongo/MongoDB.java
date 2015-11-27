package ht.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
				
				
				ArrayList<String> arr = new ArrayList<String>();
				
				//이미지 가져오기
				String imgs = (String) search.get("IMG");

				String img[] = imgs.split(".jpg");	
				
				for(int i=0 ; i<img.length ; i++) {
					//img[i] = img[i]+".jpg";
					
					String img2[] = img[i].split(".JPG");
					for(int j=0 ; j<img2.length ; j++) {
						
						img2[j] = img2[j]+".jpg";
						
						arr.add(img2[j]);
					}
					
				}
				
				String imgResult = "";
				
				if (idx==24 || idx==25 || idx==11) {
					imgResult = arr.get(1);
					
				} else {
				
					imgResult = arr.get(0);
				}
				
//				String img[] = imgs.split(".jpg");
//				String imgResult = null;
//				String img2[] = img[0].split(".JPG");
//				img2[0] = img2[0]+".jpg";
//		
//				imgResult = img2[0];
				/////////////////
				
				
				
				ContentDTO dto = new ContentDTO(idx, null, null, null, imgResult, subject, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
				
				searchResultIdx.add(dto);
			}
		}
		
		
		return searchResultIdx;
	}
	
	
	public ArrayList<ContentDTO> randomContent() {
		
		//몽고DB 연결, hightempler데이터베이스 내의 temple 컬렉션 가져오기 
		MongoClientURI mongoUri = new MongoClientURI(uri);
		client = new MongoClient(mongoUri);
		MongoDatabase db = client.getDatabase("hightempler");
		MongoCollection<Document> coll = db.getCollection("temple");
				
		

		//1~41 난수 10개 뽑기
		List<Integer> idxs = new ArrayList<Integer>();

		//난수생성
		for(int i=0 ; i<10 ; i++) {
			int random = (int) (Math.random()*41+1);
			
			idxs.add(random);
			
			for(int j=0 ; j<i ; j++) {
				if(idxs.get(j)==random){
					idxs.remove(i);
					i--;
					break;
				}
			}
		}
		
		for(int i=0 ; i<idxs.size() ; i++){
			System.out.println(idxs.get(i));
		}
		
		
		
		//find 명령어를 위한 BSON 생성 {idxs:{$in:[랜덤 난수 10개]}}
		Document regex = new Document("$in", idxs);
		Document doc = new Document("idx", regex);
		

		//find
		FindIterable<Document> result = coll.find(doc);
		
		//Iterator로 반환 (While문으로 돌리기 위해서)
		MongoCursor<Document> cursor = result.iterator();
		
		System.out.println(cursor.hasNext());
		
		ArrayList<ContentDTO> resultArr = new ArrayList<ContentDTO>();
		while (cursor.hasNext()) {
			Document dto = cursor.next();
			int idx = dto.getInteger("idx");
			String subject = dto.getString("SUBJECT");
			String img = dto.getString("IMG");
			
			String imgArr[] = img.split(".jpg");
			
			
			ArrayList<String> imgArrList = new ArrayList<String>();
			for(int i=0 ; i<imgArr.length ; i++) {
				String imgArr2[] = imgArr[i].split(".JPG");
				
				for(int j=0 ; j<imgArr2.length ; j++) {
					
					String splitImg = imgArr2[j]+".jpg";
					
					System.out.println(splitImg);
					imgArrList.add(splitImg);
				}
				
			}
			
			
			if (idx==24 || idx==25 || idx==11) {
				
				img = imgArrList.get(1);
				
			} else {
			
				img = imgArrList.get(0);
			}
			
			System.out.println(idx+subject+img);
			ContentDTO content = new ContentDTO(idx, img, subject);
			
			resultArr.add(content);
			
		}
		
		
		return resultArr;
	}
}
