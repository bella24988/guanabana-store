package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

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
			veGestirePanel.setVisible(false);
			JButton invio = (JButton) e.getSource();
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			try {
				servizioClientAzienda.aggiornaStatoOrdine(
						"RICHIESTO AL MAGAZZINO",
						veGestirePanel.getOrdini()[invio.getMnemonic()]
								.getNumeroOrdine());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			refreshFinestra("VENDUTO");
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
				clientAzienda.inviaEmailConferma(veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()].getCliente().getEmail(),//email cliente
						veGestirePanel.getOrdini()[btnConferma.getMnemonic()].getMessaggioEmail(veGestirePanel
								.getOrdini()[btnConferma.getMnemonic()].getPagamento(), "Abbiamo ricevuto il suo pagamento!"),//messaggio della email
						"Ricevuta - Ordine Numero: "+veGestirePanel
						.getOrdini()[btnConferma.getMnemonic()].getNumeroOrdine());//subject della email
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
