package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Computer;

public class ModelloController implements ActionListener {
	private String tipo;
	private Computer computer;

	public ModelloController(Computer computer, ModelloView modView) {
		this.computer = computer;
		this.setModelloView(modView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getActionCommand().equalsIgnoreCase(computer.getNome() + ", Prezzo: " + String.valueOf(computer.getPrezzo()))){
				modelloView.mostraComponente(computer.getTipo());
		}
	}
	

	/**
	 * @uml.property  name="modelloView"
	 * @uml.associationEnd  inverse="modelloController:client.ModelloView"
	 * @uml.association  name="controllato"
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
	 * @uml.associationEnd  inverse="modelloController:client.Client"
	 * @uml.association  name="utilizza"
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
	 * @return the computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer the computer to set
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

}
