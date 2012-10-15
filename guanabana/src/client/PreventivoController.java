package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Configurazione;

public class PreventivoController implements ActionListener{
	
	private ConfServerPanel confServerPanel;
	private PreventivoPanel preventivoPanel;
	private String nome, tipo;
	private Configurazione configurazione;
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
	private ContenutoPanel contenutoPanel;



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (e.getActionCommand().equalsIgnoreCase("Conferma Ordine")){
			contenutoPanel.nascondeModelli();
			configurazione = new Configurazione();
			System.out.println(getNome());
			contenutoPanel.mostraConfermaOrdine(getNome(), getPrezzoBrutto(), configurazione, new Float(preventivoPanel.getTotalePreventivo()));
		}else {
			int i = Integer.parseInt(e.getActionCommand().substring(3));	
			if(e.getActionCommand().substring(0, 3).compareTo("ram")==0){//Controlla i buttons per la ram
				prezzoRamOld = calcolarePrezzoTotale(i, prezzoRamOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("cpu")==0){//CPU
				prezzoCpuOld = calcolarePrezzoTotale(i, prezzoCpuOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("pci")==0){//PCI
				prezzoPciOld = calcolarePrezzoTotale(i, prezzoPciOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("mlc")==0){//MLC
				prezzoMlcOld = calcolarePrezzoTotale(i, prezzoMlcOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("hdd")==0){//HDD
				prezzoHddOld = calcolarePrezzoTotale(i, prezzoHddOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("hd1")==0){//HD1
				prezzoHd1Old = calcolarePrezzoTotale(i, prezzoHd1Old);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("hd2")==0){//HD2
				prezzoHd2Old = calcolarePrezzoTotale(i, prezzoHd2Old);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("hd3")==0){//HD3
				prezzoHd3Old = calcolarePrezzoTotale(i, prezzoHd3Old);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("dvd")==0){//Dvd
				prezzoDvdOld = calcolarePrezzoTotale(i, prezzoDvdOld);
				
			}else if(e.getActionCommand().substring(0, 3).compareTo("war")==0){//Garanzia
				prezzoWarOld = calcolarePrezzoTotale(i, prezzoWarOld);
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


}
