public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int _numerator, int _denominator)
	{
		int divisor = gcd(_numerator, _denominator);
		this.numerator =(_denominator>0)? _numerator/divisor:_numerator/divisor*-1;
		this.denominator = Math.abs(_denominator/divisor);
	}
	
	public Fraction(int _numerator)
	{
		this.numerator = _numerator;
		this.denominator = 1;
	}
	
	public Fraction add(Fraction right)
	{
		int denominator = lcd(this.denominator, right.denominator);
		
		return new Fraction(this.numerator*(denominator/this.denominator)+right.numerator*(denominator/right.denominator), denominator);
	}
	
	public Fraction sub(Fraction right)
	{
		int denominator = lcd(this.denominator, right.denominator);
		
		return new Fraction(this.numerator*(denominator/this.denominator)-right.numerator*(denominator/right.denominator), denominator);
	}
	
	public Fraction mult(Fraction right)
	{
		return new Fraction(this.numerator*right.numerator, this.denominator*right.denominator);
	}
	
	public Fraction div(Fraction right)
	{
		return new Fraction(this.numerator*right.denominator, this.denominator*right.numerator);
	}
	
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	
	public boolean equals(Object other)
	{
		if(this == other) return true;
		
		if(other==null) return false;
		
		if(getClass() != other.getClass()) return false;
		
		Fraction otherFraction = (Fraction) other;
		
		return this.numerator==otherFraction.numerator && this.denominator == otherFraction.denominator;
	}
	
	private int gcd(int u, int v)
	{
		u = (u<0)? -u:u; //make u non-negative
		v = (v<0)? -v:v; //make v non-negative
		
		while(u>0)
		{
			if(u<v)
			{
				int t = u;
				u=v;
				v=t;
			}
			u-=v;
		}
		if(v==0)
			v=1;
		return v; //the GCD of u and v
	}
	
	private int lcd(int a, int b)
	{
		return Math.abs(a*b)/gcd(a,b);
	}
}
