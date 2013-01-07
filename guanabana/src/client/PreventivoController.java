package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modello.Computer;

/**
 * Classe PreventivoController: Controlla il pannello di preventivo,
 * aggiornando il prezzo totale a seguito del cambio di configurazione
 * e permettendo di passare poi all'ordine e pagamento.
 * Implementa ActionListener.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class PreventivoController implements ActionListener{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private ConfigPanel configPanel;
	private PreventivoPanel preventivoPanel;
	private ContenutoPanel contenutoPanel;

	private Computer computer;
	
	private float prezzoRamOld;
	private float prezzoCpuOld;
	private float prezzoPciOld;
	private float prezzoMlcOld;
	private float prezzoHddOld;
	private float prezzoHd1Old;
	private float prezzoHd2Old;
	private float prezzoHd3Old;
	private float prezzoDvdOld;
	private float prezzoWarOld;
	private float prezzoMouOld;
	private float prezzoGpuOld;
	private float prezzoKeyOld;
	private float prezzoMonOld;
	
	private int indiceCompScelti;

	/**
	 * Costruttore del controller del preventivo
	 */
	public PreventivoController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getActionCommand().equalsIgnoreCase("Conferma configurazione")){
			configPanel.getConfigurazione();
			contenutoPanel.nascondeModelli();
			contenutoPanel.mostraConfermaOrdine(computer, configPanel.getConfigurazione(), new Float(preventivoPanel.getTotalePreventivo()), contenutoPanel.getModelloView());
		}else {
			String comando = e.getActionCommand().substring(0, 3);
			for (int i = 0; i < configPanel.getConfigurazione().getMaxComponentiScelti(); i++) {
				if(configPanel.getTipocomponenti()[configPanel.getCompTipo()][i].compareTo(comando)==0){
					indiceCompScelti = i;
				}
			}
			int i = Integer.parseInt(e.getActionCommand().substring(3));//posizione del componente configurabile
			
			if(comando.compareTo("RAM")==0){//Controlla i buttons per la ram
				prezzoRamOld = calcolarePrezzoTotale(i, prezzoRamOld);
				
			}else if(comando.compareTo("CPU")==0){//CPU
				prezzoCpuOld = calcolarePrezzoTotale(i, prezzoCpuOld);
				
			}else if(comando.compareTo("PCI")==0){//PCI
				prezzoPciOld = calcolarePrezzoTotale(i, prezzoPciOld);
				
			}else if(comando.compareTo("MLC")==0){//MLC
				prezzoMlcOld = calcolarePrezzoTotale(i, prezzoMlcOld);
				
			}else if(comando.compareTo("HDD")==0){//HDD
				prezzoHddOld = calcolarePrezzoTotale(i, prezzoHddOld);
				
			}else if(comando.compareTo("HD1")==0){//HD1
				prezzoHd1Old = calcolarePrezzoTotale(i, prezzoHd1Old);
				
			}else if(comando.compareTo("HD2")==0){//HD2
				prezzoHd2Old = calcolarePrezzoTotale(i, prezzoHd2Old);
				
			}else if(comando.compareTo("HD3")==0){//HD3
				prezzoHd3Old = calcolarePrezzoTotale(i, prezzoHd3Old);
				
			}else if(comando.compareTo("DVD")==0){//Dvd
				prezzoDvdOld = calcolarePrezzoTotale(i, prezzoDvdOld);
				
			}else if(comando.compareTo("WAR")==0){//Garanzia
				prezzoWarOld = calcolarePrezzoTotale(i, prezzoWarOld);
				
			}else if(comando.compareTo("MOU")==0){//Mouse
				prezzoMouOld = calcolarePrezzoTotale(i, prezzoMouOld);
				
			}else if(comando.compareTo("GPU")==0){//Scheda grafica
				prezzoGpuOld = calcolarePrezzoTotale(i, prezzoGpuOld);
				
			}else if(comando.compareTo("MON")==0){//Monitor
				prezzoMonOld = calcolarePrezzoTotale(i, prezzoMonOld);
				
			}else if(comando.compareTo("KEY")==0){//Tastiera
				prezzoKeyOld = calcolarePrezzoTotale(i, prezzoKeyOld);
			}
			setElementiConfigurazione(indiceCompScelti,i);
		}
		
		
	}
	
	/**
	 * Permette di aggiornare il prezzo totale, calcolando la differenza dopo un cambio
	 * di configurazione
	 * @param i
	 * @param prezzoVecchio				Prezzo totale da aggiornare
	 * @return prezzo					Prezzo totale aggiornato
	 */
	private float calcolarePrezzoTotale(int i, float prezzoVecchio){
		float prezzo = configPanel.getConfigurazione().getComponenti()[i].getPrezzo();
		float temp = new Float( preventivoPanel.getTotalePreventivo());
		float prezzoTotale = temp + prezzo - prezzoVecchio;
		preventivoPanel.setTotalePreventivo(String.valueOf(prezzoTotale));
		return prezzo;
	}

	/**
	 * Setta i componenti della configurazione scelta
	 * @param indexConfigScelta
	 * @param indexComponenti
	 */
	public void setElementiConfigurazione(int indexConfigScelta, int indexComponenti){
		configPanel.getConfigurazione().setConfigurazioneScelta(indexComponenti, indexConfigScelta);
	}

	/**
	 * Getter of preventivoPanel
	 * @return preventivoPanel
	 */
	public PreventivoPanel getPreventivoPanel() {
		return preventivoPanel;
	}


	/**
	 * Setter of preventivoPanel
	 * @param preventivoPanel
	 */
	public void setPreventivoPanel(PreventivoPanel preventivoPanel) {
		this.preventivoPanel = preventivoPanel;
	}

	/**
	 * Getter of contenutoPanel
	 * @return contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of contenutoPanel
	 * @param contenutoPanel
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}
	
	/**
	 * Getter of configPanel
	 * @return configPanel
	 */
	public ConfigPanel getConfigPanel() {
		return configPanel;
	}

	/**
	 * Setter of configPanel
	 * @param configPanel
	 */
	public void setConfigPanel(ConfigPanel configPanel) {
		this.configPanel = configPanel;
	}

	/**
	 * Getter of computer
	 * @return computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * Setter of computer
	 * @param computer
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	

}
