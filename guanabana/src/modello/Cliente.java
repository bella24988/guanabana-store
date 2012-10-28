package modello;

import java.io.Serializable;



/**
 * @author  Veronica
 */
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -321784570519146557L;
	/**
	 * @uml.property  name="cf"
	 */
	private String cf;
	/**
	 * @uml.property  name="nome"
	 */
	private String nome;
	/**
	 * @uml.property  name="cognome"
	 */
	private String cognome;
	/**
	 * @uml.property  name="email"
	 */
	private String email;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="indirizzo"
	 */
	private String indirizzo;
	/**
	 * @uml.property  name="telefono"
	 */
	private String telefono;

	/**
	 */
	

	/**
		 */			
	public Cliente(String cf, String nome, String cognome, String email,
	String password, String indirizzo, String telefono) {
		super();
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public void registrareCliente(){
		
	}


	/**
	 * @return
	 * @uml.property  name="cf"
	 */
	public String getCf() {
		return cf;
	}

	/**
	 * Setter of the property <tt>cf</tt>
	 * @param cf  The cf to set.
	 * @uml.property  name="cf"
	 */
	public void setCf(String cf) {
		this.cf = cf;
	}

	
	/**
	 * @return
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter of the property <tt>nome</tt>
	 * @param nome  The nome to set.
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * @return
	 * @uml.property  name="cognome"
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Setter of the property <tt>cognome</tt>
	 * @param cognome  The cognome to set.
	 * @uml.property  name="cognome"
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @uml.property  name="email"
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Setter of the property <tt>email</tt>
	 * @param email  The email to set.
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return
	 * @uml.property  name="indirizzo"
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Setter of the property <tt>indirizzo</tt>
	 * @param indirizzo  The indirizzo to set.
	 * @uml.property  name="indirizzo"
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	/**
	 * @return
	 * @uml.property  name="telefono"
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Setter of the property <tt>telefono</tt>
	 * @param telefono  The telefono to set.
	 * @uml.property  name="telefono"
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>password</tt>
	 * @param password  The password to set.
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

		
}
