import java.util.Scanner;

public class Program2Demo {

	public static void main(String[] args) {
		
		Song[] songs = Song.fillArray();
		Scanner input = new Scanner(System.in);
	
		
		System.out.println("How many songs?");
		int N = input.nextInt();
		
		LinkedList playlist = new LinkedList();
		playlist.fillLinkedList(N, songs);
		System.out.println("Here is your playlist:");
		for (int i = 0; i < playlist.getSize(); i++) {
			System.out.println((i+1) + ". " + playlist.songData(i));
		}
		

	}

}
