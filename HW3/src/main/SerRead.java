package main;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import classes.Shop;
import exceptions.WrongInput;

public class SerRead {

	private static ObjectInputStream input;

	// enable user to select file to open
	public static void openSer() {
		try // open file
		{
			input = new ObjectInputStream(Files.newInputStream(Paths.get("files/myShop.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	// read data from file - deserialize
	public static Shop readSer(Shop s) {
		openSer();
		try {

			while (true) // loop until there is an EOFException
			{
				Object o = (Object) input.readObject();
				if (o instanceof Shop) {
					s = (Shop) o;
				}
			}
		}

		catch (EOFException endOfFileException) {
			System.out.printf("%nEnd of file%n");
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Invalid object type. Program will close.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file. program will close.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeSer();
		return s;
	}

	// close file and terminate application
	public static void closeSer() {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. program will close.");
			System.exit(1);
		}
	}

}
