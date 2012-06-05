package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import server.Computer;
import server.DataBase;
import server.Desktop;
import server.Laptop;
import server.Server;

import client.ContenutoPanel;
import client.MenuPanel;

public class MenuController  implements ActionListener{
	
	private MenuPanel menuAcquista;
	private DataBase db;
	private Computer computers; 
	private String tipoComputer = "";
	private int numComputers = 0;
	private String[][] modelli;
	private ContenutoPanel contenuto;
	

	public MenuController(MenuPanel menuAcquista, ContenutoPanel contenuto) {
		this.setMenuAcquista(menuAcquista);
		this.setContenuto(contenuto);
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



	public void actionPerformed(ActionEvent e) {
		//Equals ignore case per chiamare la funzione del button.
		if (e.getActionCommand().equalsIgnoreCase("Acquista Laptop")){
			tipoComputer = "LAPTOP";
			gesticeModelli(tipoComputer);
			
		}else if(e.getActionCommand().equalsIgnoreCase("Acquista Desktop")){
		
			tipoComputer = "DESKTOP";
			gesticeModelli(tipoComputer);
			
			
		}else if(e.getActionCommand().equalsIgnoreCase("Acquista Server")){
			tipoComputer = "SERVER";
			gesticeModelli(tipoComputer);
		}
	}



	public void gesticeModelli(String tipoComputer){
		
		try {
			numComputers = db.conta(tipoComputer);
			modelli = new String[numComputers][2];
			modelli = db.cercaModelli(tipoComputer, numComputers);
			String[] nome = new String[numComputers];
			float[] prezzo = new float[numComputers];	
			for(int i = 0; i < numComputers; i++){
				nome[i]=modelli[i][0];
				prezzo[i]=Float.parseFloat(modelli[i][1]);
				if (tipoComputer == "LAPTOP"){
					computers = new Laptop(nome[i],prezzo[i]);
				}else if (tipoComputer == "DESKTOP"){
					computers = new Desktop(nome[i],prezzo[i]);
				}else if (tipoComputer == "SERVER"){
					computers = new Server(nome[i],prezzo[i]);
				}
			}
			try{
				contenuto.nascondeModelli();
				contenuto.mostraModelli(numComputers, nome, prezzo, tipoComputer);
			}catch (Exception e) {
				contenuto.mostraModelli(numComputers, nome, prezzo, tipoComputer);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * @return the menuAcquista
	 */
	public MenuPanel getMenuAcquista() {
		return menuAcquista;
	}



	/**
	 * @param menuAcquista the menuAcquista to set
	 */
	public void setMenuAcquista(MenuPanel menuAcquista) {
		this.menuAcquista = menuAcquista;
	}



	/**
	 * @return the contenuto
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}



	/**
	 * @param contenuto the contenuto to set
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}



	public DataBase getDb() {
		return db;
	}



	public void setDb(DataBase db) {
		this.db = db;
	}



	/**
	 * @return the computers
	 */
	public Computer getComputers() {
		return computers;
	}



	/**
	 * @param computers the computers to set
	 */
	public void setComputers(Computer computers) {
		this.computers = computers;
	}



	/**
	 * @uml.property  name="menuPanel"
	 * @uml.associationEnd  inverse="menuController1:client.MenuPanel"
	 * @uml.association  name="controllato"
	 */
	private MenuPanel menuPanel;


	/**
	 * Getter of the property <tt>menuPanel</tt>
	 * @return  Returns the menuPanel.
	 * @uml.property  name="menuPanel"
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}



	/**
	 * Setter of the property <tt>menuPanel</tt>
	 * @param menuPanel  The menuPanel to set.
	 * @uml.property  name="menuPanel"
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}



	/** 
	 * @uml.property name="contenutoPanel"
	 * @uml.associationEnd inverse="menuController:client.ContenutoPanel"
	 * @uml.association name="modifica"
	 */
	private ContenutoPanel contenutoPanel;


	/** 
	 * Getter of the property <tt>contenutoPanel</tt>
	 * @return  Returns the contenutoPanel.
	 * @uml.property  name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}



	/** 
	 * Setter of the property <tt>contenutoPanel</tt>
	 * @param contenutoPanel  The contenutoPanel to set.
	 * @uml.property  name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}
	
	

}
