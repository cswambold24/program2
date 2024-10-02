import java.util.Random;

public class LinkedList {
	private Node head;
	private Node tail;
	
	private int size;
	
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
}
