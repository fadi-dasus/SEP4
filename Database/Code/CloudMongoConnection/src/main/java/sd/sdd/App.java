package sd.sdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App {
	
	public static MongoCollection<Document> collection;
	
	
	
	public static void main(String[] args) {
	
		MongoClient mongoClient = MongoClients
				.create("mongodb+srv://fadi:Fidodido1940@fadi-pwbgj.mongodb.net/test?retryWrites=true");

		MongoDatabase database = mongoClient.getDatabase("MyDatabaseName");
		collection = database.getCollection("MyCollectionName");

		insert();
		read();
		
		
	

	}
	
	
	
	
	public static void insert() {
		Document document = new Document("name", "Café Con Leche")
				.append("contact",
						new Document("phone", "228-555-0149").append("email", "cafeconleche@example.com")
								.append("location", Arrays.asList(-73.92502, 40.8279556)))
				.append("stars", 3).append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));

		collection.insertOne(document);

		Document doc1 = new Document("name", "Amarcord Pizzeria")
				.append("contact",
						new Document("phone", "264-555-0193").append("email", "amarcord.pizzeria@example.net")
								.append("location", Arrays.asList(-73.88502, 40.749556)))
				.append("stars", 2).append("categories", Arrays.asList("Pizzeria", "Italian", "Pasta"));

		Document doc2 = new Document("name", "Blue Coffee Bar")
				.append("contact",
						new Document("phone", "604-555-0102").append("email", "bluecoffeebar@example.com")
								.append("location", Arrays.asList(-73.97902, 40.8479556)))
				.append("stars", 5).append("categories", Arrays.asList("Coffee", "Pastries"));

		List<Document> documents = new ArrayList<Document>();
		documents.add(doc1);
		documents.add(doc2);

		collection.insertMany(documents);
	}
	
	
	
	public static void read() {
		Block<Document> printBlock = new Block<Document>() {
		       public void apply(final Document document) {
		           System.out.println(document.toJson());
		       }
		};
		
		collection.find().forEach(printBlock);
	}
}
