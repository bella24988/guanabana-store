package modello;



public class Desktop extends Computer {
	
	/**
	 * 
	 */
	private static final int maxString=10;
	private static final long serialVersionUID = 1L;

	public Desktop(String nome, float prezzo) {
		super(nome, prezzo);
		configurazioneStandard = new String[maxString];
		setTipo("Desktop");
	}

	public Desktop(String nome) {
		super(nome);
		setTipo("Desktop");
	}
	
	

}
