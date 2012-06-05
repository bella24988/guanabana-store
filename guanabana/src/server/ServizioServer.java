package server;

import java.net.ServerSocket;
import java.net.Socket;

import conexionInterface.Collegare;

public class ServizioServer extends Thread implements Collegare {

private ServerSocket Server;
private Connezione c;
    
   	public static void main(String argv[]) throws Exception{
    			new ServizioServer();
    }
    	
    public ServizioServer() throws Exception{
    	
    	Server = new ServerSocket(4001);
    	System.out.println("Il Server è in attesa sulla porta 4000.");
    	this.start();
    }
    
    public void run(){
    	while(true){
			try {
				System.out.println("In attesa di Connessione.");
				Socket client = Server.accept();
				System.out.println("Connessione accettata da: "+
				client.getInetAddress());
				setC(new Connezione(client));
			}
				catch(Exception e) {
					
				}
			}
    	}

	@Override
	public DataBase collegareDB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @uml.property  name="connezione"
	 * @uml.associationEnd  inverse="servizioServer:server.Connezione"
	 */
	private Connezione connezione;

	/**
	 * Getter of the property <tt>connezione</tt>
	 * @return  Returns the connezione.
	 * @uml.property  name="connezione"
	 */
	public Connezione getConnezione() {
		return connezione;
	}

	/**
	 * Setter of the property <tt>connezione</tt>
	 * @param connezione  The connezione to set.
	 * @uml.property  name="connezione"
	 */
	public void setConnezione(Connezione connezione) {
		this.connezione = connezione;
	}

	/**
	 * @return the c
	 */
	public Connezione getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Connezione c) {
		this.c = c;
	}

}
