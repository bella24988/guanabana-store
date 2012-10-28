package modello;



public class Spedizione {

	/**
	 * @uml.property  name="computerAssemblato"
	 * @uml.associationEnd  
	 */
	private ComputerAssemblato computerAssemblato;

	/** 
	 * Getter of the property <tt>computerAssemblato</tt>
	 * @return  Returns the computerAssemblato.
	 * @uml.property  name="computerAssemblato"
	 */
	public ComputerAssemblato getComputerAssemblato() {
		return computerAssemblato;
	}

	/** 
	 * Setter of the property <tt>computerAssemblato</tt>
	 * @param computerAssemblato  The computerAssemblato to set.
	 * @uml.property  name="computerAssemblato"
	 */
	public void setComputerAssemblato(ComputerAssemblato computerAssemblato) {
		this.computerAssemblato = computerAssemblato;
	}

		
		/**
		 */
		public void spedire(){
		}


}
