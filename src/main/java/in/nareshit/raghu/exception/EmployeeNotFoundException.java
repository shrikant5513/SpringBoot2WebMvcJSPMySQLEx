package in.nareshit.raghu.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super();
	}
	
	public EmployeeNotFoundException(String messsage) {
		super(messsage);
	}
	
}
