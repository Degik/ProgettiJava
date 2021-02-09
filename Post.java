package Progetto1;

/*
 * Davide Bulotta
 * Matr. 596782
 * d.bulotta@studenti.unipi.it
 */

import java.util.*;

// Post genera oggetti mutabili (modifiche sui like consentite)
public class Post {
	//
	public static final int THRESHOLD = 140;
	
	// id: identificatore univoco del post => Due post sono uguali se e solo se hanno lo stesso id.
	private int postId;			// postid = 7
	//private String author;	// author = "Mario Rossi"
	private int userId;		// userId = 9
	private String text;	// text = "In quel ramo del lago di Como..."
	private long timestamp;	// timestamp = 5416518465132 (millisecondi trascorsi da una certa data...)
	private static int nextId;
	
	private Set<Integer> likes; // contiene gli id degli utenti che hanno messo 'mi piace' al post
	
	public Post(int userId, String text, long timestamp) {
		this.userId = userId;
		if(text.length() > THRESHOLD)
			throw new IllegalArgumentException("Testo troppo lungo (più di 140 caratteri).");
		this.text = text;
		this.timestamp = timestamp;
		this.postId=nextId;
		
		this.likes = new HashSet<>();
		
		nextId++;
	}// Costruttore
	
	public Post(int postId, int userId, String text, long timestamp) {
		this.userId = userId;
		if(text.length() > THRESHOLD)
			throw new IllegalArgumentException("Testo troppo lungo (più di 140 caratteri).");
		this.text = text;
		this.timestamp = timestamp;
		this.postId=postId;
		
		this.likes = new HashSet<>();
	}// Costruttore che passa il postId
	//
	//
	/*
	private Map<Integer, Set<Integer>> postFollowers;
	
	public Post() {
		postFollowers = new HashMap<>();
	}
	
	public Map<Integer, Set<Integer>> guessPostFollowers(List<Post> ps){
		
	}
	
	public boolean addFollowers() {
		
	}*/
	
	public Post(Post p) {
		this(p.postId,p.userId,p.text,p.timestamp);
		this.likes = new HashSet<>(p.likes);
	}// Costruttore copia
	
	public int getId() { return postId; }
	
	public int getUserId() { return userId; }
	
	public String getText() { return text; }
	
	public void setText(String text) {
		if(text==null) {
			throw new NullPointerException("Non puoi con un text null");
		}
		this.text = text;
	}
	
	public long getTimestamp() { return timestamp; }
	
	public HashSet<Integer> getLikes() {
		return new HashSet<>(likes);
	}// getLikes
	
	public boolean containsLike(int userId) {
		return likes.contains(userId);
	}
	
	public boolean containsLike(User u) {
		if(u==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		return likes.contains(u.getId());
	}
	
	public boolean addLike(int userId) {
		return likes.add(userId);
	}
	
	public boolean addLike(User u) {
		if(u==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		return likes.add(u.getId());
	}
	
	public boolean removeLike(int userId) {
		return likes.remove(userId);
	}
	
	public boolean removeLike(User u) {
		if(u==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		return likes.remove(u.getId());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(this==o) return true;
		if(!(o instanceof Post)) return false;
		Post p = (Post) o;
		return postId==p.postId;
	}// equals
	
	@Override
	public int hashCode() {
		return postId;
	}// hashCode
	
	@Override
	public String toString() {
		Date date = new Date(timestamp);
		return "(postId: " + postId + ", userId: " + userId + ", text: " + text + ", timestamp: " + date + ")";
	}// toString
	
}// Post