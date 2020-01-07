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
	
	private static Scanner scanner = new Scanner(System.in);
	public static Shop myShop;
	public static String users=null;
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
		
		myShop = new Shop("BestSell", "Hafia" ,"046793243");
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
		
		//sr.readSer(myShop);
		
	}
				
	public static void addSale()
			throws ObjectNotFound, WrongInput, ItemNotFoundException {

		String usrInput, date = null;

		System.out.println("Please select employee by id:");
		myShop.showEmployees();
		usrInput = scanner.next();
		for (Employee employee : myShop.getEmployess()) {
			if (usrInput.equals(employee.getID())) {
				e1 = employee;
			}
		}
		if (e1 == null) {
			throw new ItemNotFoundException("Employee not found!");
		}

		System.out.println("Please select customer by id:");
		myShop.showCustomers();
		usrInput = scanner.next();
		for (Customer customer : myShop.getCustomer()) {
			if (usrInput.equals(customer.getID())) {
				c1 = customer;
			}
		}
		if (c1 == null) {
			throw new ItemNotFoundException("Customer not found!");
		}

		System.out.println("Please select phone by SN:");
		myShop.showPhoneStock();
		usrInput = scanner.next();
		for (UsedPhone usedPhone : myShop.getPhones()) {
			if (usrInput.equals(usedPhone.getPhoneSN())) {
				ph1 = usedPhone;
			}
		}
		if (ph1 == null) {
			throw new ItemNotFoundException("Used phone not found!");
		}

		System.out.println("Please enter sale date: DD-MM-YYYY");
		usrInput = scanner.next();
		date = usrInput;
		if (!date.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
			throw new IllegalDateException("wrong date format");
		}

		try {
			myShop.addSale(new Sale(e1, c1, date, myShop, ph1));
		} catch (NullPointerException e) {
			System.out.println("Object not found!");
		}

	}

	public static void addCustomersToShop()
			throws ObjectNotFound, CustomerAlreadyExistsException {

		System.out.print("\nCustomers list:\n");
		for (Customer c : allCustomers) {
			System.out.print("\n Full Name: " + c.getFirstName() + " "
					+ c.getLastName() + "\n Customer Id: " + c.getID() + "\n");
		}

		System.out.print("\nPlease select custumet to add by typing id:");
		String input = scanner.next();

		boolean success = false;

		for (Customer customer : allCustomers) {
			if (customer.getID().equals(input)) {
				myShop.addCustomer(customer);
				System.out.print("\n Customer successfully added\n");
				success = true;
				break;
			}
		}

		if (!success)
			throw new ObjectNotFound("Customer Not Exists");
	}

	public static void addEmployeesToShop()
			throws ObjectNotFound, EmployeeAlreadyExistsException {

		System.out.print("\nEmployees list:\n");
		for (Employee e : allEmployees) {
			System.out.print("\n Full Name: " + e.getFirstName() + " "
					+ e.getLastName() + "\n Employee Id: " + e.getID() + "\n");
		}

		System.out.print("\nPlease select employee to add by typing id:");
		String input = scanner.next();

		boolean success = false;

		for (Employee emp : allEmployees) {
			if (emp.getID().equals(input)) {
				myShop.addEmployee(emp);
				System.out.print("\n Employee successfully added\n");
				success = true;
				break;
			}
		}

		if (!success)
			throw new ObjectNotFound("Emplpyee Not Exists");
	}

	public static void addProvidersToShop()
			throws ObjectNotFound, ProvidersAlreadyExistsException {

		System.out.print("\nProviders list:\n");
		for (Provider p : allProviders) {
			System.out.print("\n Full Name: " + p.getFirstName() + " "
					+ p.getLastName() + "\n Provider Id: " + p.getID() + "\n");
		}

		System.out.print("\nPlease select provider to add by typing id:");
		String input = scanner.next();

		boolean success = false;

		for (Provider prov : allProviders) {
			if (prov.getID().equals(input)) {
				myShop.addProvider(prov);
				System.out.print("\n Provider successfully added\n");
				success = true;
				break;
			}
		}

		if (!success)
			throw new ObjectNotFound("Provider Not Exists");
	}

	public static void addUsedPhonesToShop() throws ObjectNotFound {

		System.out.print("\nUsed Phones list:\n");
		for (UsedPhone ph : allusedPhones) {
			System.out.print("\n Phone SN: " + ph.getPhoneSN() + "\n Model: "
					+ ph.getPhoneBrand() + " " + ph.getModelNo() + "\n");
		}

		System.out.print("\nPlease select Used phone to add by typing SN:");
		String input = scanner.next();

		boolean success = false;

		for (UsedPhone usedp : allusedPhones) {
			if (usedp.getPhoneSN().equals(input)) {
				myShop.addPhone(usedp);
				System.out.print("\n Used phone successfully added\n");
				success = true;
				break;
			}
		}

		if (!success)
			throw new ObjectNotFound("Used phone Not Exists");
	}

}
