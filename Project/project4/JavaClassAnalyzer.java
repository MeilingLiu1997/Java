/**
	this class is going to find all Java files in a specified directory and then analyze each file.
	Author @Meiling Liu
**/

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaClassAnalyzer{

	public static void main(String[] args){
		/**
		1. program will be run as follows: java JavaClassAnalyzer <absolute_path>, 
		for example java JavaClassAnalyzer /Users/srollins/teaching/cs112/code/ClassExamplesWeek1.
		**/
		if(args.length != 1) {					
				System.out.println("Please follow this direction: java JavaClassAnalyzer <absolute_path>, java JavaClassAnalyzer /Users/srollins/teaching/cs112/code/ClassExamplesWeek1");
				System.exit(1);				
			}

		ValidClass test = new ValidClass();
		ClassList allClassFiles = new ClassList();	// java String List
		HashMap<String, ArrayList<String>> getNameAndPath = classSearch(args[0]);
		int countValidFile = 0;
		JavaFileBulider totalNumber = new JavaFileBulider();

		int totalSLOC = 0;
		int totalSLOCE = 0;
		ArrayList<String> invalidPath = new ArrayList<String>();

			
		String[] stringArray = allClassFiles.listOfAllClass(args[0]).toArray(new String[0]);

		for(int i = 0; i < stringArray.length; i++){

			if(test.isValid(getNameAndPath.get(stringArray[i]).get(0))){	// valid class
				countValidFile++;

			} else{															// invalid class
				invalidPath.add(getNameAndPath.get(stringArray[i]).get(0));
			}
		}
			
		
		System.out.println("Valid Classes - Total: " + countValidFile);
		HashMap<Integer, ArrayList<String>> result = new HashMap<Integer, ArrayList<String>>();

		for(String className: getNameAndPath.keySet()){
			if(test.isValid(getNameAndPath.get(className).get(0))){

				// 2) for each class, the absolute path of the class, the SLOC, and SLOC excluding comments;
				String removeExtension = className.substring(0, className.lastIndexOf("."));
				
				// the total SLOC and the SLOC excluding comments across all classes found;
				int[] list = totalNumber.countSLOC(getNameAndPath.get(className).get(0));
				
				
				for(int i = 0; i < list.length; i++){
					ArrayList<String> information = new ArrayList<String>();
					information.add(removeExtension + "," + getNameAndPath.get(className) + "," + list[i] + "," +list[i+1]);
					
					result.put(list[i],information);
					i++;
				}

				// add total SLOC and SLOC (excluding comments)
				totalSLOC += list[0];
				totalSLOCE += list[1];
			}
		}

// 4.the list of valid classes will be sorted in order of the total number of lines in each class from least to greatest.
		
		// source for applying ".toArray()" from <http://stackoverflow.com/questions/9047090/how-to-sort-hashmap-keys>
		Object[] keys = result.keySet().toArray();
		Arrays.sort(keys);
		// System.out.println("keys list: " + Arrays.toString(keys));

		for(Object key : keys) {			
			ArrayList<String> messages = result.get(key);
			String[] words = messages.get(0).split(",");

			System.out.println("Class: " + words[0] + " " + words[1]);
			System.out.println("\tSLOC: " + words[2]);
			System.out.println("\tSLOC (excluding comments): " + words[3]);
		}

		System.out.println("Total SLOC: " + totalSLOC);
		System.out.println("Total SLOC (excluding comments): " + totalSLOCE);
	
		// 5) the absolute path of all invalid classes found.
		System.out.println("Invalid Classes: ");
		for(String s: invalidPath){
			System.out.println(s);
		}
		
		
	}



	/**
	method to get class filename and its absolute path.
	**/
	public static HashMap<String, ArrayList<String>> classSearch(String directory){
		
		// create a new hashmap
		HashMap<String, ArrayList<String>> classInformation = new HashMap<String, ArrayList<String>>();

		classSearch(new File(directory), classInformation);

		return classInformation;
	}

	// helper method
	private static void classSearch(File input, HashMap<String, ArrayList<String>> nameAndAddress){
		if(input.isFile()){
			String getFile = input.getName();
			//String fileName = getFile.substring(0, getFile.lastIndexOf(".")-1);
			String address = input.getAbsolutePath();


			if(nameAndAddress.containsKey(getFile)){
				ArrayList<String> absolutePath = nameAndAddress.get(getFile);
				absolutePath.add(address);
				nameAndAddress.put(getFile,absolutePath);
			} else{
				//create a new list
				//add address to new list
				//put getFile, address into map
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(address);
				nameAndAddress.put(getFile, newList);
				}
		} else if(input.isDirectory()){		// else if input is a directory

			// open and count files in direatory each item inside
			File[] list = input.listFiles();
			for(int i = 0; i < list.length; i++){
				classSearch(list[i], nameAndAddress);		// countFiles(input, nameAndAddress)
			}
		}
	}
}