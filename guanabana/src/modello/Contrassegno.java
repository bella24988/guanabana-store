package modello;

/**
 * Classe Contrassegno: Modello del pagamento con contrassegno.
 * Estende la classe Pagamento.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class Contrassegno extends Pagamento {

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore del pagamento con contrassegno
	 * @param ordine			Ordine pagato con contrassegno
	 * @param tipoPagamento		Tipo di pagamento
	 * @param numPagamento		Numero di pagamento
	 * @param confermato		True se il pagamento e' confermato, false altrimenti
	 */
	public Contrassegno(Ordine ordine, String tipoPagamento, int numPagamento, boolean confermato) {
		super(ordine, "Contrassegno", numPagamento, confermato);
		// TODO Auto-generated constructor stub
	}

}
