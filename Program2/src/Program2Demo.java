import java.util.Scanner;

public class Program2Demo {

	public static void main(String[] args) {
		
		Song[] songs = Song.fillArray();
		Scanner input = new Scanner(System.in);
	
		
		System.out.println("How many songs?");
		int N = input.nextInt();
		
		LinkedList playlist = new LinkedList();
		playlist.fillLinkedList(N, songs);
		
		//create menu
		System.out.println("Here is your playlist:");
		for (int i = 0; i < playlist.getSize(); i++) {
			System.out.println((i+1) + ". " + playlist.songData(i));
		}
		
		do {
			
			System.out.println("---------------");
			System.out.println("Current Song: ");
			System.out.println(playlist.songData(0));
			System.out.println("---------------");
			System.out.println("1: Play Current Song");
			System.out.println("2: Next Song");
			System.out.println("3: Previous Song");
			System.out.println("4: Remove Current Song");
			System.out.println("5: Quit Playlist");
			int choice = input.nextInt();
			if (choice == 1) {
				playlist.playSong(0);
			} else if (choice == 2) {
				playlist.nextSong();
			} else if (choice == 3) {
				playlist.previousSong();
			}
		} while (playlist.getSize() > 0);
		
		

	}

}
