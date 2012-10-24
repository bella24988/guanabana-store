package modello;



public class Laptop extends Computer {
	
	/**
	 * 
	 */
	private static int maxString=6;
	private static final long serialVersionUID = -4212072025875555L;
	private String tipo;
	
	public Laptop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("LAPTOP");
		configurazioneStandard = new String[maxString];
	}
	
	
	public Laptop(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}


	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
