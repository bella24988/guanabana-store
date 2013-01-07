package client;

import javax.swing.JPanel;

import modello.Cliente;
import modello.Computer;
import modello.Configurazione;
import modello.Ordine;
import modello.Pagamento;

import java.awt.Color;
import java.io.IOException;


/** 
 * Classe ContenutoPanel: Pannello che contiene tutti gli altri pannelli in uso di volta in volta
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class ContenutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Pannelli
	 */
	private RegistratiView registratiView;
	private RegistratiController registratiController;
	private ModelloView modelloView;
	private ConfermaOrdinePanel confermaOrdinePanel;
	
	/**
	 * Variabili
	 */
	private Cliente clienteLoggato;
	private boolean waitForBuy;
	private Computer computer;
	private Ordine ordine;
	private Pagamento pagamento;
	private String host;


	/**
	 * Costruttore del pannello contenitore
	 */
	public ContenutoPanel() {
		super();
		setBackground(Color.white);
		setForeground(new Color(0, 0, 0));
		this.setWaitForBuy(false);
	}

	/** Metodo che mostra il formulario di registrazione
	 * @param panel			Pannello di login
	 */
	public void mostraFormularioRegistrati(LogPanel panel) {
		removeAll();
		pulisceSchermo();
		registratiView = new RegistratiView(this);
		registratiView.setVisible(false);
		add(registratiView);
		registratiView.setVisible(true);
		registratiView.associaPanel(panel);
	}

	/**
	 *  Metodo che nasconde il formulario di registrazione
	 */
	public void nascondiFormularioRegistrati() {
		registratiView.setVisible(false);
		nascondeModelli();
	}

	/** Metodo che mostra i modelli disponibili
	 * @param num				Numero di modelli disponibili
	 * @param computers			Modelli di computer disponibili
	 * @param tipo				Tipo di computer
	 * @param contenutoPanel	Pannello contenitore in uso
	 */
	public void mostraModelli(int num, Computer[] computers, String tipo,
			ContenutoPanel contenutoPanel) {

		this.removeAll();
		pulisceSchermo();
		modelloView = new ModelloView();
		add(modelloView);
		modelloView.setVisible(true);
		modelloView = new ModelloView();
		add(modelloView);
		modelloView.mostraButtons(num, computers, tipo);
		modelloView.setVisible(true);
		modelloView.setBackground(Color.white);
		modelloView.setContenutoPanel(contenutoPanel);
	}

	/**
	 * Metodo che nasconde i modelli disponibili
	 */
	public void nascondeModelli() {
		modelloView.setVisible(false);
	}

	/** Metodo che mostra la schermata di conferma dell'ordine
	 * @param comp					Computer ordinato
	 * @param configurazione		Configurazione scelta
	 * @param prezzoTotale			Prezzo totale dell'ordine
	 * @param panelDaRimuovere
	 */
	public void mostraConfermaOrdine(Computer comp,
			Configurazione configurazione, float prezzoTotale,
			JPanel panelDaRimuovere) {
		panelDaRimuovere.setVisible(false);
		this.remove(panelDaRimuovere);
		pulisceSchermo();
		setComputer(comp);
		confermaOrdinePanel = new ConfermaOrdinePanel(comp.getNome(),
				comp.getPrezzo(), configurazione, prezzoTotale, this);
		confermaOrdinePanel.setVisible(true);
		add(confermaOrdinePanel);
	}
	
	/**
	 * Metodo per pulire la schermata
	 */
	public void pulisceSchermo() {
		JPanel pulito;
		pulito = new JPanel();
		pulito.setVisible(false);
		pulito.setBackground(Color.white);
		pulito.setSize(1000, 900);
		this.add(pulito);
		pulito.setVisible(true);
	}
	
	/** Aggiunge il pannello di pagamento
	 * @param panelDaRimuovere
	 * @param prezzoTotale
	 */
	public void aggiungiPagamentoPanel(ConfermaOrdinePanel panelDaRimuovere,
			float prezzoTotale) {
		confermaOrdinePanel.setPrezzoTotale(prezzoTotale);

		if (clienteLoggato != null) {
			remove(panelDaRimuovere);
			continuaOperazione();

		} else {
			setWaitForBuy(true);
			panelDaRimuovere
					.mostraMessaggioErrore("Per continuare con l'acquisto, devi fare il login o registrarti");
		}

	}

	/**
	 * Metodo di supporto all'operazione di pagamento
	 */
	public void continuaOperazione() {
		try {
			ServizioClient client = new ServizioClient(host);
			setOrdine(client.creaOrdine(getComputer(),
					confermaOrdinePanel.getPrezzoTotale(), clienteLoggato));

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		mostraPagamentoPanel();

	}

	/**
	 * Mostra il pannello di pagamento
	 */
	public void mostraPagamentoPanel() {
		removeAll();
		pulisceSchermo();
		setWaitForBuy(false);
		PagamentoPanel pagamentoPanel = new PagamentoPanel(this);
		add(pagamentoPanel);
		setVisible(true);
	}
	
	/**
	 * Mostra il pannello di ringraziamento
	 */
	public void mostraRingraziamento() {
		removeAll();
		pulisceSchermo();
		RigraziamentiPanel ringraziamento = new RigraziamentiPanel();
		ringraziamento.setVisible(true);
		add(ringraziamento);
	}

	/** Mostra il pannello "I tuoi ordini"
	 * @param ordini
	 * @param carr
	 */
	public void mostraTuoiOrdini(Ordine[] ordini, boolean carr) {
		removeAll();
		pulisceSchermo();
		TuoiOrdiniPanel tuoiOrdiniPanel = new TuoiOrdiniPanel(ordini, carr);
		tuoiOrdiniPanel.setContenutoPanel(this);
		add(tuoiOrdiniPanel);
		tuoiOrdiniPanel.setVisible(true);
	}

	/**
	 * Mostra il pannello di annullamento dell'ordine
	 */
	public void mostraAnnullaOrdine() {
		removeAll();
		pulisceSchermo();
		AnnullaOrdinePanel annullaOrdinePanel = new AnnullaOrdinePanel(
				getOrdine());
		annullaOrdinePanel.setContenutoPanel(this);
		add(annullaOrdinePanel);
		annullaOrdinePanel.setVisible(true);
	}
	
	/** Restituisce il pannello di registrazione
	 * @return registratiView
	 */
	public RegistratiView getRegistratiView() {
		return registratiView;
	}

	/** Setter del pannello di registrazione
	 * @param registratiView
	 */
	public void setRegistratiView(RegistratiView registratiView) {
		this.registratiView = registratiView;
	}
	
	/** Restituisce il controller del pannello di registrazione
	 * @return registratiController
	 */
	public RegistratiController getRegistratiController() {
		return registratiController;
	}
	
	/** Setter del controller del pannello di registrazione
	 * @param registratiController		Controller da settare
	 */
	public void setRegistratiController(
			RegistratiController registratiController) {
		this.registratiController = registratiController;
	}

	/** Restituisce il pannello che contiene i modelli
	 * @return modelloView
	 */
	public ModelloView getModelloView() {
		return modelloView;
	}

	/** Setter del pannello che contiene i modelli
	 * @param modelloView
	 */
	public void setModelloView(ModelloView modelloView) {
		this.modelloView = modelloView;
	}

	/** Restituisce il cliente che ha effettuato il login
	 * @return clienteLoggato
	 */
	public Cliente getClienteLoggato() {
		return clienteLoggato;
	}

	/** Setter del cliente che ha effettuato il login
	 * @param clienteLogato
	 */
	public void setClienteLoggato(Cliente clienteLogato) {
		this.clienteLoggato = clienteLogato;
	}

	/** Getter of waitForBuy
	 * @return waitForBuy
	 */
	public boolean getWaitForBuy() {
		return waitForBuy;
	}

	/** Setter of waitForBuy
	 * @param b
	 */
	public void setWaitForBuy(boolean b) {
		this.waitForBuy = b;
	}

	/** Getter of computer
	 * @return computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/** Setter of computer
	 * @param computer    Computer to set
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/** Getter of ordine
	 * @return ordine
	 */
	public Ordine getOrdine() {
		return ordine;
	}

	/** Setter of ordine
	 * @param ordine
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	/** Getter of pagamento
	 * @return pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**Setter of pagamento
	 * @param pagamento
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/** Getter of host
	 * @return host
	 */
	public String getHost() {
		return host;
	}

	/** Setter of host
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}

}
