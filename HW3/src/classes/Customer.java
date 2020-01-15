package classes;

import java.io.Serializable;

import exceptions.IllegalEmailException;
import exceptions.WrongInput;
import main.Main;

public class Customer extends Person implements Serializable {

	public int customerID;
	private String email;
	private int counter = 100;

	public Customer(String ID, String firstName, String lastName, String phoneNumber, String dateOfBirth, String email)
			throws WrongInput {
		super(ID, firstName, lastName, phoneNumber, dateOfBirth);
		setEmail(email);
		setCustomerID();

	}

	private void setCustomerID() {
		this.customerID = Main.countCustomers++;
	}

	public void setEmail(String email) {
		if (email.contains("@"))
			this.email = email;
		else {
			throw new IllegalEmailException("Email must contain commercial at");
		}
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getEmail() {
		return email;
	}

}
