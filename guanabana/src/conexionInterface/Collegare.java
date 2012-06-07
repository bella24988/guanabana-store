package conexionInterface;

import java.io.IOException;
import java.net.UnknownHostException;


public interface Collegare {

		/**
		 * @throws IOException 
		 * @throws UnknownHostException 
		 */
		public abstract void aprireCollegamento() throws UnknownHostException, IOException;
		
		public abstract String fareLogin(String user, String password) throws IOException;
		
		public abstract void cercaModelli(String tipo);
		
		public abstract void cercaComponenti(String modello);
		
		public abstract void fareOrdine();
		
		public abstract void cambiaStatoOrdine(String codOrdine);
		
		public abstract void consultaOrdini();
		
		public abstract String registreNuovoCliente(String cf, String nome, String cognome,String email, String indirizzo, 
				 String telefono, String password) throws IOException; 
}
