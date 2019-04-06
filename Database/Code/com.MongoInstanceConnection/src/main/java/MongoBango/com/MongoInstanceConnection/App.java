package MongoBango.com.MongoInstanceConnection;

import java.sql.SQLException;

import MongoBango.com.MongoInstanceConnection.connection.DatabaseHelper;
import MongoBango.com.MongoInstanceConnection.customerDao.Customer;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws SQLException {
//		getMongo();
		System.out.println("Hello mongo");
		DatabaseHelper<Customer> helper =new DatabaseHelper<Customer>();
	
	}

	public static void getMongo() {
		MongoConnection mc = new MongoConnection();
		mc.insertIntoTheCollection();
		mc.insertMany();
		mc.insertOneDocument();
		mc.iterateOverTheCollection();
		mc.updateDocument();
		mc.deleteDocument();
		mc.iterateOverTheCollection();
		mc.listinAlltheCollections();
		mc.readBasedOnCriteria();
		mc.readBasedOnCriteria();
		mc.closeTheConnection();
	}
}
