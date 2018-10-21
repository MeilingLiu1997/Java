/**
	A class that contain a default constructor and one method defined

	@author Meiling Liu
**/

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class PokedexBuilder
{
	public Pokedex buildPokedex(String filename){

		//create list to be returned
		Pokedex list = new Pokedex();  		//Instantiate a new Pokedex.

		//open file
		File inputFile = new File(filename); //Create a File with the given filename.


		//read in each line of file
		try(Scanner input = new Scanner(inputFile)) {  //Create a new Scanner to read input from the file

			input.useDelimiter(",|\n");    //Specify that that Scanner will useDelimiter(",|\n"). This indicates that the newline character as well as the comma (,) will separate tokens read by the Scanner.

			while(input.hasNext()) { 
				String line = input.nextLine(); // Read in the first line and ignore it.
				int id = input.nextInt();
				String species = input.next(); //Use the Scanner next and nextInt methods to read in all data from the next line.
				int species_id = input.nextInt();
				int height = input.nextInt();
				int weight = input.nextInt(); 
				int experience = input.nextInt(); 
				int order = input.nextInt();
				int favorite = input.nextInt();

				//	Create a new Pokemon containing the data specified.
				Pokemon pokemon = new Pokemon(species, height, weight, experience);
				//	Add the Pokemon to the Pokedex.
				list.addPokemon(pokemon);
				
			}


		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return null;  // If a FileNotFoundException is generated, return null.
		}
		

		//Return the list.
		return list;


	}


}