package exceptions;
import java.util.InputMismatchException;

public class IllegalPriceException extends WrongInput{
	public IllegalPriceException(String errorMessage) {
		super(errorMessage);
		
	}

}
