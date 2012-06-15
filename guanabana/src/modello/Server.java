package modello;



public class Server extends Computer {
	
	private String tipo;
	
	public Server(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("SERVER");
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
