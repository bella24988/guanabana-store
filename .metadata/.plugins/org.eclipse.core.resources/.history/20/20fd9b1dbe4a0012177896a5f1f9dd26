package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modello.Computer;
import modello.Desktop;
import modello.Laptop;
import modello.Server;

import client.ContenutoPanel;
import client.MenuPanel;

/**
 * @author  Veronica
 */
public class MenuController  implements ActionListener{
	
	/**
	 * @uml.property  name="menuAcquista"
	 * @uml.associationEnd  
	 */
	private MenuPanel menuAcquista; 
	private String tipoComputer = "";
	/**
	 * @uml.property  name="contenuto"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel contenuto;

	
	public MenuController(MenuPanel menuAcquista, ContenutoPanel contenuto) {
		this.setMenuAcquista(menuAcquista);
		this.setContenuto(contenuto);
	}



	public void actionPerformed(ActionEvent e) {
		//Equals ignore case per chiamare la funzione del button.
		if (e.getActionCommand().equalsIgnoreCase("Acquista Laptop")){
			tipoComputer = "LAPTOP";
			try {
				gesticeModelli(tipoComputer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getActionCommand().equalsIgnoreCase("Acquista Desktop")){
		
			tipoComputer = "DESKTOP";
			try {
				gesticeModelli(tipoComputer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getActionCommand().equalsIgnoreCase("Acquista Server")){
			tipoComputer = "SERVER";
			try {
				gesticeModelli(tipoComputer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}



	public void gesticeModelli(String tipoComputer) throws ClassNotFoundException{

		Client servizioClientModelli;
		Computer[] modelli = null;	
		int numComputers =0;
		try {
			servizioClientModelli = new Client(contenuto.getHost());
			modelli = servizioClientModelli.cercaModelli(tipoComputer,numComputers);
			numComputers = modelli.length;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//contenuto.nascondeModelli();
		contenuto.mostraModelli(numComputers,modelli, tipoComputer, contenuto);
	}
	
	/**
	 * @return  the menuAcquista
	 * @uml.property  name="menuAcquista"
	 */
	public MenuPanel getMenuAcquista() {
		return menuAcquista;
	}



	/**
	 * @param menuAcquista  the menuAcquista to set
	 * @uml.property  name="menuAcquista"
	 */
	public void setMenuAcquista(MenuPanel menuAcquista) {
		this.menuAcquista = menuAcquista;
	}



	/**
	 * @return  the contenuto
	 * @uml.property  name="contenuto"
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}



	/**
	 * @param contenuto  the contenuto to set
	 * @uml.property  name="contenuto"
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}


	/**
	 * @uml.property  name="menuPanel"
	 * @uml.associationEnd  
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
	 * @uml.property  name="contenutoPanel"
	 * @uml.associationEnd  
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
