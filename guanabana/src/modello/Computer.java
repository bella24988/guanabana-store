package modello;

import java.io.Serializable;

/**
 * @author  Veronica
 */
public abstract class Computer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8391044426886288876L;
	/**
	 * @uml.property  name="tipo"
	 */
	private String tipo;
	/** 
	 * @uml.property name="configurazioneStandard"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="computer:modello.Configurazione"
	 * @uml.association name="configurazioneStandard"
	 */
	private Configurazione configurazione;
	/**
	 * @uml.property  name="nome"
	 */
	protected String nome;
	/**
	 * @uml.property  name="prezzo"
	 */
	protected float prezzo;
	/** 
	 * @uml.property name="configurazioneScelta"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 * @uml.association name="configurazione scelta dal cliente"
	 */
	
	public Computer(String nome, float prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	

	public Computer(String nome) {
		super();
		this.nome = nome;
		// TODO Auto-generated constructor stub
	}


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


		/** 
		 * Getter of the property <tt>configurazioneStandard</tt>
		 * @return  Returns the configurazione.
		 * @uml.property  name="configurazioneStandard"
		 */
		public Configurazione getConfigurazione() {
			return configurazione;
		}



		/** 
		 * Setter of the property <tt>configurazioneStandard</tt>
		 * @param configurazione  The configurazione to set.
		 * @uml.property  name="configurazioneStandard"
		 */
		public void setConfigurazione(
				Configurazione configurazione) {
					this.configurazione = configurazione;
				}
		
		

	

}
