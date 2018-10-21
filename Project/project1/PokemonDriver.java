/**
	A class that will implement the main method

	@author Meiling Liu
**/


public class PokemonDriver
{
	public static void main(String[] args) 
	{


		PokedexBuilder builder = new PokedexBuilder();    //Create a new PokedexBuilder.

		//verify command line argument provided
		//If the file name parameter is not present, print an error message and exit the program.
		if(args.length != 1) {					
			System.out.println("usage: java FileInputCSV <filename>");
			System.exit(1);				
		}

		//Invoke the buildPokedex method and save the Pokedex returned in a temporary variable.
		String filename = args[0];
		Pokedex list = builder.buildPokedex(filename);
		
		//If the Pokedex is null (for example, because the file was not found), print an error message and exit the program.
		if(list == null){
			System.out.println("File Not Found.");
			System.exit(1);	
		}

		//Display the string All Pokemon:.
		System.out.println("All Pokemons: \n" + list.toString());    //Use the Pokedex.toString method to display the entire Pokedex.

		//Display the result of the averageHeight method
		System.out.printf("Average Height: %3.1f\n", list.averageHeight());

		//Display the result of the averageWeight method
		System.out.printf("Average Weight: %3.1f\n", list.averageWeight());

		//Display the result of the averageExperience method
		System.out.printf("Average Experience: %3.1f\n", list.averageExperience());

		//Display the result of the tallest method 
		System.out.println("Species of Tallest: " + list.tallest());

		//Display the result of the smallest method
		System.out.println("Species of Smallest: " + list.smallest());
		
		//Display the result of the mostExperienced method 

		//Use iteration and the Pokemon.toString method to display information about all Pokemon returned by the mostExperienced method.

		//Scanner in = new Scanner(System.in);
		System.out.println("Pokemon with experience greater than 200: ");
		//int enterNum = in.nextInt();

		for(Pokemon pokemon: list.mostExperienced(200)){
			System.out.println(pokemon.toString());
		}




	}

}