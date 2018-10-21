/**
	this class will play mp3 files and stop playback
	Author@Meiling Liu
**/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.util.HashMap;
import java.util.Scanner;


public class PlayMP3 {
	private HashMap<String, String> resultList;
	private Player player;
	private boolean playerStatus = false;

	public PlayMP3(HashMap<String, String> resultList){
		this.resultList = resultList;
	}

	public void stop(){
		if(playerStatus == true){
			player.close();
		}
	}
	
	public void mP3Player(){
		try {
			int count = 0;
			HashMap<Integer, String> songMap = new HashMap<Integer, String>();


			//create a new player for specific mp3 file
			for(String fileName: resultList.keySet()){
				count++;
				songMap.put(count, resultList.get(fileName));
				System.out.println(count + ". " + fileName);

			}
			Scanner in = new Scanner(System.in);
			System.out.print("Play song NO. ");
			int newEnter = in.nextInt();

			if(newEnter <= count){
				for(Integer key: songMap.keySet()){
					if(newEnter == key){
						if(playerStatus == true){
							player.close();
							playerStatus = false;
						}
						player = new Player(new FileInputStream(songMap.get(key)));
						Thread t = new Thread() {
						    public void run() {
						        try {
						            player.play();
						        } catch(Exception e) {
						            e.printStackTrace();
						        }
						    }
						}; 
						t.start();
						playerStatus = true;
					} 
				}
			}

			if(newEnter > count){
				System.out.println("Invalid enter, go back to the menu and please choose again.");
			}
		} catch (FileNotFoundException fnf){
			System.out.println("File not found.");
            System.out.println(fnf.getMessage());
            System.exit(1);
		} catch (Exception e){
			System.out.println(e.getMessage());
            System.exit(1);
		}
				
	}
		
}