package part_2;

public class MyException extends Exception {
	private String error;

	public MyException(String error) {
		super(error);
		this.error = error;
	}

	public String getError() {
		return error;
	}
	
}