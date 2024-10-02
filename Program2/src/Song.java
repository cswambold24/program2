import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Song {
	private String title;
	private String artist;
	private String filePath;
	
	public Song(String title, String artist, String filePath) {
		this.title = title;
		this.artist = artist;
		this.filePath = filePath;
	}
	
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getFilePath() {
		return filePath;
	}
	
	public static Song[] fillArray() {
		Song[] songs = new Song[20]; 
		int i = 0;
		try {
			Scanner input = new Scanner(new FileReader("songs.txt"));
			
			while(input.hasNext()) {
				
				String line = input.nextLine();
				String[] values = line.split(",");
				
				String title = values[0];
				String artist = values[1];
				String filePath = values[2];
				
				songs[i] = new Song(title, artist, filePath);
				i++;				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		return songs;
	}
}
