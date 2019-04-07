package MongoBango.com.MongoInstanceConnection.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper<T> {
	private static Connection connection = null;

	public DatabaseHelper() throws SQLException {

		connection = ConnectionManager.getInstance().getConnection();
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (SQLException e) {

		}
	}

	private static PreparedStatement prepare(String sql, Object... parameters) throws SQLException {

		PreparedStatement stat = connection.prepareStatement(sql);
		for (int i = 0; i < parameters.length; i++) {
			stat.setObject(i + 1, parameters[i]);
		}
		return stat;
	}

	public ResultSet executeQuery(String sql, Object... parameters) throws SQLException {
		PreparedStatement stat = prepare(sql, parameters);
		return stat.executeQuery();
	}

	public int executeUpdate(String sql, Object... parameters) throws SQLException {

		PreparedStatement stat = prepare(sql, parameters);
		return stat.executeUpdate();

	}

	public T getSingle(DataMapper<T> mapper, String sql, Object... parameters) throws SQLException {

		ResultSet rs = executeQuery(sql, parameters);
		if (rs.next()) {
			return mapper.create(rs);
		}

		else {
			return null;
		}

	}

	public List<T> getList(DataMapper<T> mapper, String sql, Object... parameters)

	{
		LinkedList<T> allObjects = new LinkedList<T>();
		try {
			ResultSet rs = executeQuery(sql, parameters);

			while (rs.next()) {
				allObjects.add(mapper.create(rs));
			}

		} catch (SQLException e) {

		}
		return allObjects;

	}
}
