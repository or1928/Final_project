package exceptions;
import java.util.InputMismatchException;

public class InvalidNameException extends WrongInput{
	public InvalidNameException(String errorMessage) {
		super(errorMessage);
		
	}

}
