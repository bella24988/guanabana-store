package client;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Cliente;
import modello.Ordine;

import client.SalutoPanel;
import client.LogPanel;

/**
 * @author  Lele  Classe che implementa l'action listener per il pulsante login e logout
 */
public class LogController implements ActionListener{
	
	/**
	 * @uml.property  name="logPanel"
	 * @uml.associationEnd  
	 */
	private LogPanel logPanel; //pannello login da cui � chiamato LogController (funzionalitˆ login)
	/**
	 * @uml.property  name="salutoPanel"
	 * @uml.associationEnd  
	 */
	private SalutoPanel salutoPanel; //pannello saluto da cui � chiamato LogController (funzionalitˆ logout)
	/**
	 * @uml.property  name="cliente"
	 * @uml.associationEnd  
	 */
	private Cliente cliente;
	
	
	/**
	 * @param log
	 * costruttore 1: apre la connessione col database e si associa al LogPanel chiamante
	 */
	public LogController(LogPanel log){
		this.setLogpanel(log);
	}
	
	/**
	 * @param salutoPanel
	 * @param logPanel
	 * costruttore 2: si associa al SalutoPanel chiamante
	 */
	public LogController(SalutoPanel salutoPanel, LogPanel logPanel) {
		this.setLogFattoPanel(salutoPanel);
		this.setLogpanel(logPanel);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Login")){
			logPanel.bloccareInserimento();
			try {
				Client servizioClient = new Client();
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
		
		if (e.getActionCommand().equalsIgnoreCase("Logout")){
			logPanel.logoutFatto();
		}
		
		if (e.getActionCommand().equalsIgnoreCase("I tuoi ordini")){
				
				Client servizioClient = new Client();
				try {
					Ordine[] ordini = servizioClient.consultaOrdini(logPanel.getContenuto().getClienteLogato());
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
			
			Client servizioClient = new Client();
			try {
				Ordine[] ordini = servizioClient.consultaCarrello(logPanel.getContenuto().getClienteLogato());
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
	 * @return the logpanel
	 */
	public LogPanel getLogpanel() {
		return logPanel;
	}

	/**
	 * @param logpanel the logpanel to set
	 */
	public void setLogpanel(LogPanel logpanel) {
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

	/**
	 * @uml.property  name="logPanel1"
	 * @uml.associationEnd  
	 */
	private LogPanel logPanel1;


	/**
	 * Getter of the property <tt>logPanel1</tt>
	 * @return  Returns the logPanel1.
	 * @uml.property  name="logPanel1"
	 */
	public LogPanel getLogPanel1() {
		return logPanel1;
	}

	/**
	 * Setter of the property <tt>logPanel1</tt>
	 * @param logPanel1  The logPanel1 to set.
	 * @uml.property  name="logPanel1"
	 */
	public void setLogPanel1(LogPanel logPanel1) {
		this.logPanel1 = logPanel1;
	}

	/** 
	 * @uml.property name="salutoPanel"
	 * @uml.associationEnd inverse="logController1:client.SalutoPanel"
	 * @uml.association name="controllato"
	 */

	/**
	 * @uml.property  name="salutoPanel"
	 * @uml.associationEnd  inverse="logController1:client.SalutoPanel"
	 * @uml.association  name="controllato"
	 */
	public SalutoPanel getSalutoPanel() {
		return salutoPanel;
	}

	/** 
	 * Setter of the property <tt>salutoPanel</tt>
	 * @param salutoPanel  The salutoPanel to set.
	 * @uml.property  name="salutoPanel"
	 */
	public void setSalutoPanel(SalutoPanel salutoPanel) {
		this.salutoPanel = salutoPanel;
	}

	/**
	 * @return  the cliente
	 * @uml.property  name="cliente"
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente  the cliente to set
	 * @uml.property  name="cliente"
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



}
