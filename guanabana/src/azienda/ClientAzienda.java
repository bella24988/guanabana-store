package azienda;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modello.Cliente;
import modello.Dipendente;
import modello.Fattura;
import modello.Ordine;
import modello.Pagamento;
import connectionInterface.InterfacciaAzienda;

/**
 * Classe ClientAzienda: e' la classe che rende disponibile
 * il servizio che permette la comunicazione fra client e server per
 * il pacchetto rivolto all'azienda.
 * Implementa InterfacciaAzienda.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class ClientAzienda implements InterfacciaAzienda{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private InputStream lettura;
	private OutputStream scrittura;
	private Socket socket;
	private ObjectInputStream buffer;
	private ObjectOutputStream writer;
	
	/**
	 * Costruttore del servizio client-server
	 */
	public ClientAzienda() {
		super();
		try {
			aprireCollegamento();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void aprireCollegamento() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 4000);
		
		lettura = socket.getInputStream();
		scrittura = socket.getOutputStream();
	}

	/**
	 * Metodo per chiudere la connessione client-server
	 * @throws IOException
	 */
	public void chiudereCollegamento() throws IOException{
		writer.close();
		try {
			buffer.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Dipendente logDipendente(int id, String password) throws IOException {
		Dipendente impiegato = null;
		writer = new ObjectOutputStream(scrittura);
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
			e.printStackTrace();
		}
		
		
		return impiegato;
	}

	@Override
	public Cliente cercaClienteDalOrdine(int ordine) throws IOException {
		
		Cliente cliente = null;
		
		writer = new ObjectOutputStream(scrittura);
		
		writer.writeObject("azienda cerca cliente");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		try {
			String risposta =  (String) buffer.readObject();
			
			if(risposta.compareTo("pronto")==0){
				writer.writeObject(ordine);
				writer.flush();
				
				cliente = (Cliente) buffer.readObject();
			}
		}catch (Exception e) {
			return null;
		}
		return cliente;
	}

	@Override
	public Ordine[] cercaOrdini(String stato) throws IOException {
		Ordine[] ordini = null;
		writer = new ObjectOutputStream(scrittura);
		
		writer.writeObject("cerca ordini");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		try {
			String risposta =  (String) buffer.readObject();
			
			if(risposta.compareTo("pronto")==0){
				writer.writeObject(stato);
				writer.flush();
				
				ordini = (Ordine[]) buffer.readObject();
			}
		}catch (Exception e) {
			return null;
		}
		
		return ordini;
	}

	@Override
	public void aggiornaStatoOrdine(String nuovoStato, int numOrdine) throws IOException {
		writer = new ObjectOutputStream(scrittura);
		
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
			
		}
		chiudereCollegamento();
	}

	@Override
	public void confermarePagamento(boolean valore, int i) throws IOException, ClassNotFoundException {
		
		writer = new ObjectOutputStream(scrittura);
		
		writer.writeObject("confermarePagamento");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		
		if(risposta.compareTo("pronto")==0){
			writer.writeObject(valore);
			writer.flush();
			
			risposta = (String) buffer.readObject();
			
			writer.writeObject(i);
			writer.flush();
		}
		
		chiudereCollegamento();
	}

	/**
	 * Metodo che permette di inviare una mail di conferma dell'avvenuto acquisto
	 * al destinatario specificato.
	 * @param to						Destinatario della mail
	 * @param messaggio					Testo del messaggio da inviare
	 * @param subject					Oggetto della mail
	 * @throws UnknownHostException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void inviaEmailConferma(String to, String messaggio, String subject) throws UnknownHostException, AddressException, MessagingException{
		String host = "smtp.gmail.com";
	    String from = "guanabana.store";
	    String pass = "programmatori";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");

	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));

	    InternetAddress toAddress = new InternetAddress(to);
	    
	    message.addRecipient(Message.RecipientType.TO, toAddress);
	    message.setSubject(subject);
	    message.setContent(messaggio, "text/html");
	    
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, pass);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	    }

	@Override
	public Fattura cercaFattura(Ordine ordine) throws IOException, ClassNotFoundException {
		Fattura fattura = null;
		writer = new ObjectOutputStream(scrittura);
		
		writer.writeObject("cerca fattura");
		writer.flush();
		
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		
		if(risposta.compareTo("pronto")==0){
			writer.writeObject(ordine);
			writer.flush();
			
			fattura =  (Fattura) buffer.readObject();
		}
		
		chiudereCollegamento();
		return fattura;
	}

	@Override
	public void cancellaPagamento(Pagamento pagamento) throws IOException, ClassNotFoundException {
		writer = new ObjectOutputStream(scrittura);
		writer.writeObject("cancella pagamento");
		writer.flush();
		buffer = new ObjectInputStream(lettura);
		String risposta = (String) buffer.readObject();
		if(risposta.compareTo("pronto")==0){
			writer.writeObject(pagamento);
			writer.flush();
		} 
		
	}

}
	
	
