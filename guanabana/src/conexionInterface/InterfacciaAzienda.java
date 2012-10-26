package conexionInterface;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import modello.Cliente;
import modello.Dipendente;
import modello.Ordine;


public interface InterfacciaAzienda {
	
	public abstract Dipendente logDipendente(int id, String password) throws IOException, SQLException;
	
	public abstract Cliente cercaListaCliente(String cf);
	
	public abstract Ordine[] cercaOrdini() throws IOException;
	
	public void aggiornaStatoOrdine(String nuovoStato, int numOrdine) throws IOException;

	void aprireCollegamento() throws UnknownHostException, IOException;

}
