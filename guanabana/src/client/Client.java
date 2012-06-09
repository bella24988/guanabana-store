package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import server.Cliente;

import conexionInterface.Collegare;

public class Client implements Collegare {
	
	private String host;
	private InputStream lettura;
	private OutputStream scritura;
	private Socket socket;
	private ObjectInputStream buffer;
	private ObjectOutputStream writer;
	private String tipo;
	private int num;
	
	/**
	 * @param host
	 * @category Constructor
	 * 
	 */
	public Client() {
		super();
		try {
			aprireCollegamento();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void aprireCollegamento() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 4000);
		
		lettura = socket.getInputStream();
		scritura = socket.getOutputStream();
		
		System.out.println("Sono il client e apro porte!");
	}

	@Override
	public Cliente fareLogin(String user, String password) throws IOException, ClassNotFoundException {
		Cliente cliente;
		writer = new ObjectOutputStream(scritura);
		writer.writeObject("login");
		writer.flush();
		System.out.println("Sono il client, escribi al server login");
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		if (risposta.compareTo("pronto")==0){
			
			writer.writeObject(user);//Scrivo user
			writer.flush();
			
			risposta = (String) buffer.readObject();//Il server ha letto
			
			writer.writeObject(password);//Scrivo password
			writer.flush();
			
			cliente = (Cliente) buffer.readObject();//Ricevo il mio cliente
		}else{
			cliente = null;
			}
		
		chiudereCollegamento();
		
		return cliente;
	}

	@Override
	public String[][] cercaModelli(String tipo, int numComputer) throws IOException, ClassNotFoundException {
		writer = new ObjectOutputStream(scritura);
		String[][] modelli = new String[numComputer][2];
		writer.writeObject("cercaModelli");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		
		if (risposta.compareTo("pronto")==0){
			System.out.println("Sono il client, mi ha risposto il server: "+risposta);
			
			writer.writeObject(numComputer+"!"+tipo);
			writer.flush();
			
			for(int i=0;i<numComputer;i++){
				for(int j=0; j<2;j++){
					modelli[i][j] = (String) buffer.readObject();
					System.out.println(modelli[i][j]);
				}
			}
			
		}else{
			risposta = "impossibile collegare con il server"; 
			}
		
		chiudereCollegamento();
		
		return modelli;
	}

	@Override
	public void cercaComponenti(String modello) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fareOrdine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambiaStatoOrdine(String codOrdine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consultaOrdini() {
		// TODO Auto-generated method stub

	}


	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String registreNuovoCliente(String cf, String nome, String cognome,
			String email, String indirizzo, String telefono, String password) throws IOException, ClassNotFoundException {
		writer = new ObjectOutputStream(scritura);
		writer.writeObject("registrati");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		
		if (risposta.compareTo("pronto")==0){
			writer.writeObject(cf+"!"+nome+"!"+cognome+"!"+email+"!"+indirizzo+"!"+telefono+"!"+password);
			writer.flush();
			
			risposta = (String) buffer.readObject();
		}else{
			risposta = "impossibile collegare con il server"; }
		chiudereCollegamento();
		return risposta;
	}
	
	public void chiudereCollegamento() throws IOException{
		writer.close();
		try {
			buffer.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int conta(String cosa) throws IOException {
		int num=0;
		String risposta ="";
		writer = new ObjectOutputStream(scritura);
		writer.writeObject("conta");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		try {
			risposta = (String) buffer.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(risposta.compareTo("pronto")==0){
			writer.writeObject(cosa);
			writer.flush();

			try {
				num = (int) buffer.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		setNum(num);
		chiudereCollegamento();
		return num;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

}
