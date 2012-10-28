package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Computer;

/**
 * @author  Veronica
 */
public class ModelloController implements ActionListener {
	/**
	 * @uml.property  name="tipo"
	 */
	private String tipo;
	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  
	 */
	private Computer computer;

	public ModelloController(Computer computer, ModelloView modView) {
		this.computer = computer;
		this.setModelloView(modView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getActionCommand().equalsIgnoreCase(computer.getNome() + ", Prezzo: " + String.valueOf(computer.getPrezzo()))){
				modelloView.mostraComponente(computer);
		}
	}
	

	/**
	 * @uml.property  name="modelloView"
	 * @uml.associationEnd  
	 */
	private ModelloView modelloView;

	/**
	 * Getter of the property <tt>modelloView</tt>
	 * @return  Returns the modelloView.
	 * @uml.property  name="modelloView"
	 */
	public ModelloView getModelloView() {
		return modelloView;
	}

	/**
	 * Setter of the property <tt>modelloView</tt>
	 * @param modelloView  The modelloView to set.
	 * @uml.property  name="modelloView"
	 */
	public void setModelloView(ModelloView modelloView) {
		this.modelloView = modelloView;
	}

	/**
	 * @uml.property  name="client"
	 * @uml.associationEnd  
	 */
	private Client client;

	/**
	 * Getter of the property <tt>client</tt>
	 * @return  Returns the client.
	 * @uml.property  name="client"
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter of the property <tt>client</tt>
	 * @param client  The client to set.
	 * @uml.property  name="client"
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return  the computer
	 * @uml.property  name="computer"
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer  the computer to set
	 * @uml.property  name="computer"
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * @return  the tipo
	 * @uml.property  name="tipo"
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo  the tipo to set
	 * @uml.property  name="tipo"
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
