package modello;

import java.util.Collection;


public class Magazzino {

	/**
	 * @uml.property  name="richiestaSpedizione"
	 * @uml.associationEnd  inverse="magazzino:guanabana.RichiestaSpedizione"
	 * @uml.association  name="controlla"
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

	/**
	 * @uml.property   name="componentiMagazino"
	 * @uml.associationEnd   multiplicity="(1 -1)" inverse="magazzino:guanabana.ComponenteMagazino"
	 * @uml.association   name="assembla"
	 */
	private Collection componentiMagazino;

	/**
	 * Getter of the property <tt>componentiMagazino</tt>
	 * @return  Returns the componentiMagazino.
	 * @uml.property  name="componentiMagazino"
	 */
	public Collection getComponentiMagazino() {
		return componentiMagazino;
	}

	/**
	 * Setter of the property <tt>componentiMagazino</tt>
	 * @param componentiMagazino  The componentiMagazino to set.
	 * @uml.property  name="componentiMagazino"
	 */
	public void setComponentiMagazino(Collection componentiMagazino) {
		this.componentiMagazino = componentiMagazino;
	}


	
}
