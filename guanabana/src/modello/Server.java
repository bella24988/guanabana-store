package modello;



/**
 * @author  Veronica
 */
public class Server extends Computer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int maxString=10;
	
	public Server(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("SERVER");
		configurazioneStandard = new String[maxString];
	}
	
	

	public Server(String nome) {
		super(nome);
		setTipo("SERVER");
	}	
	

}
