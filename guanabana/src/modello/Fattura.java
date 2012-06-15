package modello;


public class Fattura {



	/**
	 * @uml.property  name="codice"
	 */
	private String codice;

	/**
	 * Getter of the property <tt>codice</tt>
	 * @return  Returns the codice.
	 * @uml.property  name="codice"
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Setter of the property <tt>codice</tt>
	 * @param codice  The codice to set.
	 * @uml.property  name="codice"
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @uml.property  name="data"
	 */
	private String data;

	/**
	 * Getter of the property <tt>data</tt>
	 * @return  Returns the data.
	 * @uml.property  name="data"
	 */
	public String getData() {
		return data;
	}

	/**
	 * Setter of the property <tt>data</tt>
	 * @param data  The data to set.
	 * @uml.property  name="data"
	 */
	public void setData(String data) {
		this.data = data;
	}

	private String totale;

	/**
	 * Getter of the property <tt>totale</tt>
	 * @return  Returns the totale.
	 * @uml.property  name="totale"
	 */
	public String getTotale() {
		return totale;
	}

	/**
	 * Setter of the property <tt>totale</tt>
	 * @param totale  The totale to set.
	 * @uml.property  name="totale"
	 */
	public void setTotale(String totale) {
		this.totale = totale;
	}

		
		/**
		 */
		public void generareFattura(){
		}

	
}
