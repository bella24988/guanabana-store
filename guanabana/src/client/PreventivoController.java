package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Configurazione;

public class PreventivoController implements ActionListener{
	
	private ConfServerPanel confServerPanel;
	private ConfDesktopPanel confDesktopPanel;
	private PreventivoPanel preventivoPanel;
	private String nome, tipo;
	private Configurazione[] configurazione;
	private float prezzoBrutto;
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
	private ContenutoPanel contenutoPanel;

	
	


	public PreventivoController() {
		super();
		configurazione = new Configurazione[10];
		
		for(int i = 0; i<10 ; i++){
			configurazione[i] = new Configurazione();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getActionCommand().equalsIgnoreCase("Conferma Ordine")){
			contenutoPanel.nascondeModelli();
			contenutoPanel.mostraConfermaOrdine(getNome(), getPrezzoBrutto(), configurazione, new Float(preventivoPanel.getTotalePreventivo()));
		}else {
			int i = Integer.parseInt(e.getActionCommand().substring(3));//NUMERO DEL COMANDO VA DA 0 A 9--- ESEMPIO RAM = 0
			
			if(e.getActionCommand().substring(0, 3).compareTo("RAM")==0){//Controlla i buttons per la ram
				prezzoRamOld = calcolarePrezzoTotale(i, prezzoRamOld);
				setElementiConfigurazione(0,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("CPU")==0){//CPU
				prezzoCpuOld = calcolarePrezzoTotale(i, prezzoCpuOld);
				setElementiConfigurazione(1,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("PCI")==0){//PCI
				prezzoPciOld = calcolarePrezzoTotale(i, prezzoPciOld);
				setElementiConfigurazione(2,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MLC")==0){//MLC
				prezzoMlcOld = calcolarePrezzoTotale(i, prezzoMlcOld);
				setElementiConfigurazione(3,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HDD")==0){//HDD
				prezzoHddOld = calcolarePrezzoTotale(i, prezzoHddOld);
				setElementiConfigurazione(4,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD1")==0){//HD1
				prezzoHd1Old = calcolarePrezzoTotale(i, prezzoHd1Old);
				setElementiConfigurazione(5,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD2")==0){//HD2
				prezzoHd2Old = calcolarePrezzoTotale(i, prezzoHd2Old);
				setElementiConfigurazione(6,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("HD3")==0){//HD3
				prezzoHd3Old = calcolarePrezzoTotale(i, prezzoHd3Old);
				setElementiConfigurazione(7,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("DVD")==0){//Dvd
				prezzoDvdOld = calcolarePrezzoTotale(i, prezzoDvdOld);
				setElementiConfigurazione(8,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("WAR")==0){//Garanzia
				prezzoWarOld = calcolarePrezzoTotale(i, prezzoWarOld);
				setElementiConfigurazione(9,confServerPanel.getComponenti()[i].getCodice(),
						confServerPanel.getComponenti()[i].getNome(), confServerPanel.getComponenti()[i].getPrezzo());
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MOU")==0){//Mouse
				prezzoMouOld = calcolarePrezzoTotale(i, prezzoMouOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("GPU")==0){//Scheda grafica
				prezzoGpuOld = calcolarePrezzoTotale(i, prezzoGpuOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("MON")==0){//Monitor
				prezzoMonOld = calcolarePrezzoTotale(i, prezzoMonOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("KEY")==0){//Tastiera
				prezzoKeyOld = calcolarePrezzoTotale(i, prezzoKeyOld);
			}
		}
		
		
	}
	
	private float calcolarePrezzoTotale(int i, float prezzoVecchio){
		float prezzo = confServerPanel.getComponenti()[i].getPrezzo();
		float temp = new Float( preventivoPanel.getTotalePreventivo());
		float prezzoTotale = temp + prezzo - prezzoVecchio;
		preventivoPanel.setTotalePreventivo(String.valueOf(prezzoTotale));
		return prezzo;
	}


	public void setElementiConfigurazione(int i, String codice, String nome, float prezzo){
		configurazione[i].setCodice(codice);
		configurazione[i].setNome(nome);
		configurazione[i].setPrezzo(prezzo);
	}

	/**
	 * @return the confServerPanel
	 */
	public ConfServerPanel getConfServerPanel() {
		return confServerPanel;
	}


	/**
	 * @param confServerPanel the confServerPanel to set
	 */
	public void setConfServerPanel(ConfServerPanel confServerPanel) {
		this.confServerPanel = confServerPanel;
	}


	/**
	 * @return the preventivoPanel
	 */
	public PreventivoPanel getPreventivoPanel() {
		return preventivoPanel;
	}


	/**
	 * @param preventivoPanel the preventivoPanel to set
	 */
	public void setPreventivoPanel(PreventivoPanel preventivoPanel) {
		this.preventivoPanel = preventivoPanel;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel the contenutoPanel to set
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * @return the prezzoBrutto
	 */
	public float getPrezzoBrutto() {
		return prezzoBrutto;
	}

	/**
	 * @param prezzoBrutto the prezzoBrutto to set
	 */
	public void setPrezzoBrutto(float prezzoBrutto) {
		this.prezzoBrutto = prezzoBrutto;
	}

	public ConfDesktopPanel getConfDesktopPanel() {
		return confDesktopPanel;
	}

	public void setConfDesktopPanel(ConfDesktopPanel confDesktopPanel) {
		this.confDesktopPanel = confDesktopPanel;
	}


}