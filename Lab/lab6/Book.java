/**
	This class is a derived class, indicating whether it is a hard or soft cover book. 
	@author Meiling Liu
**/
public class Book extends Publication{

	private boolean hardness;

	public Book(String title, int numOfPages, boolean hardness){
		super(title, numOfPages);
		this.hardness = hardness;
	}

	public boolean getHardness(){
		return this.hardness;
	}


	public String toString(){
		if(hardness == true){
			return super.toString() + " Hardcover";
		} else{
			return super.toString() + " Softcover";
		}
	}
}