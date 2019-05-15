package sqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnection {

	// to-do
	public SQLDatabaseConnection() {

	}
	
	public int getRoomId(String EUI) {
		String connectionUrl =
		         "jdbc:sqlserver://10.200.131.2;"
		       + "database=Sep4_GroupX2;"
		       + "user=groupX2;"
		       + "password=groupX2;"
		       + "trustServerCertificate=false;"
		       + "loginTimeout=30;";
	
		ResultSet resultSet = null;
	
		int roomid = 0;
		
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		     Statement statement = connection.createStatement();) {
	
		     // Create and execute a SELECT SQL statement.
		     String selectSql = "select a.id from dbo.room a join dbo.device b ON a.device_id = b.id where b.uie = \'"+EUI+"\'";
		     resultSet = statement.executeQuery(selectSql);
		            
		            // Print results from select statement
		     while (resultSet.next()) {
		          //System.out.println(resultSet.getString(1));
		          roomid = Integer.parseInt(resultSet.getString(1));
		 		  break;
		     }
		     
		 }
		 catch (SQLException e) {
		     e.printStackTrace();
	     }      
		        return roomid;
	 }
}