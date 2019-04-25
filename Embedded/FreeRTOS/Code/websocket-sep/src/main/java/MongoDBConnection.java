import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public MongoDBConnection() {
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://fadi:Fidodido1940@fadi-pwbgj.mongodb.net/test?retryWrites=true");
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient(uri);
		
		database = mongoClient.getDatabase("test");
		collection = database.getCollection("inventory");
	}
	
	public void insertMeasurement(String EUI, String timestamp, String temp, String hum, String CO2) {
		Document doc = new Document("EUI", EUI)
                .append("timestamp", timestamp)
                .append("temp", temp)
                .append("hum", hum)
                .append("CO2", CO2);
		
		collection.insertOne(doc);
	}
	
	public void closeConnection() {
		if(mongoClient != null)
			mongoClient.close();
	}
	
	
}
