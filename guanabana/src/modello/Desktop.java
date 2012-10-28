package modello;



public class Desktop extends Computer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Desktop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("DESKTOP");
	}

	public Desktop(String nome) {
		super(nome);
		setTipo("DESKTOP");
	}
	
	

}
