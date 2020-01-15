package classes;

import java.io.Serializable;
import java.util.InputMismatchException;

import main.Main;

public class Sale implements Serializable {

	public String saleID;
	private Employee employee;
	private Customer customer;
	private UsedPhone phone;
	private String sellingDate;
	private Shop shop;

	private static int counter = 600;

	public Sale(Employee employee, Customer customer, String sellingDate, Shop shop, UsedPhone phone) {
		setSaleID();
		setEmployee(employee);
		setCustomer(customer);
		setSellingDate(sellingDate);
		setShop(shop);
		setPhone(phone);

	}

	public void setEmployee(Employee employeeID) {
		try {
			this.employee = employeeID;
		} catch (InputMismatchException e) {

		}
	}

	public void setSaleID() {
		this.saleID = "SL" + Main.countSales++;
	}

	public void setCustomer(Customer customer) {
		try {

			this.customer = customer;
		} catch (InputMismatchException e) {
		}
	}

	public void setSellingDate(String sellingDate) {
		this.sellingDate = sellingDate;
	}

	public void setShop(Shop shop) {
		try {
			this.shop = shop;
		} catch (InputMismatchException e) {
		}

	}

	public void setPhone(UsedPhone phone) {
		try {
			this.phone = phone;
		} catch (InputMismatchException e) {
		}
	}

	public String getSaleID() {
		return this.saleID;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public String getSellingDate() {
		return this.sellingDate;
	}

	public Shop getShop() {
		return this.shop;
	}

	public UsedPhone getPhone() {
		return phone;
	}

	@Override
	public String toString() {

		return "\n-------\n" + "Sale id:" + this.saleID + "\nCustomer : " + this.customer + "\n" + "Employee : "
				+ this.employee + "\n" + "Phone : " + this.phone + "\n\n-------\n";

	}
}
