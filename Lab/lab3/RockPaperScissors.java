/**
	A class that implement the rock-paper-scissors game where the user plays against the computer

	@author Meiling Liu
**/
import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors
{
	public static void main (String[] args)
	{
		// The computer chooses a random number between 1 and 3. 
		Random r = new Random();  //create object of type Random
		int computerChoice = r.nextInt(3) + 1; //choose a number 0 to MAX-1, and add 1 to get


		//The computer prompts the user for a number 1 to 3.
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 1 (Rock), 2 (Paper), or 3 (Scissors) - Enter 0 to exit: ");
		int enterNum = in.nextInt();

		// 1 represents rock, 2 represents paper, 3 represents scissors
		// Rock (1) beats scissors (3).
		// Paper (2) beats rock (1).
		// Scissors (3) beat paper (2).
		while(enterNum != 0){
			if(enterNum == 1){
				if(computerChoice == 1){
					System.out.println("Player chooses Rock. Computer chooses Rock.");
					System.out.println("It's a tie!");

				} else if(computerChoice == 2){
					System.out.println("Player chooses Rock. Computer chooses Paper.");
					System.out.println("Computer wins!");

				} else if(computerChoice == 3){
					System.out.println("Player chooses Rock. Computer chooses Scissors.");
					System.out.println("Player wins!");

				}
			}else if(enterNum == 2){
				if(computerChoice == 1){
					System.out.println("Player chooses Paper. Computer chooses Rock.");
					System.out.println("Player wins!");

				} else if(computerChoice == 2){
					System.out.println("Player chooses Paper. Computer chooses Paper.");
					System.out.println("It's a tie!");

				} else if(computerChoice == 3){
					System.out.println("Player chooses Paper. Computer chooses Scissors.");
					System.out.println("Computer wins!");

				}
			}else if(enterNum == 3){
				if(computerChoice == 1){
					System.out.println("Player chooses Scissors. Computer chooses Rock.");
					System.out.println("Computer wins!");

				} else if(computerChoice == 2){
					System.out.println("Player chooses Scissors. Computer chooses Paper.");
					System.out.println("Player wins!");

				} else if(computerChoice == 3){
					System.out.println("Player chooses Scissors. Computer chooses scissors.");
					System.out.println("It's a tie!");

				}
			}else{   // If the user enters a number other than 0, 1, 2, or 3, print an error message and prompt for a new number.
				System.out.println("Invalid input.");

			}

		System.out.println("Enter 1 (Rock), 2 (Paper), or 3 (Scissors) - Enter 0 to exit: ");
		enterNum = in.nextInt();
		computerChoice = r.nextInt(3) + 1;
		}
		if(enterNum == 0){	     // Allow the game to continue until the user enters 0 to exit.
			System.out.println("Game over.");
		}
	}


}