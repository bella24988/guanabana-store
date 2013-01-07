package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import modello.Cliente;
import modello.Ordine;
import client.SalutoPanel;
import client.LogPanel;

/**
 * Classe LogController: implementa l'action listener per il pulsante login e logout.
 * Implementa ActionListener e KeyListener.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.  
 */
public class LogController implements ActionListener, KeyListener{
	
	/** Pannello di login da cui e' chiamato LogController (funzionalita' login) */
	private LogPanel logPanel;
	
	/** Pannello di saluto da cui e' chiamato LogController (funzionalita' logout) */
	private SalutoPanel salutoPanel;
	
	private Cliente cliente;
	
	
	/** 
	 * Primo costruttore del controller di login: apre la connessione col database e si associa al LogPanel chiamante
	 * @param log
	 */
	public LogController(LogPanel log){
		this.setLogPanel(log);
	}
	
	/**
	 * Secondo costruttore del controller di login: si associa al SalutoPanel chiamante
	 * @param salutoPanel
	 * @param logPanel
	 */
	public LogController(SalutoPanel salutoPanel, LogPanel logPanel) {
		this.setLogFattoPanel(salutoPanel);
		this.setLogPanel(logPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Login")){
			login();
			
		} 
		
		if (e.getActionCommand().equalsIgnoreCase("Logout")){
			logPanel.logoutFatto();
		}
		
		if (e.getActionCommand().equalsIgnoreCase("I tuoi ordini")){
				
				ServizioClient servizioClient = new ServizioClient(logPanel.getContenuto().getHost());
				try {
					Ordine[] ordini = servizioClient.consultaOrdini(logPanel.getContenuto().getClienteLoggato());
					if (ordini != null){
						logPanel.getContenuto().mostraTuoiOrdini(ordini, false);
					}else{
						logPanel.getContenuto().mostraTuoiOrdini(null, false);
					}
				} catch (IOException e1) {
					logPanel.getContenuto().mostraTuoiOrdini(null, false);
					e1.printStackTrace();
				}
		}else if (e.getActionCommand().equalsIgnoreCase("Carrello")){
			
			ServizioClient servizioClient = new ServizioClient(logPanel.getContenuto().getHost());
			try {
				Ordine[] ordini = servizioClient.consultaCarrello(logPanel.getContenuto().getClienteLoggato());
				if (ordini != null){
					logPanel.getContenuto().mostraTuoiOrdini(ordini, true);
				}else{
					logPanel.getContenuto().mostraTuoiOrdini(null, true);
				}
			} catch (IOException e1) {
				logPanel.getContenuto().mostraTuoiOrdini(null, true);
				e1.printStackTrace();
			}
		}
			
	}

	/**
	 * Effettua il login
	 */
	private void login() {
		logPanel.bloccareInserimento();
		try {
			ServizioClient servizioClient = new ServizioClient(logPanel.getContenuto().getHost());
			setCliente(servizioClient.fareLogin(logPanel.getTxtUser(), String.valueOf(logPanel.getTxtPassword())));
			if (cliente != null){
				logPanel.mostraMessaggioErrore("");
				logPanel.loginFatto(cliente);				
			}else{
				logPanel.sbloccareInserimento();
				logPanel.mostraMessaggioErrore("La email e la password non coincidono, per favore verifichi i dati.");
			}
		} catch (Exception e1) {
			logPanel.sbloccareInserimento();
			logPanel.mostraMessaggioErrore("Non si puo stabilire un collegamento con il server");
			e1.printStackTrace();
		}
		
	}

	/** 
	 * Getter of logPanel
	 * @return logPanel
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}

	/**
	 * Setter of logPanel
	 * @param logpanel
	 */
	public void setLogPanel(LogPanel logpanel) {
		this.logPanel = logpanel;
	}

	/**
	 * @return the logFattoPanel
	 */
	public SalutoPanel getLogFattoPanel() {
		return salutoPanel;
	}

	/**
	 * @param logFattoPanel the logFattoPanel to set
	 */
	public void setLogFattoPanel(SalutoPanel logFattoPanel) {
		this.salutoPanel = logFattoPanel;
	}

	/** Getter of salutoPanel
	 * @return salutoPanel
	 */
	public SalutoPanel getSalutoPanel() {
		return salutoPanel;
	}

	/** 
	 * Setter of salutoPanel
	 * @param salutoPanel
	 */
	public void setSalutoPanel(SalutoPanel salutoPanel) {
		this.salutoPanel = salutoPanel;
	}

	/**
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Setter of cliente
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER) {
        	login();           
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}


}
