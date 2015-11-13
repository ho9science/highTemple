package ht.mongo;

import java.util.HashMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoGridFSException;
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

	public MongoCollection<Document> getCollection(String collection) {
		
		try {
			
		MongoClientURI mongoUri = new MongoClientURI(uri);
		
		client = new MongoClient(mongoUri);
		
		MongoDatabase db = client.getDatabase("hightempler");
		
		MongoCollection<Document> coll = db.getCollection(collection);
		
		return coll;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			
		} finally {
			client.close();
		}
	}
	
	public void createDocument (HashMap<String, Object> map) {
		
		
			
			MongoClientURI mongoUri = new MongoClientURI(uri);
			
			client = new MongoClient(mongoUri);
			
			MongoDatabase db = client.getDatabase("hightempler");
			
			MongoCollection<Document> coll = db.getCollection("temple");
			
			
			Document doc = new Document(map);
			
			coll.insertOne(doc);
			
				
			
		
	}
	
}
