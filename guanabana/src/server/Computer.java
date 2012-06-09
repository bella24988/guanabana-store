package server;

import java.io.Serializable;
import java.util.Collection;

public abstract class Computer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8391044426886288876L;
	Componente[] componenti;
	
	public Computer(String nome, float prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	/**
	 * @uml.property  name="componente"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="computer:guanabana.Componente"
	 * @uml.association  name="composto"
	 */
	private Collection<?> componente;

	/**
	 * Getter of the property <tt>componente</tt>
	 * @return  Returns the componente.
	 * @uml.property  name="componente"
	 */
	public Collection<?> getComponente() {
		return componente;
	}

	/**
	 * Setter of the property <tt>componente</tt>
	 * @param componente  The componente to set.
	 * @uml.property  name="componente"
	 */
	public void setComponente(Collection<?> componente) {
		this.componente = componente;
	}

	/**
	 * @uml.property  name="nome"
	 */
	protected String nome;

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
	 * @uml.property  name="prezzo"
	 */
	protected float prezzo;

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
		 */
		public void mostrareComputer(){
		}

	

}
