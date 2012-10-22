package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modello.Cliente;
import modello.Computer;
import modello.Ordine;
import modello.Pagamento;


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
	public Computer[] cercaModelli(String tipo, int numComputer) throws IOException, ClassNotFoundException {
		writer = new ObjectOutputStream(scritura);
		Computer[] modelli = new Computer[numComputer];
		
		writer.writeObject("cercaModelli");//scrivo 1
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		
		String risposta = (String) buffer.readObject(); //lego 1
		
		if (risposta.compareTo("pronto")==0){
			
			System.out.println("Sono il client, mi ha risposto il server: "+risposta);
			
			writer.writeObject(numComputer); //scrivo 2
			writer.flush();
			
			risposta = (String) buffer.readObject(); //lego 2
			
			writer.writeObject(tipo); //scrivo 3
			writer.flush();
			
			modelli = (Computer[]) buffer.readObject();
			System.out.println("Sono il client, mi ha risposto il server: "+modelli);
			chiudereCollegamento();
			
			return modelli;
			
		}else{
			return null;
			}
	}

	@Override
	public void cercaComponenti(String modello) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ordine fareOrdine() {
		return null;
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
	public Cliente registreNuovoCliente(String cf, String nome, String cognome,
			String email, String indirizzo, String telefono, String password) throws IOException, ClassNotFoundException {
		
		Cliente cliente;
		writer = new ObjectOutputStream(scritura);
		writer.writeObject("registrati");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		
		if (risposta.compareTo("pronto")==0){
			writer.writeObject(cf+"!"+nome+"!"+cognome+"!"+email+"!"+indirizzo+"!"+telefono+"!"+password);
			writer.flush();
			
			cliente =  (Cliente) buffer.readObject();
		}else{
			cliente = null;
			}
		chiudereCollegamento();
		
		return cliente;
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

	@Override
	public Ordine creaOrdine(Computer comp, float prezzoTotale, Cliente cliente)
			throws IOException {
	Ordine ordine = null;
		
		writer = new ObjectOutputStream(scritura);
		
		writer.writeObject("creaOrdine");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		
		String risposta;
		try {
			risposta = (String) buffer.readObject();
			
			if (risposta.compareTo("pronto")==0){
				
				writer.writeObject(comp);
				writer.flush();
				
				risposta = (String) buffer.readObject();
				
				if (risposta.compareTo("ok")==0){
					
					writer.writeObject(prezzoTotale);
					writer.flush();
					
					risposta = (String) buffer.readObject();
					
					if (risposta.compareTo("ok")==0){
						writer.writeObject(cliente);
						writer.flush();
						
						ordine = (Ordine) buffer.readObject();
						System.out.println("Server ha risposto "+ordine.getNumeroOrdine());
					}	
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //Collegamento non reuscito
		}
		chiudereCollegamento();
		return ordine;
	}

	@Override
	public Pagamento registrarePagamento(Ordine ordine, String tipoPagamento)
			throws IOException {
		Pagamento pagamento = null;
		
		writer = new ObjectOutputStream(scritura);
		
		writer.writeObject("registraPagamento");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		
		
		
		try {
			String risposta;
			risposta = (String) buffer.readObject();
			
			if(risposta.compareTo("pronto")==0){
				writer.writeObject(ordine);
				writer.flush();
				
				risposta = (String) buffer.readObject();
				
				if(risposta.compareTo("ok")==0){
					writer.writeObject(tipoPagamento);
					writer.flush();
					
					pagamento = (Pagamento) buffer.readObject();
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pagamento;
	}

}
