/**
	A class that reads the contents of a text file, 
	stores each word in an ArrayList, 
	sorts the list, 
	then prints the contents in order smallest to largest and largest to smallest.

	@author Meiling Liu
**/
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;



public class Sorter
{
	public static void main (String[] args)
	{
		// main method


		// Create a new ArrayList of String to store the words in the file.
		ArrayList<String> storeWords = new ArrayList<String>();



		File inputFile = new File("words.txt"); // Open a file called words.txt.

		//uses a try-with-resources
		try (Scanner input = new Scanner(inputFile)) { 

			// read in file
            while(input.hasNext()) {

                String line = input.nextLine(); //read in the next line of the file
                storeWords.add(line); 		    // Store each line in the ArrayList.
                //System.out.println(line);
            }

        } catch(FileNotFoundException fnf) {
            System.out.println("File not found.");
            System.out.println(fnf.getMessage());
            //fnf.printStackTrace();
            System.exit(1); // automatically quit the whole program
        }
		
		// Sort the list. use the statice method sort of Collections
		Collections.sort(storeWords);   // This assumes that words is the name of your ArrayList variable. 
		


		// Print the contents of the list, one word on each line, 
		// in order from smallest to largest.
		System.out.println("Alphabetical A-Z: ");
		for(int i = 0; i < storeWords.size(); i++) {
			String word = storeWords.get(i);
			System.out.println(word);
		}

		System.out.println();
		// Print the contents of the list, one word on each line, 
		// in order from largest to smallest.
		System.out.println("Alphabetical Z-A: ");
		for(int i = storeWords.size() - 1; i >= 0; i--) {
			String word = storeWords.get(i);
			System.out.println(word);
		}

	}
}







