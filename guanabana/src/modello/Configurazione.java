package modello;

import java.io.Serializable;

/**
 * Classe Configurazione: modello di una configurazione di componenti scelta
 * per un computer.
 * Implementa Serializable.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Configurazione implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Dichiarazione delle variabili
	 */
	private Componente[] componentiConfigurabili;	//Componenti selezionabili per una configurazione di un computer
	private Componente[] componentiScelti;			//Componenti selezionati
	private Componente[] componentiStandard;		//Componenti facenti parte della configurazione standard
	private int maxComponentiScelti;				//Numero di componenti selezionati per una configurazione

	/**
	 * Primo costruttore della classe Configurazione, setta i componenti configurabili,
	 * la configurazione standard e il numero di componenti selezionati.
	 * @param componenti				Componenti configurabili
	 * @param codiceConfigStandard		Lista di componenti della configurazione standard di un computer
	 * @param maxComp					Numero di componenti selezionati
	 */
	public Configurazione(Componente[] componenti, String[] codiceConfigStandard, int maxComp) {
		super();
		setMaxComponentiScelti(maxComp);
		this.componentiConfigurabili = componenti;
		setConfigurazioneStandard(codiceConfigStandard);
		this.componentiScelti = new Componente[getMaxComponentiScelti()];
	}
	
	

	/**
	 * Secondo costruttore della classe Configurazione, setta i componenti scelti
	 * e il numero di componenenti scelti.
	 * @param componentiScelti			Componenti scelti
	 * @param maxComponentiScelti		Numero di componenti scelti
	 */
	public Configurazione(Componente[] componentiScelti, int maxComponentiScelti) {
		super();
		this.componentiScelti = componentiScelti;
		this.maxComponentiScelti = maxComponentiScelti;
	}



	/**
	 * Metodo che permette di stabilire quali dei componenti
	 * configurabili appartiene alla configurazione standard.
	 * @param configStandard			Configurazione standard
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
	 * Metodo che permette di settare una configurazione scelta arbitrariamente.
	 */
	public void setConfigurazioneScelta(int indexComponenti, int indexConfigScelta){
		
		componentiScelti[indexConfigScelta]=componentiConfigurabili[indexComponenti];
		
	}

	/** 
	 * Getter of componenti
	 * @return componenti
	 */
	public Componente[] getComponenti() {
		return componentiConfigurabili;
	}

	/** 
	 * Setter of componenti
	 * @param componenti
	 */
	public void setComponenti(Componente[] componenti) {
		this.componentiConfigurabili = componenti;
	}

	/**
	 * Getter of componentiScelti
	 * @return componentiScelti
	 */
	public Componente[] getComponentiScelti() {
		return componentiScelti;
	}

	/**
	 * Setter of componentiScelti
	 * @param componentiScelti
	 */
	public void setComponentiScelti(Componente[] componentiScelti) {
		this.componentiScelti = componentiScelti;
	}

	/**
	 * Getter of componentiStandard
	 * @return componentiStandard
	 */
	public Componente[] getComponentiStandard() {
		return componentiStandard;
	}

	/**
	 * Setter of componentiStandard
	 * @param componentiStandard
	 */
	public void setComponentiStandard(Componente[] componentiStandard) {
		this.componentiStandard = componentiStandard;
	}

	/**
	 * Getter of maxComponentiScelti
	 * @return maxComponentiScelti
	 */
	public int getMaxComponentiScelti() {
		return maxComponentiScelti;
	}

	/**
	 * Setter of maxComponentiScelti
	 * @param maxComponentiScelti
	 */
	public void setMaxComponentiScelti(int maxComponentiScelti) {
		this.maxComponentiScelti = maxComponentiScelti;
	}
		

}
