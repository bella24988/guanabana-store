package modello;

import java.io.Serializable;


/**
 * @author  Veronica
 */
public class Ordine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="numeroOrdine"
	 */
	private int numeroOrdine;
	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  
	 */
	private Computer computer;
	private float totale;
	/**
	 * @uml.property  name="cliente"
	 * @uml.associationEnd  
	 */
	private Cliente cliente;
	/**
	 * @uml.property  name="data"
	 */
	private String data;
	/**
	 * @uml.property  name="stato"
	 */
	private String stato;
	
	

	public Ordine(int numeroOrdine, Computer computer, float prezzo, Cliente cliente) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.computer = computer;
		this.totale = prezzo;
		this.cliente = cliente;
	}

	/**
	 * @return  the numeroOrdine
	 * @uml.property  name="numeroOrdine"
	 */
	public int getNumeroOrdine() {
		return numeroOrdine;
	}

	/**
	 * @param numeroOrdine  the numeroOrdine to set
	 * @uml.property  name="numeroOrdine"
	 */
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	/**
	 * @return  the computer
	 * @uml.property  name="computer"
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer  the computer to set
	 * @uml.property  name="computer"
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return totale;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.totale = prezzo;
	}

	/**
	 * @return  the cliente
	 * @uml.property  name="cliente"
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente  the cliente to set
	 * @uml.property  name="cliente"
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return  the data
	 * @uml.property  name="data"
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data  the data to set
	 * @uml.property  name="data"
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return  the stato
	 * @uml.property  name="stato"
	 */
	public String getStato() {
		return stato;
	}

	/**
	 * @param stato  the stato to set
	 * @uml.property  name="stato"
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/** 
	 * @uml.property name="pagamento"
	 * @uml.associationEnd aggregation="composite" inverse="ordine:modello.Pagamento"
	 * @uml.association name="conclusa con"
	 */
	private Pagamento pagamento;



	/** 
	 * Getter of the property <tt>pagamento</tt>
	 * @return  Returns the pagamento.
	 * @uml.property  name="pagamento"
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/** 
	 * Setter of the property <tt>pagamento</tt>
	 * @param pagamento  The pagamento to set.
	 * @uml.property  name="pagamento"
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/** 
	 * @uml.property name="richiestaSpedizione"
	 * @uml.associationEnd aggregation="composite" inverse="ordine:modello.RichiestaSpedizione"
	 * @uml.association name="crea"
	 */
	private RichiestaSpedizione richiestaSpedizione;



	/** 
	 * Getter of the property <tt>richiestaSpedizione</tt>
	 * @return  Returns the richiestaSpedizione.
	 * @uml.property  name="richiestaSpedizione"
	 */
	public RichiestaSpedizione getRichiestaSpedizione() {
		return richiestaSpedizione;
	}

	/** 
	 * Setter of the property <tt>richiestaSpedizione</tt>
	 * @param richiestaSpedizione  The richiestaSpedizione to set.
	 * @uml.property  name="richiestaSpedizione"
	 */
	public void setRichiestaSpedizione(RichiestaSpedizione richiestaSpedizione) {
		this.richiestaSpedizione = richiestaSpedizione;
	}
	

}
