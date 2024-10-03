import java.util.Random;
import java.util.Scanner;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class LinkedList {
	private Node head;
	private Node tail;
	
	private int size;
	Clip currentClip;
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void fillLinkedList(int N, Song[] songs) {
		
		for (int i = 0; i < N; i ++) {
			Random rand = new Random();
			int j = rand.nextInt(20);
			while (songs[j] == null) {
				j = rand.nextInt(20);
			}
			Node newNode = new Node(songs[j].getTitle(), songs[j].getArtist(), songs[j].getFilePath());
			insert(newNode, this.size + 1);
			songs[j] = null;
			
		}
		
	}
	
	public void insert(Node newNode, int n) {
		
		if(this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
		}
		else if(n == 1) {
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
		}
		else if(n == this.size + 1) {
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			this.tail = newNode;
		}
		else { 
			
			Node current = this.head;
			for(int i = 0; i < n - 1; i++) {
				current = current.getNext();
			}
			Node prevNode = current.getPrev();
			current.setPrev(newNode);
			newNode.setNext(current);
			prevNode.setNext(newNode);
			newNode.setPrev(prevNode);
		}
		
		head.setPrev(tail);
		tail.setNext(head);
		
		this.size++;
	}
	

	
	
	public int getSize() {
		return this.size;
	}
 
	public String songData(int i) {
		String output = "";
		Node current = head;
		for (int j = 0; j < i; j++) {
			current = current.getNext();
		}
			output = current.getTitle() + " by " + current.getArtist();
			
		
		return output;
	}
	
	public void playSong(int i) {
		Node current = head;
		for (int j = 0; j < i; j++) {
			current = current.getNext();
		}
		File musicPath = new File(current.getFilePath());
		
		System.out.println(current.getFilePath());
		
		try {
					
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
			currentClip = AudioSystem.getClip();
			currentClip.open(audioInput);
			currentClip.start();
					
			Scanner s = new Scanner(System.in);
			System.out.println("Press 1 to stop");
			
					
		}catch (Exception e) {
			System.out.println("Error playing music...");
			System.out.println(e);
		}
	}
	
	public void nextSong() {
		System.out.println("Going to next song");
		tail = head;
		head = head.getNext();
		
	}
	
	public void previousSong() {
		System.out.println("Going to previous song");
		head = tail;
		tail = tail.getPrev();
	}
	
	public void removeCurrentSong() {
		
		if (this.size == 3) {
			head = head.getNext();
			head.setPrev(tail);
			head.setNext(tail);
			tail.setNext(head);
			
			size--;
		} else if (this.size == 2) {
			head = tail;
			head.setNext(head);
			head.setPrev(head);
			
			size--;
		} else if (this.size > 3) {
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
		} else if (this.size == 1) {
			System.out.println("Playlist is empty. Ending program...");
			System.out.println("Thanks for listening!");
			size--;
		}
	}
}
