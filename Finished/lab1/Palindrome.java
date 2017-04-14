//package lab1;

import java.util.Scanner;

/**
 * @author Cameron Pickle
 *
 * Palindrome is a program that takes input via command line argument or
 * input scanner and then informs the user whether or not the word is a 
 * valid palindrome.
 * 
 */
public class Palindrome {

	public static void main(String[] args) {
		String input = "";
		if(args.length==0) {
			System.out.println("Use scanner object");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter a potencial palindrome: ");
			input = scanner.nextLine();
			scanner.close();
			
		} else {
			for(int i=0; i<args.length; i++)
				input += args[i];
		}
		
		input = removeNonAlphaChars(input);
		input = input.toLowerCase();
		
		if(input.length()==0) {
			System.out.println("Either the input was blank or it was invalid input.");
			System.out.println("This program will determine if a string is a palindrome based on characters [a-z][A-Z] dissregarding case.");
			System.out.println("Please try again.");
			System.exit(1);
		}
		
		for(int j=0; j<input.length()/2; j++) {
			if(input.charAt(j)!=input.charAt(input.length()-1-j)) {
				System.out.println("The input is not a palindrome.");
				System.exit(0);
			}
		}
		System.out.println("The input is a palindrome.");
	}

	private static String removeNonAlphaChars(String input) {
		String result = "";
		for(int i=0; i<input.length(); i++)
			if(Character.isLetter(input.charAt(i)))
				result += input.charAt(i);
				
		return result;
	}
}
