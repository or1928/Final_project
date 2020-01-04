package classes;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

import exceptions.CustomerAlreadyExistsException;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.InvalidAddressException;
import exceptions.InvalidPhoneNumberException;
import exceptions.PhoneNotInInventoryExeption;
import exceptions.ProvidersAlreadyExistsException;
import exceptions.WrongInput;

public class Shop {
	private String shopName;
	private String address;
	private String phoneNumber;

	private ArrayList<Employee> employess = new ArrayList<Employee>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Provider> providers = new ArrayList<Provider>();
	private ArrayList<UsedPhone> phones = new ArrayList<UsedPhone>();

	private	HashMap<String, Sale> sales = new HashMap<String, Sale>();

	

	public Shop(String shopName, String address, String phoneNumber) throws WrongInput {
		setShopName(shopName);
		setAddress(address);
		setPhoneNumber(phoneNumber);

	}

	// phone functions
	public void addPhone(UsedPhone p) {
		this.phones.add(p);
	}
	public void removePhone(UsedPhone p) {
		phones.remove(p);
	}

	public void showPhoneStock() {
		for (UsedPhone p : phones) {
			System.out.println(p);
		}
	}

	// employees functions

	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		if(this.employess.contains(e)) {
			throw new EmployeeAlreadyExistsException("You cannot add the same employee twice!");
		}
		this.employess.add(e);
	}

	public void removeEmployee(Employee e) {
		this.employess.remove(e);
	}

	public void showEmployees() {
		for (Employee e : this.employess) {
			System.out.println(e);
		}
	}

	// customers functions

	public void addCustomer(Customer c) throws CustomerAlreadyExistsException {
		if(this.customers.contains(c)) {
			throw new CustomerAlreadyExistsException("You cannot add the same employee twice!");
		}
		this.customers.add(c);
	}

	public void removeCustomer(Customer c) {
		this.customers.remove(c);
	}

	public void showCustomers() {
		for (Customer c : this.customers) {
			System.out.println(c);
		}
	}

	// provider functions

	public void addProvider(Provider p) throws ProvidersAlreadyExistsException {
		
		if(this.providers.contains(p)) {
			throw new ProvidersAlreadyExistsException("You cannot add the same employee twice!");
		}	
		this.providers.add(p);
	}

	public void removeProvider(Provider p) {
		this.providers.remove(p);
	}

	public void showProviders() {
		for (Provider p : this.providers) {
			System.out.println(p);
		}
	}

	// sales functions

	public void addSale(Sale sale) throws PhoneNotInInventoryExeption {
		UsedPhone phoneToSell = sale.getPhone();
		if (phones.contains(phoneToSell)) { // if the shop have the phone
			this.sales.put(sale.getSellingDate(), sale);
			this.phones.remove(phoneToSell); // remove phone from inventory
		} else {
			throw new PhoneNotInInventoryExeption(
					"The store does not have the phone"
							+ phoneToSell.getPhoneSN() + " in stock");

		}
	}

	public void cencelSale(String sellingDate, Sale sale) {
		this.sales.remove(sellingDate, sale);
	}

	public void showSales() {
		for (HashMap<String, Sale> a : Arrays.asList(this.sales))
			System.out.println(a);

	}

	public void setShopName(String shopName) {
		if (shopName.length() <= 20)
			this.shopName = shopName;
		else {
			throw new InputMismatchException(
					"Shop name can contain at most 20 letters");
		}
	}

	public void setAddress(String address) throws InvalidAddressException {
		if (address.length() <= 40)
			this.address = address;
		else {
			throw new InvalidAddressException(
					"The address cannot contain more than 40 characters");
		}
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber.matches("[0-9]+")
				&& (phoneNumber.length() == 9 || phoneNumber.length() == 10))
			this.phoneNumber = phoneNumber;
		else {
			throw new InvalidPhoneNumberException(
					"Phone number length must be 10 digits start with '05' and can only contain only numbers");
		}
	}

	public String getShopName() {
		return this.shopName;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public ArrayList<UsedPhone> getPhones() {
		return this.phones;
	}

	public ArrayList<Employee> getEmployess() {
		return this.employess;
	}

	public ArrayList<Provider> getProviders() {
		return this.providers;
	}

	public ArrayList<Customer> getCustomer() {
		return this.customers;
	}
	public HashMap<String, Sale> getSales() {
		return this.sales;
	}

	public void setSales(HashMap<String, Sale> sales) {
		this.sales = sales;
	}

}
