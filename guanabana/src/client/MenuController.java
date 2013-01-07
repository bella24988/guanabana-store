package client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modello.Computer;
import client.ContenutoPanel;
import client.MenuPanel;

/**
 * Classe MenuController: Controller del pannello che contiene i pulsanti di scelta fra i vari tipi di computer disponibili.
 * Implementa ActionListener.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class MenuController  implements ActionListener{
	
	/**
	 * Dichiarazione delle variabili
	 */
	private MenuPanel menuAcquista; 
	private ContenutoPanel contenuto;
	
	private String tipoComputer = "";

	
	/**
	 * Costruttore del controller dei tasti di scelta fra i tipi di computers
	 * @param menuAcquista
	 * @param contenuto
	 */
	public MenuController(MenuPanel menuAcquista, ContenutoPanel contenuto) {
		this.setMenuAcquista(menuAcquista);
		this.setContenuto(contenuto);
	}



	@Override
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



	/**
	 * Trova e mostra i modelli disponibili in base al tipo di computer selezionato
	 * @param tipoComputer
	 * @throws ClassNotFoundException
	 */
	public void gesticeModelli(String tipoComputer) throws ClassNotFoundException{

		ServizioClient servizioClientModelli;
		Computer[] modelli = null;	
		int numComputers =0;
		try {
			servizioClientModelli = new ServizioClient(contenuto.getHost());
			modelli = servizioClientModelli.cercaModelli(tipoComputer,numComputers);
			numComputers = modelli.length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		contenuto.mostraModelli(numComputers,modelli, tipoComputer, contenuto);
	}
	
	/**
	 * Getter of menuAcquista
	 * @return menuAcquista
	 */
	public MenuPanel getMenuAcquista() {
		return menuAcquista;
	}

	/**
	 * Setter of menuAcquista
	 * @param menuAcquista
	 */
	public void setMenuAcquista(MenuPanel menuAcquista) {
		this.menuAcquista = menuAcquista;
	}

	/**
	 * Getter of contenuto
	 * @return contenuto
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * Setter of contenuto
	 * @param contenuto
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}	

}
