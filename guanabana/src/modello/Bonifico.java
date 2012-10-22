package modello;


public class Bonifico extends Pagamento {
	

	public Bonifico(Ordine ordine, String tipoPagamento, int numPagamento) {
		super(ordine, "Bonifico", numPagamento);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codice;
	private String Banca;
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
	 * @return the banca
	 */
	public String getBanca() {
		return Banca;
	}
	/**
	 * @param banca the banca to set
	 */
	public void setBanca(String banca) {
		Banca = banca;
	}
	


}
