package modello;



public class Server extends Computer {
	
	private String tipo;
	private String ram;
	private String pci;
	private String hdd;
	private String hd1;
	private String hd2;
	private String hd3;
	private String cpu;
	private String mlc;
	private String war;
	private String dvd;
	private String[] configurazioneStandard = {ram,pci,cpu,hdd,hd1,hd2,hd3,war,mlc,dvd};
	
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

	/**
	 * @return the configurazioneStandard
	 */
	public String[] getConfigurazioneStandard() {
		return configurazioneStandard;
	}

	/**
	 * @param configurazioneStandard the configurazioneStandard to set
	 */
	public void setConfigurazioneStandard(String[] configurazioneStandard) {
		this.configurazioneStandard = configurazioneStandard;
	}
	
	

}
