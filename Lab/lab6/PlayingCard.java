/**
	This class that represents the main method of running process.
	@author Meiling Liu
**/
public class PlayingCard implements Comparable<PlayingCard>{

	// data members
	protected int value;
	protected String suit;
	protected String color;

	// constructor
	public PlayingCard(int value, String suit, String color){
		this.value = value;
		this.suit = suit;
		this.color = color;
	}


	// getters
	public int getValue(){
		return this.value;
	}

	public String getSuit(){
		return this.suit;
	}

	public String getColor(){
		return this.color;
	}


	// methods
	public String toString(){
		if(value < 11){
			return "Value: " + value + " Suit: " + suit + " Color: " + color;
		} else if (value == 11){
			return "Career: Jack" + " Suit: " + suit + " Color: " + color;
		} else if (value == 12){
			return "Career: Queen" + " Suit: " + suit + " Color: " + color;
		} else if (value == 13){
			return "Career: King" + " Suit: " + suit + " Color: " + color;
		} else{
			return "Input invaild.";
		}
	}


	// To compare two PlayingCard objects you will compare the value
	public int compareTo(PlayingCard input){

			if(this.value == input.getValue()){		// If the values are the same

			// the cards will be sorted according to spades, hearts, diamonds, and clubs
			int suitResult = this.suit.compareTo(input.getSuit());
			
			return 0 - suitResult;

			} else {

				return (this.value - input.getValue());
			}
		

	}


}






