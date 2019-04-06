package MongoBango.com.MongoInstanceConnection;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoConnection {

	final String uriString = "mongodb+srv://fadi:Fidodido1940@fadi-pwbgj.mongodb.net/test?retryWrites=true";
	MongoDatabase mongoDB;
	MongoClient mongoClient;
	MongoCollection<Document> collection;

	public MongoConnection() {

		MongoClientURI uri = new MongoClientURI(uriString);
		this.mongoClient = new MongoClient(uri);

		getDatabase("test");
		GetCollection("inventory");

	}

	public void getDatabase(String database) {
		// specify the database you want to work with
		this.mongoDB = mongoClient.getDatabase(database);
	}

	public void GetCollection(String collection) {
		// specify the collection that you want to work with
		this.collection = mongoDB.getCollection(collection);
	}

	public void insertIntoTheCollection() {

		// this create a basic document to be inserted in the inventory collection
		// the first argument is the item : canvas is the value
		// we can add so many pairs as we want and they will be listed in the document
		Document canvas = new Document("item", "canvas").append("qty", 100);

		Document size = new Document("h", 28).append("w", 35.5).append("uom", "cm");

		// we can attach another document to the first one by doing this
		canvas.put("size", size);
		// without this statement we are not inserting anything to the mongo
		collection.insertOne(canvas);

	}

	public void iterateOverTheCollection() {

		FindIterable<Document> iterDoc = collection.find();
		int i = 1;

		// Getting the iterator
		Iterator<Document> it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			i++;
		}

	}

	public void insertMany() {

		ArrayList<Document> documents = new ArrayList<Document>();

		documents.add(Document.parse("{ item: 'journal', qty: 25, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"));
		documents.add(Document.parse("{ item: 'notebook', qty: 50, size: { h: 8.5, w: 11, uom: 'in' }, status: 'A' }"));
		documents.add(Document.parse("{ item: 'paper', qty: 100, size: { h: 8.5, w: 11, uom: 'in' }, status: 'D' }"));
		documents
				.add(Document.parse("{ item: 'planner', qty: 75, size: { h: 22.85, w: 30, uom: 'cm' }, status: 'D' }"));
		documents.add(
				Document.parse("{ item: 'postcard', qty: 45, size: { h: 10, w: 15.25, uom: 'cm' }, status: 'A' }"));
		collection.insertMany(documents);

	}

	public void insertOneDocument() {
		Document document = new Document("title", "MongoDB").append("id", 1).append("description", "database")
				.append("likes", 100).append("url", "http://www.tutorialspoint.com/mongodb/")
				.append("by", "tutorials point");
		collection.insertOne(document);
		System.out.println("Document inserted successfully");
	}

	public void deleteDocument() {
		collection.deleteOne(Filters.eq("id", 1));
		System.out.println("Document deleted successfully...");
	}

	public void readBasedOnCriteria() {
		Document myDoc = collection.find(Filters.eq("id", 1)).first();
		System.out.println(myDoc.toJson());
	}

	public void findFirstDocument() {
		Document myDoc = collection.find().first();
		System.out.println(myDoc.toJson());
	}

	public void updateDocument() {
		collection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));
		System.out.println("Document update successfully...");

	}

	public void dropingCollection(String collectionName) {
		MongoCollection<Document> collection = mongoDB.getCollection(collectionName);

		// Dropping a Collection
		collection.drop();
		System.out.println("Collection dropped successfully");
	}

	public void listinAlltheCollections() {
		for (String name : mongoDB.listCollectionNames()) {
			System.out.println(name);
		}
	}

	public void closeTheConnection() {
		mongoClient.close();
	}

}
