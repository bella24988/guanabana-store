package modello;

import java.io.Serializable;

/**
 * @author  Veronica
 */
public class Pagamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="tipoPagamento"
	 */
	private String tipoPagamento;
	/**
	 * @uml.property  name="numPagamento"
	 */
	private int numPagamento;
	public Pagamento(Ordine ordine, String tipoPagamento, int numPagamento) {
		super();
		this.setOrdine(ordine);
		this.setTipoPagamento(tipoPagamento);
		this.setNumPagamento(numPagamento);
	}
	/**
	 * @return  the tipoPagamento
	 * @uml.property  name="tipoPagamento"
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	/**
	 * @param tipoPagamento  the tipoPagamento to set
	 * @uml.property  name="tipoPagamento"
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	/**
	 * @return  the numPagamento
	 * @uml.property  name="numPagamento"
	 */
	public int getNumPagamento() {
		return numPagamento;
	}
	/**
	 * @param numPagamento  the numPagamento to set
	 * @uml.property  name="numPagamento"
	 */
	public void setNumPagamento(int numPagamento) {
		this.numPagamento = numPagamento;
	}
	/** 
	 * @uml.property name="ordine"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="pagamento:modello.Ordine"
	 * @uml.association name="conclusa con"
	 */
	private Ordine ordine = null;
	/** 
	 * Getter of the property <tt>ordine</tt>
	 * @return  Returns the ordine.
	 * @uml.property  name="ordine"
	 */
	public Ordine getOrdine() {
		return ordine;
	}
	/** 
	 * Setter of the property <tt>ordine</tt>
	 * @param ordine  The ordine to set.
	 * @uml.property  name="ordine"
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	/** 
	 * @uml.property name="fattura"
	 * @uml.associationEnd multiplicity="(1 1)" aggregation="composite" inverse="pagamento:modello.Fattura"
	 * @uml.association name="genera"
	 */
	private Fattura fattura = null;
	/** 
	 * Getter of the property <tt>fattura</tt>
	 * @return  Returns the fattura.
	 * @uml.property  name="fattura"
	 */
	public Fattura getFattura() {
		return fattura;
	}
	/** 
	 * Setter of the property <tt>fattura</tt>
	 * @param fattura  The fattura to set.
	 * @uml.property  name="fattura"
	 */
	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
	

	
	
	
}
