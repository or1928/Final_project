package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBconnect {

	public static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	public static void openDB() {
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");
			System.out.println("CONNECTED");

		} catch (Exception e) {
			System.err.println("Error opening DB. Terminating.");
		}
	}

	public static void closeDB() {
		try {
			connection.close();
			System.out.println("DB closed");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
