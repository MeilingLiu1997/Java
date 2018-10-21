/**
	this class is going to open each java file,
	and record SLOC

	Author @Meiling Liu
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class JavaFileBulider{

	public static int[] countSLOC(String filename){

		int sloc = 0;
		boolean inMutiLine = false;
		int countMutiLine = 0;
		int countSingleLine = 0;

		//open file
		File inputFile = new File(filename); //Create a File with the given filename.

		//read in each line of file
		try(Scanner input = new Scanner(inputFile)) {  //Create a new Scanner to read input from the file

			while(input.hasNextLine()) { 
					String line = input.nextLine();	// first line of file

					// total comments
					sloc++;

					String noSpaceLine = line.trim();

					// count multi-line
					if(!inMutiLine && noSpaceLine.startsWith("/*")){	// first multi-line
						inMutiLine = true;
						countMutiLine++;
					} else if(inMutiLine && !noSpaceLine.endsWith("*/")){
						countMutiLine++;
					} else if(inMutiLine && noSpaceLine.endsWith("*/")){
						inMutiLine = false;
						countMutiLine++;
					} else if(!inMutiLine && noSpaceLine.startsWith("//")){	// if Single-line comments begin with //. 
						countSingleLine++;
					}
					
				
			}
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return null;  // If a FileNotFoundException is generated, return null.
		}
		
		int excluding = sloc - countSingleLine - countMutiLine;

		int[] input = new int[2];
		input[0] = sloc;
		input[1] = excluding;

		return input;

	}

}