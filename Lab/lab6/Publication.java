/**
	This class is an abstract base class, comparing two objects
	@author Meiling Liu
**/
public abstract class Publication implements Comparable<Publication>{

	// two properties
	protected String title;
	protected int numOfPages;

	public Publication(String title, int numOfPages){
		this.title = title;
		this.numOfPages = numOfPages;
	}

	
	public String getTitle(){
		return this.title;
	}

	public int getNumOfPages(){
		return this.numOfPages;
	}

	public String toString(){
		return "Title: " + title +
				" Number of pages: " + numOfPages;
	}

	// two Publication objects are compared by comparing their numOfPages properties.

	public int compareTo(Publication input){
		if(this.numOfPages == input.getNumOfPages()){
			return 0;
		} else {
			return (this.numOfPages - input.getNumOfPages());
		}
	}


}