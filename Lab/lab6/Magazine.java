/**
	This class is a derived class, indicating the number of subscribers
	@author Meiling Liu
**/
public class Magazine extends Publication{

	private int numOfSub;

	public Magazine(String title, int numOfPages, int numOfSub){

		super(title, numOfPages);
		this.numOfSub= numOfSub;
	}

	public int getNumber(){
		return this.numOfSub;
	}


	public String toString(){
		return super.toString() + " Number of Subscribers: " + this.numOfSub;
	}
	
}