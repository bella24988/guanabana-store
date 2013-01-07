package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import modello.Computer;

/**
 * Classe ModelloView: Pannello che mostra i modelli disponibili per il tipo di computer selezionato
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class ModelloView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private int numButtons;
	private String[] nome;
	private float[] prezzo;
	private JButton[] btnModels;
	
	private JPanel modelsPanel;
	private ConfigPanel configPanel;
	private ContenutoPanel contenutoPanel;
	private PreventivoPanel preventivoPanel;

	private ModelloController modelloController;
	private PreventivoController preventivoController;

	private Computer computer;

	/**
	 * Costruttore del pannello di scelta dei modelli
	 */
	public ModelloView() {

		modelsPanel = new JPanel();
		modelsPanel.setVisible(false);
		modelsPanel.setBackground(Color.white);
	}

	/**
	 * Mostra i pulsanti di scelta fra i modelli disponibili in base al tipo di computer scelto,
	 * evidenziando nome e prezzo dei modelli.
	 * @param num
	 * @param computer
	 * @param tipo
	 */
	public void mostraButtons(int num, Computer[] computer, String tipo) {

		int i = 0;
		btnModels = new JButton[num];
		setNumButtons(num);
		while (i < num) {
			btnModels[i] = new JButton();
			btnModels[i].setText(computer[i].getNome() + ", Prezzo: "
					+ String.valueOf(computer[i].getPrezzo()));
			btnModels[i].setBackground(Color.white);
			modelsPanel.add(btnModels[i]);
			modelsPanel.setVisible(true);
			add(modelsPanel);

			this.setComputer(computer[i]);
			modelloController = new ModelloController(computer[i], this);
			btnModels[i].addActionListener(modelloController);
			i++;
		}
	}

	/**
	 * Nasconde i pulsanti di scelta fra i modelli disponibili.
	 */
	public void nascondeButtons() {
		setVisible(false);
	}
	
	/**
	 * Mostra i componenti selezionabili per il computer passato come parametro
	 * @param comp
	 */
	public void mostraComponente(Computer comp) {
		int type = 0;
		modelsPanel.setVisible(false);
		preventivoController = new PreventivoController();
		if (comp.getTipo().compareTo("LAPTOP") == 0) {
			type = 0;
		} else if (comp.getTipo().compareTo("DESKTOP") == 0) {
			type = 1;
		} else if (comp.getTipo().compareTo("SERVER") == 0) {
			type = 2;
		}
		configPanel = new ConfigPanel(comp.getConfigurazione(),
				preventivoController, type);
		configPanel.setVisible(true);
		setSecondoComputer(comp);
	}

	/**
	 * Metodo di supporto a mostraComponente: in base al computer selezionato imposta la configurazione standard e
	 * l'associa al pannello di preventivo, cos“ da permettere l'aggiornamento in tempo reale del prezzo totale.
	 * @param comp
	 */
	private void setSecondoComputer(Computer comp) {

		preventivoPanel = new PreventivoPanel(preventivoController);
		preventivoController.setConfigPanel(configPanel);
		preventivoController.setPreventivoPanel(preventivoPanel);
		preventivoController.setComputer(comp);
		preventivoController.setContenutoPanel(getContenutoPanel());
		preventivoPanel.setTotalePreventivo(String.valueOf(comp.getPrezzo()));
		JScrollPane scroller = new JScrollPane(configPanel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setPreferredSize(new Dimension(500, 510));
		add(scroller, BorderLayout.WEST);
		add(preventivoPanel, BorderLayout.EAST);
		setBackground(Color.white);
	}

	/**
	 * Getter of numButtons
	 * @return numButtons
	 */
	public int getNumButtons() {
		return numButtons;
	}

	/**
	 * Setter of numButtons
	 * @param numButtons
	 */
	public void setNumButtons(int numButtons) {
		this.numButtons = numButtons;
	}

	/**
	 * Getter of nome
	 * @return nome
	 */
	public String[] getNome() {
		return nome;
	}

	/**
	 * Setter of nome
	 * @param nome
	 */
	public void setNome(String[] nome) {
		this.nome = nome;
	}

	/**
	 * Getter of prezzo
	 * @return prezzo
	 */
	public float[] getPrezzo() {
		return prezzo;
	}

	/**
	 * Setter of prezzo
	 * @param prezzo
	 */
	public void setPrezzo(float[] prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * Getter of contenutoPanel
	 * @return contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of contenutoPanel
	 * @param contenutoPanel
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
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
}
