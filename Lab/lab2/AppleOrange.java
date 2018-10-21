/**
	A class that ask user enter a number that between 1 and 100, then print corresponding 
	apple, orange, or appleorage.

	@author Meiling Liu
**/
import java.util.Scanner;

public class AppleOrange
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
	// Prompt the user for a number between 1 and 100.
		System.out.println("Enter a number between 1 and 100: ");

		int enterNum = in.nextInt();

		if(enterNum < 1 || enterNum > 100){ //If the number is out of range print banana.
			System.out.println("banana");
		} else{
			if(enterNum % 3 == 0 && enterNum % 7 == 0){ //If the number is divisible by 3 and 7 print appleorange.
					System.out.println("appleorange");
				}else if(enterNum % 3 == 0){ //If the number is divisible by 3 print apple.
					System.out.println("apple");
				
				}else if(enterNum % 7 == 0){ //If the number is divisible by 7 print orange.
					System.out.println("orange");	
				}else { //In all other cases simply print the number.
					System.out.println(enterNum);
				}
		}


	}
}