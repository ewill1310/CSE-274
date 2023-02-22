package palindromes;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// Get the user input string
		Scanner in = new Scanner(System.in);
		System.out.println("Please Input a String to Check");
		String userInput = in.next();

		// Creates a reversed String
		String reversed = reverseString(userInput);

		// Checks if it is a palindrome
		if (isPalindrome(userInput, reversed)) {
			System.out.println("The word " + userInput + " is a palindrome");
		} else {
			System.out.println("The word " + userInput + " is not a palindrome");
		}
	}

	/**
	 * Take an input string and reverse it
	 * 
	 * @param input
	 * @return a String that is the reverse of the input
	 */
	public static String reverseString(String input) {
		String reverse = "";
		// Get character array from the input string
		char[] letters = input.toCharArray();

		// Loop through array to build the new reversed word
		for (int i = 0; i < letters.length; i++) {
			reverse = reverse + letters[letters.length - (i + 1)];
		}
		// Finally return the reversed word
		return reverse;
	}

	/**
	 * Takes an input string a determines if it is a palindrome or not
	 * @param str
	 * @return a boolean variable on if the string is indeed a palindrome or not
	 */
	public static boolean isPalindrome(String forward, String backwards) {
		// Make the strings lower case so we can test them, and see if they are the same
		String tempFor = forward.replaceAll("[^a-zA-Z0-9]+","").toLowerCase();
		String tempBack = backwards.replaceAll("[^a-zA-Z0-9]+","").toLowerCase();
		// Test to see if the strings are equal to each other
		if (tempFor.equals(tempBack)) {
			return true;
		} else {
			return false;
		}
	}
}
