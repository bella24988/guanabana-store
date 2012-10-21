package modello;


public class Ordine {
	
	private Pagamento pagamento;
	private String numeroOrdine;
	private Computer computer;
	private float prezzo;
	private Cliente cliente;
	
	

	public Ordine(String numeroOrdine, Computer computer, float prezzo, Cliente cliente) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.computer = computer;
		this.prezzo = prezzo;
		this.cliente = cliente;
	}

	/**
	 * @return the pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * @return the numeroOrdine
	 */
	public String getNumeroOrdine() {
		return numeroOrdine;
	}

	/**
	 * @param numeroOrdine the numeroOrdine to set
	 */
	public void setNumeroOrdine(String numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	/**
	 * @return the computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer the computer to set
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
