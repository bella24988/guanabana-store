package modello;



public class ComputerAssemblato {

	/**
	 * @uml.property  name="spedizione"
	 * @uml.associationEnd  
	 */
	private Spedizione spedizione;

	/** 
	 * Getter of the property <tt>spedizione</tt>
	 * @return  Returns the spedizione.
	 * @uml.property  name="spedizione"
	 */
	public Spedizione getSpedizione() {
		return spedizione;
	}

	/** 
	 * Setter of the property <tt>spedizione</tt>
	 * @param spedizione  The spedizione to set.
	 * @uml.property  name="spedizione"
	 */
	public void setSpedizione(Spedizione spedizione) {
		this.spedizione = spedizione;
	}

		
		/**
		 */
		public void assemblaComputer(){
		}

	
}
