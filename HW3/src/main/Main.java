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
	public static ArrayList<Employee> allEmployees;
	public static ArrayList<Customer> allCustomers;
	public static ArrayList<Provider> allProviders;
	public static ArrayList<UsedPhone> allusedPhones;
	public static FileManager fm = new FileManager();

	public static Employee e1;
	public static Customer c1;
	public static UsedPhone ph1;

	// Files functions
	
	public static void main(String[] args) throws WrongInput {
		
		myShop = new Shop("BestSell", "Hafia" ,"046793243");
		init();
		// show second menu for coosing actions in selected shop
		chooseAction();
				 
	}

	
	public static void init() {
		fm.openFile();
		fm.readFile();
	
		allEmployees = fm.getEmployees();
		allCustomers = fm.getCustomers();
		allProviders = fm.getProviders();
		allusedPhones = fm.getUsedPhones();
	}

	

	public static void shopMenu() {
		System.out.println("Please choose a shop:");
		System.out.println(
				"(1) Haifa \n(2) Tel-Aviv  \n(3) Afula \n(4) Eilat \n(5) Gaza");
	}

	private static void actionMenu() {

		System.out.println("\nShop selected: " + myShop.getShopName() + "\n");
		System.out.println("Please select an option:\n");
		System.out.println("(1) Add employees from list");
		System.out.println("(2) Add providers from list");
		System.out.println("(3) Add customers from list");
		System.out.println("(4) Add used phones from list");
		System.out.println("(5) Create new sale");
		System.out.println("(6) sorted menu");
		System.out.println("(7) Exit\n");
	}
	private static void sortMenu() {

		System.out.println("\nShop selected: " + myShop.getShopName() + "\n");
		System.out.println("Please select an option:\n");
		System.out.println("(1) Show sorted employees in shop by id");
		System.out.println("(2) Show sorted providers in shop by id");
		System.out.println("(3) Show sorted customers in shop by id");
		System.out.println("(4) Show sorted phones in shop by price");
		System.out.println("(5) print all");
		System.out.println("(6) return to main menu \n");
	}

	private static void chooseAction() throws WrongInput {

		boolean contLoop = true;

		while (contLoop) {
			actionMenu();
			int opt = scanner.nextInt();
			/*
			 * if (opt > 0 && opt < 8) { contLoop = false; }
			 */
			switch (opt) {
				case 1 : {
					try {
						addEmployeesToShop();
					} catch (ObjectNotFound e) {
						System.out.println(e);
					}
					break;
				}
				case 2 : {
					try {
						addProvidersToShop();
					} catch (ObjectNotFound e) {
						System.out.println(e);
					}
					break;
				}
				case 3 : {
					try {
						addCustomersToShop();
					} catch (ObjectNotFound e) {
						System.out.println(e);
					}
					break;
				}
				case 4 : {
					try {
						addUsedPhonesToShop();
					} catch (ObjectNotFound e) {
						System.out.println(e);
					}
					break;
				}
				case 5 : {
					try {
						addSale();
					} catch (WrongInput e) {
						System.out.println(e.getMessage());
					} catch (ItemNotFoundException e) {
						System.out.println(e.getMessage());
					}

					break;

				}
				case 6 : {
					sortAction();
					break;
				}
				case 7 : {
					System.out.println("\nThanks for using our system!\n");
					break;
				}
				default :
					System.out.println("\n Wrong input. Please try again");
					actionMenu();
			}

		}

	}

	private static void sortAction() throws ObjectNotFound {

		boolean contLoop = true;

		while (contLoop) {
			sortMenu();
			int opt = scanner.nextInt();
			if (opt > 0 && opt < 6) {
				contLoop = false;
			}
			switch (opt) {
				case 1 : {
					sortEmployee();
					break;
				}
				case 2 : {
					sortProvider();
					break;
				}
				case 3 : {
					sortCustomer();
					break;
				}
				case 4 : {
					sortallusedPhones();
					break;
				}
				case 5 : {
					App app_win = new App();
					 app_win.main(null);
					break;
				}
				case 6 : {
					actionMenu();
					break;
				}
				default :
					System.out.println("\n Wrong input. Please try again");
					sortMenu();
			}

		}
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

	public static void printall() throws ObjectNotFound {

		System.out.println("\nEmployees of this shop:\n");
		myShop.showEmployees();

		System.out.println("\nProviders of this shop:\n");
		myShop.showProviders();

		System.out.println("\nCustomers of this shop:\n");
		myShop.showCustomers();

		System.out.println("\nInventory of this shop:\n");
		myShop.showPhoneStock();

		System.out.println("\nSale list:\n");
		myShop.showSales();

	}

	public static void sortallusedPhones() throws ObjectNotFound {

		myShop.showPhoneStock();
		System.out.println("---------------------------");
		Collections.sort(myShop.getPhones(), new MyComp());
		myShop.showPhoneStock();

	}

	public static void sortEmployee() throws ObjectNotFound {

		System.out.println("---------------------------");
		Collections.sort(myShop.getEmployess(), new MyComp1());
		myShop.showEmployees();

	}

	public static void sortProvider() throws ObjectNotFound {

		System.out.println("---------------------------");
		Collections.sort(myShop.getProviders(), new MyComp2());
		myShop.showProviders();
	}

	public static void sortCustomer() throws ObjectNotFound {

		System.out.println("---------------------------");
		Collections.sort(myShop.getCustomer(), new MyComp3());
		myShop.showCustomers();

	}

	public static class MyComp implements Comparator<UsedPhone> {
		public int compare(UsedPhone s1, UsedPhone s2) {
			if (s1.getPrice() > s2.getPrice())
				return -1;
			if (s1.getPrice() < s2.getPrice())
				return 1;
			return -1;
		}
	}
	public static class MyComp1 implements Comparator<Employee> {
		public int compare(Employee s1, Employee s2) {
			if (s1.getEmployeeID() > s2.getEmployeeID())
				return -1;
			if (s1.getEmployeeID() < s2.getEmployeeID())
				return 1;
			return -1;
		}
	}
	public static class MyComp2 implements Comparator<Provider> {
		public int compare(Provider s1, Provider s2) {
			if (s1.getProviderID() > s2.getProviderID())
				return -1;
			if (s1.getProviderID() < s2.getProviderID())
				return 1;
			return -1;
		}
	}
	public static class MyComp3 implements Comparator<Customer> {
		public int compare(Customer s1, Customer s2) {
			if (s1.getCustomerID() > s2.getCustomerID())
				return -1;
			if (s1.getCustomerID() < s2.getCustomerID())
				return 1;
			return -1;
		}
	}

}
