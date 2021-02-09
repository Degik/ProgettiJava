package Progetto1;

// classe immutabile
public class User {	
	private static final String ILLEGAL_USN = "Caratteri non validi!";
	private static final String ILLEGAL_CAP = "CAP non valido!";
	private static final String ILLEGAL_EML = "Indirizzo email non corretto!";
	
	private static final String USERNAME_CONDITION = "@ - ? | = [ ] # § ' ^ + * ° ç ! \" £ $ % & / ( ) ; , : . < > \\ ";
	//private String USERNAME_CONDITION = " @ - ? | = [ ] # § ' ^ + * ° ç ! £ $ % & / ( ) ; , : . < >";
	
	private	String fName;
	private String lName;
	private String username;
	private String password;
	private String city;
	private String email;
	private String pCode;
	private int userId;
	private int userLevel; // 0=amministratore, 1=utente normale
	
	private static int nextId=0;
	//private String[] s = USERNAME_CONDITION.split(" ");
	public User(String fName, String lName, String username, String password, String pCode, String city, String email) {
		this.fName=fName;
		this.lName=lName;
		//USERNAME_CONDITION = " @-?|=[]#§'^+*°ç!"£$%&/();,:.<>\";
		/*if(username.contains(" ")||username.contains("@")||username.contains("-")||username.contains("?")||	//  @-?
				username.contains("|")||username.contains("=")||username.contains("[")||username.contains("]")|| // |=[]
					username.contains("#")||username.contains("§")||username.contains("'")||username.contains("^")|| // #§'^
						username.contains("+")||username.contains("*")||username.contains("°")||username.contains("ç")|| // +*°ç
							username.contains("!")||username.contains("\"")||username.contains("£")||username.contains("$")|| // !"£$
								username.contains("%")||username.contains("&")||username.contains("/")||username.contains("(")|| // %&/(
									username.contains(")")||username.contains(";")||username.contains(",")||username.contains(":")|| // );,:
										username.contains(".")||username.contains("<")||username.contains(">")||username.contains("\\")) // .<>\
			throw new IllegalArgumentException(ILLEGAL_USN);*/
		// Il for qui sotto è una soluzione molto più pulita
		
		String[] s = USERNAME_CONDITION.split(" ");
		for(int i=0; i<s.length; i++) {
			if(username.contains(s[i]))
				throw new IllegalArgumentException(ILLEGAL_USN);
		}
		
		
		this.username=username;
		this.password=password;
		if(username.equals("Admin")) {
			this.userLevel=0;
		}else {
			this.userLevel=1;
		}
		if(pCode.length()!=5)
			throw new IllegalArgumentException(ILLEGAL_CAP);
		this.pCode=pCode;
		this.city= city;
		if(!email.contains("@"))
			throw new IllegalArgumentException(ILLEGAL_EML);
		this.email=email;
		this.userId=nextId;
		nextId++;
	}// Costruttore
	
	// Costruttore contentenete userId
	public User(int userId, String fName, String lName, String username, String password, String pCode, String city, String email) {
		this.fName=fName;
		this.lName=lName;
		//USERNAME_CONDITION = " @ - ? | = [ ] # § ' ^ + * ° ç ! " £ $ % & / ( ) ; , : . < > \ ";
		/*if(username.contains(" ")||username.contains("@")||username.contains("-")||username.contains("?")||	//  @-?
				username.contains("|")||username.contains("=")||username.contains("[")||username.contains("]")|| // |=[]
					username.contains("#")||username.contains("§")||username.contains("'")||username.contains("^")|| // #§'^
						username.contains("+")||username.contains("*")||username.contains("°")||username.contains("ç")|| // +*°ç
							username.contains("!")||username.contains("\"")||username.contains("£")||username.contains("$")|| // !"£$
								username.contains("%")||username.contains("&")||username.contains("/")||username.contains("(")|| // %&/(
									username.contains(")")||username.contains(";")||username.contains(",")||username.contains(":")|| // );,:
										username.contains(".")||username.contains("<")||username.contains(">")||username.contains("\\")) // .<>\
			// Il for qui sotto è una soluzione molto più pulita
			throw new IllegalArgumentException(ILLEGAL_USN);*/
		
		//String USERNAME_CONDITION = "@ - ? | = [ ] # § ' ^ + * ° ç ! \" £ $ % & / ( ) ; , : . < > \\ ";
		String[] s = USERNAME_CONDITION.split(" ");
		for(int i=0; i<s.length; i++) {
			if(username.contains(s[i]))
				throw new IllegalArgumentException(ILLEGAL_USN);
		}
		this.username=username;
		this.password=password;
		if(username=="Admin") {
			this.userLevel=0;
		}else {
			this.userLevel=1;
		}
		if(pCode.length()!=5)
			throw new IllegalArgumentException(ILLEGAL_CAP);
		this.pCode=pCode;
		this.city= city;
		if(!email.contains("@"))
			throw new IllegalArgumentException(ILLEGAL_EML);
		this.email=email;
		this.userId=userId;
	}// Costruttore id
	
	public User(User u) {
		this(u.userId, u.fName, u.lName, u.username, u.password, u.pCode, u.city, u.email);
	}
	
	public int getId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String pass) {	// Modifica Password
		if(pass==null) {
			throw new NullPointerException("Non puoi con una pass null");
		}
		this.password=pass;
	}
	
	public void setUsername(String username) {	// Modifica Username
		if(username==null) {
			throw new NullPointerException("Non puoi con un username null");
		}
		this.username=username;
	}
	
	public void setEmail(String email) {	// Modifica Email
		if(email==null) {
			throw new NullPointerException("Non puoi con una email null");
		}
		this.email=email;
	}
	
	public void setRole(boolean b) {
		if(b) {
			this.userLevel=1;
		}else {
			this.userLevel=0;
		}
	}
	
	public boolean isAdmin() {
		return userLevel==0;
	}
	
	public boolean checkPassword(String pass) {	// Essendo poco sicuro realizzare un getPassword, utilizzo questa funzione per la verifica
		if(pass==null) {
			throw new NullPointerException("Non puoi con una password null");
		}
		return pass.equals(password);
	}
	
	@Override
	public String toString() {
		String role;
		if(this.isAdmin()) {
			role = "Amministratore";
		}else {
			role = "Utente";
		}
		String s = "Dati utente= ([Nome: " + fName + "], [Cognome: " + lName + "], [Username: " + username + "], [email: " + email + "], [CAP: " + pCode + "], [Città: " + city + "], [Ruolo: " + role + "])";
		return s;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(this==o) return true;
		if(!(o instanceof User)) return false;
		User us = (User) o;
		return userId==us.userId;
	}
	
	@Override
	public int hashCode() {
		return userId;
	}
}
