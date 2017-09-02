package exception;

public class MyTestException extends Exception {

	private static final long serialVersionUID = 7848800747822813294L;

	public MyTestException() {
		super();

	}

	public MyTestException(String message) {
		super(message);

	}
	
	public MyTestException(Throwable cause){
		super(cause);
		}
    
}
