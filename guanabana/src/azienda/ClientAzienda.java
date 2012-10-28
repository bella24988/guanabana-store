package azienda;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modello.Cliente;
import modello.Dipendente;
import modello.Ordine;
import conexionInterface.InterfacciaAzienda;

public class ClientAzienda implements InterfacciaAzienda{
	
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
	public ClientAzienda() {
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
		
		System.out.println("Sono il client Aziendale e apro porte!");
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
	public Dipendente logDipendente(int id, String password) throws IOException {
		Dipendente impiegato = null;
		writer = new ObjectOutputStream(scritura);
		writer.writeObject("logDipendente");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		String risposta;
		try {
			risposta = (String) buffer.readObject();
			if (risposta.compareTo("pronto")==0){
				writer.writeObject(id);//Scrivo user
				writer.flush();
				
				risposta = (String) buffer.readObject();//Il server ha letto
				
				writer.writeObject(password);//Scrivo password
				writer.flush();
				
				impiegato = (Dipendente) buffer.readObject();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return impiegato;
	}

	@Override
	public Cliente cercaListaCliente(String cf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine[] cercaOrdini() throws IOException {
		Ordine[] ordini = null;
		writer = new ObjectOutputStream(scritura);
		
		writer.writeObject("ordini da spedire");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		try {
			ordini = (Ordine[]) buffer.readObject();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ordini;
	}

	@Override
	public void aggiornaStatoOrdine(String nuovoStato, int numOrdine) throws IOException {
		writer = new ObjectOutputStream(scritura);
		
		writer.writeObject("aggiornaStato");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		try {
			String risposta;
			risposta = (String) buffer.readObject();
			
			if(risposta.compareTo("pronto")==0){
				writer.writeObject(numOrdine);
				writer.flush();
				
				risposta = (String) buffer.readObject();
				
				if(risposta.compareTo("ok")==0){
					writer.writeObject(nuovoStato);
					writer.flush();
					
					risposta = (String) buffer.readObject();
				}
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
		chiudereCollegamento();
	}

		
}
	
	