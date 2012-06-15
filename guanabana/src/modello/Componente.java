package modello;

import java.io.Serializable;
import java.util.Collection;


public class Componente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="configurazione"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="componente:guanabana.Configurazione"
	 * @uml.association  name="possiede"
	 */
	private Collection configurazione;

	/**
	 * Getter of the property <tt>configurazione</tt>
	 * @return  Returns the configurazione.
	 * @uml.property  name="configurazione"
	 */
	public Collection getConfigurazione() {
		return configurazione;
	}

	/**
	 * Setter of the property <tt>configurazione</tt>
	 * @param configurazione  The configurazione to set.
	 * @uml.property  name="configurazione"
	 */
	public void setConfigurazione(Collection configurazione) {
		this.configurazione = configurazione;
	}

	/**
	 * @uml.property  name="codice"
	 */
	private String codice;

	/**
	 * Getter of the property <tt>codice</tt>
	 * @return  Returns the codice.
	 * @uml.property  name="codice"
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Setter of the property <tt>codice</tt>
	 * @param codice  The codice to set.
	 * @uml.property  name="codice"
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @uml.property  name="modello"
	 */
	private String modello;

	/** 
	 * Getter of the property <tt>nome</tt>
	 * @return  Returns the nome.
	 * @uml.property  name="modello"
	 */
	public String getModello() {
		return modello;
	}

	/** 
	 * Setter of the property <tt>nome</tt>
	 * @param nome  The nome to set.
	 * @uml.property  name="modello"
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}

	/**
	 * @uml.property  name="tipo"
	 */
	private String tipo;

	/**
	 * Getter of the property <tt>tipo</tt>
	 * @return  Returns the tipo.
	 * @uml.property  name="tipo"
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter of the property <tt>tipo</tt>
	 * @param tipo  The tipo to set.
	 * @uml.property  name="tipo"
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @uml.property  name="nome"
	 */
	private String nome;

	/**
	 * Getter of the property <tt>nome</tt>
	 * @return  Returns the nome.
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
	 * @uml.property  name="prezzo"
	 */
	private float prezzo;

	/**
	 * Getter of the property <tt>prezzo</tt>
	 * @return  Returns the prezzo.
	 * @uml.property  name="prezzo"
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Setter of the property <tt>prezzo</tt>
	 * @param prezzo  The prezzo to set.
	 * @uml.property  name="prezzo"
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}


}
