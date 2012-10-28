package modello;



/**
 * @author  Veronica
 */
public class Laptop extends Computer {
	
	/**
	 * 
	 */
	private static final int maxString=6;
	private static final long serialVersionUID = -4212072025875555L;
	public Laptop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("LAPTOP");
		configurazioneStandard = new String[maxString];
	}
	
	
	public Laptop(String nome) {
		super(nome);
		setTipo("LAPTOP");
	}

	
}
