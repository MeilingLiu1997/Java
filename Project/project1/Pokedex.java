/**
	A class that implement a default constructor

	@author Meiling Liu
**/
import java.util.ArrayList;
import java.util.Scanner;



public class Pokedex
{
	//data members - a list
	private ArrayList<Pokemon> pokemons;// An ArrayList containing objects of type Pokemon.


	// constructor
	public Pokedex(){
		this.pokemons = new ArrayList<Pokemon>();
	}


	// methods
	public void addPokemon(Pokemon pokemonToAdd){  // Takes as input a Pokemon object

		this.pokemons.add(pokemonToAdd); // adds pokemon to the ArrayList of pokemon
	}
	

	public String toString(){	//Returns a string representation of the Pokedex
		String returnVal = "";

		//build the string
		for(Pokemon pokemon: this.pokemons){
			returnVal += pokemon.toString() + "\n";
		}
		return returnVal;
	} 


	public double averageHeight(){
		double total = 0;
		//int total = 0;

		for(Pokemon pokemon: this.pokemons){
			total += pokemon.getHeight();// add all heights to total
		}

		// divide total by number of students
		double result = total / pokemons.size();
		//double result = ((double)total) / pokemons.size();

		// Returns the average height of all Pokemon in the Pokedex.
		return result; 
	} 


	public double averageWeight(){
		int total = 0;

		for(Pokemon pokemon: this.pokemons){
			total += pokemon.getWeight();
		}

		double result = ((double)total) / pokemons.size();

		// Returns the average weight of all Pokemon in the Pokedex.
		return result; 
	} 


	public double averageExperience(){
		double total = 0;

		for(Pokemon pokemon: this.pokemons){
			total += pokemon.getExperience();
		}

		double result = total / pokemons.size();
		
		// Returns the average experience of all Pokemon in the Pokedex.
		return result; 
	} 


	//with the largest height.
	public String tallest(){
		int tallestNum = pokemons.get(0).getHeight();
		String result = pokemons.get(0).getSpecies();

		for(Pokemon pokemon: this.pokemons){
			if(tallestNum < pokemon.getHeight()){
				tallestNum = pokemon.getHeight();
				result = pokemon.getSpecies();
			}
		}

		// Returns the species of the Pokemon with the largest height.
		return result;
	} 

	//with the smallest weight
	public String smallest(){
		String result = pokemons.get(0).getSpecies();
		int smallestItem = pokemons.get(0).getWeight();

		for(Pokemon pokemon: this.pokemons){
			if(smallestItem > pokemon.getWeight()){
				smallestItem = pokemon.getWeight();
				result = pokemon.getSpecies();
			}
		}

		// Returns the species of the Pokemon with the smallest weight.
		return result;
	} 


	public ArrayList<Pokemon> mostExperienced(int level){	//Takes as input an experience level
		ArrayList<Pokemon> mostExperienced = new ArrayList<Pokemon>();


		for(Pokemon pokemon: this.pokemons){
			if(level < pokemon.getExperience()){
				mostExperienced.add(pokemon);
			}
		}
		

		//returns a list of all Pokemon with experience level greater than the level passed as input.
		return mostExperienced;


	} 

}