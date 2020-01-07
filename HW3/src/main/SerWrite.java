package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import classes.Shop;

public class SerWrite {

	private static ObjectOutputStream output;

	public static void openSer() {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("files/myShop.ser")));
		} catch (IOException ioException) {
			System.err.println("Error opening file. Program will close.");
			System.exit(1); // terminate the program
		}
	}

	public static void writeSer(Shop s) {
		openSer();
		try {
			output.writeObject(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error writing to file. Program will close.");
		}
		closeSer();
	}

	public static void closeSer() {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file. Program will close.");
		}
	}

}
