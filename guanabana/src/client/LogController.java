package client;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Cliente;
import modello.Ordine;

import client.SalutoPanel;
import client.LogPanel;

/**
 * @author Lele
 * Classe che implementa l'action listener per il pulsante login e logout
 */
public class LogController implements ActionListener{
	
	private LogPanel logPanel; //pannello login da cui � chiamato LogController (funzionalitˆ login)
	private SalutoPanel salutoPanel; //pannello saluto da cui � chiamato LogController (funzionalitˆ logout)
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
			Ordine[] ordini=null;
			Client servizioClient = new Client();
			try {
				ordini = servizioClient.consultaOrdini(logPanel.getContenuto().getClienteLogato());
			} catch (IOException e1) {
				logPanel.mostraMessaggioErrore("Non è possibile collegarsi al server");
				e1.printStackTrace();
			}
			
			if (ordini != null){
				logPanel.getContenuto().mostraTuoiOrdini(ordini);
			}else{
				logPanel.mostraMessaggioErrore("lei non ha fatto nessuna ordine");
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
	 * @uml.associationEnd  inverse="logController1:client.LogPanel"
	 * @uml.association  name="controllato"
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
	 * Getter of the property <tt>salutoPanel</tt>
	 * @return  Returns the salutoPanel.
	 * @uml.property  name="salutoPanel"
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



}
