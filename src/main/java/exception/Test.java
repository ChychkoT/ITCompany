package exception;


public class Test {

	public String helloMessage(String name) throws MyTestException {
		if (name == null) {
			throw new MyTestException("Message is null");
		}
		return "Hello, " + name;
	}
	

}
