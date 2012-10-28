package modello;


/**
 * @author  Veronica
 */
public class Bonifico extends Pagamento {
	

	public Bonifico(Ordine ordine, String tipoPagamento, int numPagamento) {
		super(ordine, "Bonifico", numPagamento);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="codice"
	 */
	private String codice;
	/**
	 * @uml.property  name="banca"
	 */
	private String Banca;
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
	 * @return  the banca
	 * @uml.property  name="banca"
	 */
	public String getBanca() {
		return Banca;
	}
	/**
	 * @param banca  the banca to set
	 * @uml.property  name="banca"
	 */
	public void setBanca(String banca) {
		Banca = banca;
	}
	


}
