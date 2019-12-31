package exceptions;
import java.util.InputMismatchException;

public class InvalidPhoneNumberException extends WrongInput{
	public InvalidPhoneNumberException(String errorMessage) {
		super(errorMessage);
		
	}

}
