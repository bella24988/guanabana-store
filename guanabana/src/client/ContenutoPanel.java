package client;

import javax.swing.JPanel;

import modello.Cliente;
import modello.Computer;
import modello.Configurazione;
import modello.Pagamento;

import java.awt.Color;

public class ContenutoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private RegistratiView registratiView;
	
	/**
	 * @uml.property name="modelloView"
	 * @uml.associationEnd inverse="contenutoPanel:client.ModelloView"
	 * @uml.association name="mostra"
	 */
	private ModelloView modelloView;
	private ConfermaOrdinePanel confermaOrdinePanel;
	private Cliente clienteLogato;
	private boolean attessaCompra;

	public ContenutoPanel() {
		super();
		setBackground(Color.white);
		setForeground(new Color(0, 0, 0));
		this.setAttessaCompra(false);
		//registratiView.setVisible(false);
		
		
	}

	public RegistratiView getRegistratiView() {
		return registratiView;
	}

	public void setRegistratiView(RegistratiView registratiView) {
		this.registratiView = registratiView;
	}

	public void mostraFormularioRegistrati(LogPanel panel) {
		removeAll();
		pulisceSchermo();
		registratiView = new RegistratiView(this);
		registratiView.setVisible(false);
		registratiView.setBackground(new Color(204, 255, 153));
		add(registratiView);
		registratiView.setVisible(true);
		registratiView.conoscePanel(panel);
		//modelloView.setVisible(false);
	}

	public void nascondeFormularioRegistrati() {
		registratiView.setVisible(false);
		nascondeModelli();
	}

	public void mostraModelli(int num, Computer[] computers, String tipo, ContenutoPanel contenutoPanel) {
		
		this.removeAll();
		pulisceSchermo();
		modelloView = new ModelloView();
		modelloView.setVisible(false);
		add(modelloView);
		modelloView.setVisible(true);
		
		//nascondeFormularioRegistrati();
		modelloView = new ModelloView();
		add(modelloView);
		
		modelloView.mostraButtons(num, computers, tipo);
		modelloView.setVisible(true);
		modelloView.setContenutoPanel(contenutoPanel);
	}

	public void nascondeModelli() {
		modelloView.setVisible(false);
	}
	
	public void mostraConfermaOrdine(String nome, float prezzo, Configurazione[] configurazione, float prezzoTotale, JPanel panelDaRimuovere){
		panelDaRimuovere.setVisible(false);
		this.remove(panelDaRimuovere);
		pulisceSchermo();
		confermaOrdinePanel = new ConfermaOrdinePanel(nome, prezzo, configurazione, prezzoTotale, this);
		confermaOrdinePanel.setVisible(true);
		add(confermaOrdinePanel);
	}
	
	public void pulisceSchermo(){
		JPanel pulito;
		pulito = new JPanel();
		pulito.setVisible(false);
		pulito.setBackground(Color.white);
		pulito.setSize(800, 800);
		this.add(pulito);
		pulito.setVisible(true);
	}

	/**
	 * @uml.property name="registratiController"
	 * @uml.associationEnd inverse="contenutoPanel:client.RegistratiController"
	 * @uml.association name="modifica"
	 */
	private RegistratiController registratiController;

	/**
	 * Getter of the property <tt>registratiController</tt>
	 * 
	 * @return Returns the registratiController.
	 * @uml.property name="registratiController"
	 */
	public RegistratiController getRegistratiController() {
		return registratiController;
	}

	/**
	 * Setter of the property <tt>registratiController</tt>
	 * 
	 * @param registratiController
	 *            The registratiController to set.
	 * @uml.property name="registratiController"
	 */
	public void setRegistratiController(
			RegistratiController registratiController) {
		this.registratiController = registratiController;
	}

	/**
	 * @return the modelloView
	 */
	public ModelloView getModelloView() {
		return modelloView;
	}

	/**
	 * @param modelloView
	 *            the modelloView to set
	 */
	public void setModelloView(ModelloView modelloView) {
		this.modelloView = modelloView;
	}

	public void aggiungePagamentoPanel(ConfermaOrdinePanel panelDaRimuovere) {
		if(clienteLogato!=null){
			remove(panelDaRimuovere);
			continuaOperazione();
		}else{
			setAttessaCompra(true);
			panelDaRimuovere.mostraMessaggioErrore("Per continuare con l'acquisto, devi fare il log-in o registrarti");
		}
	}
	
	public void continuaOperazione(){
		removeAll();
		pulisceSchermo();
		setAttessaCompra(false);
		PagamentoPanel pagamentoPanel = new PagamentoPanel(this);
		add(pagamentoPanel);
		setVisible(true);
	}

	/**
	 * @return the clienteLogato
	 */
	public Cliente getClienteLogato() {
		return clienteLogato;
	}

	/**
	 * @param clienteLogato the clienteLogato to set
	 */
	public void setClienteLogato(Cliente clienteLogato) {
		this.clienteLogato = clienteLogato;
	}

	/**
	 * @return the attessaCompra
	 */
	public boolean getAttessaCompra() {
		return attessaCompra;
	}

	/**
	 * @param b the attessaCompra to set
	 */
	public void setAttessaCompra(boolean b) {
		this.attessaCompra = b;
	}

}
