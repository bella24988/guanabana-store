package modello;




/**
 * @author  Veronica
 */
public class CartaCredito extends Pagamento {
	
	public CartaCredito(Ordine ordine, String tipoPagamento, int numPagamento, boolean confermato) {
		super(ordine, "Carta di credito", numPagamento, confermato);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="intestatario"
	 */
	private String intestatario;
	/**
	 * @uml.property  name="codice"
	 */
	private String codice;
	/**
	 * @uml.property  name="dataScadenza"
	 */
	private String dataScadenza;
	/**
	 * @uml.property  name="cvs"
	 */
	private String cvs;
	
	
	/**
	 * @return  the intestatario
	 * @uml.property  name="intestatario"
	 */
	public String getIntestatario() {
		return intestatario;
	}
	/**
	 * @param intestatario  the intestatario to set
	 * @uml.property  name="intestatario"
	 */
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	/**
	 * @return  the codice
	 * @uml.property  name="codice"
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice  the codice to set
	 * @uml.property  name="codice"
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return  the dataScadenza
	 * @uml.property  name="dataScadenza"
	 */
	public String getDataScadenza() {
		return dataScadenza;
	}
	/**
	 * @param dataScadenza  the dataScadenza to set
	 * @uml.property  name="dataScadenza"
	 */
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	/**
	 * @return  the cvs
	 * @uml.property  name="cvs"
	 */
	public String getCvs() {
		return cvs;
	}
	/**
	 * @param cvs  the cvs to set
	 * @uml.property  name="cvs"
	 */
	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	
	
}
