package modello;

import java.io.Serializable;

/**
 * Classe Dipendente: Modello di dipendente dell'azienda.
 * Implementa Serializable.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Dipendente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione delle variabili
	 */
	private String nome;			//Nome del dipendente
	private String cognome;			//Cognome del dipendente
	private int id;					//Numero identificativo del dipendente
	private String dipartimento;	//Dipartimento di appartenenza del dipendente
	
	/**
	 * Costruttore di un dipendente dell'azienda.
	 * @param nome					Nome del dipendente
	 * @param cognome				Cognome del dipendente
	 * @param id					Numero identificativo del dipendente
	 * @param dipartimento			Dipartimento di appartenenza del dipendente
	 */
	public Dipendente(String nome, String cognome, int id,
			String dipartimento) {
		super();
		this.setNome(nome);
		this.setCognome(cognome);
		this.setId(id);
		this.setDipartimento(dipartimento);
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
	 * Getter of id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter of dipartimento
	 * @return dipartimento
	 */
	public String getDipartimento() {
		return dipartimento;
	}

	/**
	 * Setter of dipartimento
	 * @param dipartimento
	 */
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

}
