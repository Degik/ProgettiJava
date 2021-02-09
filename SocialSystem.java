package Progetto1;

/*
 * Davide Bulotta
 * Matr. 596782
 * d.bulotta@studenti.unipi.it
 */

import java.util.*;

public class SocialSystem {
	//private static final String WELCOME = "Benvenuti nella prima versione del nostro Social Network";
	private static final String MENU_IN_ADM = "Menu admin v1.0";
	private static final String MENU_ADM_DETAILS = "Ecco le tue infomazioni account.";
	private static final String MENU_ADM_INFO = "Come admin non ti è permesso da questo account di pubblicare e seguire altro persone";
	private static final String MENU_ADM_SHOW_USERS = "1. Mostra tutti gli utenti e gli adimin";
	private static final String MENU_ADM_SHOW_POSTS = "2. Mostra tutti i post";
	private static final String MENU_ADM_CENSORED_SYSTEM = "3. Sistema di censura";
	private static final String MENU_ADM_SOCIAL_SYSTEM = "4. Social System";
	private static final String MENU_CENSORED_SYSTEM = "Menu per il sistema di censura";
	//private static final String MENU_CENSORED_OLD_POST_OP1 = "1. Censura i vecchi post";
	//private static final String MENU_CENSORED_OLD_POST_OP2 = "Censurare i vecchi post?";
	//private static final String MENU_CENSORED_OLD_POST_OP3 = "Tutti i vecchi post sono stati censurati!";
	private static final String MENU_CENSORED_TRUE_OP1 = "1. Disabilità il sistema di censura";
	private static final String MENU_CENSORED_TRUE_OP2 = "Disabilitare la censura?";
	private static final String MENU_CENSORED_TRUE_OP3 = "Censura disabilitata!";
	private static final String MENU_CENSORED_FALSE_OP1 = "1. Abilita il sistema di censura";
	private static final String MENU_CENSORED_FALSE_OP2 = "Abilitare la censura?";
	private static final String MENU_CENSORED_FALSE_OP3 = "Censura abiltata!";
	private static final String MENU_O1 = "1. Registrati al portale";
	private static final String MENU_O2 = "2. Accedi al portale";
	private static final String MENU_USER = "        Menu utente: ";
	private static final String MENU_USER_OP1 = "1. Visualizza le mie informazioni";
	private static final String MENU_USER_OP2 = "2. Visualizza i miei post";
	private static final String MENU_USER_OP3 = "3. Impostazioni followers";
	private static final String MENU_USER_OP4 = "4. Visualizza il mio social";
	private static final String MENU_USER_OP5 = "5. Logout";
	private static final String SHOW_DETAILS = "Ecco le tue informazioni...";
	private static final String CHANGE_PSSWD1 = "1. Modifica password";
	private static final String CHANGE_PSSWD2 = "Inserisci vecchia password: ";
	private static final String CHANGE_PSSWD3 = "Inserisci nuova password: ";
	private static final String CHANGE_PSSWD4 = "Password modificata correttamente.";
	private static final String MENU_POST_OP1 = "Ecco l'elenco dei posts pubblicati da te...";
	private static final String POSTS_USER_EMPTY = "Non hai pubblicato nessun post.";
	private static final String CREATE_NEW_POST = "1. Desideri creare un nuovo post?";
	private static final String DELETE_POST = "2. Desideri cancellare un post?";
	private static final String POST_FORM_O1 = "Inserisci il testo qui sotto (Massimo 140 caratteri).";
	private static final String CREATE_POST_DONE = "Creazione del post riuscita.";
	private static final String DELETE_POST_ID = "Inserisci l'id del post che desideri cancellare.";
	private static final String FOLLOWERS_MENU_O1 = "1. Mostra i miei followers";
	private static final String FOLLOWERS_MENU_O2 = "2. Mostra i miei seguiti";
	private static final String FOLLOWERS_MENU_O3 = "3. Incomincia a seguire qualcuno"; 
	private static final String DELETE_ACCOUNT = "1. Elimina un utente";
	private static final String DELETE_ACCOUNT_WARNING = "ATTENZIONE SE DECIDI DI CANCELLARE UN UTENTE L'OPERAZIONE E' IRREVERSIBILE E TUTTI I DATI (POST SCRITTI, FOLLOWERS, INFORMAZIONI PERSONALI) ANDRANNO PERSI!";
	private static final String DELETE_ACCOUNT_NAME = "Inserisci il nome dell'utente che vuoi eliminare: ";
	private static final String DELETE_ACCOUNT_WAITING = "Eliminazione dell'utente in corso...";
	private static final String POST_LIST_INFORMATION = "La lista dei post presenti nel sistema";
	private static final String DELETE_POST_ADM = "1. Elimina un post tramite il suo postId";
	private static final String DELETE_POST_ID_ADM = "Inserisci il postId del post che desideri eliminare: ";
	private static final String DELETE_POST_WAITING_ADM = "Sto cancellando il post...";
	private static final String DELETE_POST_DONE_ADM = "Post utente eliminato";
	private static final String LOGIN_FORM = "       Login Form";
	private static final String USERNAME_FIELD = "Username: ";
	private static final String PASSWORD_FIELD = "Password: ";
	private static final String PASSWORD_USERNAME_WRONG = "Nome utente o password errato/i.";
	private static final String LOGOUT = "- Logout";
	private static final String BACK_MENU = "- Ritorna al menu";
	private static final String BACK_MENU_TEXT = "Stai per tornare al menu";
	private static final String WRONG_OLD_PASSWORD = "Password inserita errata!";
	private static final String GLOBAL_POSTS_EMPTY = "Non sono presenti post nel sistema";
	private static final String SHOW_FOLLOWERS = "Ecco la lista degli utenti che ti seguono:";
	private static final String FOLLOWERS_EMPTY = "Non hai utenti che ti seguono...";
	private static final String INSERT_NAME_FOLLOW = "Inserisci il nome dell'utente che vuoi seguire";
	private static final String FOLLOW_DONE = "Ora segui ";
	private static final String LIST_USER_FOLLOW = "Ecco la lista degli utenti che segui";
	private static final String LIST_USER_FOLLOW_EMPTY = "Non segui nessuno...";
	private static final String DELETE_FOLLOW = "1. Smetti di seguire qualcuno";
	private static final String DELETE_FOLLOW_NAME = "Inserisci il nome dell'utente che non vuoi più seguire:";
	private static final String USERNAME_ALREADY_EXIST = "Se lo username inserito è già presente ti verrà richiesto di reinserirlo";
	private static final String CHANGE_EMAIL1 = "2. Modifica email";
	private static final String CHANGE_EMAIL2 = "Inserisci la nuova email:";
	private static final String CHANGE_EMAIL3 = "Modifica email riuscita";
	private static final String CHANGE_USERNAME1 = "3. Modifica username";
	private static final String CHANGE_USERNAME2 = "Inserisci il nuovo username";
	private static final String CHANGE_USERNAME3 = "Modifica utente riuscita";
	private static final String SOCIAL_CHECK = "1. Verfica sistema social";
	private static final String SOCIAL_OK = "Il social è ok";
	private static final String SOCIAL_NOT_OK = "Il social non corrisponde con guessFollowers";
	private static final String ADD_LIKE_ID = "Inserisci id del post a cui vuoi aggiungere il mi piace";
	private static final String POST_ADD_LIKE = "1. Aggiungi mi piace";
	private static final String ADD_LIKE_DONE = "Like aggiunto con successo";
	private static final String ADD_LIKE_FAIL = "Like non aggiunto, evidentemente il post già ti piaceva";
	private static final String POST_RMV_LIKE = "2. Rimuovi un mi piace";
	private static final String POST_USER = "Post scritto da: ";
	private static final String RMV_LIKE_DONE = "Like rimosso con successo";
	private static final String RMV_LIKE_FAIL = "Like non rimosso, evidentemente non avevi messo mi piace a questo post";
	private static final String RMV_LIKE_ID = "Inserisci id del post a cui vuoi rimuovere il mi piace";
	private static final String SHOW_FL_POSTS_EMPTY = "Evidentemente non segui qualcuno, oppure nessuno di quelli che segui ha ancora pubblicato qualcosa";
	private static final String SHOW_FL_POSTS_OP1 = "1. Mostra i post pubblicati dagli utenti che segui";
	private static final String SHOW_FL_POSTS_OP2 = "Ecco la lista dei post...";
	private static final String SHOW_HIGH_INFLUENCERS = "2. Mostra i top influencers";
	private static final String INFLUENCERS_LIST_EMPTY = "La classifica è vuota";
	private static final String TOP_INFLUENCERS_LIST = "Ecco la classifica...";
	private static final String USER_NOT_FOUND = "Utente non trovato";
	private static final String ROLE_MODIFY = "2. Modifica ruolo utente";
	private static final String MAKE_ADMIN = "Desideri rendere l'utente un amministratore?";
	private static final String MAKE_USER = "Desideri rendere l'amministratore un utente?";
	private static final String ROLE_MODIFY_NAME = "Inserisci il nome utente: ";
	private static final String SET_ROLE_DONE = "Ruolo modificato.";
	private static final String CONTAINING = "2. Verifica parole";
	private static final String CONTAINING_EMPTY = "Non ho trovato nessun risultato!";
	private static final String CONTAINING_LIST = "Ecco la lista dei post contenente questi post";
	private static final String CONTAINING_WORDS = "Inerisci le parole qui sotto:";
	private static final String CONTAINING_NUMBER = "Inserisci il numero di parole che vuoi cercare:";
	private static final String SHOW_MENTIONS = "3. Mostra menzioni";
	private static final String MENTIONS_LIST_EMPTY = "Non ci sono utenti menzionati dalle persone che segui";
	private static final String MENTIONS_LIST = "Ecco la lista degli utenti menzionati dalle persone che segui";
	private static final String WRITTEN = "3. Cerca post in base al nome utente";
	private static final String WRITTEN_BY = "Inserisci il nome utente per cercare i post:";
	private static final String WRITTEN_EMPTY = "L'utente non ha scritto alcun post.";
	private static final String WRITTEN_LIST = "Ecco la lista dei post scritti dall'utente ";
	
	/*private AdvancedSocialNetwork sn;
	
	public SocialSystem(AdvancedSocialNetwork sn) {
		this.sn=sn;
	}*/
	
	public static void menu(AdvancedSocialNetwork sn, Scanner sc) {
		Space();
		//System.out.println(WELCOME);
		System.out.println();
		System.out.println(MENU_O1);
		System.out.println(MENU_O2);
		//Scanner sc = new Scanner(System.in);
		int setting = sc.nextInt();
		sc.nextLine();
		switch(setting) {
		case 1:
			// Porta newUserForm
			newUserForm(sn,sc);
			break;
		case 2:
			// Porta loginForm
			loginForm(sn, sc);
			break;
		}
		//sc.close();
	}
	
	public static void loginForm(AdvancedSocialNetwork sn, Scanner sc) {
		Space();
		//Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(LOGIN_FORM);
		System.out.println();
		System.out.println(USERNAME_FIELD);
		String name = sc.next();
		System.out.println(PASSWORD_FIELD);
		String password = sc.next();
		if(sn.eRegistrato(name)) {
			User us = sn.cerca(name);
			if(us.checkPassword(password)) {
				if(us.isAdmin()) {
					menuAdm(sn,us,sc);
				}
				menu(sn,us,sc);
			}else {
				System.out.println(PASSWORD_USERNAME_WRONG);
				Delay(3);	//Ritardo di 2,25 secondi
				menu(sn, sc);	//Riporta al menu index
			}
		}else {
			System.out.println(PASSWORD_USERNAME_WRONG);
			Delay(3);	//Ritardo di 2,25 secondi
			menu(sn, sc);	//Riporta al menu index
		}
	}// loginForm
	/*
	 * Questo form è dedicato per il login di un utente già esistente nel sistema
	 */
	
	public static void newUserForm(AdvancedSocialNetwork sn, Scanner sc) {
		Space();// Fa 15 println cosi da pulire graficamente
		String nome,cognome,username,password,cap,citta,email;
		System.out.print("Nome: ");
		nome = sc.next();
		System.out.print("Cognome: ");
		cognome = sc.next();
		System.out.println(USERNAME_ALREADY_EXIST);
		do {
			System.out.println("Username: ");
			username = sc.next();
		}while(sn.checkUsername(username));
		System.out.println("Password: ");
		password = sc.next();
		System.out.print("CAP: ");
		cap = sc.next();
		/*if(cap.length()!=5) {
			throw new IllegalArgumentException("CAP non valido!");
		}*/
		System.out.print("Città: ");
		citta = sc.next();
		System.out.print("Email: ");
		email = sc.next();
		/*if(!email.contains("@")) {
			throw new IllegalArgumentException("Indirizzo e-mail non valido!");
		}*/
		//
		// (String fName, String lName, String username, String password, String address, String pCode, String city, String email)
		User us = new User(nome,cognome,username,password,cap,citta,email);
		sn.registraUtente(us);
		// Subito dopo aver creato l'utente entra nel menu utente
		// Verifica se l'untente è admin
		if(us.isAdmin()) {
			menuAdm(sn, us,sc);
		}else {
			menu(sn,us,sc);
		}
		//sc.close();
	}// newUserForm
	/*
	 * Qui si registra un nuovo utente
	 * Per poi aggiungerlo al sistema
	 */
	
	public static void menu(AdvancedSocialNetwork sn, User us, Scanner sc) {	// menu utente
		while(true) {
			Space();
			int setting;
			System.out.println();
			System.out.print(MENU_USER + us.getUsername());
			System.out.println();
			System.out.println(MENU_USER_OP1);
			System.out.println(MENU_USER_OP2);
			System.out.println(MENU_USER_OP3);
			System.out.println(MENU_USER_OP4);
			System.out.println(MENU_USER_OP5);
			setting = sc.nextInt();
			sc.nextLine();
			switch(setting) {
			case 1:
				//ShowDetails
				Space();
				System.out.println(SHOW_DETAILS);
				System.out.println(us);
				System.out.println(CHANGE_PSSWD1);
				System.out.println(CHANGE_EMAIL1);
				System.out.println(CHANGE_USERNAME1);
				System.out.println(BACK_MENU);
				System.out.println();
				setting = sc.nextInt();
				sc.nextLine();
				switch(setting) {
				case 1:
					// Modifica password
					System.out.println(CHANGE_PSSWD2);
					String pass;
					pass = sc.next();
					if(us.checkPassword(pass)) {
						System.out.println();
						System.out.println(CHANGE_PSSWD3);
						pass = sc.next();
						us.setPassword(pass);
						System.out.println(CHANGE_PSSWD4);
						Delay(3);
						menu(sn,us,sc);
					}else {
						System.out.println();
						System.out.println(WRONG_OLD_PASSWORD);
						Delay(3);
						menu(sn,us,sc);
					}
					break;
				case 2:
					// Modifica email
					System.out.println();
					System.out.println(CHANGE_EMAIL2);
					String email = sc.next();
					us.setEmail(email);
					System.out.println(CHANGE_EMAIL3);
					Delay(3);
					menu(sn,us,sc);
					break;
				case 3:
					// Modifica username
					System.out.println();
					String username;
					System.out.println(USERNAME_ALREADY_EXIST);
					do {
						System.out.println(CHANGE_USERNAME2);
						username = sc.next();
					}while(sn.checkUsername(username));
					us.setUsername(username);
					System.out.println(CHANGE_USERNAME3);
					Delay(3);
					menu(sn,us,sc);
					break;
				default:
					Delay(3);
					menu(sn,us,sc);
					break;
				}
				break;
			case 2:
				//showPost and modify post
				System.out.println(MENU_POST_OP1);	//MENU_POST_OP1 = "Ecco l'elenco dei posts pubblicati da te...";
				System.out.println();
				Set<Post> ris = new HashSet<>(sn.getPosts(us));
				if(ris.size()==0) {// Verifica se l'utente ha già pubblicato qualcosa
					// Nel caso non l'abbia fatto ti conduce in questo piccolo form
					System.out.println(POSTS_USER_EMPTY);
					System.out.println();
					System.out.println(CREATE_NEW_POST);
					System.out.println(BACK_MENU);
					setting = sc.nextInt();
					sc.nextLine();
					switch(setting) {
					case 1:
						System.out.println();
						createPostForm(sn,us, sc);
						Delay(3);
						menu(sn,us,sc);
						break;
					default:
						Delay(3);
						menu(sn,us,sc);
						break;
					}
				}else {
					for(Post p: ris) {
						System.out.println(sn.toString(p));
					}
					System.out.println();
					System.out.println(CREATE_NEW_POST);
					System.out.println(DELETE_POST);
					System.out.println(BACK_MENU);
					setting = sc.nextInt();
					sc.nextLine();
					switch(setting) {
					case 1:
						// Create new post
						createPostForm(sn,us, sc);
						Delay(3);
						menu(sn,us,sc);
						break;
					case 2:
						// Delete old post
						deletePostForm(sn,us,sc);
						Delay(3);
						menu(sn,us,sc);
						break;
					default:
						Delay(3);
						menu(sn,us,sc);
						break;
					}
				}
				System.out.println();
				break;
			case 3:
				//ShowFollower
				System.out.println();
				System.out.println(FOLLOWERS_MENU_O1);
				System.out.println(FOLLOWERS_MENU_O2);
				System.out.println(FOLLOWERS_MENU_O3);
				System.out.println(BACK_MENU);
				setting = sc.nextInt();
				sc.nextLine();
				switch(setting) {
				case 1:
					//Show my followers
					System.out.println();
					Set<String> followers = new HashSet<>(sn.utentiFollower(us));
					if(followers.size()==0) {
						System.out.println();
						System.out.println(FOLLOWERS_EMPTY);
						System.out.println();
						Delay(3);
						menu(sn,us,sc);
					}else {
						System.out.println(SHOW_FOLLOWERS);
						System.out.println();
						for(String fl: followers) {
							System.out.println(fl);
						}
						System.out.println();
						System.out.println(BACK_MENU);
						System.out.println();
						setting = sc.nextInt();
						sc.nextLine();
						switch(setting) {
						default:
							Delay(3);
							menu(sn,us,sc);
							break;
						}
					}
					
					break;
				case 2:
					// Show my seguiti
					System.out.println();
					System.out.println(LIST_USER_FOLLOW);
					Set<String> fl = new HashSet<>(sn.utentiSeguitiUs(us));
					if(fl.size()==0) {
						System.out.println();
						System.out.println(LIST_USER_FOLLOW_EMPTY);
						System.out.println();
						Delay(3);
						menu(sn,us,sc);
					}else {
						System.out.println();
						for(String f: fl) {
							System.out.println(f);
						}
						System.out.println();
						System.out.println(DELETE_FOLLOW);
						System.out.println(BACK_MENU);
						setting = sc.nextInt();
						sc.nextLine();
						switch(setting) {
						case 1:
							System.out.println();
							System.out.println(DELETE_FOLLOW_NAME);
							String name = sc.next();
							sn.nonSeguirePiu(us,name);
							Delay(3);
							menu(sn,us,sc);
							break;
						default:
							Delay(3);
							menu(sn,us,sc);
							break;
						}
					}
					break;
				case 3:
					// Incomincia a seguire qualcuno
					System.out.println();
					System.out.println(INSERT_NAME_FOLLOW);
					System.out.println();
					String user = sc.next();
					if(sn.nuovoFollower(us, user)) {
						System.out.println();
						System.out.println(FOLLOW_DONE + user);
					}
					Delay(3);
					menu(sn,us,sc);
					break;
				default:
					Delay(3);
					menu(sn,us,sc);
					break;
				}
				break;
			case 4:
				//Social
				System.out.println();
				System.out.println(SHOW_FL_POSTS_OP1);
				System.out.println(SHOW_HIGH_INFLUENCERS);
				System.out.println(SHOW_MENTIONS);
				System.out.println(BACK_MENU);
				System.out.println();
				setting = sc.nextInt();
				sc.nextLine();
				switch(setting) {
				case 1:
					//Show friend Post
					Space();
					System.out.println(SHOW_FL_POSTS_OP2);
					System.out.println();
					Set<Post> sg = new HashSet<>(sn.socialPost(us));
					if(sg.size()==0) {
						System.out.println(SHOW_FL_POSTS_EMPTY);
						Delay(3);
						menu(sn,us,sc);
					}else {
						for(Post s: sg){
							System.out.println(POST_USER + sn.postUser(s.getUserId()));
							System.out.println(sn.toString(s));
							System.out.println();
						}
						System.out.println(POST_ADD_LIKE);
						System.out.println(POST_RMV_LIKE);
						System.out.println(BACK_MENU);
						System.out.println();
						setting = sc.nextInt();
						sc.nextLine();
						switch(setting) {
						case 1:
							// add like
							System.out.println(ADD_LIKE_ID);
							setting = sc.nextInt();
							sc.nextLine();
							Post p_add = sn.getPostLike(setting);	// Prendo lo specifico oggetto post
							if(p_add.addLike(us))// e gli aggiunge il like
								System.out.println(ADD_LIKE_DONE);
							else
								System.out.println(ADD_LIKE_FAIL);
							Delay(3);
							menu(sn,us,sc);
							break;
						case 2:
							// remove like
							System.out.println(RMV_LIKE_ID);
							setting = sc.nextInt();
							sc.nextLine();
							Post p_rmv = sn.getPostLike(setting);	// Prendo lo specifico oggetto post
							if(p_rmv.removeLike(us))// e gli rimuove il like
								System.out.println(RMV_LIKE_DONE);
							else
								System.out.println(RMV_LIKE_FAIL);
							
							Delay(3);
							menu(sn,us,sc);
							break;
						default:
							Delay(3);
							menu(sn,us,sc);
							break;
						}
					}
					break;
				case 2:
					// Best Influecers
					System.out.println(TOP_INFLUENCERS_LIST);
					List<String> infl = new LinkedList<>(sn.influencers());
					if(infl.size()==0) {
						System.out.println(INFLUENCERS_LIST_EMPTY);
					}else {
						int i=1;
						for(String ifl: infl) {
							System.out.println(i + ". " + ifl); // Es: 1. Davide
							i++;
						}
					}
					System.out.println();
					System.out.println(BACK_MENU);
					setting = sc.nextInt();
					sc.nextLine();
					switch(setting) {
					default:
						Delay(3);
						menu(sn,us,sc);
					}
					break;
				case 3:
					// MENTIONS
					System.out.println(MENTIONS_LIST);
					Set<String> mentions = new HashSet<>(sn.getMentionedUsers(sn.socialPost(us))); // Prende come Set<Post> il ritorno di -> sn.socialPost(us)
					if(mentions.size()==0) {
						System.out.println(MENTIONS_LIST_EMPTY);
						Delay(3);
						menu(sn,us,sc);
					}else {
						for(String mn: mentions) {
							System.out.println(mn);
						}
						System.out.println();
						System.out.println(BACK_MENU);
						setting = sc.nextInt();
						sc.nextLine();
						switch(setting) {
						default:
							Delay(3);
							menu(sn,us,sc);
							break;
						}
					}
					break;
				default:
					Delay(3);
					menu(sn,us,sc);
					break;
				}
			case 5:
				menu(sn, sc);
				break;
			default:
				break;
			}
		}
	}// menu
	/*
	 * Questo è il menu utente
	 * Gestione dell'account ed altro
	 */
	
	public static void createPostForm(AdvancedSocialNetwork sn, User us, Scanner sc) {
		//Scanner sc = new Scanner(System.in);
		System.out.println(POST_FORM_O1);
		String text = sc.nextLine();
		sn.pubblica(new Post(us.getId(), text, System.currentTimeMillis()), us);	//(int userId, String text, long timestamp)
		System.out.println(CREATE_POST_DONE);
	}// createPostForm
	/*
	 * Da qui si crea un nuovo post
	 */
	
	public static void deletePostForm(AdvancedSocialNetwork sn, User us, Scanner sc) {
		System.out.println();
		System.out.println(DELETE_POST_ID);
		int id = sc.nextInt();
		sc.nextLine();
		sn.eliminaPost(us, id);
	}// deletePostForm
	/*
	 * Da qui si cancellano i post
	 */
	
	private static void menuAdm(AdvancedSocialNetwork sn, User us, Scanner sc) {	// Menu per gli admin
		//
		Space();
		System.out.println();
		System.out.println(MENU_IN_ADM);
		System.out.println();
		System.out.println(MENU_ADM_INFO);
		System.out.println(MENU_ADM_DETAILS);
		System.out.println(us);
		System.out.println();
		System.out.println(MENU_ADM_SHOW_USERS);
		System.out.println(MENU_ADM_SHOW_POSTS);
		System.out.println(MENU_ADM_CENSORED_SYSTEM);
		System.out.println(MENU_ADM_SOCIAL_SYSTEM);
		System.out.println(LOGOUT);
		int setting = sc.nextInt();
		sc.nextLine();
		switch(setting) {
		case 1:
			// Stampa tutte le informazioni utente 
			List<User> users = new LinkedList<>(sn.getUsers(us));
			System.out.println();
			for(User u: users) {
				System.out.println(u);
			}
			System.out.println();
			System.out.println(DELETE_ACCOUNT);
			System.out.println(ROLE_MODIFY);
			System.out.println(WRITTEN);
			System.out.println(BACK_MENU);
			System.out.println();
			setting = sc.nextInt();
			sc.nextLine();
			switch(setting) {
			case 1:
				System.out.println(DELETE_ACCOUNT_WARNING);
				System.out.println(DELETE_ACCOUNT_NAME);
				String name = sc.next();
				System.out.println(DELETE_ACCOUNT_WAITING);
				sn.eliminaUtente(us, name);
				System.out.println();
				Delay(3);
				menuAdm(sn,us,sc);
				break;
			case 2:
				// Modifica ruolo
				System.out.println(ROLE_MODIFY_NAME);
				String name_ = sc.next();
				if(sn.eRegistrato(name_)) {
					if(sn.cerca(name_).isAdmin()) {
						// Modifica ruolo da admin ad utente
						System.out.println(MAKE_USER);
						String line = sc.next();
						if(line.toLowerCase().contains("si")) {
							sn.cerca(name_).setRole(true);	// true lo rende un utente
							System.out.println(SET_ROLE_DONE);
							if(us.isAdmin()) {	// se è se stesso ad aver cambiato i propri permessi torna al menu per utenti
								Delay(3);
								menuAdm(sn,us,sc);
							}else {
								Delay(3);
								menu(sn,us,sc);
							}
						}else {
							Delay(3);
							menuAdm(sn,us,sc);
						}
					}else {
						// Modifca ruolo da utente ad admin
						System.out.println(MAKE_ADMIN);
						String line = sc.next();
						if(line.toLowerCase().contains("si")) {
							sn.cerca(name_).setRole(false);	// false lo rende amministratore
							System.out.println(SET_ROLE_DONE);
							Delay(3);
							menuAdm(sn,us,sc);
						}else {
							Delay(3);
							menuAdm(sn,us,sc);
						}
					}
				}else {
					System.out.println(USER_NOT_FOUND);
					Delay(3);
					menuAdm(sn,us,sc);
				}
				break;
			case 3:
				// Written_by
				System.out.println(WRITTEN_BY);
				System.out.println();
				String username = sc.next();
				if(sn.eRegistrato(username)) {	// Non genera exceptionNullPointer
					List<Post> ris = new LinkedList<>(sn.writtenBy(username));
					if(ris.size()==0) {
						System.out.println(WRITTEN_EMPTY);
						Delay(3);
						menuAdm(sn,us,sc);
					}else {
						System.out.println(WRITTEN_LIST + username);
						System.out.println();
						for(Post p: ris) {
							System.out.println(sn.toString(p));
						}
						System.out.println();
						System.out.println(BACK_MENU);
						setting = sc.nextInt();
						switch(setting) {
						default:
							Delay(3);
							menuAdm(sn,us,sc);
							break;
						}
					}
				}else {
					System.out.println(USER_NOT_FOUND);
					Delay(3);
					menuAdm(sn,us,sc);
				}
				break;
			default:
				Delay(3);
				menuAdm(sn,us,sc);
				break;
			}
			break;
		case 2:
			// Search Posts and print
			System.out.println(POST_LIST_INFORMATION);
			Set<Post> posts = new HashSet<>(sn.getPosts());
			if(posts.size()==0) {
				System.out.println();
				System.out.println(GLOBAL_POSTS_EMPTY);
				System.out.println();
				Delay(3);
				menuAdm(sn,us,sc);
			}else{
				for(Post p: posts) {
					System.out.println(sn.toString(p));
				}
				System.out.println();
				System.out.println(DELETE_POST_ADM);
				System.out.println(BACK_MENU);
				setting = sc.nextInt();
				sc.nextLine();
				switch(setting) {
				case 1:
					// Delete post by id
					System.out.println();
					System.out.println(DELETE_POST_ID_ADM);
					int postId = sc.nextInt();
					sc.nextLine();
					System.out.println();
					System.out.println(DELETE_POST_WAITING_ADM);
					sn.eliminaPost(us, postId);
					System.out.println(DELETE_POST_DONE_ADM);
					Delay(3);
					menuAdm(sn,us,sc);
					break;
				default:
					Delay(3);
					menuAdm(sn,us,sc);
					break;
				}
			}
			break;
		case 3:
			//	Censored System
			System.out.println();
			System.out.println(MENU_CENSORED_SYSTEM);
			System.out.println();
			if(sn.isCensored()) {
				System.out.println(MENU_CENSORED_TRUE_OP1);
			}else {
				System.out.println(MENU_CENSORED_FALSE_OP1);
			}
			//System.out.println(MENU_CENSORED_OLD_POST_OP1);
			System.out.println(BACK_MENU);
			System.out.println();
			String line;
			setting = sc.nextInt();
			sc.nextLine();
			switch(setting) {
			// Abilita/Disabilita censura
			case 1:
				if(sn.isCensored()) {
					System.out.println(MENU_CENSORED_TRUE_OP2);
					line = sc.next();
					if(line.toLowerCase().contains("si")) {
						sn.setCensored(false);
						System.out.println(MENU_CENSORED_TRUE_OP3);
						Delay(3);
						menuAdm(sn,us,sc);
					}else {
						Delay(3);
						menuAdm(sn,us,sc);
					}
				}else {
					System.out.println(MENU_CENSORED_FALSE_OP2);
					line = sc.next();
					if(line.toLowerCase().contains("si")) {
						sn.setCensored(true);
						System.out.println(MENU_CENSORED_FALSE_OP3);
						Delay(3);
						menuAdm(sn,us,sc);
					}else {
						Delay(3);
						menuAdm(sn,us,sc);
					}
				}
				break;
			/*case 2:
				//
				System.out.println(MENU_CENSORED_OLD_POST_OP2);
				line = sc.next();
				if(line.toLowerCase().contains("si")) {
					//sn.censura();
					System.out.println(MENU_CENSORED_OLD_POST_OP3);
					Delay(3);
					menuAdm(sn,us,sc);
				}else {
					Delay(3);
					menuAdm(sn,us,sc);
				}
				break;*/
			default:
				Delay(3);
				menuAdm(sn,us,sc);
				break;
			}
		case 4:
			// SocialSystem
			System.out.println();
			System.out.println(SOCIAL_CHECK);
			System.out.println(CONTAINING);
			System.out.println(BACK_MENU);
			System.out.println();
			setting = sc.nextInt();
			sc.nextLine();
			switch(setting) {
			case 1:
				if(sn.getFollowers().equals(sn.guessFollowers(sn.getPosts()))) {
					System.out.println(SOCIAL_OK);
					Delay(3);
					menuAdm(sn,us,sc);
				}else {
					System.out.println(SOCIAL_NOT_OK);
					Delay(3);
					menuAdm(sn,us,sc);
				}
				break;
			case 2:
				// CONTAINING SYSTEM
				// Questo stampa i post con la censura sempre disabilitatà
				System.out.println(CONTAINING_NUMBER);
				int number = sc.nextInt();
				sc.nextLine();
				System.out.println(CONTAINING_WORDS);
				List<String> words = new LinkedList<>();
				String word;
				int i=0;
				while(i<number) {
					word = sc.next();
					words.add(word);
					i++;
				}
				System.out.println();
				List<Post> listP = new LinkedList<>(sn.containing(words));
				System.out.println(CONTAINING_LIST);
				if(listP.size()==0) {
					System.out.println(CONTAINING_EMPTY);
					Delay(3);
					menuAdm(sn,us,sc);
				}else {
					System.out.println();
					for(Post p: listP) {
						System.out.println(p);
					}
					System.out.println();
					System.out.println(BACK_MENU);
					setting = sc.nextInt();
					sc.nextLine();
					switch(setting) {
					default:
						Delay(3);
						menuAdm(sn,us,sc);
						break;
					}
				}
				System.out.println();
				System.out.println(BACK_MENU);
			default:
				Delay(3);
				menuAdm(sn,us,sc);
				break;
			}
			break;
		default:
			menu(sn, sc);
			break;
		}
	}// menuAdm
	/*
	 * Dedicato interamente agli admin per la gestione del sistema (utenti, post)
	 */
	
	public static void Space(){
		for(int i=0;i<15;i++) {
			System.out.println();
		}
	}
	
	//public p
	
	public static void Delay(int x) {
		System.out.println();
		System.out.println(BACK_MENU_TEXT);
		System.out.println();
		for(int i=x;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(750);
			}catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		//SocialSystem system = new SocialSystem(new AdvancedSocialNetwork());
		Set<String> bws = new HashSet<>();
		bws.add("stringhe");
		bws.add("BlackWord");
		bws.add("Facebook");
		AdvancedSocialNetwork sn = new AdvancedSocialNetwork(bws, true);
		
		User u = new User("Mario", "Rossi", "Mario", "12345", "00000", "Roma", "mariorossi@gmail.com");// 0
		sn.registraUtente(u);
		User u1 = new User("Mario", "Rossi", "Admin", "admin", "00000", "Roma", "adm@adm.it");	//1
		sn.registraUtente(u1);
		User u2 = new User("Luigi", "verdi", "luigi", "12345", "00000", "Roma", "luigi@tiscali.it");// 2
		sn.registraUtente(u2);
		User u3 = new User("Federica", "Monte", "Fede", "12345", "00000", "Roma", "fede@gmail.com");	//3
		sn.registraUtente(u3);
		
		Post p = new Post(0,"Sono stato su Facebook è bellissimo",System.currentTimeMillis());
		Post p1 = new Post(0,"Le parole fanno male",System.currentTimeMillis());
		Post p2 = new Post(2, "BlackWord BlackWord", System.currentTimeMillis());
		
		p.addLike(u2);	// luigi mette like al post p(appartenente a Mario)
		//sn.nuovoFollower(u,u2);	// Mario inizia a seguire luigi
		sn.nuovoFollower(u2,u);	// luigi inizia a seguire Mario
		sn.pubblica(p,u);
		sn.pubblica(p1,u);
		sn.pubblica(p2, u2);
		Scanner sc = new Scanner(System.in);
		menu(sn, sc);	// menu principale		
		sc.close();
	}
}
