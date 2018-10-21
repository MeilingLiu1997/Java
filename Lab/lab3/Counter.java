/**
	A class that represent the Counter' detail information

	@author Meiling Liu
**/
public class Counter
{
	// data members
	private int track;



	// constructor
	//A constructor will initialize the data member to 0
	public Counter(){
		this.track = 0;
	}


	// implement the following methods:

	// click takes no input, returns nothing, and increases the count
	public void click(){
		this.track ++;
	}

	// getCount takes no input and returns the current count
	public int getCount(){
		return this.track;
	}

	// reset takes no input, returns nothing, and resets the counter to 0
	public void reset(){
		this.track = 0;
	}

}