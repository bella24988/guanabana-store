package modello;

/**
 * Classe Bonifico: Modello del pagamento con bonifico.
 * Estende la classe Pagamento.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Bonifico extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione delle variabili
	 */
	private String codice; //codice del bonifico
	private String Banca;  //banca del cliente

	/**
	 * Costruttore del pagamento con bonifico
	 * @param ordine				Ordine pagato con bonifico
	 * @param tipoPagamento			Tipo di pagamento
	 * @param numPagamento			Numero di pagamento
	 * @param confermato			True se il pagamento e' confermato, false altrimenti
	 */
	public Bonifico(Ordine ordine, String tipoPagamento, int numPagamento, boolean confermato) {
		super(ordine, "Bonifico", numPagamento, confermato);
		// TODO Auto-generated constructor stub
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
	 * Getter of banca
	 * @return banca
	 */
	public String getBanca() {
		return Banca;
	}
	
	/**
	 * Setter of banca
	 * @param banca
	 */
	public void setBanca(String banca) {
		Banca = banca;
	}

}
