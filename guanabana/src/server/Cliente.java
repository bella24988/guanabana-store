package server;

import java.sql.SQLException;
import java.util.Collection;


public class Cliente {

	private String cf;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String indirizzo;
	private String telefono;
	private DataBase db;
	
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

	public void registrareCliente(){
		try {
			db = new DataBase();
			db.insertCliente(cf, nome, cognome, email, indirizzo, telefono, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @uml.property  name="ordineNegozioOnline"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="cliente:guanabana.OrdineNegozioOnline"
	 * @uml.association  name="Realizza"
	 */
	private Collection ordineNegozioOnline;

	/**
	 * Getter of the property <tt>ordineNegozioOnline</tt>
	 * @return  Returns the ordineNegozioOnline.
	 * @uml.property  name="ordineNegozioOnline"
	 */
	public Collection getOrdineNegozioOnline() {
		return ordineNegozioOnline;
	}

	/**
	 * Setter of the property <tt>ordineNegozioOnline</tt>
	 * @param ordineNegozioOnline  The ordineNegozioOnline to set.
	 * @uml.property  name="ordineNegozioOnline"
	 */
	public void setOrdineNegozioOnline(Collection ordineNegozioOnline) {
		this.ordineNegozioOnline = ordineNegozioOnline;
	}

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


	/**
	 * @return the db
	 */
	public DataBase getDb() {
		return db;
	}


	/**
	 * @param db the db to set
	 */
	public void setDb(DataBase db) {
		this.db = db;
	}

		
}
