package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import server.Computer;
import server.Desktop;
import server.Laptop;
import server.Server;
import client.ContenutoPanel;
import client.MenuPanel;

public class MenuController  implements ActionListener{
	
	private MenuPanel menuAcquista; 
	private String tipoComputer = "";
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
			
		int numComputers = 0;
		Client servizioClientConta, servizioClientModelli;
		servizioClientConta = new Client();
		try {
			numComputers = servizioClientConta.conta(tipoComputer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Computer[] modelli = null;
		String[] nome = new String[numComputers];
		float[] prezzo = new float[numComputers];	
		System.out.println(numComputers);
		if (tipoComputer == "LAPTOP"){
			modelli=new Laptop [numComputers];
		}else if (tipoComputer == "DESKTOP"){
			modelli=new Desktop [numComputers];
		}else if (tipoComputer == "SERVER"){
			modelli=new Server [numComputers];
		}
		try {
			servizioClientModelli = new Client();
			modelli = servizioClientModelli.cercaModelli(tipoComputer,numComputers);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(int i = 0; i < numComputers; i++){
			System.out.println(modelli[i].getNome());
			nome[i]=modelli[i].getNome();
			prezzo[i]=modelli[i].getPrezzo();
		}
		
		contenuto.nascondeModelli();
		contenuto.mostraModelli(numComputers, nome, prezzo, tipoComputer);
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
