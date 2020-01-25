package classes;

import java.io.Serializable;

import exceptions.IllegalDateException;
import exceptions.InvalidIDException;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneNumberException;
import exceptions.WrongInput;

public abstract class  Person implements Serializable {
	private String ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dateOfBirth;

	public Person(String ID, String firstName, String lastName, String phoneNumber, String dateOfBirth)
			throws WrongInput {
		setID(ID);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setDateOfBirth(dateOfBirth);

	}

	public void setID(String ID) throws InvalidIDException {
		if (!ID.matches("[0-9]+") && ID.length() == 9)
			throw new InvalidIDException("ID length must be 9 digits and can only contain only numbers");
		this.ID = ID;

	}

	public void setFirstName(String firstName) throws InvalidNameException {
		if (firstName.matches("[a-zA-Z]+") && firstName.length() <= 20)
			this.firstName = firstName;
		else {
			throw new InvalidNameException(
					"The first name can contain only 20 digits and must be written in English letters only");
		}
	}

	public void setLastName(String lastName) throws InvalidNameException {
		if (lastName.matches("[a-zA-Z]+") && lastName.length() <= 20)
			this.lastName = lastName;
		else {
			throw new InvalidNameException(
					"The last name can contain only 20 digits and must be written in English letters only");
		}
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (phoneNumber.startsWith("05") && phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10)
			this.phoneNumber = phoneNumber;
		else {
			throw new InvalidPhoneNumberException(
					"Phone number length must be 10 digits start with '05' and can only contain only numbers");
		}
	}

	public void setDateOfBirth(String dateOfBirth) throws IllegalDateException {

		if (dateOfBirth.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
			this.dateOfBirth = dateOfBirth;
		} else
			throw new IllegalDateException("wrong date format");
	}

	public String getID() {
		return ID;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " ,Id:" + this.ID;
	}

}