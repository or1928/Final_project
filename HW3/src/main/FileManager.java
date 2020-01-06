package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import classes.Customer;
import classes.Employee;
import classes.Provider;
import classes.UsedPhone;
import enums.brand;
import enums.condition;
import exceptions.WrongInput;

public class FileManager {
	private static Scanner input;
	private static ObjectOutputStream output;
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Provider> providers = new ArrayList<>();
	private ArrayList<UsedPhone> usedPhones = new ArrayList<>();
	private ArrayList<Employee> employees = new ArrayList<>();

	// open file objects_in.txt
	public void openFile() {
		try {

			input = new Scanner(Paths.get("files/objects_in.txt"));
		} catch (IOException ioException) {

			System.err.println("ERROR : file can not open");
			System.exit(1);
		}
	}

	// read record from file
	public void readFile() {

		try {

			while (input.hasNext()) {
				String obj = input.next();
				if (obj.equals("Customer")) {
					this.customers.add(new Customer(input.next(), input.next(),
							input.next(), input.next(), input.next(),
							input.next()));
				}

				if (obj.equals("Employee")) {
					this.employees.add(new Employee(input.next(), input.next(),
							input.next(), input.next(), input.next()));
				}
				if (obj.equals("Provider")) {
					this.providers.add(new Provider(input.next(), input.next(),
							input.next(), input.next(), input.next()));
				}
				if (obj.equals("UsedPhone")) {
					this.usedPhones.add(new UsedPhone(input.next(), input.nextInt(),
							condition.valueOf(input.next()), input.nextInt(),
							brand.valueOf(input.next())));
				}

			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.2");

		} catch (WrongInput e) {
			e.printStackTrace();
		}

	} // end method readRecords

	public void closeFile() {
		if (input != null)
			input.close();
	}

	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}

	public  ArrayList<Provider> getProviders() {
		return this.providers;
	}

	public  ArrayList<UsedPhone> getUsedPhones() {
		return this.usedPhones;
	}

	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}



	public void openFileSer() {
		try  {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("ScheduleSer.ser")));
		}
		catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1); 
		} 
	} 

	// add records to file
	public <E> void writeIntoSer(ArrayList<E> list) {
	} 

	// close file and terminate application 
	public static void closeFileSer() 
	{
		try 
		{
			if (output != null)
				output.close();
		} 
		catch (IOException ioException) {
			System.err.println("Error closing file. Terminating.");
		} 
	} 

}






