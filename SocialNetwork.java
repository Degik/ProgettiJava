package Progetto1;

/*
 * Davide Bulotta
 * Matr. 596782
 * d.bulotta@studenti.unipi.it
 */

import java.util.*;

public class SocialNetwork {
	private static final String USER_FOUND = "Utente trovato.";
	private static final String USER_NOT_FOUND = "Utente non registrato.";
	private static final String POST_NOT_FOUND = "Post non trovato";
	private static final String POST_DELETED = "Post eliminato.";
	private static final String USER_POST_NOT_FOUND = "Utente autore del post non registrato.";
	private static final String ID_POST_ALREADY_EXIST = "Esiste giÃ  un post con questo id = ";
	private static final String USER_OR_FOLLOWER_NOT_FOUND = "Utente o follower non esistenti";
	private static final String NOT_FOLLOW_YOURSELF = "Non puoi seguire te stesso";
	private static final String ALREADY_FOLLOW = " segue giÃ  ";
	private static final String NO_MORE_FOLLOW = " non segue piÃ¹ ";
	private static final String FOLLOWER_NOT_FOLLOW_USER = " non Ã¨ seguito da ";
	private static final String USER_REMOVE_FROM_FOLLOWERS = "Ã¨ stato rimosso dai followers ";
	private static final String ADM_ROLE_NOT_PRESENT = "Non hai il permesso per compiere questa azione";
	private static final String RMV_FOLLOWERS_DONE = "Rimozione dai followers completata!";
	private static final String RMV_POSTS_DONE = "Rimozione dei post completata!";
	private static final String RMV_USERS_DONE = "Utente eliminato correttamente!";
	private static final String CHANGE_ROLE = "Per cambiare il ruolo 1=amministratore 0=utente";
	private static final String CHANGE_ROLE_DONE = "Ruolo utente modificato.";
	
	protected Set<User> users;
	protected Set<Post> posts;
	protected Map<Integer, Set<Integer>> followers;

	public SocialNetwork() {
		users = new HashSet<>();
		posts = new HashSet<>();
		followers = new HashMap<>();
	}// Costruttore di default

	public SocialNetwork(Set<User> users, Set<Post> posts, Map<Integer, Set<Integer>> followers) {
		// Popoliamo this.users in modo da tutelarci dalla possibilitÃ  che User sia
		// mutabile
		this.users = new HashSet<>();
		for (User u : users) {
			User copia = new User(u);
			this.users.add(copia);
		}
		
		// Popoliamo this.posts in modo da tutelarci dalla possibilita' che Post sia
		// mutabile
		this.posts = new HashSet<>(posts);
		for (Post p : posts) {
			Post copia = new Post(p);
			this.posts.add(copia);
		}
		
		this.followers = new HashMap<>();
		for (Integer key : followers.keySet()) {

			Set<Integer> value = followers.get(key);
			Set<Integer> copia = new HashSet<>(value);
			this.followers.put(key, copia);
		}
	}// Costruttore

	public SocialNetwork(SocialNetwork sn) {
		this(sn.users, sn.posts, sn.followers);
	}// Costruttore per copia

	public Set<User> getUtenti() {
		return new HashSet<>(users);
	}// getUtente
	/*
	 * Restituisce il set degli utenti
	 */

	public boolean eRegistrato(User user) {
		if(user==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		return users.contains(user);
	}// eRegistrato
	/*
	 * Verifica in base al'utente se questo Ã¨ registrato
	 */
	
	public boolean eRegistrato(String user) {
		if(user==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		return users.contains(cerca(user));
	}// eRegistrato
	/*
	 * Questo metodo serve in particolare per il loginForm di SocialSystem
	 */
	
	public boolean eRegistrato(int userId) {
		// User dummy = new User(userId, null, null, null, null, null, null, null, null);
		// return users.contains(dummy);
		// Alternativa
		for (User u : users)
			if (u.getId() == userId)
				return true;
		return false;
	}// eRegistrato
	/*
	 * Verifica in base all'userId se questo Ã¨ registrato
	 */
	
	public Set<Post> getPosts() {
		Set<Post> posts = new HashSet<>();
		for(Post p: this.posts)
			posts.add(new Post(p));
		return posts;
	}// getPost

	public Post getPost(int id) {
		for (Post p : posts)
			if (p.getId() == id)
				return new Post(p);
		return null;
	}// getPost
	/*
	 * IF: in base all'id trova se presente il post avente il dato id e lo restituisce
	 * ELSE: non trovandolo ritorna null
	 */
	
	public Post getPostLike(int id) {	// Ho creato questo metodo per sfruttare il suo aliasing
		for (Post p : posts)
			if (p.getId() == id)
				return p;
		return null;
	}

	public Set<Post> getPosts(User user) {
		if(user==null) {
			throw new NullPointerException("Non puoi con un utente null");
		}
		if (!users.contains(user)) {
			System.out.println(USER_NOT_FOUND);
			return null;
		}
		Set<Post> ris = new HashSet<>();
		for (Post p : posts)
			if (p.getUserId() == user.getId())
				ris.add(new Post(p));
		return ris;
	}// getPosts
	/*
	 * IF: verica la mancata presenza dell'utente in questione ritornando in caso la print ed il null
	 * Dopo averlo verificato si porta avanti un for-each del Set ris, che restituirÃ  l'elenco dei post scritti dall'utente
	 */

	public Set<Post> getPosts(int userId) {
		User dummy = new User(userId, null, null, null, null, null, null, null);
		if (!users.contains(dummy)) {
			System.out.println(USER_NOT_FOUND);
			return null;
		}
		Set<Post> ris = new HashSet<>();
		for (Post p : posts)
			if (p.getUserId() == userId)
				ris.add(new Post(p));
		return ris;
	}// getPosts

	public Map<Integer, Set<Integer>> getFollowers() {
		Map<Integer, Set<Integer>> ris = new HashMap<>();
		for (int key : followers.keySet()) {
			Set<Integer> value = followers.get(key);
			Set<Integer> copia = new HashSet<>(value);
			ris.put(key, copia);
		} // for
		return ris;
	}// getFollowers
	/*
	 * Creando una struttura di supporto ris, restituisce la ris evitando aliasing (proprio come nel costruttore)
	 */

	public boolean registraUtente(User user) {
		if(user==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		return users.add(user);
	}// registraUtente
	/*
	 * Registra l'utente nella rete ritornando true se registrato correttamente, altrimenti false
	 */

	public boolean pubblica(Post p, User us) {
		if(us==null||p==null) {
			throw new NullPointerException("Non puoi con user o post null");
		}
		//User dummy = new User(p.getUserId(), null, null, null, null, null, null, null, null);
		if (!users.contains(us)) {
			System.out.println(USER_POST_NOT_FOUND);
			return false;
		}
		if (posts.contains(p)) {
			System.out.println(ID_POST_ALREADY_EXIST + p.getId());
			return false;
		}
		return posts.add(p);
	}// pubblica
	/*
	 * IF: verica la mancata presenza dell'utente in questione ritornando in caso la print ed il false
	 * IF: verifica se il post con dato id e testo Ã¨  giÃ  presente all'interno di posts
	 * Superati tutte le verifiche aggiugne in posts il nuovo post
	 */

	public boolean nuovoFollower(User follower, User user) {
		if(user==null||follower==null) {
			throw new NullPointerException("Non puoi con user o follower null");
		}
		// Controlliamo che follower e utente siano registrati
		if (!users.contains(follower) || !users.contains(user)) {
			System.out.println(USER_OR_FOLLOWER_NOT_FOUND);
			return false;
		}
		if (follower.equals(user)) {
			System.out.println(NOT_FOLLOW_YOURSELF);
			return false;
		}

		if (followers.containsKey(follower.getId())) {
			Set<Integer> seguiti = followers.get(follower.getId());
			if (seguiti.contains(user.getId())) {
				System.out.println(follower + ALREADY_FOLLOW + user + ".");
				return false;
			} else {
				seguiti.add(user.getId());
				return true;
			}
		} else {
			Set<Integer> seguiti = new HashSet<>();
			seguiti.add(user.getId());
			followers.put(follower.getId(), seguiti);
			return true;
		}
	}// nuovoFollower
	/*
	 *  IF: se non sono presenti ne utente o follower, ritorna false
	 *  IF: verifica se utente e follower sono la stessa persona, ritorna false
	 *  IF: verifica se Ã¨ giÃ  presente la chiave follower
	 *  	IF: verifica se follower segue giÃ  utente e ritorna false
	 *  	ELSE: aggiunge utente alla struttura e ritorna true
	 *  ELSE: se non Ã¨ presente la chiave si crea un nuovo hashset e si aggiugono i nuovi elementi ritorna true
	 */
	
	public boolean nuovoFollower(User follower, String us) {
		if(follower==null||us==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		// Controlliamo che follower e utente siano registrati
		if(!eRegistrato(us)) {	// Non genera exceptionNullPointer
			System.out.println(USER_NOT_FOUND);
			return false;
		}
		User user = new User(cerca(us));
		if (!users.contains(follower) || !users.contains(user)) {
			System.out.println(USER_OR_FOLLOWER_NOT_FOUND);
			return false;
		}
		if (follower.equals(user)) {
			System.out.println(NOT_FOLLOW_YOURSELF);
			return false;
		}

		if (followers.containsKey(follower.getId())) {
			Set<Integer> seguiti = followers.get(follower.getId());
			if (seguiti.contains(user.getId())) {
				System.out.println(follower.getUsername() + ALREADY_FOLLOW + user.getUsername() + ".");
				return false;
			} else {
				seguiti.add(user.getId());
				return true;
			}
		} else {
			Set<Integer> seguiti = new HashSet<>();
			seguiti.add(user.getId());
			followers.put(follower.getId(), seguiti);
			return true;
		}
	}// nuovoFollower
	/*
	 * Questo metodo permette a follower di iniziare a seguire us (ricerca del nome)
	 */

	public boolean eliminaUtente(User adm, String user) {
		if(adm==null||user==null) {
			throw new NullPointerException("Non puoi con user o adm null");
		}
		if(!eRegistrato(user)) {
			System.out.println(USER_NOT_FOUND);
			return false;
		}
		if(!adm.isAdmin()) {
			System.out.println(ADM_ROLE_NOT_PRESENT);
			return false;
		}
		User u = new User(cerca(user));
		if(!u.equals(null)) {
			System.out.println(USER_FOUND);
			eliminaDaFollowers(u);		// chiama il metodo per eliminare il set dell'utente da eliminare (chi segue) e dai set di chi lo seguiva
			System.out.println(RMV_FOLLOWERS_DONE);
			eliminaPosts(u);			// elimina tutti i posts scritti dall'utente 
			System.out.println(RMV_POSTS_DONE);
			System.out.println(RMV_USERS_DONE);
			eliminaLikePost(u);
			return users.remove(u);
		}
		System.out.println(USER_NOT_FOUND);
		return false;
	}// eliminaUtente

	private void eliminaDaFollowers(User u) {
		if(u==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		followers.remove(u.getId());
		for (Integer key : followers.keySet()) {
			Set<Integer> value = followers.get(key);
			if (value.contains(u.getId())) {
				value.remove(u.getId());
				if (value.isEmpty())
					followers.remove(key);
			}
		}
	}// eliminaDaFollowers
	/*
	 * Scorre i followers alla ricerca di qualsiasi riferimento all'utente da eliminare
	 */

	private void eliminaPosts(User u) {
		/*
		 * for(Post p: posts) if(p.getUserId()==u.getId()) posts.remove(p);
		 */
		if(u==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post p = it.next();
			if (p.getUserId() == u.getId())
				it.remove();
		} // while
	}// eliminaPosts

	public boolean eliminaPost(User us, Post p) {
		if(us.isAdmin() || p.getUserId()==us.getId()) {
			if(!posts.contains(p)) {
				System.out.println(POST_NOT_FOUND);
				return false;
			}
			System.out.println(POST_DELETED);
			return posts.remove(p);
		}else {
			System.out.println(ADM_ROLE_NOT_PRESENT);
			return false;
		}
	}// eliminaPostAdm
	/*
	 * IF: verifica la mancata presenza di post all'interno di posts e ritorna false;
	 * Rimuove il post
	 */
	
	public boolean eliminaPost(User us, int postId) {
		if(us==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		Post p = getPost(postId);
		if(us.isAdmin() || p.getUserId()==us.getId()) {
			if(!posts.contains(p)) {
				System.out.println(POST_NOT_FOUND);
				return false;
			}
			System.out.println(POST_DELETED);
			return posts.remove(p);
		}else {
			System.out.println(ADM_ROLE_NOT_PRESENT);
			return false;
		}
	}
	/*
	 * 
	 */
	
	public void eliminaLikePost(User us) {
		if(us==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		for(Post p: posts) {
			if(p.containsLike(us)) {
				p.removeLike(us);
			}
		}
	}// Elimino tutte le traccie dai like
	
	public String postUser(int userid) {
		return cerca(userid).getUsername();
	}// postUser
	
	public boolean nonSeguirePiu(User follower, String user) {
		if(user==null||follower==null) {
			throw new NullPointerException("Non puoi con user o follower null");
		}
		if(!eRegistrato(user)) {	// Non genera exceptionNullPointer
			System.out.println(USER_NOT_FOUND);
			return false;
		}
		User utente = new User(cerca(user));
		// Controlliamo che follower e utente siano registrati
		if (!users.contains(follower) || !users.contains(utente)) {
			System.out.println(USER_OR_FOLLOWER_NOT_FOUND);
			return false;
		}
		if (follower.equals(utente)) {
			System.out.println(NOT_FOLLOW_YOURSELF);
			return false;
		}

		Set<Integer> seguiti = followers.get(follower.getId());
		if (seguiti == null || !seguiti.contains(utente.getId())) {
			System.out.println(follower.getUsername() + FOLLOWER_NOT_FOLLOW_USER + utente.getUsername() + ".");
			return false;
		}
		System.out.println(follower.getUsername() + NO_MORE_FOLLOW + utente.getUsername() + ".");
		return seguiti.remove(utente.getId());
	}// nonSeguirePiu
	/*
	 * IF: se non sono presenti ne utente o follower, ritorna false
	 * IF: verifica se utente e follower sono la stessa persona, ritorna false
	 * IF: verifica se all'interno di seguiti Ã¨ contenuto o meno utente, ritorna false
	 * Superate le verifiche rimuove utente
	 */

	public boolean rimuoviFollower(User utente, String fl) {	// rimuove utente dalla liste delle persone che fl segue
		if(utente==null||fl==null) {
			throw new NullPointerException("Non puoi con user o fl null");
		}
		User follower = new User(cerca(fl));
		// Controlliamo che follower e utente siano registrati
		if (!users.contains(follower) || !users.contains(utente)) {
			System.out.println(USER_OR_FOLLOWER_NOT_FOUND);
			return false;
		}
		if (follower.equals(utente)) {
			System.out.println(follower + NOT_FOLLOW_YOURSELF);
			return false;
		}

		Set<Integer> seguiti = followers.get(follower.getId());
		if (seguiti == null || !seguiti.contains(utente.getId())) {
			System.out.println(utente.getUsername() + FOLLOWER_NOT_FOLLOW_USER + follower.getUsername() + ".");
			return false;
		}
		System.out.println(follower.getUsername() + USER_REMOVE_FROM_FOLLOWERS + utente.getUsername() + ".");
		return seguiti.remove(utente.getId());

		// Mario => [Carlo, Luigi, Roberto]
	}// rimuoviFollower
	/*
	 * IF: se non sono presenti ne utente o follower, ritorna false
	 * IF: verifica se utente e follower sono la stessa persona, ritorna false
	 * IF: verifica se all'interno di seguiti Ã¨ contenuto o meno utente, ritorna false
	 * Superate le verifiche rimuove utente
	 */
	
	public Set<String> utentiSeguitiUs(User utente){
		if(utente==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		Set<String> ris = new HashSet<>();
		for(Integer u: followers.keySet()) {
			if(u==utente.getId()) {
				for(Integer fl: followers.get(u)) {
					ris.add(cercaNome(fl));
				}
			}
		}
		return ris;
	}// utentiSeguit
	/*
	 * IF: se non sono presenti ne utente o follower, ritorna null
	 * IF: controlla se Ã¨ presente come chiave utente
	 * Il metodo ritorna HashSet di utente
	 */
	
	public Set<User> utentiSeguiti(User utente) {
		if(utente==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		if (!users.contains(utente)) {
			System.out.println("Utente " + utente + " non registrato.");
			return null;
		}

		if (!followers.containsKey(utente.getId()))
			return new HashSet<>();

		Set<Integer> seguiti = followers.get(utente.getId());
		Set<User> ris = new HashSet<>();
		for (int userId : seguiti)
			ris.add(cerca(userId));

		return ris;
	}// utentiSeguiti
	/*
	 * IF: se non sono presenti ne utente o follower, ritorna null
	 * IF: controlla se Ã¨ presente come chiave utente
	 * Il metodo ritorna HashSet di utente
	 */
	
	public Set<String> utentiSeguiti(String user){
		if(user==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		User us = new User(cerca(user));
		if(!followers.containsKey(us.getId())) {
			return new HashSet<>();
		}
		Set<Integer> seguiti = followers.get(us.getId());
		Set<String> ris = new HashSet<>();
		for(int userId: seguiti) {
			ris.add(cercaNome(userId));
		}
		return ris;
	}// utentiSeguiti
	
	public Set<String> utentiFollower(User us){
		Set<String> ris = new HashSet<>();
		if(!followers.equals(null)) {
			for(Integer u: followers.keySet()) {
				for(Integer fl: followers.get(u)) {
					if(fl==us.getId()) {
						ris.add(cercaNome(u));
						break;
					}
				}
			}
		}
		return ris;
	}// utentiFollower
	/*
	 * Restituisce tutti gli utenti che seguono us
	 */
	
	public String cercaNome(int userId) {
		for(User u: users) {
			if(u.getId()==userId)
				return u.getUsername();
		}
		return null;
	}
	
	public User cerca(int userId) {
		for (User u : users) {
			if (u.getId() == userId)
				return u;
		}
		return null;
	}// Cerca in base all'id
	
	public User cerca(String user) {
		if(user==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		for(User u: users) {
			if(u.getUsername().equals(user))
				return u;
		}
		return null;
	}// Cerca tramite username
	/*
	 * Salva l'utente e lo ritorna
	 */
	
	public Set<User> getFollowers(User utente) {
		if(utente==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		if (!users.contains(utente)) {
			System.out.println("Utente " + utente + " non registrato.");
			return null;
		}

		Set<User> ris = new HashSet<>();
		for (Integer flwr : followers.keySet()) {
			Set<Integer> seguiti = followers.get(flwr);
			if (seguiti.contains(utente.getId()))
				ris.add(cerca(flwr));
		} // for
		return ris;
	}// getFollowers
	/*
	 * IF: se non sono presenti ne utente o follower, ritorna null
	 * Creandoci come supporto ris, il metodo restituisce HashSet
	 */

	public Set<User> utentiMenzionati(Post p) {
		if(p==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		Set<User> ris = new HashSet<>();
		for (User us : users) {
			if (p.getText().indexOf(us.getUsername()) != -1)
				ris.add(us);
		}
		return ris;
	}// utentiMenzionati
	// Restituisce gli utenti piï¿½ influenti delle rete sociale (parametro del
	// metodo), ovvero quelli che hanno un numero maggiore di follower
	
	public Set<String> getMentionedUsers(){
		Set<String> ris = new HashSet<>();
		for(Post p: posts) {
			for(User u: users) {
				if(p.getText().indexOf(u.getUsername())!=-1){
					ris.add(u.getUsername());
				}
			}
		}
		return ris;
	}// getMentionedUsers
	/*
	 * Il metodo gira i post dove al suo interno controlla la presenza di tutti gli username presenti nel sistema
	 */
	
	public Set<String> getMentionedUsers(Set<Post> ps){
		if(ps==null) {
			throw new NullPointerException("Non puoi con Set ps null");
		}
		Set<String> ris = new HashSet<>();
		for(Post p: ps) {
			for(User u: users) {
				if(p.getText().indexOf(u.getUsername())!=-1) {
					ris.add(u.getUsername());
				}
			}
		}
		return ris;
	}// getMentionedUsers
	/*
	 * Il metodo cerca al'interno di tutti i post di Set<Post> gli utenti menzionati e ritorna l'insieme dei loro nomi
	 */
	
	public List<String> influencers() {
		int max = 0;
		List<String> ris = new LinkedList<>();
		for (User u : users) {
			Set<User> followers = getFollowers(u);
			if (followers.size() > max) {
				ris.clear();
				ris.add(u.getUsername());
				max = followers.size();
			} else if (followers.size() == max) {
				ris.add(u.getUsername());
			}
		} // for
		return ris;
	}// influencers
	// restituisce gli utenti piÃ¹ influenti delle rete sociale (parametro del
	// metodo), ovvero quelli che hanno un numero maggiore di follower;
	
	/*
	public List<String> influencers(Map<Integer, Set<Integer>> followers) {
		int max = 0;
		List<String> ris = new LinkedList<>();
		for (User u : users) {
			Map<Integer, Set<Integer>> park = this.followers;
			this.followers = followers;
			Set<User> seguaci = getFollowers(u);
			this.followers = park;
			
			if (seguaci.size() > max) {
				ris.clear();
				ris.add(u.getUsername());
				max = seguaci.size();
			} else if (seguaci.size() == max) {// possibili username duplicate
				ris.add(u.getUsername());
			}
		} // for
		return ris;
	}// influencers*/
	
	public boolean changeRole(User us, String user) {
		if(user==null||us==null) {
			throw new NullPointerException("Non puoi con user o us null");
		}
		if(!us.isAdmin()) {
			System.out.println(ADM_ROLE_NOT_PRESENT);
			return false;
		}
		User u = cerca(user);
		if(u!=null) {
			System.out.println(USER_FOUND);
			System.out.println(CHANGE_ROLE);
			Scanner sc = new Scanner(System.in);
			boolean check = sc.nextBoolean();
			u.setRole(check);	// Cambia in base al check
			System.out.println(CHANGE_ROLE_DONE);
			sc.close();
			return true;
		}else {
			System.out.println(USER_NOT_FOUND);
			return false;
		}
	}// Cambia ruolo dell'utente
	
	// Funzione che riporta la lista dei post che hanno al loro interno almeno una delle parole contenute nella lista di parole
	public List<Post> containing(List<String> words){
		if(words==null) {
			throw new NullPointerException("Non puoi con words null");
		}
		List<Post> ris = new LinkedList<>();
		for(Post p: posts) {
			for(String w: words) {
				if(p.getText().indexOf(w) != -1) {
					ris.add(p);
				}
			}
		}
		return ris;
	}// containing
	
	public Set<User> getUsers(User us){
		if(us==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		if(us.isAdmin()) {
			Set<User> ris = new HashSet<>();
			for(User u: users) {
				ris.add(u);
			}
			return ris;
		}else {
			System.out.println(ADM_ROLE_NOT_PRESENT);
			return null;
		}
	}// getUsers
	/*
	 * Questo metodo server in particolare per gli admin
	 * PoichÃ© ritorna tutte le informazioni
	 */
	
	public List<String> getUsers(){
		List<String> ris = new LinkedList<>();
		//inserire il metod getUsers
		for(User us: users) {
			if(!us.isAdmin()) {
				ris.add(us.getUsername());
			}
		}
		return ris;
	}// getUsers
	/*
	 * Questo metodo Ã¨ dedicato agli utenti
	 * Ritorna la lista degli utenti che non sono admin
	 */
	
	public boolean checkUsername(String username) {
		if(username==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		for(User us: users) {
			if(us.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}// checkUsername
	/*
	 * Questo metodo serve per evitare che siano presenti username identici nel sistema
	 */
	
	// Dato un post p, se u ha messo un like a p, allora u Ã¨ un follower dell'autore di p.
	/*
	 * p1:	autore: u1		mi piace: u2, u3 	
	 * p2:	autore: u2		mi piace: u2, u3, u4
	 * 
	 * --> 	u1 non segue nessuno
	 * 		u2 segue u1
	 * 		u3 segue u1 e u2
	 * 		u4 segue u2
	 */
	public Map<Integer, Set<Integer>> guessFollowers(Set<Post> ps) {
		Map<Integer, Set<Integer>> socialNetwork = new HashMap<>();
		
		for(Post p: ps) {
			int authorId = p.getUserId();
			Set<Integer> followersIds = p.getLikes();
			for(int followerId: followersIds) {
				if(followerId!=authorId) {
					if(!socialNetwork.containsKey(followerId)) {
						Set<Integer> seguiti = new HashSet<>();
						seguiti.add(authorId);
						socialNetwork.put(followerId, seguiti);
					} else {
						Set<Integer> seguiti = socialNetwork.get(followerId);
						seguiti.add(authorId);// Essendo seguiti un set, non controllo se esso giÃ  contiene authorId
					}
				}// if
			}// for
		}// for
		return socialNetwork;
	}// guessFollowers
	
	public List<Post> writtenBy(String username){
		if(username==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		User us = new User(cerca(username));
		List<Post> ris = new LinkedList<>();
		for(Post p: posts)
			if(p.getUserId()==us.getId())
				ris.add(p);
		return ris;
	}// writtenBy
	
	public List<Post> writtenBy(List<Post> ps, String username){
		if(username==null||ps==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		User us = new User(cerca(username));
		List<Post> ris = new LinkedList<>();
		for(Post p: ps)
			if(p.getUserId()==us.getId())
				ris.add(p);
		return ris;
	}// writtenBy
	
	public Set<Post> socialPost(User us){
		if(us==null) {
			throw new NullPointerException("Non puoi con user null");
		}
		Set<Post> ris = new HashSet<>();
		for(Post ps: posts)
			for(Integer fl: followers.get(us.getId()))
				if(ps.getUserId()==fl) {
					ris.add(ps);
					break;
				}
		return ris;
	}// SocialPost
	/*
	 * Questo metodo restituisce il set di Post che sono stati pubblicati dagli utenti che us segue
	 */
	
	
	
	public String toString(Post p) {
		if(p==null) {
			throw new NullPointerException("Non puoi con p null");
		}
		return p.toString();
	}
	
}// SocialNetwork
