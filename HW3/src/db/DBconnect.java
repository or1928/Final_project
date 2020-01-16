package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import classes.Customer;
import classes.Employee;
import classes.Provider;
import classes.Sale;
import classes.UsedPhone;
import enums.brand;
import enums.condition;
import exceptions.WrongInput;
import main.Main;

public class DBconnect {

	public static Connection connection;
	private static PreparedStatement insertCustomer;
	private static PreparedStatement insertEmployee;
	private static PreparedStatement insertProvider;
	private static PreparedStatement insertSale;
	private static PreparedStatement insertUsedPhone;
	private static PreparedStatement insertUtil;
	private static PreparedStatement selectCustomer;
	private static PreparedStatement selectEmployee;
	private static PreparedStatement selectProvider;
	private static PreparedStatement selectSale;
	private static PreparedStatement selectUsedPhone;
	private static PreparedStatement selectUtil;
	private static PreparedStatement delete;
	public static List<Employee> empList;
	public static List<Customer> cList;
	public static List<UsedPhone> phList;

	public static void openDB() {
		try {
			connection = DriverManager
					.getConnection("jdbc:sqlserver://localhost;databaseName=ShopDB;integratedSecurity=true;");
			System.out.println("Connected to SQL Server DB");

		} catch (Exception e) {
			System.err.println("Error opening DB. Terminating.");
		}
	}

	public static void clearDB() {
		// delete all old DB.
		try {
			delete = connection.prepareStatement("DELETE FROM customer");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM employee");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM provider");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM usedPhone");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM sale");
			delete.execute();
			delete = connection.prepareStatement("DELETE FROM util");
			delete.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeShopToDB() {

		// read all objects from "myShop" in "main" and store in DB
		try {

			insertCustomer = connection.prepareStatement(
					"INSERT INTO customer " + "(customer_id, id, firstName, lastName, phoneNumber, dateOfBirth, email) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			insertEmployee = connection.prepareStatement(
					"INSERT INTO employee " + "(employee_id, id, firstName, lastName, phoneNumber, dateOfBirth) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");
			insertProvider = connection.prepareStatement(
					"INSERT INTO provider " + "(provider_id, id, firstName, lastName, phoneNumber, dateOfBirth) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");
			insertUsedPhone = connection.prepareStatement(
					"INSERT INTO usedPhone " + "(phoneSN, modelNo, manufactureYear, condition, price, brand, isInShop) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
			insertSale = connection.prepareStatement("INSERT INTO sale "
					+ "(sale_id, employee_id, customer_id, phoneSN, sellingDate, shop) " + "VALUES (?, ?, ?, ?, ?, ?)");
			insertUtil = connection.prepareStatement(
					"INSERT INTO util " + "(employee_count,	customer_count, provider_count, phone_count, sale_count) "
							+ "VALUES (?, ?, ?, ?, ?)");
			// insert customers from myshop to db
			for (Customer c : Main.myShop.getCustomer()) {
				insertCustomer.setInt(1, c.getCustomerID());
				insertCustomer.setString(2, c.getID());
				insertCustomer.setString(3, c.getFirstName());
				insertCustomer.setString(4, c.getLastName());
				insertCustomer.setString(5, c.getPhoneNumber());
				insertCustomer.setString(6, c.getDateOfBirth());
				insertCustomer.setString(7, c.getEmail());
				insertCustomer.executeUpdate();
			}

			// insert employyes from myshop to db
			for (Employee e : Main.myShop.getEmployess()) {
				insertEmployee.setInt(1, e.getEmployeeID());
				insertEmployee.setString(2, e.getID());
				insertEmployee.setString(3, e.getFirstName());
				insertEmployee.setString(4, e.getLastName());
				insertEmployee.setString(5, e.getPhoneNumber());
				insertEmployee.setString(6, e.getDateOfBirth());
				insertEmployee.executeUpdate();
			}

			// insert providers from myshop to db
			for (Provider p : Main.myShop.getProviders()) {
				insertProvider.setInt(1, p.getProviderID());
				insertProvider.setString(2, p.getID());
				insertProvider.setString(3, p.getFirstName());
				insertProvider.setString(4, p.getLastName());
				insertProvider.setString(5, p.getPhoneNumber());
				insertProvider.setString(6, p.getDateOfBirth());
				insertProvider.executeUpdate();
			}

			// insert used phones from myshop to db
			for (UsedPhone up : Main.myShop.getPhones()) {
				insertUsedPhone.setString(1, up.getPhoneSN());
				insertUsedPhone.setString(2, up.getModelNo());
				insertUsedPhone.setInt(3, up.getManufactureYear());
				insertUsedPhone.setString(4, up.getPhoneCondition().toString());
				insertUsedPhone.setDouble(5, up.getPrice());
				insertUsedPhone.setString(6, up.getPhoneBrand().toString());
				insertUsedPhone.setInt(7, up.isInShop);
				insertUsedPhone.executeUpdate();
			}

			// insert sales from myshop to db
			for (Sale sl : Main.myShop.getSales().values()) {
				insertSale.setString(1, sl.getSaleID());
				insertSale.setInt(2, sl.getEmployee().getEmployeeID());
				insertSale.setInt(3, sl.getCustomer().getCustomerID());
				insertSale.setString(4, sl.getPhone().getPhoneSN());
				insertSale.setString(5, sl.getSellingDate());
				insertSale.setString(6, sl.getShop().toString());
				insertSale.executeUpdate();
			}

			// insert utility data into db
			insertUtil.setInt(2, Main.countCustomers);
			insertUtil.setInt(1, Main.countEmployyes);
			insertUtil.setInt(3, Main.countProviders);
			insertUtil.setInt(4, Main.countPhones);
			insertUtil.setInt(5, Main.countSales);
			insertUtil.executeUpdate();

		} catch (SQLException e2) {
// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public static void readShopFromDB() throws WrongInput {

		ResultSet customerResultSet = null;
		ResultSet employeeResultSet = null;
		ResultSet providerResultSet = null;
		ResultSet usedPhoneResultSet = null;
		ResultSet saleResultSet = null;
		ResultSet utilResultSet = null;

		// for stream use in sale add

		empList = Main.myShop.getEmployess();
		cList = Main.myShop.getCustomer();
		phList = Main.myShop.getPhones();

		try {
			selectCustomer = connection.prepareStatement("SELECT * FROM customer");
			customerResultSet = selectCustomer.executeQuery();
			selectEmployee = connection.prepareStatement("SELECT * FROM employee");
			employeeResultSet = selectEmployee.executeQuery();
			selectProvider = connection.prepareStatement("SELECT * FROM provider");
			providerResultSet = selectProvider.executeQuery();
			selectUsedPhone = connection.prepareStatement("SELECT * FROM usedPhone");
			usedPhoneResultSet = selectUsedPhone.executeQuery();
			selectSale = connection.prepareStatement("SELECT * FROM sale");
			saleResultSet = selectSale.executeQuery();
			selectUtil = connection.prepareStatement("SELECT * FROM util");
			utilResultSet = selectUtil.executeQuery();
			// read customers to shop from db

			while (customerResultSet.next()) {
				Customer c = new Customer(customerResultSet.getString(2), customerResultSet.getString(3),
						customerResultSet.getString(4), customerResultSet.getString(5), customerResultSet.getString(6),
						customerResultSet.getString(7));
				c.customerID = customerResultSet.getInt(1);
				Main.myShop.addCustomer(c);
			}

			// read employyes to shop from db
			while (employeeResultSet.next()) {
				Employee e = new Employee(employeeResultSet.getString(2), employeeResultSet.getString(3),
						employeeResultSet.getString(4), employeeResultSet.getString(5), employeeResultSet.getString(6));
				e.employeeID = employeeResultSet.getInt(1);
				Main.myShop.addEmployee(e);
			}

			// read providers to shop from db

			while (providerResultSet.next()) {
				Provider p = new Provider(providerResultSet.getString(2), providerResultSet.getString(3),
						providerResultSet.getString(4), providerResultSet.getString(5), providerResultSet.getString(6));
				p.ProviderID = providerResultSet.getInt(1);
				Main.myShop.addProvider(p);
			}

			// read used phones to shop from db

			while (usedPhoneResultSet.next()) {
				UsedPhone up = new UsedPhone(usedPhoneResultSet.getString(2), usedPhoneResultSet.getInt(3),
						condition.valueOf(usedPhoneResultSet.getString(4)), usedPhoneResultSet.getDouble(5),
						brand.valueOf(usedPhoneResultSet.getString(6)));
				up.phoneSN = usedPhoneResultSet.getString(1);
				up.isInShop = usedPhoneResultSet.getInt(7);
				Main.myShop.addPhone(up);
			}

			// read sales to shop from db

			while (saleResultSet.next()) {
				// use stream to find objects by property in myShop
				Integer tempEmployeeId = saleResultSet.getInt(2);
				Integer tempCustomerId = saleResultSet.getInt(3);
				String tempPhoneSN = saleResultSet.getString(4);
				String tempShopName = saleResultSet.getString(6);

				Employee e = ((List<Employee>) empList).stream().filter(emp -> emp.getEmployeeID() == tempEmployeeId)
						.findFirst().get();
				Customer c = ((List<Customer>) cList).stream().filter(cs -> cs.getCustomerID() == tempCustomerId)
						.findFirst().get();
				UsedPhone up = ((List<UsedPhone>) phList).stream().filter(ph -> ph.getPhoneSN().equals(tempPhoneSN))
						.findFirst().get();
				Sale sl = new Sale(e, c, saleResultSet.getString(5), Main.myShop, up);
				sl.saleID = saleResultSet.getString(1);
				Main.myShop.addSale(sl);
			}

			// get util values from DB
			while (utilResultSet.next()) {
				Main.countCustomers = utilResultSet.getInt(2);
				Main.countEmployyes = utilResultSet.getInt(1);
				Main.countProviders = utilResultSet.getInt(3);
				Main.countPhones = utilResultSet.getInt(4);
				Main.countSales = utilResultSet.getInt(5);
			}

		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	public static void updateDB2() {

		// read all objects from "myShop" in "main" and store in DB
		try {

			insertCustomer = connection.prepareStatement(
					"UPDATE customer SET customer_id = ?, id=?, firstName=?, lastName=?, phoneNumber=?, dateOfBirth=?, email=?");

			// insert customers from myshop to db
			for (Customer c : Main.myShop.getCustomer()) {
				insertCustomer.setInt(1, c.getCustomerID());
				insertCustomer.setString(2, c.getID());
				insertCustomer.setString(3, c.getFirstName());
				insertCustomer.setString(4, c.getLastName());
				insertCustomer.setString(5, c.getPhoneNumber());
				insertCustomer.setString(6, c.getDateOfBirth());
				insertCustomer.setString(7, c.getEmail());
				insertCustomer.execute();
			}

		} catch (SQLException e2) {
// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public static void updtaeDB() throws WrongInput {
		clearDB();
		writeShopToDB();
		// readShopFromDB();
	}

	public static void closeDB() {
		try {
			connection.close();
			System.out.println("\nConnection to DB successfully closed\nData is stored in DB.");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
