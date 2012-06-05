package client;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import server.Cliente;
import server.DataBase;
import client.SalutoPanel;
import client.LogPanel;

public class LogController implements ActionListener{
	
	private LogPanel logPanel;
	private Cliente cliente;
	private DataBase db;
	private SalutoPanel logFattoPanel;
	
	
	public LogController(LogPanel log){
		this.setLogpanel(log);
		try {
			setDb(new DataBase());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LogController(SalutoPanel logFattoPanel, LogPanel logPanel) {
		this.setLogFattoPanel(logFattoPanel);
		this.setLogpanel(logPanel);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Login")){
			logPanel.bloccareInserzione();
			try {
				String[] consultaDB = new String[7];
				consultaDB = db.consultaLog(logPanel.getTxtUser(), logPanel.getTxtPassword());
				if (consultaDB[0]!=null){
					logPanel.mostraMessagio("");
					Cliente cliente = new Cliente(consultaDB[0],consultaDB[1],consultaDB[2],consultaDB[3],
						consultaDB[4],consultaDB[5],consultaDB[6]);
					logPanel.loginFatto(cliente.getNome(), cliente.getCognome());				
				}else{
					logPanel.SbloccareInserzione();
					logPanel.mostraMessagio("La email e la password non coincidono, per favore verifichi i dati.");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} 
		
		if (e.getActionCommand().equalsIgnoreCase("Logout")){
			logPanel.logoutFatto();
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

	/**
	 * @return the db
	 */
	public DataBase getDb() {
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(DataBase db) {
		this.db = db;
	}

	/**
	 * @return the logFattoPanel
	 */
	public SalutoPanel getLogFattoPanel() {
		return logFattoPanel;
	}

	/**
	 * @param logFattoPanel the logFattoPanel to set
	 */
	public void setLogFattoPanel(SalutoPanel logFattoPanel) {
		this.logFattoPanel = logFattoPanel;
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
	private SalutoPanel salutoPanel;


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



}
