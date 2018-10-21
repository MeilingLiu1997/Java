/**
	this class will list mp3 files
	Author@Meiling Liu
**/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;



public class Sort {
	private ArrayList<MP3File> files;

	public Sort(){
		this.files = new ArrayList<MP3File>();
	}

	public void addFiles(MP3File input){
		this.files.add(input);
	}

	public void sortedTitle(){

		Collections.sort(files, new TitleComparator());

		for(MP3File file: this.files){
			System.out.println("Title: " + file.getTitle() + "\tFile: " + file.getFileName());
		}
	}

	public void sortedArtist(){

		Collections.sort(files, new ArtistComparator());

		for(MP3File file: this.files){
			System.out.println("Artist: " + file.getArtist() + "\tFile: " + file.getFileName());
		}
		
	}
}