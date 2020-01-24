package classes;

import java.io.Serializable;
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

public class Shop implements Serializable {
	private String shopName;
	private String address;
	private String phoneNumber;

	private ArrayList<Employee> employess = new ArrayList<Employee>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Provider> providers = new ArrayList<Provider>();
	private ArrayList<UsedPhone> phones = new ArrayList<UsedPhone>();

	private HashMap<String, Sale> sales = new HashMap<String, Sale>();

	public Shop(String shopName, String address, String phoneNumber) throws WrongInput {
		setShopName(shopName);
		setAddress(address);
		setPhoneNumber(phoneNumber);

	}

	// phone functions
	public void addPhone(UsedPhone p) {
		if (!this.phones.contains(p)) {
			this.phones.add(p);
		}
		p.isInShop = 1;
		for (UsedPhone up : this.phones) {
			if (up.counter == p.counter) {
				p.counter++;
			}
		}
	}

	public void removePhone(UsedPhone p) {
		// phones.remove(p);
		p.isInShop = 0;
	}

	public void showPhoneStock() {
		for (UsedPhone p : phones) {
			System.out.println(p);
		}
	}

	// employees functions

	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		boolean found = false;
		for (Employee emp : this.employess) {
			if (emp.counter == e.counter) {
				e.counter++;
			}
			if ((emp.getID().equals(e.getID()))) {
				found = true;
			}
		}
		if (found == false) {
			this.employess.add(e);
		} else
			throw new EmployeeAlreadyExistsException("You cannot add the same Employee twice!");
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
		boolean found = false;
		for (Customer cs : this.customers) {
			if (cs.counter == c.counter) {
				c.counter++;
			}
			if ((cs.getID().equals(c.getID()))) {
				found = true;
			}
		}
		if (found == false) {
			this.customers.add(c);
		} else
			throw new CustomerAlreadyExistsException("You cannot add the same customer twice!");
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

		boolean found = false;
		for (Provider pro : this.providers) {
			if (pro.counter == p.counter) {
				p.counter++;
			}
			if ((pro.getID().equals(p.getID()))) {
				found = true;
			}
		}
		if (found == false) {
			this.providers.add(p);
		} else
			throw new ProvidersAlreadyExistsException("You cannot add the same employee twice!");

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
		if (phones.contains(phoneToSell) && phoneToSell.isInShop == 1) { // if the shop have the phone
			this.sales.put(sale.getSaleID(), sale);
			// this.phones.remove(phoneToSell); // remove phone from inventory
			phoneToSell.isInShop = 0;

		} else {
			throw new PhoneNotInInventoryExeption(
					"The store does not have the phone" + phoneToSell.getPhoneSN() + " in stock");

		}
	}

	public void cencelSale(String saleID, Sale sale) {
		this.sales.remove(saleID, sale);
	}

	public void showSales() {
		for (HashMap<String, Sale> a : Arrays.asList(this.sales))
			System.out.println(a);

	}

	public void setShopName(String shopName) {
		if (shopName.length() <= 20)
			this.shopName = shopName;
		else {
			throw new InputMismatchException("Shop name can contain at most 20 letters");
		}
	}

	public void setAddress(String address) throws InvalidAddressException {
		if (address.length() <= 40)
			this.address = address;
		else {
			throw new InvalidAddressException("The address cannot contain more than 40 characters");
		}
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber.matches("[0-9]+") && (phoneNumber.length() == 9 || phoneNumber.length() == 10))
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getShopName();
	}

	public static double sum(ArrayList<? extends Number> list) {
		double max = 0;
		for (Number obj : list) {
			max += obj.doubleValue();
		}
		return max;
	}
}
