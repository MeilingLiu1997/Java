/**
	This class is a test program, teseting Publication.java; Book.java; and Magazine.java
	@author Meiling Liu
**/

import java.util.ArrayList;
import java.util.Collections;


public class LibraryDriver{

	public static void main(String[] args){
		// create Arraylist
		ArrayList<Publication> publicationList = new ArrayList<Publication>();

		publicationList.add(new Book("The Black Book", 448, true));
		publicationList.add(new Magazine("Better Homes and Gardens Magazine", 46, 615614));
		publicationList.add(new Book("The Thirst (Signed Book) (Harry Hole Series #11)", 352, true));
		publicationList.add(new Book("Murder Must Advertise", 328, false));
		publicationList.add(new Book("A Going Concern", 169, false));
		publicationList.add(new Magazine("Entertainment Weekly", 55, 547653));
		publicationList.add(new Magazine("Reader's Digest", 58, 476453));


		// 2. use Collections.sort to sort the publications
		Collections.sort(publicationList);

		// 3. print
		for(Publication p: publicationList){
			System.out.println(p);
		}
	}
	

}