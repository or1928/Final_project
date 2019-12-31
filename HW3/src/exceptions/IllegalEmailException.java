package exceptions;
import java.util.InputMismatchException;

public class IllegalEmailException extends InputMismatchException{
	public IllegalEmailException(String errorMessage) {
		super(errorMessage);
		
	}

}
