package main;

import java.util.ArrayList;

import classes.Customer;
import classes.Employee;
import classes.Provider;
import classes.Shop;
import classes.UsedPhone;
import db.DBconnect;
import exceptions.WrongInput;
import gui.App;

public class Main {

	public static Shop myShop;
	public static String users = null;
	public static ArrayList<Employee> allEmployees;
	public static ArrayList<Customer> allCustomers;
	public static ArrayList<Provider> allProviders;
	public static ArrayList<UsedPhone> allusedPhones;

	public static FileManager fm = new FileManager();
	// public static SerWrite sw = new SerWrite();
	// public static SerRead sr = new SerRead();

	public static Employee e1;
	public static Customer c1;
	public static UsedPhone ph1;

	public static void main(String[] args) throws WrongInput {

		DBconnect.openDB();
		myShop = new Shop("BestSell", "Hafia", "046793243");
		DBconnect.readShopFromDB();
		init();

		// ******test db actions - temporary*******

		// myShop.addCustomer(allCustomers.get(0));
		// myShop.addCustomer(allCustomers.get(1));
		// myShop.addCustomer(allCustomers.get(2));
		// myShop.addEmployee(allEmployees.get(0));
		// myShop.addEmployee(allEmployees.get(1));
		// myShop.addEmployee(allEmployees.get(2));

	}

	public static void init() {

		// Open GUI
		App app_win = new App();
		app_win.main(null);

		// read objects from text file
		fm.openFile();
		fm.readFile();

		allEmployees = fm.getEmployees();
		allCustomers = fm.getCustomers();
		allProviders = fm.getProviders();
		allusedPhones = fm.getUsedPhones();

		// Serialize - local database - read data from last saved session
		// myShop = sr.readSer();

	}

}
