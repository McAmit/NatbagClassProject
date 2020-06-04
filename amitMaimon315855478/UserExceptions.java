package amitMaimon315855478;

public class UserExceptions extends Exception{
	private String msg;
	
	public UserExceptions(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
