package modello;

public class Magazzino {

	/**
	 * @uml.property  name="richiestaSpedizione"
	 * @uml.associationEnd  
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
