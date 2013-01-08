package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import modello.Pagamento;

/**
 * Classe PagamentoController: controller del pannello di pagamento.
 * Implementa ActionListener.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class PagamentoController implements ActionListener {

	/**
	 * Dichiarazione delle variabili
	 */
	private PagamentoPanel pagamentoPanel;
	private String tipoPagamento;

	/**
	 * Costruttore del controller del pannello di pagamento.
	 * @param pagamentoPanel
	 */
	public PagamentoController(PagamentoPanel pagamentoPanel) {
		super();
		this.pagamentoPanel = pagamentoPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("carta di credito")) {
			pagamentoPanel.getPanelCartaCredito().setVisible(true);
			pagamentoPanel.getPanelBonifico().setVisible(false);
			pagamentoPanel.getPanelContrassegno().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(1);

		} else if (e.getActionCommand().equalsIgnoreCase("bonifico")) {
			pagamentoPanel.getPanelBonifico().setVisible(true);
			pagamentoPanel.getPanelContrassegno().setVisible(false);
			pagamentoPanel.getPanelCartaCredito().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(2);

		} else if (e.getActionCommand().equalsIgnoreCase("contrassegno")) {
			pagamentoPanel.getPanelContrassegno().setVisible(true);
			pagamentoPanel.getPanelCartaCredito().setVisible(false);
			pagamentoPanel.getPanelBonifico().setVisible(false);
			pagamentoPanel.setTipoPagamentoScelto(3);

		} else if (e.getActionCommand().equalsIgnoreCase("accetta")) {
			pagamentoPanel.setEnabled(false);
			if (pagamentoPanel.getContenutoPanel().getClienteLoggato() != null) {

				ServizioClient client = new ServizioClient(pagamentoPanel.getContenutoPanel()
						.getHost());

				if (pagamentoPanel.getTipoPagamentoScelto() == 0) {
					pagamentoPanel
							.mostraMessaggioErrore("Selezionare il tipo di pagamento");
					pagamentoPanel.setEnabled(true);
				} else {
					if (validate(pagamentoPanel)) {
						try {
							Pagamento pagamento;
							
							if(getTipoPagamento().compareTo("Carta di Credito")==0){
								pagamento = client.registrarePagamento(pagamentoPanel
										.getContenutoPanel().getOrdine(),
										getTipoPagamento(), pagamentoPanel.getTxtIntestatario(), pagamentoPanel.getTxtCarta());
							}else if(getTipoPagamento().compareTo("Bonifico")==0){
								pagamento = client.registrarePagamento(pagamentoPanel
										.getContenutoPanel().getOrdine(),
										getTipoPagamento(), pagamentoPanel.getTxtCodiceBonifico(), pagamentoPanel.getTxtBanca());
							}else{
								pagamento = client.registrarePagamento(pagamentoPanel
										.getContenutoPanel().getOrdine(),
										getTipoPagamento(), "","");
							}
							pagamentoPanel.getContenutoPanel()
									.mostraRingraziamento();
							pagamentoPanel.getContenutoPanel().getOrdine().setPagamento(pagamento);
							try {
								client.inviaEmailConferma(pagamentoPanel.getContenutoPanel().getOrdine().getCliente().getEmail(),//email cliente
										pagamentoPanel.getContenutoPanel().getOrdine().getMessaggioEmail(pagamento, "Abbiamo ricevuto il tuo ordine! " +
												"Appena avremo ricevuto il suo pagamento, le invieremmo un&rsquo;email di conferma."),//messaggio della email
										"Ricevuta - Ordine Numero: "+pagamentoPanel.getContenutoPanel().getOrdine().getNumeroOrdine());//subject della email
							} catch (AddressException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (MessagingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}
				}
			}
		} else {
			pagamentoPanel.setEnabled(true);
		}

	}

	/**
	 * Validazione dei campi del form di pagamento, ottenuta con Java Pattern
	 * @param p
	 * @return true or false se il form e' rispettivamente valido o non valido
	 */
	private boolean validate(PagamentoPanel p) {

		if (p.getTipoPagamentoScelto() == 1) {

			setTipoPagamento("Carta di Credito");

			Matcher cardNumberMatcher = null;
			Matcher intestatarioMatcher = null;
			Matcher codSicurezzaMatcher = null;

			Pattern cardNumberPattern = Pattern.compile("[0-9]{16}");
			Pattern intestatarioPattern = Pattern.compile("[a-zA-Z ]{2,}");
			Pattern codSicurezzaPattern = Pattern.compile("[0-9]{3}");

			cardNumberMatcher = cardNumberPattern.matcher(p.getTxtCarta());
			intestatarioMatcher = intestatarioPattern.matcher(p
					.getTxtIntestatario());
			codSicurezzaMatcher = codSicurezzaPattern.matcher(p
					.getTxtCodSicurezza());

			if (!cardNumberMatcher.matches()) {
				p.mostraMessaggioErrore("Il numero della carta deve essere di 16 cifre \ne non deve contenere spazi");
				return false;
			}

			if (!intestatarioMatcher.matches()) {
				p.mostraMessaggioErrore("Inserire il nome dell'intestatario \ncome riportato sulla carta");
				return false;
			}

			if (!codSicurezzaMatcher.matches()) {
				p.mostraMessaggioErrore("Il codice di sicurezza e' di tre cifre \ne si trova sul retro della carta");
				return false;
			}

			if (cardNumberMatcher.matches())
				if (intestatarioMatcher.matches())
					if (codSicurezzaMatcher.matches()) {
						return true;
					}

		} else if (p.getTipoPagamentoScelto() == 2) {

			setTipoPagamento("Bonifico");

			//Matcher codiceBonificoMatcher = null;
			Matcher bancaMatcher = null;

			//Pattern codiceBonificoPattern = Pattern.compile("[a-zA-Z]{4,}");
			Pattern bancaPattern = Pattern.compile("[a-zA-Z ]+");

			//codiceBonificoMatcher = codiceBonificoPattern.matcher(p
				//	.getTxtCodiceBonifico());
			bancaMatcher = bancaPattern.matcher(p.getTxtBanca());

			/*if (!codiceBonificoMatcher.matches()) {
				p.mostraMessaggioErrore("Il codice della transazione deve essere di almeno 4 cifre \ne non deve contenere spazi");
				return false;
			}*/

			if (!bancaMatcher.matches()) {
				p.mostraMessaggioErrore("Inserire il nome della banca");
				return false;
			}

			/*if (codiceBonificoMatcher.matches())
				if (bancaMatcher.matches()) {
					return true;
				}*/
			return true;

		} else if (p.getTipoPagamentoScelto() == 3) {
			setTipoPagamento("Contrassegno");
			return true;
		}

		p.mostraMessaggioErrore("Errore di pagamento");
		return false;

	}

	/**
	 * Getter of pagamentoPanel
	 * @return pagamentoPanel
	 */
	public PagamentoPanel getPagamentoPanel() {
		return pagamentoPanel;
	}

	/**
	 * Setter of pagamentoPanel
	 * @param pagamentoPanel
	 */
	public void setPagamentoPanel(PagamentoPanel pagamentoPanel) {
		this.pagamentoPanel = pagamentoPanel;
	}

	/**
	 * Getter of tipoPagamento
	 * @return tipoPagamento
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}

	/**
	 * Setter of tipoPagamento
	 * @param tipoPagamento
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

}
