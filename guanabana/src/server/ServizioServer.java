package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import modello.Cliente;
import modello.Componente;
import modello.Computer;
import modello.Desktop;
import modello.Laptop;
import modello.Ordine;
import modello.Server;

import conexionInterface.Collegare;
import java.util.Collection;

import javax.security.auth.Subject;

/**
 * @author Veronica
 * @version 0.1
 * 			Classe che permette la comunicazione con il client, ed il passaggio di 
 *			informazione.
 *
 */
public class ServizioServer implements Collegare, Runnable{
	
	private Socket client;
	private DataBase db;
	/**
	 * @uml.property  name="cliente1"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="servizioServer:modello.Cliente"
	 * @uml.association  name="utilizza servizio"
	 */
	private Cliente cliente = new modello.Cliente();;
	private Computer[] computers;
	private Componente[] componenti;

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
				
				int numComputer = (int) ricevo.readObject();//Legge 2
				
				scrive.writeObject("ok");//Scrive 2
				scrive.flush();
				
				String tipo = (String) ricevo.readObject();//lego 3
				
				scrive.writeObject(cercaModelli(tipo, numComputer));//scrivo 3
				scrive.flush();
				
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

	public Computer[] cercaModelli(String tipo, int numComputer) {
		//Dichiarazione variabile locali
		String[][] modelli = new String[numComputer][2];
		Computer[] comp = new Computer[numComputer];
		System.out.println("Entro in cerca TIPO:"+tipo+numComputer);
		try {
			modelli = db.cercaModelli(tipo, numComputer);
			System.out.println("Entro in cerca "+modelli);
			String[] nome = new String[numComputer];
			float[] prezzo = new float[numComputer];
			
			for(int i = 0; i < numComputer; i++){
				nome[i]=modelli[i][0];
				prezzo[i]=Float.parseFloat(modelli[i][1]);
				System.out.println("Entro in cerca - CICLO; "+nome[i]);
				if (tipo.compareTo("LAPTOP")==0){
					comp[i]= new Laptop(nome[i],prezzo[i]);
					cercaComponentiComputer("lap",comp[i]);
					System.out.println("Entro in cerca "+comp[i].getNome());
					comp[i].setTipo("LAPTOP");
				}else if (tipo.compareTo("DESKTOP")==0){
					comp[i]= new Desktop(nome[i],prezzo[i]);
					comp[i].setTipo("DESKTOP");
					System.out.println("Entro in cerca "+comp[i].getNome());
					cercaComponentiComputer("des",comp[i]);
				}else if (tipo.compareTo("SERVER")==0){
					comp[i]= new Server(nome[i],prezzo[i]);
					System.out.println("Entro in cerca "+comp[i].getNome());
					cercaComponentiComputer("ser",comp[i]);
					comp[i].setTipo("SERVER");
				}
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Chiamata funzione al db
				
		return comp;
	}
	
	private void cercaComponentiComputer(String tipo,  Computer comp) throws SQLException{
		int rows = 0;
		int maxCol = 3;
		rows = db.countComponentiModello(tipo);
		String[][] components = new String[rows][maxCol];
		components = db.getComponentiModello(tipo);
		componenti = new Componente[rows];
		for(int i = 0; i < rows; i++){
			componenti[i] = new Componente();
			componenti[i].setCodice(components[i][0]);
			componenti[i].setNome(components[i][1]);
			componenti[i].setPrezzo(Float.parseFloat(components[i][2]));
			componenti[i].setTipo(components[i][0].substring(0, 3));
		}
		comp.setComponente(componenti);
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
	public Cliente registreNuovoCliente(String cf, String nome, String cognome,
			String email, String indirizzo, String telefono, String password){
		
		try {
			db.insertCliente(cf, nome, cognome, email, indirizzo, telefono, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		setCliente(new Cliente(cf, nome, cognome, email, indirizzo, telefono, password));
		return cliente;
	}


	/**
	 * @return the computers
	 */
	public Computer[] getComputers() {
		return computers;
	}

	/**
	 * @param computers the computers to set
	 */
	public void setComputers(Computer[] computers) {
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

	/**
	 * @uml.property  name="dataBase"
	 * @uml.associationEnd  inverse="servizioServer:server.DataBase"
	 * @uml.association  name="utilizza"
	 */
	private DataBase dataBase;

	/**
	 * Getter of the property <tt>dataBase</tt>
	 * @return  Returns the dataBase.
	 * @uml.property  name="dataBase"
	 */
	public DataBase getDataBase() {
		return dataBase;
	}

	/**
	 * Setter of the property <tt>dataBase</tt>
	 * @param dataBase  The dataBase to set.
	 * @uml.property  name="dataBase"
	 */
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="servizioServer:modello.Computer"
	 * @uml.association  name="cerca"
	 */
	private Collection<?> computer;

	/**
	 * Getter of the property <tt>computer</tt>
	 * @return  Returns the computer.
	 * @uml.property  name="computer"
	 */
	public Collection<?> getComputer() {
		return computer;
	}

	/**
	 * Setter of the property <tt>computer</tt>
	 * @param computer  The computer to set.
	 * @uml.property  name="computer"
	 */
	public void setComputer(Collection<?> computer) {
		this.computer = computer;
	}

	/**
	 * Getter of the property <tt>cliente1</tt>
	 * @return  Returns the cliente.
	 * @uml.property  name="cliente"
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Setter of the property <tt>cliente1</tt>
	 * @param cliente1  The cliente1 to set.
	 * @uml.property  name="cliente"
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
