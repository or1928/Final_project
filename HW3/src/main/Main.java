package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import classes.Customer;
import classes.Employee;
import classes.Provider;
import classes.Sale;
import classes.Shop;
import classes.UsedPhone;
import enums.brand;
import enums.condition;
import exceptions.CustomerAlreadyExistsException;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.IllegalDateException;
import exceptions.ItemNotFoundException;
import exceptions.ObjectNotFound;
import exceptions.ProvidersAlreadyExistsException;
import exceptions.WrongInput;
import gui.App;
import gui.Manager_window;

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

		myShop = new Shop("BestSell", "Hafia", "046793243");
		init();

		App app_win = new App();
		app_win.main(null);

	}

	public static void init() {
		fm.openFile();
		fm.readFile();

		allEmployees = fm.getEmployees();
		allCustomers = fm.getCustomers();
		allProviders = fm.getProviders();
		allusedPhones = fm.getUsedPhones();
		// Serialize functions

		// sr.readSer(myShop);

	}

}
