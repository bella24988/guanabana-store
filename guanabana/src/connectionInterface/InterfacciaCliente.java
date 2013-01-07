package connectionInterface;

import java.io.IOException;
import java.net.UnknownHostException;

import modello.Cliente;
import modello.Computer;
import modello.Ordine;
import modello.Pagamento;

/**
 * Classe InterfacciaCliente: Interfaccia di connessione che permette la comunicazione client-server 
 * per il pacchetto rivolto al cliente.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public interface InterfacciaCliente {

		/**
		 * Metodo che permette di aprire la connessione client-server
		 * @throws UnknownHostException
		 * @throws IOException
		 */
		public abstract void aprireCollegamento() throws UnknownHostException, IOException;
		
		/**
		 * Metodo che permette di effettuare il login di un cliente registrato.
		 * @param user							Username del cliente
		 * @param password						Password del cliente
		 * @return cliente						Il cliente che ha effettuato il login
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		public abstract Cliente fareLogin(String user, String password) throws IOException, ClassNotFoundException;
		
		/**
		 * Metodo che permette di cercare i modelli disponibili di un certo tipo di computer.
		 * @param tipo							Tipo di computer
		 * @param numComputer					Numero di computer
		 * @return modelli						I modelli disponibili per il tipo di computer selezionato
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		public abstract Computer[] cercaModelli(String tipo, int numComputer) throws IOException, ClassNotFoundException;
		
		/**
		 * Metodo che permette di cercare i componenti disponibili per la
		 * configurazione di un certo tipo di modello di computer.
		 * @param modello						Il modello di computer di cui si vogliono i componenti disponibili
		 */
		public abstract void cercaComponenti(String modello);
		
		/**
		 * Metodo che permette di effettuare un ordine.
		 * @return ordine 						L'ordine effettuato
		 */
		public abstract Ordine fareOrdine();
		
		/**
		 * Metodo che permette di cambiare lo stato di un particolare ordine.
		 * @param codOrdine						Codice dell'ordine di cui si vuole cambiare lo stato
		 */
		public abstract void cambiaStatoOrdine(String codOrdine);
		
		/**
		 * Metodo che permette di ottenere una lista degli ordini
		 * effettuati da un particolare cliente.
		 * @param cliente						Cliente di cui si vuole la lista degli ordini effettuati
		 * @return ordini						Lista degli ordini effettuati dal cliente
		 * @throws IOException
		 */
		public abstract Ordine[] consultaOrdini(Cliente cliente) throws IOException;
		
		/**
		 * Metodo che permette di creare un nuovo ordine.
		 * @param comp							Computer ordinato
		 * @param prezzoTotale					Prezzo totale della configurazione scelta
		 * @param cliente						Cliente che ha effettuato l'ordine
		 * @return ordine						Ordine creato
		 * @throws IOException
		 */
		public abstract Ordine creaOrdine(Computer comp, float prezzoTotale, Cliente cliente) throws IOException;
		
		/**
		 * Metodo che permette di registrare un nuovo cliente.
		 * @param cf							Codice fiscale del cliente
		 * @param nome							Nome del cliente
		 * @param cognome						Cognome del cliente
		 * @param email							Email del cliente
		 * @param indirizzo						Indirizzo del cliente
		 * @param telefono						Telefono del cliente
		 * @param password						Password d'accesso del cliente
		 * @return cliente						Cliente registrato
		 * @throws IOException
		 * @throws ClassNotFoundException
		 */
		public abstract Cliente registraNuovoCliente(String cf, String nome, String cognome,String email, String indirizzo, 
				 String telefono, String password) throws IOException, ClassNotFoundException; 
		
		/**
		 * Metodo di supporto alle operazioni, utile per contare
		 * @param cosa
		 * @return count						Conto effettuato
		 * @throws IOException
		 */
		public abstract int conta(String cosa) throws IOException;
		
		/**
		 * Metodo che permette di registrare il pagamento effettuato per un certo ordine.
		 * @param ordine						Ordine di cui si registra il pagamento
		 * @param tipoPagamento					Tipo di pagamento
		 * @param arg1							Argomento di supporto alle operazioni (in caso di pagamenti con carta di credito/bonifico)
		 * @param arg2							Argomento di supporto alle operazioni (in caso di pagamenti con carta di credito/bonifico)
		 * @return pagamento					Il pagamento registrato
		 * @throws IOException
		 */
		public abstract Pagamento registrarePagamento(Ordine ordine, String tipoPagamento,
				String arg1, String arg2) throws IOException;
		
		/**
		 * Metodo che permette di visualizzare un elenco di ordini ancora nel carrello di un certo cliente.
		 * @param cliente						Cliente di cui si vuole l'elenco di ordini nel carrello
		 * @return ordini						Lista degli ordini nel carrello del cliente
		 * @throws IOException
		 */
		public abstract Ordine[] consultaCarrello(Cliente cliente)throws IOException;
		
		/**
		 * Metodo che permette di aggiornare lo stato di un ordine.
		 * @param numOrdine						Numero dell'ordine da aggiornare
		 * @param nuovoStato					Nuovo stato da assegnare all'ordine
		 * @throws IOException
		 */
		public abstract void aggiornaOrdine(int numOrdine, String nuovoStato)throws IOException;

		/**
		 * Metodo che permette di trovare un cliente dal suo codice fiscale.
		 * @param cf							Codice fiscale del cliente da cercare
		 * @return cliente						Cliente trovato
		 */
		Cliente cercaCliente(String cf);

		
}
