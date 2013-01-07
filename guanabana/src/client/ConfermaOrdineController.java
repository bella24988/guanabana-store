package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Classe ConfermaOrdineController: Controller per confermare l'ordine.
 * Implementa ActionListener
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class ConfermaOrdineController implements ActionListener{

	/** Pannello per confermare l'ordine */
	private ConfermaOrdinePanel confermaOrdinePanel;
	
	
	/** Costruttore del controllore
	 * @param confermaOrdinePanel
	 */
	public ConfermaOrdineController(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Aggiunge al carrello")){
			//confermaOrdinePanel.getContenutoPanel().getComputer().setConfigurazioneScelta(confermaOrdinePanel.getConfigurazione());
			confermaOrdinePanel.getContenutoPanel().aggiungiPagamentoPanel(confermaOrdinePanel, confermaOrdinePanel.getPrezzoTotale());
		}
	}

	/** Restituisce il pannello di conferma ordine in uso
	 * @return confermaOrdinePanel
	 */
	public ConfermaOrdinePanel getConfermaOrdinePanel() {
		return confermaOrdinePanel;
	}

	/** Setter del pannello di conferma ordine
	 * @param confermaOrdinePanel		Pannello di conferma ordine da settare
	 */
	public void setConfermaOrdinePanel(ConfermaOrdinePanel confermaOrdinePanel) {
		this.confermaOrdinePanel = confermaOrdinePanel;
	}

}
