/**
	A class that test class Pokemon 
	@author Meiling Liu
**/
public class PokemonDriver
{
	public static void main (String[] args)
	{

		//create three different Pokemon
		//public Pokemon(String newSpecies, int newExperience, boolean newFavorite)

		Pokemon p1 = new Pokemon("Pikachu", 100000, true);
		Pokemon p2 = new Pokemon("Bulbasaur", 843, false);
		Pokemon p3 = new Pokemon("Mewtwo", 167);
	

	// print 
	// e.g. Zubat with Experience 137 - Starred

		System.out.printf(p1.toString());
		System.out.printf(p2.toString());
		System.out.printf(p3.toString());
		
	
	
	
	}	


	
}