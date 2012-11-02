package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Ordine;

/**
 * @author  Veronica
 */
public class MagazinoController implements ActionListener{
	/**
	 * @uml.property  name="panelPrincipalGestione"
	 * @uml.associationEnd  
	 */
	private MagazinoPanel magazzinoPanel;
	private Ordine[] ordini;
	private SistemaGestioneFinestra sistemaGestioneFinestra;


	public MagazinoController(SistemaGestioneFinestra sisFinestra) {
		this.setSistemaGestioneFinestra(sisFinestra);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().substring(0, 4).compareTo("Sped")==0){
			sistemaGestioneFinestra.getContenutoPanel().remove(magazzinoPanel);
			try {
				int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
				Ordine ordine = magazzinoPanel.getOrdini()[indiceArray];
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				servizioClientAzienda.aggiornaStatoOrdine("SPEDITO", ordine.getNumeroOrdine());
				refreshOrdini();	
			} catch (IOException e1) {
				sistemaGestioneFinestra.setTxtErrore("Non è stato possibile communicare con il server");
				e1.printStackTrace();
			}
			
		   
		}else if (e.getActionCommand().compareTo("Magazzino")==0) {
			refreshOrdini();
		}
		
	}
	
	public void refreshOrdini() {
		setOrdini(sistemaGestioneFinestra.enlistaOrdini("RICHIESTO AL MAGAZZINO"));
		magazzinoPanel = new MagazinoPanel(ordini, this);
		if(getOrdini()!=null){
		sistemaGestioneFinestra.getContenutoPanel().add(magazzinoPanel);
		magazzinoPanel.setVisible(true);
		}else{
			magazzinoPanel.setVisible(false);
			sistemaGestioneFinestra.setTxtErrore("Non ci sono ordini da spedire");
			sistemaGestioneFinestra.getContenutoPanel().removeAll();
		}
		sistemaGestioneFinestra.Refresh();
	}



	/**
	 * @return  the panelPrincipalGestione
	 * @uml.property  name="panelPrincipalGestione"
	 */
	public MagazinoPanel getPanelPrincipalGestione() {
		return magazzinoPanel;
	}



	/**
	 * @param panelPrincipalGestione  the panelPrincipalGestione to set
	 * @uml.property  name="panelPrincipalGestione"
	 */
	public void setPanelPrincipalGestione(MagazinoPanel panelPrincipalGestione) {
		this.magazzinoPanel = panelPrincipalGestione;
	}

	/**
	 * @return the ordini
	 * @uml.property name="ordini"
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * @param ordini
	 *            the ordini to set
	 * @uml.property name="ordini"
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}



	/**
	 * @return the sistemaGestioneFinestra
	 */
	public SistemaGestioneFinestra getSistemaGestioneFinestra() {
		return sistemaGestioneFinestra;
	}



	/**
	 * @param sistemaGestioneFinestra the sistemaGestioneFinestra to set
	 */
	public void setSistemaGestioneFinestra(SistemaGestioneFinestra sistemaGestioneFinestra) {
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}
}
