package modello;



public class Server extends Computer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private static int maxString=10;
	
	public Server(String nome, float prezzo) {
		super(nome, prezzo);
		setTipo("SERVER");
		configurazioneStandard = new String[maxString];
		// TODO Auto-generated constructor stub
	}
	
	

	public Server(String nome) {
		super(nome);
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
		for(int i=0;i<configurazioneStandard.length;i++){
			System.out.println(configurazioneStandard[i]);
		}
	}
	
	

}
