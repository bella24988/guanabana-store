package modello;

import java.util.Collection;


public class Preventivo {

	

	/** 
	 * @uml.property name="configurazione"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="preventivo:guanabana.Configurazione"
	 * @uml.association name="genera"
	 */
	private Collection configurazione;

	/** 
	 * Getter of the property <tt>configurazione</tt>
	 * @return  Returns the configurazione.
	 * @uml.property  name="configurazione"
	 */
	public Collection getConfigurazione() {
		return configurazione;
	}

	/** 
	 * Setter of the property <tt>configurazione</tt>
	 * @param configurazione  The configurazione to set.
	 * @uml.property  name="configurazione"
	 */
	public void setConfigurazione(Collection configurazione) {
		this.configurazione = configurazione;
	}

		
		/**
		 */
		public float ricalcolaTotale(){
			return 0;
		}

		/**
		 * @uml.property  name="totale"
		 */
		private float totale;

		/**
		 * Getter of the property <tt>totale</tt>
		 * @return  Returns the totale.
		 * @uml.property  name="totale"
		 */
		public float getTotale() {
			return totale;
		}

		/**
		 * Setter of the property <tt>totale</tt>
		 * @param totale  The totale to set.
		 * @uml.property  name="totale"
		 */
		public void setTotale(float totale) {
			this.totale = totale;
		}

	/**
	 * @uml.property  name="ordine"
	 * @uml.associationEnd  inverse="preventivo1:negozioOnline.Ordine"
	 * @uml.association  name="caratterizzato"
	 */



}
