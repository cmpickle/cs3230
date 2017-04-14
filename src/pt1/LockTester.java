package pt1;

public class LockTester {
	public static void main(String[] args) {
		Password pass = new Password("42");
		Double dble = new Double("pickle",42);
		Combination comb = new Combination(1,2,3);
		Password pass2 = new Password("42");
		Double dble2 = new Double("pickle",42);
		Combination comb2 = new Combination(1,2,3);
		Password pass3 = new Password("432");
		Double dble3 = new Double("picgkle",42);
		Combination comb3 = new Combination(13,2,3);
		Integer i = new Integer(42);
		
		System.out.println("pass equals pass2?");
		System.out.println(pass.equals(pass2));
		System.out.println("pass2 equals pass3?");
		System.out.println(pass2.equals(pass3));
		System.out.println("dble equals dble2?");
		System.out.println(dble.equals(dble2));
		System.out.println("dble equals dble3?");
		System.out.println(dble.equals(dble3));
		System.out.println("dble3 equals dble3?");
		System.out.println(dble3.equals(dble3));
		System.out.println("comb equals comb2?");
		System.out.println(comb.equals(comb2));
		System.out.println("comb2 equals comb3?");
		System.out.println(comb2.equals(comb3));
		System.out.println("comb equals comb?");
		System.out.println(comb.equals(comb));
		System.out.println("pass equals i?");
		System.out.println(pass.equals(i));
	}
}
