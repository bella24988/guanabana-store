package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Ordine;

/**
 * Classe MagazzinoController: Controller del pannello di magazzino.
 * Implementa ActionListener.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class MagazzinoController implements ActionListener{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private MagazzinoPanel magazzinoPanel;
	private Ordine[] ordini;
	private SistemaGestioneFinestra sistemaGestioneFinestra;

	/**
	 * Costruttore del controller di magazzino
	 * @param sisFinestra
	 */
	public MagazzinoController(SistemaGestioneFinestra sisFinestra) {
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
				servizioClientAzienda.aggiornaStatoOrdine("PRONTO PER LA SPEDIZIONE", ordine.getNumeroOrdine());
				refreshOrdini();	
			} catch (IOException e1) {
				sistemaGestioneFinestra.setTxtErrore("Non e' stato possibile comunicare con il server");
				e1.printStackTrace();
			}
			
		   
		}else if (e.getActionCommand().compareTo("Magazzino")==0) {
			refreshOrdini();
		}
		
	}
	
	/**
	 * Metodo per aggiornare gli ordini richiesti al magazzino
	 */
	public void refreshOrdini() {
		sistemaGestioneFinestra.pulisceSchermo();
		setOrdini(sistemaGestioneFinestra.elencaOrdini("RICHIESTO AL MAGAZZINO"));
		magazzinoPanel = new MagazzinoPanel(ordini, this);
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
	 * Getter of magazzinoPanel
	 * @return  magazzinoPanel
	 */
	public MagazzinoPanel getPanelPrincipalGestione() {
		return magazzinoPanel;
	}



	/**
	 * Setter of magazzinoPanel
	 * @param panelPrincipalGestione
	 */
	public void setPanelPrincipalGestione(MagazzinoPanel panelPrincipalGestione) {
		this.magazzinoPanel = panelPrincipalGestione;
	}

	/**
	 * Getter of ordini
	 * @return ordini
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * Setter of ordini
	 * @param ordini
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

	/**
	 * Getter of sistemaGestioneFinestra
	 * @return sistemaGestioneFinestra
	 */
	public SistemaGestioneFinestra getSistemaGestioneFinestra() {
		return sistemaGestioneFinestra;
	}



	/**
	 * Setter of sistemaGestioneFinestra
	 * @param sistemaGestioneFinestra
	 */
	public void setSistemaGestioneFinestra(SistemaGestioneFinestra sistemaGestioneFinestra) {
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}
}
