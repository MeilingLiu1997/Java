/**
	This class will print the contents of the HashMap
	The HashMap will map String objects representing file extensions 
	(e.g., jpg or doc) to a count of the number of files found with that extension.

	Author @Meiling Liu
**/
import java.io.File;
import java.util.HashMap;


public class FileFinder{


	// The findFiles method takes as input a String representing the absolute path to a directory 
	// and recursively traverses the directory and all directories below it. 
	// It returns a HashMap that maps file extensions to a count of the number of files found with that extension.

	public static HashMap<String, Integer> findFiles(String directory){
		
		// create a new hashmap
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		findFiles(new File(directory), map);

		return map;
	}	

	// helper method
	private static void findFiles(File input, HashMap<String, Integer> map){

		// if input is a file
		if(input.isFile()){	// base case

			String fileName = input.getName();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

			// count file
			// if this is the first file seen
			if(map.containsKey(extension)){
				int value = map.get(extension);
				map.put(extension, value + 1);
			} else {
				map.put(extension, 1);
			}


		} else if(input.isDirectory()){		// else if input is a directory

			// open and count files in direatory each item inside
			File[] list = input.listFiles();
			for(int i = 0; i < list.length; i++){
				findFiles(list[i], map);		// findFiles(input, map)
			}
		}


	}

	// Remember that if you pass a HashMap to a method any changes made by the method will be made to the original map.

	
	//The main method will call a method and then print the contents of the HashMap
	public static void main(String[] args){
		if(args.length != 1) {					
			System.out.println("Please follow this direction: java FileFinder <absolute_path>, for example java FileFinder /Users/srollins/teaching/cs112.");
			System.exit(1);				
		}

		HashMap<String, Integer> resultList = new HashMap<String, Integer>();
			
		findFiles(new File(args[0]), resultList);

		for(String key: resultList.keySet()){
			System.out.println("File extension: " + key);
			
			System.out.println("\thas " + resultList.get(key) + " files.");
			
		}

	}	
}