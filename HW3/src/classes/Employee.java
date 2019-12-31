package classes;
import java.util.InputMismatchException;

import exceptions.WrongInput;

public class Employee extends Person {

	private static int counter = 200;
	private int employeeID;

	public Employee(String ID, String firstName, String lastName,
			String phoneNumber, String dateOfBirth) throws WrongInput {
		super(ID, firstName, lastName, phoneNumber, dateOfBirth);
		setEmployeeID();
	}

	public void setEmployeeID() {
		this.employeeID = counter++;
	}

	public int getEmployeeID() {
		return employeeID;
	}

}
