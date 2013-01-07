package modello;

import java.io.Serializable;

/**
 * Classe Computer: Modello di un computer in vendita.
 * Implementa Serializable.
 * @author Gabriele
 * @author  Veronica
 * @version 3.0 Jan 3, 2013.
 */
public abstract class Computer implements Serializable{
	
	private static final long serialVersionUID = 8391044426886288876L;
	/**
	 * Dichiarazione delle variabili
	 */
	private String tipo;					//tipo di computer
	private Configurazione configurazione;	//configurazione dei componenti del computer
	protected String nome;					//nome del computer
	protected float prezzo;					//prezzo del computer
	
	/**
	 * Primo costruttore della classe Computer, setta nome e prezzo.
	 * @param nome				Nome del computer
	 * @param prezzo			Prezzo del computer
	 */
	public Computer(String nome, float prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	

	/**
	 * Secondo costruttore della classe computer, setta il nome.
	 * @param nome				Nome del computer
	 */
	public Computer(String nome) {
		super();
		this.nome = nome;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo per rendere visibile un computer
	 */
	public void mostrareComputer(){
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
	 * Getter of configurazioneStandard
	 * @return configurazione
	 */
	public Configurazione getConfigurazione() {
		return configurazione;
	}

	/** 
	 * Setter of configurazioneStandard
	 * @param configurazione
	 */
	public void setConfigurazione(
			Configurazione configurazione) {
				this.configurazione = configurazione;
			}

}
