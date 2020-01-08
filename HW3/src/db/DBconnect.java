package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import classes.Customer;
import classes.Shop;
import main.Main;

public class DBconnect {

	public static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static PreparedStatement insertCustomer;
	private static PreparedStatement insertEmployee;
	private static PreparedStatement insertProvider;
	private static PreparedStatement insertSale;
	private static PreparedStatement insertUsedPhone;
	private static PreparedStatement selectCustomer;
	private static PreparedStatement selectEmployee;
	private static PreparedStatement selectProvider;
	private static PreparedStatement selectSale;
	private static PreparedStatement selectUsedPhone;
	private static PreparedStatement delete;

	public static void openDB() {
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");
			System.out.println("CONNECTED");

		} catch (Exception e) {
			System.err.println("Error opening DB. Terminating.");
		}
	}

	public static Shop readShop()
	{
		Shop recoveredShop = null;

		ResultSet customerResultSet = null;
		ResultSet employeeResultSet = null;
		ResultSet providerResultSet = null;
		ResultSet usedPhoneResultSet = null;
		ResultSet saleResultSet = null;
		
		
		try 
		{
			selectCustomer = 
					connection.prepareStatement("SELECT * FROM customer");
			customerResultSet = selectCustomer.executeQuery(); 
			selectEmployee = 
					connection.prepareStatement("SELECT * FROM employee");
			employeeResultSet = selectEmployee.executeQuery(); 
			selectProvider = 
					connection.prepareStatement("SELECT * FROM provider");
			providerResultSet = selectProvider.executeQuery(); 
			selectUsedPhone = 
					connection.prepareStatement("SELECT * FROM usedPhone");
			usedPhoneResultSet = selectUsedPhone.executeQuery(); 
			selectSale = 
					connection.prepareStatement("SELECT * FROM sale");
			saleResultSet = selectSale.executeQuery(); 
			//readManager from db
			
			while (customerResultSet.next())
			{
				
				Customer c =new Customer(customerResultSet.getString(1),customerResultSet.getString(2), customerResultSet.getString(3), customerResultSet.getString(4), customerResultSet.getString(5), customerResultSet.getString(6));
				Main.myShop.addCustomer(c);
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
