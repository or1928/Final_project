package exceptions;
import java.util.InputMismatchException;

public class InvalidShopNameException extends WrongInput{
	public InvalidShopNameException(String errorMessage) {
		super(errorMessage);
		
	}

}
