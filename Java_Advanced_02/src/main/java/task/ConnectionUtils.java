package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static final String USER_NAME = "skripnal";
	private static final String USER_PASSWORD = "s1141978u";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sport";
	
	public static Connection openConnection() {
		try {
			Connection connection = DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
			Class.forName ("com.mysql.cj.jdbc.Driver");
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
