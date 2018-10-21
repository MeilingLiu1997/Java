/**
	A class that will support a constructor that takes initial values for all data members
	MP3 files object

	@Author Meiling Liu
**/

public class MP3File {
	// data member
	private String fileName;
	private String artist;
	private String title;

	// constructor
	public MP3File (String fileName, String artist, String title){
		this.fileName = fileName;
		this.artist = artist;
		this.title = title;
	}

	// methods
	public String getFileName(){
		return this.fileName;
	}

	public String getArtist(){
		return this.artist;
	}
	
	public String getTitle(){
		return this.title;
	}
}