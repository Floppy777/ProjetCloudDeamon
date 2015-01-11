package esipe.cloud.mongo;

import java.util.Arrays;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import esipe.cloud.twitter.Tweet;

public class MongoDBClient {

	private final MongoClient mongoClient;
	private final DB base ;
	private final DBCollection collection;

	public MongoDBClient(String url, String db_name, String login,
			String password) throws Exception {

		MongoCredential credential = MongoCredential.createMongoCRCredential(
				login, db_name, password.toCharArray());
		mongoClient = new MongoClient(new ServerAddress(url),
				Arrays.asList(credential));
		
		base = mongoClient.getDB(db_name);
		collection = base.getCollection("tweet");
	}

	public void insert(Tweet t) {
		BasicDBObject o = new BasicDBObject();
		o.put("_id",t.getID());
		if(collection.findOne(o) == null){
			System.out.println("On rentre");
			collection.insert(t.getBasicDBObject());
		}
	}
	
	public void insertCollection(List<Tweet> list){
		for(Tweet t : list){
			insert(t);
		}
	}
}
