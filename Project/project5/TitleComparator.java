/**
	A class that will compare Title for sorting

	@Author Meiling Liu
**/
import java.util.Comparator;

public class TitleComparator implements Comparator<MP3File> {
	
	public int compare(MP3File input, MP3File input1){
		return (input.getTitle()).compareTo(input1.getTitle()); 
	}
}