package main;

import java.io.IOException;
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
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Provider> providers = new ArrayList<>();
	static ArrayList<UsedPhone> usedPhones = new ArrayList<>();
	static ArrayList<Employee> employees = new ArrayList<>();

	// open file objects_in.txt
	public static void openFile() {
		try {

			input = new Scanner(Paths.get("files/objects_in.txt"));
		} catch (IOException ioException) {

			System.err.println("ERROR : file can not open");
			System.exit(1);
		}
	}

	// read record from file
	public static void readFile() {

		try {

			while (input.hasNext()) {
				String obj = input.next();
				if (obj.equals("Customer")) {
					customers.add(new Customer(input.next(), input.next(),
							input.next(), input.next(), input.next(),
							input.next()));
				}

				if (obj.equals("Employee")) {
					employees.add(new Employee(input.next(), input.next(),
							input.next(), input.next(), input.next()));
				}
				if (obj.equals("Provider")) {
					providers.add(new Provider(input.next(), input.next(),
							input.next(), input.next(), input.next()));
				}
				if (obj.equals("UsedPhone")) {
					usedPhones.add(new UsedPhone(input.next(), input.nextInt(),
							condition.valueOf(input.next()), input.nextInt(),
							brand.valueOf(input.next())));
				}

			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File improperly formed. Terminating.2");

		} catch (WrongInput e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end method readRecords

	public static void closeFile() {
		if (input != null)
			input.close();
	}
}