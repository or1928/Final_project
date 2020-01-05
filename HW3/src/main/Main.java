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
	public static String users=null;
	public static Shop myShop, shop, shop2, shop3, shop4, shop5;
	public static ArrayList<Employee> allEmployees;
	public static ArrayList<Customer> allCustomers;
	public static ArrayList<Provider> allProviders;
	public static ArrayList<UsedPhone> allusedPhones;

	public static Employee e1;
	public static Customer c1;
	public static UsedPhone ph1;

	// Files functions

	public static void main(String[] args) throws WrongInput {
		FileManager fm = new FileManager();
		fm.openFile();
		fm.readFile();
		
		myShop = shop;
		init();
		// create new items for testing
		createLists();
		// show first menu for choosing the shop to work with
     	chooseShop();
		// show second menu for coosing actions in selected shop
		chooseAction();
				 
	}

	public static void init() {

		allEmployees = new ArrayList<>();
		allCustomers = new ArrayList<>();
		allProviders = new ArrayList<>();
		allusedPhones = new ArrayList<>();
	}

	public static void createLists() throws WrongInput {

		// create new shop s

		shop = new Shop("BestBuy_Haifa", "Herzel 40 , Haifa", "048656321");
		shop2 = new Shop("BestBuy_Tel Aviv", "Herzel 40 , Tel Aviv",
				"048656321");
		shop3 = new Shop("BestBuy_Afula", "Herzel 40 , Afula", "048656321");
		shop4 = new Shop("BestBuy_Eilat", "Herzel 40 , Eilat", "048656321");
		shop5 = new Shop("BestBuy_Gaza", "Herzel 40 , Gaza", "048656321");

		// create new Customers customer id start with 100 and increase by 1

		allCustomers.add(new Customer("109138534", "David", "deGea",
				"0504462353", "07-11-1990", "deGea@ManUtd.com"));
		allCustomers.add(new Customer("374298537", "Victor", "Lindelof",
				"0546546247", "17-07-1994", "Lindelof@ManUtd.com"));
		allCustomers.add(new Customer("202678343", "Eric", "Bailly",
				"0524454763", "12-04-1994", "Bailly@ManUtd.com"));
		allCustomers.add(new Customer("144308524", "Phil", "Jones",
				"0504162398", "21-02-1992", "Jones@ManUtd.com"));
		allCustomers.add(new Customer("217438501", "Harry", "Maguire",
				"0504262353", "05-03-1993", "Maguire@ManUtd.com"));

		// create new Employees employee id start with 200 and increase by 1

		allEmployees.add(new Employee("234947569", "Paul", "Pogba",
				"0542782927", "15-03-1993"));
		allEmployees.add(new Employee("274841631", "Juan", "Mata", "0541872936",
				"28-04-1988"));
		allEmployees.add(new Employee("124167233", "Anthony", "Martial",
				"0548152415", "05-12-1995"));
		allEmployees.add(new Employee("202647939", "Ashley", "Young",
				"0542192123", "09-07-1985"));
		allEmployees.add(new Employee("248647596", "Marcus", "Rashford",
				"0545442781", "31-10-1997"));

		// Invalid Name Exeption
		// Employee e6 = new Employee("248647596", "Mar4s", "Rashford",
		// "0545442781", "31-10-1997");

		// create new Provider employee id start with 300 and increase by 1

		allProviders.add(new Provider("208903612", "Diogo", "Dalot",
				"0582347121", "18-03-1999"));
		allProviders.add(new Provider("231936363", "Luke", "Shaw", "0562561971",
				"12-07-1995"));
		allProviders.add(new Provider("202851724", "Mason", "Greenwood",
				"0542285562", "01-10-2001"));
		allProviders.add(new Provider("239744549", "Angel", "Gomes",
				"0542929682", "31-08-2000"));
		allProviders.add(new Provider("209381428", "Nemanja", "Matic",
				"0542116215", "01-08-1988"));

		// Invalid Phone Number Exception
		// Provider p5 = new Provider("209381428", "Nemanja", "Matic",
		// "4352116215", "01-08-1988");

		allusedPhones.add(new UsedPhone("IPhone s7", 2015, condition.Used, 1000,
				brand.Apple));
		allusedPhones.add(new UsedPhone("IPhone X", 2019, condition.New, 2440,
				brand.Apple));
		allusedPhones.add(new UsedPhone("galaxy s8", 2019, condition.New, 1350,
				brand.Samsung));
		allusedPhones.add(
				new UsedPhone("LG g5", 2017, condition.asNew, 1140, brand.LG));
		allusedPhones.add(new UsedPhone("xiaomi mi mix", 2018, condition.Used,
				1500, brand.Xiaomi));

		// Illegal Price Exception
		// UsedPhone ph6 = new UsedPhone("xiaomi mi mix", 2018, condition.Used,
		// -40, brand.Xiaomi);
	}

	public static void shopMenu() {
		System.out.println("Please choose a shop:");
		System.out.println(
				"(1) Haifa \n(2) Tel-Aviv  \n(3) Afula \n(4) Eilat \n(5) Gaza");
	}

	private static void chooseShop() {

		shopMenu();
		boolean contLoop = true;

		while (contLoop) {
			int opt = scanner.nextInt();
			if (opt > 0 && opt < 6) {
				contLoop = false;
			}
			if (opt == 1) {
				myShop = shop;
			} else if (opt == 2) {
				myShop = shop2;
			} else if (opt == 3) {
				myShop = shop3;
			} else if (opt == 4) {
				myShop = shop4;
			} else if (opt == 5) {
				myShop = shop5;
			} else {
				System.out.println("\n Wrong input. Please try again");
				shopMenu();
			}
		}
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
