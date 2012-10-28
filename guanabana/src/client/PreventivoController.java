package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modello.Computer;


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
			contenutoPanel.nascondeModelli();
			contenutoPanel.mostraConfermaOrdine(computer, configPanel.getConfigurazione(), new Float(preventivoPanel.getTotalePreventivo()), contenutoPanel.getModelloView());
		}else {
			int i = Integer.parseInt(e.getActionCommand().substring(3));//posizione del componente configurabile
			
			if(e.getActionCommand().substring(0, 3).compareTo("RAM")==0){//Controlla i buttons per la ram
				prezzoRamOld = calcolarePrezzoTotale(i, prezzoRamOld);
				setElementiConfigurazione(0,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("CPU")==0){//CPU
				prezzoCpuOld = calcolarePrezzoTotale(i, prezzoCpuOld);
				setElementiConfigurazione(1,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("PCI")==0){//PCI
				prezzoPciOld = calcolarePrezzoTotale(i, prezzoPciOld);
				setElementiConfigurazione(2,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MLC")==0){//MLC
				prezzoMlcOld = calcolarePrezzoTotale(i, prezzoMlcOld);
				setElementiConfigurazione(3,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HDD")==0){//HDD
				prezzoHddOld = calcolarePrezzoTotale(i, prezzoHddOld);
				setElementiConfigurazione(4,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD1")==0){//HD1
				prezzoHd1Old = calcolarePrezzoTotale(i, prezzoHd1Old);
				setElementiConfigurazione(5,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD2")==0){//HD2
				prezzoHd2Old = calcolarePrezzoTotale(i, prezzoHd2Old);
				setElementiConfigurazione(6,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD3")==0){//HD3
				prezzoHd3Old = calcolarePrezzoTotale(i, prezzoHd3Old);
				setElementiConfigurazione(7,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("DVD")==0){//Dvd
				prezzoDvdOld = calcolarePrezzoTotale(i, prezzoDvdOld);
				setElementiConfigurazione(8,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("WAR")==0){//Garanzia
				prezzoWarOld = calcolarePrezzoTotale(i, prezzoWarOld);
				setElementiConfigurazione(9,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MOU")==0){//Mouse
				prezzoMouOld = calcolarePrezzoTotale(i, prezzoMouOld);
				setElementiConfigurazione(10,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("GPU")==0){//Scheda grafica
				prezzoGpuOld = calcolarePrezzoTotale(i, prezzoGpuOld);
				setElementiConfigurazione(11,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MON")==0){//Monitor
				prezzoMonOld = calcolarePrezzoTotale(i, prezzoMonOld);
				setElementiConfigurazione(12,i);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("KEY")==0){//Tastiera
				prezzoKeyOld = calcolarePrezzoTotale(i, prezzoKeyOld);
				setElementiConfigurazione(13,i);
			}
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
