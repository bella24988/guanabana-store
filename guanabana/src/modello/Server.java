package modello;

/**
 * Classe Server: Modello di un computer server.
 * Estende la classe Computer.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Server extends Computer {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primo costruttore di un computer server,
	 * setta nome e prezzo, nonche' il tipo di computer: SERVER
	 * @param nome			Nome del computer
	 * @param prezzo		Prezzo del computer
	 */
	public Server(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("SERVER");
	}
	
	/**
	 * Secondo costruttore di un computer server,
	 * setta il nome e il tipo di computer: SERVER
	 * @param nome
	 */
	public Server(String nome) {
		super(nome);
		setTipo("SERVER");
	}	
	

}
