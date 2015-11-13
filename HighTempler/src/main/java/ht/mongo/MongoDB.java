package ht.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

	public MongoDB() {
		
		
		
		
	}

	public void test() {
		
		MongoClientURI uri = new MongoClientURI("mongodb://user22:user22@ds053184.mongolab.com:53184/lol");
		MongoClient client = new MongoClient(uri);
		
		MongoDatabase db = client.getDatabase("lol");
		
		MongoCollection<Document> coll = db.getCollection("temple");
		
		Document op = new Document("name", "이현");
		
		FindIterable<Document> resultList = coll.find(op);
		
		
		
		MongoCursor<Document> cursor = resultList.iterator();
		
		while(cursor.hasNext()) {
			
			System.out.println(cursor.next());
			
		}
	}
	
}
