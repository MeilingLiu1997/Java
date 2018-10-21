/**
	this class will open valid mp3 files
	Author@Meiling Liu
**/
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class OpenMP3Files {
	public Sort buildSort(HashMap<String, String> resultList) {
		Sort list = new Sort();

		try{
			for(String key: resultList.keySet()){
				//create an audio file
				AudioFile f = AudioFileIO.read(new File(resultList.get(key)));
				//get the tag object
				Tag tag = f.getTag();
				//get the various fields from the tag
				String title = tag.getFirst(FieldKey.TITLE);
				String artist = tag.getFirst(FieldKey.ARTIST);

				//	Create a new MP3File to collect information
				MP3File mp3File = new MP3File(key, artist, title);
				list.addFiles(mp3File);
			}

		} catch (CannotReadException cre){
			System.out.println("File cannot read.");
			System.out.println(cre.getMessage());
            System.exit(1);
        } catch (FileNotFoundException fnf){
			System.out.println("File not found.");
            System.out.println(fnf.getMessage());
            System.exit(1);
		} catch (IOException ie){
			System.out.println(ie.getMessage());
            System.exit(1);
		} catch (Exception e){
			System.out.println(e.getMessage());
            System.exit(1);
		}

		return list;
	}
}