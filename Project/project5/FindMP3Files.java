/**
	this class will find valid mp3 files,
	and add into HashMap
	Author@Meiling Liu
**/
import java.io.File;
import java.util.HashMap;

public class FindMP3Files {
	/**
	the program will recursively traverse the given directory and build a list of all MP3 files 
	that appear in the directory or any directory that is a descendant of the directory provided.
	**/
	public static HashMap<String, String> findFiles(String directory){
		
		// create a new hashmap
		HashMap<String, String> map = new HashMap<String, String>();

		findFiles(new File(directory), map);

		return map;
	}	

	// helper method
	private static void findFiles(File input, HashMap<String, String> map){

		// if input is a file
		if(input.isFile()){	// base case

			String fileName = input.getName();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			String address = input.getAbsolutePath();

			if(extension.equals("mp3")){

				map.put(fileName, address);
			}
		} else if(input.isDirectory()){		// else if input is a directory

			// open and count files in direatory each item inside
			File[] list = input.listFiles();
			for(int i = 0; i < list.length; i++){
				findFiles(list[i], map);		// findFiles(input, map)
			}
		}
	}
}