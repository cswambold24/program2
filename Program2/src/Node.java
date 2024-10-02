
public class Node {
	private String title;
	private String artist;
	private String filePath;
	
	private Node next;
	private Node prev;
	
	public Node(String title, String artist, String filePath) {
		this.title = title;
		this.artist = artist;
		this.filePath = filePath;
		this.next = null;
		this.prev = null;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public void setNext(Node newNode) {
		this.next = newNode;
	}
	
	public void setPrev(Node newNode) {
		this.prev = newNode;
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
	
}
