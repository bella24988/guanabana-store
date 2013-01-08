package modello;

/**
 * Classe CartaCredito: Modello del pagamento con carta di credito.
 * Estende la classe Pagamento.
 * @author Gabriele
 * @author  Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class CartaCredito extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private String intestatario; //intestatario della carta
	private String codice;       //numero della carta
	private String dataScadenza; //data di scadenza della carta
	private String cvs;			 //codice segreto della carta
	
	/**
	 * Costruttore del pagamento con carta di credito
	 * @param ordine				Ordine pagato con carta di credito
	 * @param tipoPagamento			Tipo di pagamento
	 * @param numPagamento			Numero di pagamento
	 * @param confermato			True se il pagamento e' confermato, false altrimenti
	 */
	public CartaCredito(Ordine ordine, String tipoPagamento, int numPagamento, boolean confermato) {
		super(ordine, "Carta di Credito", numPagamento, confermato);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter of intestatario
	 * @return intestatario
	 */
	public String getIntestatario() {
		return intestatario;
	}
	
	/**
	 * Setter of intestatario
	 * @param intestatario
	 */
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	
	/**
	 * Getter of codice
	 * @return codice
	 */
	public String getCodice() {
		return codice;
	}
	
	/**
	 * Setter of codice
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	/**
	 * Getter of dataScadenza
	 * @return dataScadenza
	 */
	public String getDataScadenza() {
		return dataScadenza;
	}
	
	/**
	 * Setter of dataScadenza
	 * @param dataScadenza
	 */
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	/**
	 * Getter of cvs
	 * @return cvs
	 */
	public String getCvs() {
		return cvs;
	}
	
	/**
	 * Setter of cvs
	 * @param cvs
	 */
	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	
	
}
