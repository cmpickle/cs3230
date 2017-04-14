public class Double extends Password {
	private int pin;
	
	public Double(String password, int pin) {
		super(password);
		this.pin = pin;
	}
	
	public boolean equals(Object other) {
		return super.equals(other) && this.pin == ((Double) other).pin;
	}
}
