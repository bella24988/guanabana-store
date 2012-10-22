package modello;




public class CartaCredito extends Pagamento {
	
	public CartaCredito(Ordine ordine, String tipoPagamento, int numPagamento) {
		super(ordine, "Carta di credito", numPagamento);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String intestatario;
	private String codice;
	private String dataScadenza;
	private String cvs;
	
	
	/**
	 * @return the intestatario
	 */
	public String getIntestatario() {
		return intestatario;
	}
	/**
	 * @param intestatario the intestatario to set
	 */
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return the dataScadenza
	 */
	public String getDataScadenza() {
		return dataScadenza;
	}
	/**
	 * @param dataScadenza the dataScadenza to set
	 */
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	/**
	 * @return the cvs
	 */
	public String getCvs() {
		return cvs;
	}
	/**
	 * @param cvs the cvs to set
	 */
	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	
	
}
