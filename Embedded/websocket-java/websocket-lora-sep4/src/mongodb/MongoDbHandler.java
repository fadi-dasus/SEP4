package mongodb;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbHandler {

	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public MongoDbHandler() {
		client = MongoClients.create("mongodb+srv://fadi:Fidodido1940@fadi-pwbgj.mongodb.net/Sep4?retryWrites=true");
		database = client.getDatabase("Sep4");
		collection = database.getCollection("EUI");	
	}
	
	public void insertDoc(Document doc) {
		collection.insertOne(doc);
	}
}