package modello;

import java.io.Serializable;
import java.util.Collection;


public class Componente implements Serializable{
	
	

	public Componente(String codice, String nome, float prezzo, String tipo) {
		super();
		this.codice = codice;
		this.tipo = tipo;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="configurazione"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="componente:guanabana.Configurazione"
	 * @uml.association  name="possiede"
	 */

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

	/**
	 * @uml.property  name="componenti"
	 * @uml.associationEnd  multiplicity="(1 -1)"
	 * @uml.association  name="contiene"
	 */
	private Collection componenti;

	/**
	 * Getter of the property <tt>componenti</tt>
	 * @return  Returns the componenti.
	 * @uml.property  name="componenti"
	 */
	public Collection getComponenti() {
		return componenti;
	}

	/**
	 * Setter of the property <tt>componenti</tt>
	 * @param componenti  The componenti to set.
	 * @uml.property  name="componenti"
	 */
	public void setComponenti(Collection componenti) {
		this.componenti = componenti;
	}

	/**
	 * @uml.property  name="standard"
	 */
	private boolean standard;

	/**
	 * Getter of the property <tt>standard</tt>
	 * @return  Returns the standard.
	 * @uml.property  name="standard"
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * Setter of the property <tt>standard</tt>
	 * @param standard  The standard to set.
	 * @uml.property  name="standard"
	 */
	public void setStandard(boolean standard) {
		this.standard = standard;
	}

	/**
	 * @uml.property  name="scelto"
	 */
	private boolean scelto;

	/**
	 * Getter of the property <tt>scelto</tt>
	 * @return  Returns the scelto.
	 * @uml.property  name="scelto"
	 */
	public boolean isScelto() {
		return scelto;
	}

	/**
	 * Setter of the property <tt>scelto</tt>
	 * @param scelto  The scelto to set.
	 * @uml.property  name="scelto"
	 */
	public void setScelto(boolean scelto) {
		this.scelto = scelto;
	}


}
