import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalc {
	static String regex ="(-?[0-9]+)([ \t]*/[ \t]*)(-?[0-9]+)([ \t]*)([+-/\\*])([ \t]*)(-?[0-9]+)([ \t]*/[ \t]*)(-?[0-9]+)";
	
	public static void main(String[] args) {
		int firstNumerator = 0;
		int firstDenominator = 0;
		String opperator = "";
		int secondNumerator = 0;
		int secondDenominator = 0;
		
		//Prompt user to input fraction operation
		System.out.println("Input a fraction operation: ");
		
		//User scanner to read in user input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine(); // a space is not permitted between the minus sign and and number
		scanner.close();
		input = input.trim();
		
		//Parse string to determine components
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(input);

		//store components in correct data types
		if(m.find()) {
			firstNumerator = Integer.parseInt(m.group(1));
			firstDenominator = Integer.parseInt(m.group(3));
			opperator = m.group(5);
			secondNumerator = Integer.parseInt(m.group(7));
			secondDenominator = Integer.parseInt(m.group(9));
		} else {
			System.out.println("Incorrect input.\nExiting...");
			System.exit(0);
		}
		
		if(firstDenominator==0 || secondDenominator==0) {
			System.out.println("Denominator cannot be 0.\nExiting...");
			System.exit(1);
		}
		
		//create the Fraction objects
		Fraction f1 = new Fraction(firstNumerator, firstDenominator);
		Fraction f2 = new Fraction(secondNumerator, secondDenominator);
		Fraction result = new Fraction(1,2);
		
		//apply operations
		switch(opperator) {
		case "+":
			result = f1.add(f2);
			break;
		case "-":
			result = f1.sub(f2);
			break;
		case "*":
			result = f1.mult(f2);
			break;
		case "/":
			result = f1.div(f2);
			break;
		default:
			break;
		}
		
		//return result
		System.out.println(result);
	}
}
