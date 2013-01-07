package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modello.Computer;

/**
 * Classe ModelloController: Controller del pannello ModelloView.
 * Implementa ActionListener.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class ModelloController implements ActionListener {
	/**
	 * Dichiarazione delle variabili
	 */
	private String tipo;
	private Computer computer;
	
	private ModelloView modelloView;


	/**
	 * Costruttore della classe, associa il computer e il pannello di scelta dei modelli al controller
	 * @param computer
	 * @param modView
	 */
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
	 * Getter of modelloView
	 * @return modelloView
	 */
	public ModelloView getModelloView() {
		return modelloView;
	}

	/**
	 * Setter of modelloView
	 * @param modelloView
	 */
	public void setModelloView(ModelloView modelloView) {
		this.modelloView = modelloView;
	}

	/**
	 * Getter of computer
	 * @return computer
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * Setter of computer
	 * @param computer
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	/**
	 * Getter of tipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter of tipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
