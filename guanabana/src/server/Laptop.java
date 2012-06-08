package server;


public class Laptop extends Computer {
	
	private String tipo;
	public Laptop(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("LAPTOP");
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
