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
	 * @uml.property  name="componenti"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	Componente[] componenti;
	/**
	 * @uml.property  name="configurazioneStandard"
	 */
	protected String[] configurazioneStandard;
	/**
	 * @uml.property  name="configurazioneScelta"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Configurazione[] configurazioneScelta;
	
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
	 * @uml.property  name="componente"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private Componente[] componente;

	/**
	 * Getter of the property <tt>componente</tt>
	 * @return  Returns the componente.
	 * @uml.property  name="componente"
	 */
	public Componente[] getComponente() {
		return componente;
	}

	/**
	 * Setter of the property <tt>componente</tt>
	 * @param componenti2  The componente to set.
	 * @uml.property  name="componente"
	 */
	public void setComponente(Componente[] componenti2) {
		this.componente = componenti2;
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

		/**
		 * @return  the configurazioneStandard
		 * @uml.property  name="configurazioneStandard"
		 */
		public String[] getConfigurazioneStandard() {
			return configurazioneStandard;
		}

		/**
		 * @param configurazioneStandard  the configurazioneStandard to set
		 * @uml.property  name="configurazioneStandard"
		 */
		public void setConfigurazioneStandard(String[] configurazioneStandard) {
			this.configurazioneStandard = configurazioneStandard;
		}

		/**
		 * @return  the configurazioneScelta
		 * @uml.property  name="configurazioneScelta"
		 */
		public Configurazione[] getConfigurazioneScelta() {
			return configurazioneScelta;
		}

		/**
		 * @param configurazioneScelta  the configurazioneScelta to set
		 * @uml.property  name="configurazioneScelta"
		 */
		public void setConfigurazioneScelta(Configurazione[] configurazioneScelta) {
			this.configurazioneScelta = configurazioneScelta;
		}
		
		

	

}
