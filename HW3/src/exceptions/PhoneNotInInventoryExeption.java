package exceptions;
import java.util.InputMismatchException;

public class PhoneNotInInventoryExeption extends WrongInput{
	public PhoneNotInInventoryExeption(String errorMessage) {
		super(errorMessage);
		
	}

}
