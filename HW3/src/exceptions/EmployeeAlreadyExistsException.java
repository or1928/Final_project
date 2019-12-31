package exceptions;

public class EmployeeAlreadyExistsException extends WrongInput{
	public EmployeeAlreadyExistsException(String errorMessage) {
		super(errorMessage);
		
	}

}
