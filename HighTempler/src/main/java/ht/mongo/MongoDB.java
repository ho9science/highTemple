package ht.mongo;

import com.mongodb.BasicDBObject; 
import com.mongodb.BulkWriteOperation; 
import com.mongodb.BulkWriteResult; 
import com.mongodb.Cursor; 
import com.mongodb.DB; 
import com.mongodb.DBCollection; 
import com.mongodb.DBCursor; 
import com.mongodb.DBObject; 
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ParallelScanOptions; 
import com.mongodb.ServerAddress; 

public class MongoDB {

	public MongoDB() {
		
	}
	
	public Object test() {
		
		MongoClientURI mc = new MongoClientURI("mongodb://SystemUser22:user1122@ds053184.mongolab.com:53184/lol");
		
		String str = mc.getDatabase();
		
		System.out.println(str);
		
		return null;
		
	}

}
