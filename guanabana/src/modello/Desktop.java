package modello;



public class Desktop extends Computer {
	
	/**
	 * 
	 */
	private static int maxString=10;
	private static final long serialVersionUID = 1L;

	public Desktop(String nome, float prezzo) {
		super(nome, prezzo);
		configurazioneStandard = new String[maxString];
		// TODO Auto-generated constructor stub
	}

	public Desktop(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	

}
