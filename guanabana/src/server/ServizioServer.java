package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import conexionInterface.Collegare;

/**
 * @author Veronica
 * @version 0.1
 * 			Classe che permette la comunicazione con il client, ed il passaggio di 
 *			informazione.
 *
 */
public class ServizioServer implements Collegare, Runnable {
	
	private Socket client;
	private DataBase db;
	private Cliente cliente;
	private Computer computers;

	public ServizioServer(Socket client) {
		super();
		this.client = client;
		try {
			db= new DataBase();
		} catch (ClassNotFoundException e) {
			System.out.println("Data base non trovato");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Impossibile collegarsi con il Data base");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try (Socket s=client) {
			InputStream is = s.getInputStream();
			
			ObjectInputStream ricevo = new ObjectInputStream(is);
			String richiestaClient = (String) ricevo.readObject();//Legge 1
			System.out.println("Sono il server, ricevo messaggio dal client: no blocco if"+richiestaClient);
			String datiLetti;
			ObjectOutputStream scrive = new ObjectOutputStream(s.getOutputStream());
			
			if(richiestaClient.compareTo("login")==0){
				scrive.writeObject("pronto");
				scrive.flush();
				
				datiLetti = (String) ricevo.readObject();
				String user = datiLetti;
				
				scrive.writeObject("ok");
				scrive.flush();
				
				datiLetti = (String) ricevo.readObject();
				String password = datiLetti;
				
				System.out.print("user: "+user);
				System.out.println(" password: "+password);
				
				scrive.writeObject(fareLogin(user, password));
				scrive.flush();
				
			}else if (richiestaClient.compareTo("registrati")==0){
				System.out.println("Sono il server, ricevo messaggio dal client: "+richiestaClient);
				
				scrive.writeObject("pronto");
				scrive.flush();
				
				datiLetti = (String) ricevo.readObject();
				String[] variabile = new String[7];
				variabile[0]=(String) datiLetti.subSequence(0, datiLetti.indexOf("!"));
				System.out.println("CF:"+variabile[0]);
				int i=1;
				String temp = (String) datiLetti.substring(datiLetti.indexOf("!")+1);
				while(i<6){
					variabile[i]=(String) temp.substring(0, temp.indexOf("!"));
					System.out.println("Cognome:"+variabile[i]);
					temp = temp.substring(temp.indexOf("!")+1);
					i++;
				}
				variabile[6]=temp;
				System.out.println("Password:"+variabile[6]);
				scrive.writeObject(registreNuovoCliente(variabile[0],variabile[1],variabile[2],variabile[3],variabile[4],variabile[5],variabile[6]));
				scrive.flush();
				
			}else if(richiestaClient.compareTo("cercaModelli")==0){
				System.out.println("Sono il server, ricevo messaggio dal client: "+richiestaClient);
				scrive.writeObject("pronto");//Scrive 1
				scrive.flush();
				
				String messaggio = (String) ricevo.readObject();//Legge 2
				String tipo = messaggio.substring(messaggio.indexOf("!")+1);
				int numComputer = Integer.parseInt(messaggio.substring(0, messaggio.indexOf("!")));
				
				String [][] modelli = cercaModelli(tipo, numComputer);
				for(int i=0;i<numComputer;i++){
					for(int j=0; j<2;j++){
						scrive.writeObject(modelli[i][j]);
						scrive.flush();
					}
				}
				
			}else if (richiestaClient.compareTo("conta")==0){
				String tipo;
				System.out.println("Sono il server, ricevo messaggio dal client: "+richiestaClient);
				
				scrive.writeObject("pronto");
				scrive.flush();
				
				tipo = (String) ricevo.readObject();
				System.out.println("Sono il server, ricevo la variabile tipo: "+tipo);
				scrive.writeObject(conta(tipo));
				scrive.flush();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void aprireCollegamento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente fareLogin(String user, String password) {
		String[] consultaDB = new String[7];
		try {
			consultaDB = db.consultaLog(user, password);
			if (consultaDB[0]!=null){
				Cliente cliente = new Cliente(consultaDB[0],consultaDB[1],consultaDB[2],consultaDB[3],
					consultaDB[4],consultaDB[5],consultaDB[6]);
				System.out.println("Cliente Trovato");
				return cliente;				
			}else{
				return null;}
		} catch (SQLException e) {
			System.out.println("Cliente NON Trovato");
			e.printStackTrace();
			return null;
		}

	}

	public String[][] cercaModelli(String tipo, int numComputer) {
		//Dichiarazione variabile locali
		String[][] modelli = null;
		setComputers(null);
		try {
			numComputer = db.conta(tipo);
			modelli = new String[numComputer][2];
			modelli = db.cercaModelli(tipo, numComputer);
			String[] nome = new String[numComputer];
			float[] prezzo = new float[numComputer];	
			for(int i = 0; i < numComputer; i++){
				nome[i]=modelli[i][0];
				prezzo[i]=Float.parseFloat(modelli[i][1]);
				if (tipo == "LAPTOP"){
					setComputers(new Laptop(nome[i],prezzo[i]));
				}else if (tipo == "DESKTOP"){
					setComputers(new Desktop(nome[i],prezzo[i]));
				}else if (tipo == "SERVER"){
					setComputers(new Server(nome[i],prezzo[i]));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Chiamata funzione al db
		
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
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(4000);
			System.out.println("Sono il server, aspetto un client...");
			while(true){
				try {
					Socket client = serverSocket.accept(); //accetto conezione con il client
					System.out.println("Ho trovato un client: ");
					new Thread(new ServizioServer(client)).start();
				} catch (Exception e) {
					System.out.println("Errore in richiesta: "+ e);
				}
			}
		} catch (Exception e) {
			System.out.println("Impossibile avviare il server: "+ e);
		}
	}

	@Override
	public String registreNuovoCliente(String cf, String nome, String cognome,
			String email, String indirizzo, String telefono, String password){
		
		try {
			db.insertCliente(cf, nome, cognome, email, indirizzo, telefono, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return "errore";
		}
		setCliente(new Cliente(cf, nome, cognome, email, indirizzo, telefono, password));
		return nome+" "+cognome;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the computers
	 */
	public Computer getComputers() {
		return computers;
	}

	/**
	 * @param computers the computers to set
	 */
	public void setComputers(Computer computers) {
		this.computers = computers;
	}

	@Override
	public int conta(String cosa) {
		
			try {
				System.out.print("Entro en conta: "+cosa);
				int numComputers = db.conta(cosa);
				return numComputers;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.print("C'e errore");
				return 0;
			}
		
	}


}
