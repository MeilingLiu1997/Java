/**
	A class that will support a constructor that takes initial values for all data members

	@author Meiling Liu
**/
public class Pokemon
{
	//data members

	private String species; // e.g., zubat
	private int height; // an integer value
	private int weight; // an integer value
	private int experience; // denoted as base_experience in the data files
	private boolean favorite;

	// constructor
		// a constructor that takes initial values for all data members
	public Pokemon(String species, int height, int weight, int experience){
		this.species = species;
		this.height = height;
		this.weight = weight;
		this.experience = experience;
		this.favorite = false; // have to use int because there is some numbers in the input file of this part.
	}


	// methods

	// get methods for all data members
	public String getSpecies(){
		return this.species;
	}

	public int getHeight(){
		return this.height;
	}

	public int getWeight(){
		return this.weight;
	}

	public int getExperience(){
		return this.experience;
	}

	public boolean getFavorite(){
		return this.favorite;
	}


	///a toString method that returns a String
	// <species>(<height>, <weight>) with experience <experience> - [Not] Starred
	public String toString() {
		if(getFavorite()) {
			return this.species + "(" + this.height + ", " + this.weight + ") with Experience " + this.experience + " - Starred";	
		} else {
			return this.species + "(" + this.height + ", " + this.weight + ") with Experience " + this.experience + " - Not Starred";
		}
		
	}
	// nidoqueen(13, 600) with experience 227 - Not Starred
	// jumpluff(8, 30) with experience 207 - Starred








}