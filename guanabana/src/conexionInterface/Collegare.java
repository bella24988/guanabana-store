package conexionInterface;

import java.io.IOException;
import java.net.UnknownHostException;

import modello.Cliente;
import modello.Computer;
import modello.Ordine;
import modello.Pagamento;

public interface Collegare {

		/**
		 * @throws IOException 
		 * @throws UnknownHostException 
		 */
		public abstract void aprireCollegamento() throws UnknownHostException, IOException;
		
		public abstract Cliente fareLogin(String user, String password) throws IOException, ClassNotFoundException;
		
		public abstract Computer[] cercaModelli(String tipo, int numComputer) throws IOException, ClassNotFoundException;
		
		public abstract void cercaComponenti(String modello);
		
		public abstract Ordine fareOrdine();
		
		public abstract void cambiaStatoOrdine(String codOrdine);
		
		public abstract Ordine[] consultaOrdini(Cliente cliente) throws IOException;
		
		public abstract Ordine creaOrdine(Computer comp, float prezzoTotale, Cliente cliente) throws IOException;
		
		public abstract Cliente registreNuovoCliente(String cf, String nome, String cognome,String email, String indirizzo, 
				 String telefono, String password) throws IOException, ClassNotFoundException; 
		
		public abstract int conta(String cosa) throws IOException;
		
		public abstract Pagamento registrarePagamento(Ordine ordine, String tipoPagamento) throws IOException;
		
		public abstract Ordine[] consultaCarrello(Cliente cliente)throws IOException;
		
		public abstract void aggiornaOrdine(int numOrdine, String nuovoStato)throws IOException;
}
