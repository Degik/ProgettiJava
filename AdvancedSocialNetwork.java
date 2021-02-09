package Progetto1;

import java.util.*;

/*
 * Si richiede di discutete come sia possibile progettare una estensione gerarchica del tipo di dato
 * SocialNetwork che permetta di introdurre un criterio per segnalare contenuti offensivi presenti nella
 * rete sociale. Si presenti la progettazione e realizzazione di almeno una soluzione.
 */
public class AdvancedSocialNetwork extends SocialNetwork {

	private Set<String> blackWords;
	private boolean censored;
	
	public AdvancedSocialNetwork() {
		super();
		blackWords = new HashSet<>();
	}// Costruttore
	
	public AdvancedSocialNetwork(Set<String> blackWords) {
		super();
		this.blackWords = new HashSet<>();
		for(String word: blackWords)
			this.blackWords.add(word.toLowerCase());
		censored = false;
	}// Costruttore
	
	public AdvancedSocialNetwork(AdvancedSocialNetwork asn) {
		super(asn);
		blackWords = new HashSet<>(asn.blackWords);
		censored = false;
	}// Costruttore per copia
	
	
	public AdvancedSocialNetwork(Set<String> blackWords, boolean censored) {
		super();
		this.blackWords = new HashSet<>();
		for(String word: blackWords)
			this.blackWords.add(word.toLowerCase());
		this.censored = censored;
	}// Costruttore
	
	public AdvancedSocialNetwork(AdvancedSocialNetwork asn, boolean censored) {
		super(asn);
		blackWords = new HashSet<>(asn.blackWords);
		this.censored = censored;
	}// Costruttore per copia
	
	public boolean isCensored() { return censored; }
	
	public void setCensored(boolean censored) { this.censored = censored; }
	
	public boolean addBlackWord(String word) {
		return blackWords.add(word.toLowerCase());
	}// addBlackWord
	
	public boolean removeBlackWord(String word) {
		return blackWords.remove(word.toLowerCase());
	}// removeBlackWord
	
	public boolean isBlackWord(String word) {
		return blackWords.contains(word.toLowerCase());
	}// isBlackWord
	
	// Restituisce true se e solo se p contiene almeno una blackWord
	public boolean isBlackPost(Post p) {
		String text = p.getText().toLowerCase();
		for(String bw: blackWords)
			if(text.indexOf(bw)!=-1) {
				return true;
			}
		return false;
	}// isBlackPost
	
	public String replace(Post p) {
		String text = p.getText().toLowerCase();
		String originalText = p.getText();
		for(String bw: blackWords) {
			/*String censored = "";
			for(int i=0; i<bw.length(); i++)
				censored += '*';
			text.replaceAll(bw, censored);*/
			int index = text.indexOf(bw);
			while(index!=-1) {
				int finalIndex = index + bw.length();
				String censored = "";
				for(int i=0; i<bw.length(); i++)
					censored += '*';
				originalText = originalText.substring(0, index) + censored + originalText.substring(finalIndex);
				text = text.substring(0, index) + censored + text.substring(finalIndex);
				index = text.indexOf(bw);
			}
		}
		return originalText;
	}// replace
	
	/*
	// Modifica il testo del post p in input
	public void censura(Post p) {
		String text = p.getText().toLowerCase();
		String originalText = p.getText();
		for(String bw: blackWords) {
//			String censored = "";
//			for(int i=0; i<bw.length(); i++)
//				censored += '*';
//			text.replaceAll(bw, censored);
			int index = text.indexOf(bw);
			while(index!=-1) {
				int finalIndex = index + bw.length();
				String censored = "";
				for(int i=0; i<bw.length(); i++)
					censored += '*';
				originalText = originalText.substring(0, index) + censored + originalText.substring(finalIndex);
				text = text.substring(0, index) + censored + text.substring(finalIndex);
				index = text.indexOf(bw);
			}
		}
		p.setText(originalText);
	}// replace
	*/
	
	/*
	@Override
	public boolean pubblica(Post p, User us) {
		if(censored) {
			censura(p);
		}
		return super.pubblica(p, us);
	}// pubblica
	*/
	
	/*
	public void censura() {
		for(Post p: this.posts) {
			censura(p);
		}
	}// censura
	*/
	
	@Override
	public String toString(Post p) {
		if(!censored)
			return p.toString();
		else {
			String newText = replace(p);
			return "(postId: " + p.getId() + ", userId: " + p.getUserId() + ", text: " + newText + ", timestamp: " + new Date(p.getTimestamp()) + ")";
		}
	}
	
}// AdvancedSocialNetwork
