package MongoBango.com.MongoInstanceConnection.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null;

//	final String JDBC_URL = "jdbc:sqlserver://LAPTOP-6DO0QSTE\\SQL2016.database.windows.net:1433;database=northwindDB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	final String USERNAME = "fadi";
	final String PASSWORD = "*********";

	private String JDBC_URL ="jdbc:microsoft:sqlserver://LAPTOP-6DO0QSTE\\SQL2016;DatabaseName=northwindDB";

	private Connection conn = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();

		}

		return instance;
	}

	private boolean openConnection() {
		try {

			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}

	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Closing connection");
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
		}
	}

}