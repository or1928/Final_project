package exceptions;

public class CustomerAlreadyExistsException extends WrongInput{
	public CustomerAlreadyExistsException(String errorMessage) {
		super(errorMessage);
		
	}

}
