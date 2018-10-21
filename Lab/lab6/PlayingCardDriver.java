/**
	This class is a test "class PlayingCard" file.
	@author Meiling Liu
**/
import java.util.ArrayList;
import java.util.Collections;


public class PlayingCardDriver{
	public static void main(String[] args) {

		// 1. create an ArrayList of at least five PlayingCard objects
		ArrayList<PlayingCard> cardsObjects = new ArrayList<PlayingCard>();

		cardsObjects.add(new PlayingCard(9, "spades", "black"));
		cardsObjects.add(new PlayingCard(5, "diamonds", "red"));
		cardsObjects.add(new PlayingCard(4, "hearts", "red"));
		cardsObjects.add(new PlayingCard(5, "clubs", "black"));
		cardsObjects.add(new PlayingCard(4, "spades", "black"));
		cardsObjects.add(new PlayingCard(13, "diamonds", "red"));
		cardsObjects.add(new PlayingCard(11, "clubs", "black"));
		cardsObjects.add(new PlayingCard(12, "diamonds", "red"));



		// 2. use Collections.sort to sort the cards
		Collections.sort(cardsObjects);

		for(PlayingCard s: cardsObjects){

			System.out.println(s);		// 3. print the result to standard output.

		}


	}
}