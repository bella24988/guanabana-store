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

public class VenditaDaGestireController implements ActionListener, ItemListener {

	private SistemaGestioneFinestra sistemaGestioneFinestra;
	private VenditaDaGestirePanel veGestirePanel;

	public VenditaDaGestireController(
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
			inviaMessaggioCambiaStato(buttonPressed, "ORDINATO", "Il suo pagamento non &eacute; stato accettato, vi preghiamo di rifarlo. Nella voce &ldquo;Carrello&rdquo;");
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
	
	private void inviaMessaggioCambiaStato(JButton invio,String nuovoStato, String messagioEmail){
		veGestirePanel.setVisible(false);
		ClientAzienda servizioClientAzienda = new ClientAzienda();
		try {
			servizioClientAzienda.aggiornaStatoOrdine(
					nuovoStato,
					veGestirePanel.getOrdini()[invio.getMnemonic()]
							.getNumeroOrdine());
			servizioClientAzienda.inviaEmailConferma(veGestirePanel.getOrdini()[invio.getMnemonic()].getCliente().getEmail(),//email cliente
					veGestirePanel.getOrdini()[invio.getMnemonic()].getMessaggioEmail(veGestirePanel
							.getOrdini()[invio.getMnemonic()].getPagamento(), messagioEmail),//messaggio della email
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

	private void refreshFinestra(String tipo) {
		sistemaGestioneFinestra.pulisceSchermo();
		Ordine[] ordini = sistemaGestioneFinestra.enlistaOrdini(tipo);
		if (ordini == null) {
			sistemaGestioneFinestra
					.setTxtErrore("Non ci sono ordini da gestire");
		} else if (tipo == "VENDUTO") {
			veGestirePanel = new VenditaDaGestirePanel(ordini, this);
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
				veGestirePanel.mostraButtoneInvio(btnConferma.getMnemonic());
				clientAzienda.confermarePagamento(true, veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getNumeroOrdine());
			} else {
				veGestirePanel.nascondiButtoneInvio(btnConferma.getMnemonic());
				clientAzienda.confermarePagamento(false, veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()]
						.getNumeroOrdine());
			}
		} catch (Exception e2) {
		}

	}

	/**
	 * @return the sistemaGestioneFinestra
	 */
	public SistemaGestioneFinestra getSistemaGestioneFinestra() {
		return sistemaGestioneFinestra;
	}

	/**
	 * @param sistemaGestioneFinestra
	 *            the sistemaGestioneFinestra to set
	 */
	public void setSistemaGestioneFinestra(
			SistemaGestioneFinestra sistemaGestioneFinestra) {
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}

	/**
	 * @return the veGestirePanel
	 */
	public VenditaDaGestirePanel getVeGestirePanel() {
		return veGestirePanel;
	}

	/**
	 * @param veGestirePanel
	 *            the veGestirePanel to set
	 */
	public void setVeGestirePanel(VenditaDaGestirePanel veGestirePanel) {
		this.veGestirePanel = veGestirePanel;
	}

}
