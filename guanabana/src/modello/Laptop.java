package modello;

/**
 * Classe Laptop: Modello di un computer laptop.
 * Estende la classe Computer.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Laptop extends Computer {
	
	private static final long serialVersionUID = -4212072025875555L;
	
	/**
	 * Primo costruttore di un computer laptop,
	 * setta nome e prezzo, nonchè il tipo di computer: LAPTOP
	 * @param nome			Nome del computer
	 * @param prezzo		Prezzo del computer
	 */
	public Laptop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("LAPTOP");
	}
	
	/**
	 * Secondo costruttore di un computer laptop,
	 * setta il nome e il tipo di computer: LAPTOP
	 * @param nome
	 */
	public Laptop(String nome) {
		super(nome);
		setTipo("LAPTOP");
	}

	
}
