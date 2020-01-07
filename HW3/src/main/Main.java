package main;

import java.util.ArrayList;

import classes.Customer;
import classes.Employee;
import classes.Provider;
import classes.Shop;
import classes.UsedPhone;
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
	public static SerWrite sw = new SerWrite();
	public static SerRead sr = new SerRead();

	public static Employee e1;
	public static Customer c1;
	public static UsedPhone ph1;

	// Files functions

	public static void main(String[] args) throws WrongInput {

		// DBconnect.openDB();
		// DBconnect.closeDB();
		// myShop = new Shop("BestSell", "Hafia", "046793243");
		init();

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

		// Serialize functions - read data from last saved session
		myShop = sr.readSer();

	}

}
