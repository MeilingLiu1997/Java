/**
	A class that represent the Pokemons' detail information
	@author Meiling Liu
**/
public class Pokemon
{
	// data members
	private String species;
	private int experience;
	private boolean favorite;

	// constructor
	//A constructor that takes as input species, experience, and favorite
	public Pokemon(String species, int experience, boolean favorite){
		this.species = species;
		this.experience = experience;
		this.favorite = favorite;
	}


	//A constructor that takes as input species and experience and sets favorite to be a default value
	public Pokemon(String newSpecies, int newExperience){
		this.species = newSpecies;
		this.experience = newExperience;
		this.favorite = true;   // set favorite value always true
	}

	// methods


	// getter method
	public String getSpecies() {
		return this.species;
	}

	public int getExperience() {
		return this.experience;
	}

	public boolean getFavorite() {
		return this.favorite;
	}


	// print
	// e.g. Zubat with Experience 137 - Starred
	public String toString() {
		if(getFavorite()) {
			return this.species + " with Experience " + this.experience + " - " + "Starred\n";	
		} else {
			return this.species + " with Experience " + this.experience + " - " + "Not Starred\n";
		}
		
	}


	// set method for every data member
	// String species; int experience; boolean favorite
	public void setSpecies(String species) {
		this.species = species;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}



}