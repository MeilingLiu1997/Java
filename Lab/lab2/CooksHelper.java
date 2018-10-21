/**
	A class that helps user to convert the number of tablespoons to cups
	@author Meiling Liu
**/

import java.util.Scanner;

public class CooksHelper
{
	public static void main (String[] args)
	{
		Scanner enter = new Scanner(System.in);


		// ask the user for the number of tablespoons.
		System.out.println("Enter number of Tablespoons: ");
		int numberTable = enter.nextInt();


		// Convert tablespoons to cups.
			// One cup is equal to 16 tablespoons.
		final int transfer = 16;
		double numberCups = ((double)numberTable) / transfer;


		// print result
		//System.out.println(numberTable + " tablespoons is equal to " + numberCups + " cups.");
		System.out.printf("%d tablespoons is equal to %3.2f cups.\n", numberTable, numberCups);


	}
}