/**
	this class is collecting all class under the input directory
	@Author Meiling Liu
**/
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class ClassList{
	
	public static ArrayList<String> listOfAllClass(String directory){
		ArrayList<String> newList = new ArrayList<String>();

		listOfAllClass(new File(directory), newList);
		return newList;
	}

	private static void listOfAllClass(File input, ArrayList<String> list){
		if(input.isFile()){
			String fileName = input.getName();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			if(extension.equals("java")){
				list.add(fileName);
			}
			
		} else if(input.isDirectory()){

			File[] listUnderD = input.listFiles();
			for(int i = 0; i < listUnderD.length; i++){
				listOfAllClass(listUnderD[i], list);		// countFiles(input, map)
			}

		}

	}
}