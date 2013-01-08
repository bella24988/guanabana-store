package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.itextpdf.text.DocumentException;

import modello.Fattura;
import modello.Ordine;

/**
 * Classe SpedizioneController: Controller del pannello dedicato agli impiegati
 * del reparto spedizione.
 * Implementa ActionListener.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class SpedizioneController implements ActionListener{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private Ordine[] ordini;
	private SistemaGestioneFinestra sistemaGestioneFinestra;
	private SpedizionePanel spedizionePanel;
	
	

	/**
	 * Costruttore del controller del pannello
	 * @param sistemaGestioneFinestra
	 */
	public SpedizioneController(SistemaGestioneFinestra sistemaGestioneFinestra) {
		super();
		this.sistemaGestioneFinestra = sistemaGestioneFinestra;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Spedizione")==0) {
			refreshOrdini();
		}else if (e.getActionCommand().substring(0, 4).compareTo("Sped")==0) {
			sistemaGestioneFinestra.getContenutoPanel().remove(spedizionePanel);
			try {
				int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
				Ordine ordine = spedizionePanel.getOrdini()[indiceArray];
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				servizioClientAzienda.aggiornaStatoOrdine("SPEDITO", ordine.getNumeroOrdine());
				servizioClientAzienda.inviaEmailConferma(ordine.getCliente().getEmail(),//email cliente
						ordine.getMessaggioEmail(ordine.getPagamento(), "Ordine in spedizione"),//messaggio della email
						"Ordine spedito - Ordine Numero: "+ordine.getNumeroOrdine());//subject della email
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
			refreshOrdini();
		}else if(e.getActionCommand().substring(0, 4).compareTo("Fatt")==0) {
			int indiceArray = Integer.parseInt(e.getActionCommand().substring(4));
			Ordine ordine = spedizionePanel.getOrdini()[indiceArray];
			ClientAzienda servizioClientAzienda = new ClientAzienda();
			Fattura fattura = null;
			try {
				fattura = servizioClientAzienda.cercaFattura(ordine);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String file = System.getProperty("user.home")+"/FATTURA_"+ordine.getNumeroOrdine()+".pdf";
			try {
				fattura.generareFattura(file);
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Metodo per aggiornare la lista degli ordini
	 * pronti per la spedizione.
	 */
	public void refreshOrdini() {
		sistemaGestioneFinestra.pulisceSchermo();
		setOrdini(sistemaGestioneFinestra.elencaOrdini("PRONTO PER LA SPEDIZIONE"));
		spedizionePanel = new SpedizionePanel(ordini, this);
		if(getOrdini()!=null){
		sistemaGestioneFinestra.getContenutoPanel().add(spedizionePanel);
		spedizionePanel.setVisible(true);
		}else{
			spedizionePanel.setVisible(false);
			sistemaGestioneFinestra.setTxtErrore("Non ci sono ordini da spedire");
			sistemaGestioneFinestra.getContenutoPanel().removeAll();
		}
		sistemaGestioneFinestra.Refresh();
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
	 * Getter of spedizionePanel
	 * @return spedizionePanel
	 */
	public SpedizionePanel getSpedizionePanel() {
		return spedizionePanel;
	}



	/**
	 * Setter of spedizionePanel
	 * @param spedizionePanel
	 */
	public void setSpedizionePanel(SpedizionePanel spedizionePanel) {
		this.spedizionePanel = spedizionePanel;
	}
	
	

}