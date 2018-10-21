/**
	A class that will compare Artist for sorting

	@Author Meiling Liu
**/
import java.util.Comparator;

public class ArtistComparator implements Comparator<MP3File> {
	
	public int compare(MP3File input, MP3File input1){
		return (input.getArtist()).compareTo(input1.getArtist()); 
	}
}