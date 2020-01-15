package classes;

import java.io.Serializable;

import exceptions.WrongInput;
import main.Main;

public class Employee extends Person implements Serializable {

	private static int counter = 200;
	public int employeeID;

	public Employee(String ID, String firstName, String lastName, String phoneNumber, String dateOfBirth)
			throws WrongInput {
		super(ID, firstName, lastName, phoneNumber, dateOfBirth);
		setEmployeeID();
	}

	public void setEmployeeID() {
		this.employeeID = Main.countEmployyes++;
	}

	public int getEmployeeID() {
		return employeeID;
	}

}
