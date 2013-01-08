package modello;

import java.io.Serializable;

/**
 * Classe Pagamento: Modello di un pagamento effettuato.
 * Implementa Serializable.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Pagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private String tipoPagamento;		//Tipo di pagamento (bonifico, contrassegno o carta di credito)
	private int numPagamento;			//Numero del pagamento
	private boolean confermato;			//True se il pagamento e' confermato, false altrimenti
	private Ordine ordine = null;		//Ordine pagato
	private Fattura fattura = null;		//Fattura del pagamento
	
	/**
	 * Costruttore di un pagamento effettuato.
	 * @param ordine					Ordine pagato
	 * @param tipoPagamento				Tipo di pagamento
	 * @param numPagamento				Numero del pagamento
	 * @param confermato				True se il pagamento e' confermato, false altrimenti
	 */
	public Pagamento(Ordine ordine, String tipoPagamento, int numPagamento, boolean confermato) {
		super();
		this.setOrdine(ordine);
		this.setTipoPagamento(tipoPagamento);
		this.setNumPagamento(numPagamento);
		this.setConfermato(confermato);
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
	
	/**
	 * Getter of numPagamento
	 * @return numPagamento
	 */
	public int getNumPagamento() {
		return numPagamento;
	}
	
	/**
	 * Setter of numPagamento
	 * @param numPagamento
	 */
	public void setNumPagamento(int numPagamento) {
		this.numPagamento = numPagamento;
	}
	
	
	/**
	 * Getter of ordine
	 * @return ordine
	 */
	public Ordine getOrdine() {
		return ordine;
	}
	
	/** 
	 * Setter of ordine
	 * @param ordine
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	
	/** 
	 * Getter of fattura
	 * @return fattura
	 */
	public Fattura getFattura() {
		return fattura;
	}
	
	/** 
	 * Setter of fattura
	 * @param fattura
	 */
	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
	
	/**
	 * Getter of confermato
	 * @return confermato
	 */
	public boolean isConfermato() {
		return confermato;
	}
	
	/**
	 * Setter of confermato
	 * @param confermato
	 */
	public void setConfermato(boolean confermato) {
		this.confermato = confermato;
	}
	
}
