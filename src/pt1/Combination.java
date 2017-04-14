package pt1;

public class Combination extends Lock {
	private int first;
	private int second;
	private int third;
	
	public Combination(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public boolean equals(Object other) {
		return super.equals(other) && this.first == ((Combination) other).first && 
				this.second == ((Combination) other).second && 
				this.third == ((Combination) other).third;
	}
}
