package connectionInterface;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import modello.Cliente;
import modello.Dipendente;
import modello.Fattura;
import modello.Ordine;
import modello.Pagamento;


/**
 * Classe InterfacciaAzienda: Interfaccia di connessione che permette la comunicazione client-server per il pacchetto aziendale.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public interface InterfacciaAzienda {
	
	/**
	 * Metodo che permette al dipendente di effettuare il login.
	 * @param id					Username del dipendente
	 * @param password				Password del dipendente
	 * @return dipendente			Il dipendente che ha effettuato il login
	 * @throws IOException
	 * @throws SQLException
	 */
	public abstract Dipendente logDipendente(int id, String password) throws IOException, SQLException;
	
	/**
	 * Metodo che permette di cercare il cliente che ha effettuato un certo ordine.
	 * @param ordine				Numero dell'ordine di cui si vuole conoscere il cliente
	 * @return cliente				Il cliente che ha effettuato l'ordine
	 * @throws IOException
	 */
	public abstract Cliente cercaClienteDalOrdine(int ordine) throws IOException;
	
	/**
	 * Metodo che permette di cercare gli ordini in base al loro stato.
	 * @param stato					Stato degli ordini da cercare
	 * @return ordini				Lista degli ordini trovati in base allo stato
	 * @throws IOException
	 */
	public abstract Ordine[] cercaOrdini(String stato) throws IOException;
	
	/**
	 * Metodo che permette di aggiornare lo stato di un ordine
	 * @param nuovoStato			Nuovo stato da assegnare all'ordine
	 * @param numOrdine				Numero dell'ordine da aggiornare
	 * @throws IOException
	 */
	public void aggiornaStatoOrdine(String nuovoStato, int numOrdine) throws IOException;

	/**
	 * Metodo che apre la connessione client-server
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	void aprireCollegamento() throws UnknownHostException, IOException;
	
	/**
	 * Metodo che permette di confermare il pagamento di un ordine.
	 * @param valore				True se il pagamento è confermato, false altrimenti
	 * @param i						Indice dell'ordine
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void confermarePagamento(boolean valore, int i) throws IOException, ClassNotFoundException;
	
	/**
	 * Metodo che permette di cercare la fattura relativa ad un ordine.
	 * @param ordine				Ordine di cui si vuole ottenere la fattura
	 * @return fattura				Fattura relativa all'ordine
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Fattura cercaFattura(Ordine ordine) throws IOException, ClassNotFoundException;
	
	/**
	 * Metodo che permette di cancellare un pagamento
	 * @param pagamento				Pagamento da cancellare
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void cancellaPagamento(Pagamento pagamento) throws IOException, ClassNotFoundException;

}
