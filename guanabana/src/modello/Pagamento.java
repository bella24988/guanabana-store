package modello;

public class Pagamento{
	
	private Ordine ordine;
	private String tipoPagamento;
	private int numPagamento;
	public Pagamento(Ordine ordine, String tipoPagamento, int numPagamento) {
		super();
		this.setOrdine(ordine);
		this.setTipoPagamento(tipoPagamento);
		this.setNumPagamento(numPagamento);
	}
	/**
	 * @return the ordine
	 */
	public Ordine getOrdine() {
		return ordine;
	}
	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	/**
	 * @return the tipoPagamento
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	/**
	 * @param tipoPagamento the tipoPagamento to set
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	/**
	 * @return the numPagamento
	 */
	public int getNumPagamento() {
		return numPagamento;
	}
	/**
	 * @param numPagamento the numPagamento to set
	 */
	public void setNumPagamento(int numPagamento) {
		this.numPagamento = numPagamento;
	}
	

	
	
	
}
