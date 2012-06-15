package modello;

import java.util.Collection;


public class Configurazione {

	/** 
	 * @uml.property name="preventivo"
	 * @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="configurazione:guanabana.Preventivo"
	 * @uml.association name="genera"
	 */
	private Collection preventivo;

	/** 
	 * Getter of the property <tt>preventivo</tt>
	 * @return  Returns the preventivo.
	 * @uml.property  name="preventivo"
	 */
	public Collection getPreventivo() {
		return preventivo;
	}

	/** 
	 * Setter of the property <tt>preventivo</tt>
	 * @param preventivo  The preventivo to set.
	 * @uml.property  name="preventivo"
	 */
	public void setPreventivo(Collection preventivo) {
		this.preventivo = preventivo;
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
	 * @uml.property  name="descrizione"
	 */
	private String descrizione;

	/**
	 * Getter of the property <tt>descrizione</tt>
	 * @return  Returns the descrizione.
	 * @uml.property  name="descrizione"
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Setter of the property <tt>descrizione</tt>
	 * @param descrizione  The descrizione to set.
	 * @uml.property  name="descrizione"
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	 * @uml.property  name="standard"
	 */
	private boolean standard = false;

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


}
