package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import conexionInterface.Collegare;

public class Client implements Collegare {
	
	private String host;
	private InputStream lettura;
	private OutputStream scritura;
	private Socket socket;
	private BufferedReader buffer;
	private PrintWriter writer;
	
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
		buffer = new BufferedReader(new InputStreamReader(lettura));
		
		writer = new PrintWriter(scritura);
	
		
		System.out.println("Sono il client e apro porte!");
	}

	@Override
	public String fareLogin(String user, String password) throws IOException {
		writer.println("login");
		writer.flush();
		
		String risposta = buffer.readLine();
		if (risposta.compareTo("pronto")==0){
			writer.println(user+"!"+password);
			writer.flush();
			
			risposta = buffer.readLine();
		}else{risposta = "impossibile collegare con il server"; }
		chiudereCollegamento();
		return risposta;
	}

	@Override
	public void cercaModelli(String tipo) {
		// TODO Auto-generated method stub

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
			String email, String indirizzo, String telefono, String password) throws IOException {
		writer.println("registrati");
		writer.flush();
		
		String risposta = buffer.readLine();
		
		if (risposta.compareTo("pronto")==0){
			writer.println(cf+"!"+nome+"!"+cognome+"!"+email+"!"+indirizzo+"!"+telefono+"!"+password);
			writer.flush();
			
			risposta = buffer.readLine();
		}else{
			risposta = "impossibile collegare con il server"; }
		chiudereCollegamento();
		return risposta;
	}
	
	public void chiudereCollegamento(){
		writer.close();
		try {
			buffer.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
