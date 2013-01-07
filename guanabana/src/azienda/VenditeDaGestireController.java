package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import modello.Ordine;

/**
 * Classe VenditeDaGestireController: Controller del pannello rivolto al reparto
 * vendite, che si occupa degli ordini ancora in gestione (in attesa di pagamento o da spedire).
 * Implementa ActionListener e ItemListener.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class VenditeDaGestireController implements ActionListener, ItemListener {

	/**
	 * Dichiarazione delle variabili.
	 */
	private SistemaGestioneFinestra sistemaGestioneFinestra;
	private VenditeDaGestirePanel veGestirePanel;

	/**
	 * Costruttore del controller delle vendite da gestire.
	 * @param sistemaGestioneFinestra
	 */
	public VenditeDaGestireController(
			SistemaGestioneFinestra sistemaGestioneFinestra) {
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().compareTo("Ordini da gestire") == 0) {
			refreshFinestra("VENDUTO");
		} else if (e.getActionCommand().compareTo("invia al magazzino") == 0) {
			JButton buttonPressed = (JButton) e.getSource();
			inviaMessaggioCambiaStato(buttonPressed, "RICHIESTO AL MAGAZZINO", "Abbiamo ricevuto il suo pagamento!");
			refreshFinestra("VENDUTO");
			
		}else if (e.getActionCommand().compareTo("richiede pagamento") == 0) {
			JButton buttonPressed = (JButton) e.getSource();
			inviaMessaggioCambiaStato(buttonPressed, "ORDINATO", "Il suo pagamento non &eacute; stato accettato, vi preghiamo di procedere di nuovo alla transazione dalla sezione &ldquo;Carrello&rdquo;");
			Ordine ordine = veGestirePanel.getOrdini()[buttonPressed.getMnemonic()];
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			try {
				servizioClientAzienda.cancellaPagamento(ordine.getPagamento());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	/**
	 * Metodo che invia una mail al cliente ad ogni cambio di stato dell'ordine.
	 * @param invio
	 * @param nuovoStato
	 * @param messaggioEmail
	 */
	private void inviaMessaggioCambiaStato(JButton invio,String nuovoStato, String messaggioEmail){
		veGestirePanel.setVisible(false);
		ClientAzienda servizioClientAzienda = new ClientAzienda();
		try {
			servizioClientAzienda.aggiornaStatoOrdine(
					nuovoStato,
					veGestirePanel.getOrdini()[invio.getMnemonic()]
							.getNumeroOrdine());
			servizioClientAzienda.inviaEmailConferma(veGestirePanel.getOrdini()[invio.getMnemonic()].getCliente().getEmail(),//email cliente
					veGestirePanel.getOrdini()[invio.getMnemonic()].getMessaggioEmail(veGestirePanel
							.getOrdini()[invio.getMnemonic()].getPagamento(), messaggioEmail),//messaggio della email
					"Ricevuta - Ordine Numero: "+veGestirePanel
					.getOrdini()[invio.getMnemonic()].getNumeroOrdine());//subject della email
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/**
	 * Metodo che permette di aggiornare la finestra degli ordini da gestire.
	 * @param tipo
	 */
	private void refreshFinestra(String tipo) {
		sistemaGestioneFinestra.pulisceSchermo();
		Ordine[] ordini = sistemaGestioneFinestra.elencaOrdini(tipo);
		if (ordini == null) {
			sistemaGestioneFinestra
					.setTxtErrore("Non ci sono ordini da gestire");
		} else if (tipo == "VENDUTO") {
			veGestirePanel = new VenditeDaGestirePanel(ordini, this);
			sistemaGestioneFinestra.getContenutoPanel().add(veGestirePanel);
			veGestirePanel.setVisible(true);
		}
		sistemaGestioneFinestra.Refresh();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			ClientAzienda clientAzienda = new ClientAzienda();
			JCheckBox btnConferma = (JCheckBox) e.getSource();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				veGestirePanel.mostraBottoneInvio(btnConferma.getMnemonic());
				clientAzienda.confermarePagamento(true, veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getNumeroOrdine());
			} else {
				veGestirePanel.nascondiBottoneInvio(btnConferma.getMnemonic());
				clientAzienda.confermarePagamento(false, veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getNumeroOrdine());
			}
		} catch (Exception e2) {
		}

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
	public void setSistemaGestioneFinestra(
			SistemaGestioneFinestra sistemaGestioneFinestra) {
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}

	/**
	 * Getter of veGestirePanel
	 * @return veGestirePanel
	 */
	public VenditeDaGestirePanel getVeGestirePanel() {
		return veGestirePanel;
	}

	/**
	 * Setter of veGestirePanel
	 * @param veGestirePanel
	 */
	public void setVeGestirePanel(VenditeDaGestirePanel veGestirePanel) {
		this.veGestirePanel = veGestirePanel;
	}

}
