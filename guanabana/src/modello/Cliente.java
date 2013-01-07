package modello;

import java.io.Serializable;

/**
 * Classe Cliente: Modello di cliente dell'azienda.
 * Implementa Serializable.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Cliente implements Serializable{

	/**
	 * Serializzazione
	 */
	private static final long serialVersionUID = -321784570519146557L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private String cf;        //codice fiscale del cliente
	private String nome;      //nome del cliente
	private String cognome;   //cognome del cliente
	private String email;     //email del cliente
	private String password;  //password d'accesso del cliente
	private String indirizzo; //indirizzo del cliente
	private String telefono;  //telefono del cliente
	
	/**
	 * Costruttore del cliente
	 * @param cf			Codice fiscale del cliente
	 * @param nome			Nome del cliente
	 * @param cognome		Cognome del cliente
	 * @param email			Email del cliente
	 * @param indirizzo		Indirizzo del cliente
	 * @param telefono		Telefono del cliente
	 * @param password		Password d'accesso del cliente
	 */
	public Cliente(String cf, String nome, String cognome, String email,
	 String indirizzo, String telefono,String password) {
		super();
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		
	}

	/**
	 * Costruttore del cliente vuoto
	 */
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo che permette di registrare un cliente
	 */
	public void registrareCliente(){
		
	}

	/**
	 * Getter of cf
	 * @return cf
	 */
	public String getCf() {
		return cf;
	}

	/**
	 * Setter of cf
	 * @param cf 
	 */
	public void setCf(String cf) {
		this.cf = cf;
	}

	
	/**
	 * Getter of nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter of nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * Getter of cognome
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Setter of cognome
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Getter of email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * Getter of indirizzo
	 * @return indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Setter of indirizzo
	 * @param indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	/**
	 * Getter of telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setter of telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * Getter of password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Getter of messaggio
	 * @return messaggio
	 */
	public String getMessaggio(){
		String messaggio = "<p class=MsoNormal><span style='font-size:14.0pt'>"+getNome()+" "+getCognome()+
				", Grazie per aver completato la registrazione al nostro sito!</span></p>"+
				"<p class=MsoNormal><span style='font-size:10.0pt'>Utente: "+getEmail()+"</span></p>"+
				"<p class=MsoNormal><span style='font-size:10.0pt'>Password: "+getPassword()+"</span></p>";
		return messaggio;
		
	}

		
}
