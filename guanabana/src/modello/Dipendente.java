package modello;

import java.io.Serializable;

/**
 * @author  Veronica
 */
public class Dipendente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="nome"
	 */
	private String nome;
	/**
	 * @uml.property  name="cognome"
	 */
	private String cognome;
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="dipartimento"
	 */
	private String dipartimento;
	
	public Dipendente(String nome, String cognome, int id,
			String dipartimento) {
		super();
		this.setNome(nome);
		this.setCognome(cognome);
		this.setId(id);
		this.setDipartimento(dipartimento);
	}

	/**
	 * @return  the nome
	 * @uml.property  name="nome"
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome  the nome to set
	 * @uml.property  name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return  the cognome
	 * @uml.property  name="cognome"
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome  the cognome to set
	 * @uml.property  name="cognome"
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id2  the id to set
	 * @uml.property  name="id"
	 */
	public void setId(int id2) {
		this.id = id2;
	}

	/**
	 * @return  the dipartimento
	 * @uml.property  name="dipartimento"
	 */
	public String getDipartimento() {
		return dipartimento;
	}

	/**
	 * @param dipartimento  the dipartimento to set
	 * @uml.property  name="dipartimento"
	 */
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	
	

}
