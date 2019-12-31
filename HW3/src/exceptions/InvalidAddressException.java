package exceptions;
import java.util.InputMismatchException;

public class InvalidAddressException extends WrongInput{
	public InvalidAddressException(String errorMessage) {
		super(errorMessage);
		
	}

}
