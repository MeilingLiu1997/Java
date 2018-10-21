/**
	This class is print the word and whether it is or is not a palindrome
	for example, racecar is a palindrome or computer is not a palindrome.
	Author @Meiling Liu
**/

public class PalindromeTester{

	// The method takes as input a word and returns true if it is a palindrome and false otherwise. 
	// The method will be called from main and may not use any loops.
	
	public static boolean isPalindrome(String word){
		// if it is a palindrome
		int length = word.length();

		// base case
		if(length == 0 || length == 1){		// even number or odd
			return true;
		}

		if(word.charAt(0) == word.charAt(length - 1)){
			return isPalindrome(word.substring(1, length - 1));
		} else {
			return false;
		}

	}

	// The main method will print an appropriate usage message and exit if the parameter is not provided.
	public static void main(String[] args){
		if(args.length != 1) {					
			System.out.println("Please follow this direction: java PalindromeTester <word>, for example java PalindromeTester racecar.");
			System.exit(1);				
		}

		System.out.println(isPalindrome(args[0]));

		if(isPalindrome(args[0]) == true){
			System.out.println("The input word is palindrome.");
		} else {
			System.out.println("The input word is not palindrome.");
		}
	}
}