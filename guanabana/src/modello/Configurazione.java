package modello;

import java.io.Serializable;

public class Configurazione implements Serializable{
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * @uml.property name="componenti"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1" ordering="true" inverse="configurazione:modello.Componente"
	 * @uml.association name="composta"
	 */
	private Componente[] componentiConfigurabili;
	private Componente[] componentiScelti;
	private Componente[] componentiStandard;
	private int maxComponentiScelti;

	public Configurazione(Componente[] componenti, String[] codiceConfigStandard, int maxComp) {
		super();
		setMaxComponentiScelti(maxComp);
		this.componentiConfigurabili = componenti;
		setConfigurazioneStandard(codiceConfigStandard);
		this.componentiScelti = new Componente[getMaxComponentiScelti()];
	}

	/**
	 * @param componenti
	 * @param configStandard
	 * Serve per stabilire quali dei componenti configurabili è standard.
	 */
	private void setConfigurazioneStandard(String[] configStandard) {
		int numComponenti = configStandard.length;
		componentiStandard = new Componente[numComponenti];
		for(int i=0; i<numComponenti; i++){
			for(int j=0; j<componentiConfigurabili.length; j++){
				if(componentiConfigurabili[j].getCodice().compareTo(configStandard[i])==0){
					componentiConfigurabili[j].setStandard(true);
					componentiStandard[i]=componentiConfigurabili[j];
				}
			}
		}
	}

	/** 
	 * Getter of the property <tt>componenti</tt>
	 * @return  Returns the componenti.
	 * @uml.property  name="componenti"
	 */
	public Componente[] getComponenti() {
		return componentiConfigurabili;
	}

	/** 
	 * Setter of the property <tt>componenti</tt>
	 * @param componenti  The componenti to set.
	 * @uml.property  name="componenti"
	 */
	public void setComponenti(Componente[] componenti) {
		this.componentiConfigurabili = componenti;
	}

		
		/**
		 */
		public void setConfigurazioneScelta(int indexComponenti, int indexConfigScelta){
			
			componentiScelti[indexConfigScelta]=componentiConfigurabili[indexComponenti];
			
		}

		public Componente[] getComponentiScelti() {
			return componentiScelti;
		}

		public void setComponentiScelti(Componente[] componentiScelti) {
			this.componentiScelti = componentiScelti;
		}

		/**
		 * @return the componentiStandard
		 */
		public Componente[] getComponentiStandard() {
			return componentiStandard;
		}

		/**
		 * @param componentiStandard the componentiStandard to set
		 */
		public void setComponentiStandard(Componente[] componentiStandard) {
			this.componentiStandard = componentiStandard;
		}

		/**
		 * @return the maxComponentiScelti
		 */
		public int getMaxComponentiScelti() {
			return maxComponentiScelti;
		}

		/**
		 * @param maxComponentiScelti the maxComponentiScelti to set
		 */
		public void setMaxComponentiScelti(int maxComponentiScelti) {
			this.maxComponentiScelti = maxComponentiScelti;
		}
		
		
		
		

}
