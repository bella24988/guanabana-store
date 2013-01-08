package modello;

import java.io.Serializable;
import java.util.Collection;

/**
 * Classe Componente: Modello di componente selezionabile in una configurazione.
 * Implementa Serializable.
 * @author Gabriele
 * @author  Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Componente implements Serializable{
	
	/**
	 * Serializzazione.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Dichiarazione delle variabili.
	 */
	private String codice;   //codice del componente
	private String modello;  //modello del componente
	private String tipo;     //tipo di componente
	private String nome;     //nome del componente
	private float prezzo;    //prezzo del componente
	private boolean standard;//true se il componente fa parte della configurazione standard, false altrimenti
	private boolean scelto;  //true se il componente e' stato scelto in una configurazione, false altrimenti


	
	private Collection componenti; //lista di componenti



	public Componente(String codice, String nome, float prezzo, String tipo) {
		super();
		this.codice = codice;
		this.tipo = tipo;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	
	/**
	 * Getter of codice
	 * @return codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Setter of codice
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/** 
	 * Getter of modello
	 * @return modello
	 */
	public String getModello() {
		return modello;
	}

	/** 
	 * Setter of modello
	 * @param modello
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}


	/**
	 * Getter of tipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter of tipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * Getter of prezzo
	 * @return prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Setter of prezzo
	 * @param prezzo
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Getter of componenti
	 * @return componenti
	 */
	public Collection getComponenti() {
		return componenti;
	}

	/**
	 * Setter of componenti
	 * @param componenti
	 */
	public void setComponenti(Collection componenti) {
		this.componenti = componenti;
	}

	/**
	 * Getter of standard
	 * @return standard
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * Setter of standard
	 * @param standard
	 */
	public void setStandard(boolean standard) {
		this.standard = standard;
	}

	/**
	 * Getter of scelto
	 * @return scelto
	 */
	public boolean isScelto() {
		return scelto;
	}

	/**
	 * Setter of scelto
	 * @param scelto
	 */
	public void setScelto(boolean scelto) {
		this.scelto = scelto;
	}


}
