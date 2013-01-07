package azienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import modello.Dipendente;


/**
 * Classe LogControllerAzienda: Controller che gestisce il login
 * dei dipendenti al software aziendale.
 * Implementa ActionListener e KeyListener.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class LogControllerAzienda implements ActionListener, KeyListener{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private LogPanel logAzienda;
	private Dipendente impiegato;
	private SistemaGestioneFinestra sistemaGestioneFinestra;

	/**
	 * Costruttore del controller di login
	 * @param logAzienda
	 */
	public LogControllerAzienda(LogPanel logAzienda) {
		this.logAzienda = logAzienda;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Entra")){
			faLogIn();
			
		}else if (e.getActionCommand().compareTo("Logout")==0){
			sistemaGestioneFinestra.setVisible(false);
			logAzienda.setVisible(true);
			logAzienda.setTxtUser("");
			logAzienda.setTxtPassword("");
		}
		
	}
	
	
	
	/**
	 * Metodo che effettua il login del dipendente
	 */
	private void faLogIn() {
		try {
			int id = Integer.parseInt(logAzienda.getTxtUser());
			String psw=String.valueOf(logAzienda.getTxtPassword());
			if(psw.compareTo("")!=0 && logAzienda.getTxtUser().compareTo("")!=0){
				ClientAzienda servizioClientAzienda = new ClientAzienda();
				try {
					Dipendente impiegato = servizioClientAzienda.logDipendente(id, psw);
					if(impiegato.getNome().compareTo("")!=0){
						setImpiegato(impiegato);
						mostraPanelPrincipale(getImpiegato());
					}else{
						mostraMessaggioErrore("User e password non coincidono.");
					}
				} catch (IOException e1) {
					mostraMessaggioErrore("User e password non coincidono.");
					e1.printStackTrace();
				}
				
			}
		} catch (Exception e2) {
			mostraMessaggioErrore("Il nome utente o la password non sono validi.");
		}
		
		
	}


	/**
	 * Metodo che mostra a video un messaggio d'errore 
	 * @param msn				Messaggio da visualizzare
	 */
	private void mostraMessaggioErrore(String msn) {
		logAzienda.setTxtErrore(msn);
		logAzienda.setTxtPassword("");
		logAzienda.setTxtUser("");
	}


	/**
	 * Metodo che mostra il pannello principale dopo aver effettuato il login
	 * @param impiegato
	 */
	public void mostraPanelPrincipale(Dipendente impiegato) {
		logAzienda.setVisible(false);
		sistemaGestioneFinestra = new SistemaGestioneFinestra(impiegato, this);
		sistemaGestioneFinestra.setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER) {
        	faLogIn();           
        }
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Getter of impiegato
	 * @return impiegato
	 */
	public Dipendente getImpiegato() {
		return impiegato;
	}


	/**
	 * Setter of impiegato
	 * @param impiegato
	 */
	public void setImpiegato(Dipendente impiegato) {
		this.impiegato = impiegato;
	}



}
