package classes;
import java.util.InputMismatchException;

import exceptions.IllegalEmailException;
import exceptions.WrongInput;

public class Customer extends Person {



	private int customerID;
	private String email;
	private static int counter = 100; 

	public Customer(String ID, String firstName, String lastName,
			String phoneNumber, String dateOfBirth,
			String email) throws WrongInput {
		super(ID, firstName, lastName, phoneNumber, dateOfBirth);
		setEmail(email);
		setCustomerID();


	}

	private void setCustomerID() {
		this.customerID = counter++;
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
