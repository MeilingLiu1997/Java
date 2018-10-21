/**
	this class is varifying whether the class is valid
	Author@ Meiling Liu
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ValidClass{

	public static boolean isValid(String filename){

		String className = null;

		//open file
		File inputFile = new File(filename); //Create a File with the given filename.

		//read in each line of file
		try(Scanner input = new Scanner(inputFile)) {  //Create a new Scanner to read input from the file

			String localPath = filename.substring(filename.lastIndexOf("/") + 1);

			while(input.hasNextLine()) {
				String line = input.nextLine();	// first line of file
				String noSpaceLine = line.trim();
				
				if(noSpaceLine.startsWith("/*") == noSpaceLine.startsWith("//") == noSpaceLine.startsWith("*/") == false){
					
					String[] words = noSpaceLine.split(" ");

					for(int i = 0; i < words.length; i++){
						if(words[i].equals("class")){

							className = words[i+1];

							if(className.equals(localPath.substring(0, localPath.lastIndexOf(".")))){
								return true;
							}
						}
					}
				}
			}
			
			return false;


		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return false;  // If a FileNotFoundException is generated, return null.
		}
	}
	
}