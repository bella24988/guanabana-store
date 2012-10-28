package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modello.Computer;
import modello.Configurazione;


/**
 * @author  Veronica
 */
public class PreventivoController implements ActionListener{
	
	/**
	 * @uml.property  name="configPanel"
	 * @uml.associationEnd  
	 */
	private ConfigPanel configPanel;
	

	/**
	 * @uml.property  name="preventivoPanel"
	 * @uml.associationEnd  
	 */
	private PreventivoPanel preventivoPanel;
	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  
	 */
	private Computer computer;
	/**
	 * @uml.property  name="configurazioneScelta"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
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
	 * @uml.property  name="contenutoPanel"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel contenutoPanel;

	
	


	public PreventivoController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getActionCommand().equalsIgnoreCase("Conferma Ordine")){
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
			System.out.println("Possizione di scelta: "+indiceCompScelti+ "i:"+i);
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
	
	private float calcolarePrezzoTotale(int i, float prezzoVecchio){
		float prezzo = configPanel.getConfigurazione().getComponenti()[i].getPrezzo();
		float temp = new Float( preventivoPanel.getTotalePreventivo());
		float prezzoTotale = temp + prezzo - prezzoVecchio;
		preventivoPanel.setTotalePreventivo(String.valueOf(prezzoTotale));
		return prezzo;
	}


	public void setElementiConfigurazione(int indexConfigScelta, int indexComponenti){
		configPanel.getConfigurazione().setConfigurazioneScelta(indexComponenti, indexConfigScelta);
	}

	/**
	 * @return  the preventivoPanel
	 * @uml.property  name="preventivoPanel"
	 */
	public PreventivoPanel getPreventivoPanel() {
		return preventivoPanel;
	}


	/**
	 * @param preventivoPanel  the preventivoPanel to set
	 * @uml.property  name="preventivoPanel"
	 */
	public void setPreventivoPanel(PreventivoPanel preventivoPanel) {
		this.preventivoPanel = preventivoPanel;
	}


	

	/**
	 * @return  the contenutoPanel
	 * @uml.property  name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel  the contenutoPanel to set
	 * @uml.property  name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}


	
	/**
	 * @return
	 * @uml.property  name="configPanel"
	 */
	public ConfigPanel getConfigPanel() {
		return configPanel;
	}

	/**
	 * @param configPanel
	 * @uml.property  name="configPanel"
	 */
	public void setConfigPanel(ConfigPanel configPanel) {
		this.configPanel = configPanel;
	}

	/**
	 * @return  the computer
	 * @uml.property  name="computer"
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer  the computer to set
	 * @uml.property  name="computer"
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	

}
