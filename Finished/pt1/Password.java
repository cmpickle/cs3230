public class Password extends Lock {
	private String password;
	
	public Password(String password) {
		this.password = password;
	}
	
	public boolean equals(Object other) {
		return super.equals(other) && this.password.equals(((Password) other).password);
	}
}
