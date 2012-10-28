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

	public Configurazione(Componente[] componenti, String[] codiceConfigStandard) {
		super();
		this.componentiConfigurabili = componenti;
		setConfigurazioneStandard(componenti, codiceConfigStandard);
	}

	/**
	 * @param componenti
	 * @param configStandard
	 * Serve per stabilire quali dei componenti configurabili è standard.
	 */
	private void setConfigurazioneStandard(Componente[] componenti, String[] configStandard) {
		int numComponenti = configStandard.length;
		componentiStandard = new Componente[numComponenti];
		for(int i=0; i<numComponenti; i++){
			for(int j=0; j<componenti.length; j++){
				if(componenti[j].getCodice().compareTo(configStandard[i])==0){
					componenti[j].setStandard(true);
					componenti[j].setScelto(true);
					componentiStandard[i]=componenti[j];
				}else{
					componenti[j].setStandard(false);
					componenti[j].setScelto(false);
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
			componentiConfigurabili[indexComponenti].setScelto(true);
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
		
		

}
