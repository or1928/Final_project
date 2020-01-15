package classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.InputMismatchException;

import enums.brand;
import enums.condition;

public class UsedPhone implements Serializable {

	public String phoneSN;
	private String modelNo;
	private int manufactureYear;
	private condition phoneCondition;
	private double price;
	private brand phoneBrand;
	public int isInShop = 0;

	private static int counter = 500;

	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	public UsedPhone(String modelNo, int manufactureYear, condition phoneCondition, double price, brand phoneBrand) {

		setPhoneSN(phoneSN);
		setModelNo(modelNo);
		setPhoneBrand(phoneBrand);
		setManufactureYear(manufactureYear);
		setPhoneCondition(phoneCondition);
		setPrice(price);

	}

	public void setPhoneSN(String phoneSN) {
		// UP = used phone

		this.phoneSN = "UP" + counter++;

	}

	public void setModelNo(String modelNo) {
		try {
			this.modelNo = modelNo;

		} catch (InputMismatchException e) {

		}
	}

	public void setManufactureYear(int manufactureYear) {
		if (manufactureYear > 1900 && manufactureYear <= CURRENT_YEAR)
			this.manufactureYear = manufactureYear;
		else {
			throw new InputMismatchException("invalid year value");
		}
	}

	public void setPhoneCondition(condition phoneCondition) {
		try {
			this.phoneCondition = phoneCondition;
		} catch (InputMismatchException e) {

		}

	}

	public void setPhoneBrand(brand phoneBrand) {
		try {

			this.phoneBrand = phoneBrand;

		} catch (InputMismatchException e) {

		}
	}

	public void setPrice(double price) {
		if (price > 0)
			this.price = price;
		else {
			throw new InputMismatchException("Price cannot be under zero");
		}
	}

	public String getPhoneSN() {
		return phoneSN;
	}

	public String getModelNo() {
		return modelNo;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public condition getPhoneCondition() {
		return phoneCondition;
	}

	public double getPrice() {
		return price;
	}

	public brand getPhoneBrand() {
		return phoneBrand;
	}

	@Override
	public String toString() {
		return "SN:" + this.phoneSN + " " + this.phoneBrand + " " + this.modelNo;
	}
}
