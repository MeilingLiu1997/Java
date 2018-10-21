/**
	this class is the main class,
	which display the menu and call all methods
	@Author Meiling Liu
**/
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class MusicPlayerDriver {
	public static void main(String[] args){
		// open and find mp3 file
		if(args.length != 1) {					
			System.out.println("Please follow this direction: java FileFinder <absolute_path>, for example java java MusicPlayerDriver /Users/srollins/mymusic.");
			System.exit(1);				
		}

		Scanner in = new Scanner(System.in);
		displayMenu();

		OpenMP3Files builder = new OpenMP3Files();
		FindMP3Files map = new FindMP3Files();
		HashMap<String, String> resultList = map.findFiles(args[0]);
		
		PlayMP3 playMp3 = new PlayMP3(resultList);
		Sort list = builder.buildSort(resultList);


		System.out.print("Your option: ");
		int enterNum = in.nextInt();

		while(enterNum != 5) {
			if(enterNum == 1){
				// sorted by artist
				list.sortedArtist();

			} else if(enterNum == 2) {
				// sorted by title
				list.sortedTitle();
			} else if(enterNum == 3) {
				// play mp3
				System.out.println("Please choose your song: ");
				playMp3.mP3Player();
		
			} else if(enterNum == 4) {
				// stop playback
				playMp3.stop();
			} else {
				System.out.println("\n" + "Invalid input." + "\n"
									+ "Please enter a number between 1-5.");
			}

			displayMenu();
			System.out.print("Your option: ");
			enterNum = in.nextInt();
		}
		
	}


	public static void displayMenu(){
		System.out.println("Please choose your option: " + "\n"
							+ "================" + "\n"
							+ "1. List all MP3s sorted by artist." + "\n"
							+ "2. List all MP3s sorted by title." + "\n"
							+ "3. Play MP3." + "\n"
							+ "4. Stop playback." + "\n"
							+ "5. Exit.");

	}
}