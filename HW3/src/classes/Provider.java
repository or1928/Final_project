package classes;

import java.io.Serializable;

import exceptions.WrongInput;

public class Provider extends Person implements Serializable {

	private int ProviderID;

	private static int counter = 300;

	public Provider(String ID, String firstName, String lastName, String phoneNumber, String dateOfBirth)
			throws WrongInput {
		super(ID, firstName, lastName, phoneNumber, dateOfBirth);
		setProviderID();
	}

	public void setProviderID() {
		this.ProviderID = counter++;
	}

	public int getProviderID() {
		return ProviderID;
	}

}
