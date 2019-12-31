package exceptions;
import java.util.InputMismatchException;

public class InvalidIDException extends WrongInput{
	public InvalidIDException(String errorMessage) {
		super(errorMessage);
		
	}

}
