package modello;



/**
 * @author  Veronica
 */
public class Server extends Computer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Server(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("SERVER");
	}
	
	

	public Server(String nome) {
		super(nome);
		setTipo("SERVER");
	}	
	

}
