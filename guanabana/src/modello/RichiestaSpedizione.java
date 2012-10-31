package modello;

public class RichiestaSpedizione {

	/**
	 * @uml.property  name="magazzino"
	 * @uml.associationEnd  
	 */
	private Magazzino magazzino;

	/**
	 * Getter of the property <tt>magazzino</tt>
	 * @return  Returns the magazzino.
	 * @uml.property  name="magazzino"
	 */
	public Magazzino getMagazzino() {
		return magazzino;
	}

	/**
	 * Setter of the property <tt>magazzino</tt>
	 * @param magazzino  The magazzino to set.
	 * @uml.property  name="magazzino"
	 */
	public void setMagazzino(Magazzino magazzino) {
		this.magazzino = magazzino;
	}
		
		/**
		 */
		public void generaRichiesta(){
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

		/**
		 * @uml.property  name="ora"
		 */
		private String ora;

		/**
		 * Getter of the property <tt>ora</tt>
		 * @return  Returns the ora.
		 * @uml.property  name="ora"
		 */
		public String getOra() {
			return ora;
		}

		/**
		 * Setter of the property <tt>ora</tt>
		 * @param ora  The ora to set.
		 * @uml.property  name="ora"
		 */
		public void setOra(String ora) {
			this.ora = ora;
		}

		/** 
		 * @uml.property name="ordine"
		 * @uml.associationEnd multiplicity="(1 1)" inverse="richiestaSpedizione:modello.Ordine"
		 * @uml.association name="crea"
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


}
