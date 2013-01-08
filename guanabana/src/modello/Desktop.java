package modello;

/**
 * Classe Desktop: Modello di un computer desktop.
 * Estende la classe Computer.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class Desktop extends Computer {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Primo costruttore di un computer desktop,
	 * setta nome e prezzo, nonche' il tipo di computer: DESKTOP
	 * @param nome			Nome del computer
	 * @param prezzo		Prezzo del computer
	 */
	public Desktop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("DESKTOP");
	}

	/**
	 * Secondo costruttore di un computer desktop,
	 * setta il nome e il tipo di computer: DESKTOP
	 * @param nome
	 */
	public Desktop(String nome) {
		super(nome);
		setTipo("DESKTOP");
	}

}
