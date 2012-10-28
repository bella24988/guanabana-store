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
 * @author  Veronica
 */
public class ModelloView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel modelsPanel;
	/**
	 * @uml.property  name="configPanel"
	 * @uml.associationEnd  
	 */
	private ConfigPanel configPanel;
	/**
	 * @uml.property  name="contenutoPanel"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel contenutoPanel;
	/**
	 * @uml.property  name="numButtons"
	 */
	private int numButtons;
	/**
	 * @uml.property  name="nome"
	 */
	private String[] nome;
	/**
	 * @uml.property  name="prezzo"
	 */
	private float[] prezzo;
	private JButton[] btnModels;
	
	/**
	 * @uml.property  name="modelloController"
	 * @uml.associationEnd  
	 */
	private ModelloController modelloController;
	/**
	 * @uml.property  name="preventivoPanel"
	 * @uml.associationEnd  
	 */
	private PreventivoPanel preventivoPanel;
	/**
	 * @uml.property  name="computer"
	 * @uml.associationEnd  
	 */
	private Computer computer;
	/**
	 * @uml.property  name="preventivoController"
	 * @uml.associationEnd  
	 */
	private PreventivoController preventivoController;

	/**
	 * Create the panel.
	 */
	public ModelloView() {

		modelsPanel = new JPanel();
		modelsPanel.setVisible(false);
		setBackground(Color.white);
	}
	
	
	public void mostraButtons(int num, Computer[] computer, String tipo) {

		int i = 0;
		btnModels = new JButton[num];
		setNumButtons(num);
		while (i < num) {
			btnModels[i] = new JButton();
			btnModels[i].setText(computer[i].getNome() + ", Prezzo: "
					+ String.valueOf(computer[i].getPrezzo()));
			
			modelsPanel.add(btnModels[i]);
			modelsPanel.setVisible(true);
			add(modelsPanel);
			
			this.setComputer(computer[i]);
			modelloController = new ModelloController(computer[i], this);
			btnModels[i].addActionListener(modelloController);
			i++;
		}
	}

	public void nascondeButtons() {
		setVisible(false);
	}

	/**
	 * @return  the numButtons
	 * @uml.property  name="numButtons"
	 */
	public int getNumButtons() {
		return numButtons;
	}

	/**
	 * @param numButtons  the numButtons to set
	 * @uml.property  name="numButtons"
	 */
	public void setNumButtons(int numButtons) {
		this.numButtons = numButtons;
	}

	/**
	 * @return  the nome
	 * @uml.property  name="nome"
	 */
	public String[] getNome() {
		return nome;
	}

	/**
	 * @param nome  the nome to set
	 * @uml.property  name="nome"
	 */
	public void setNome(String[] nome) {
		this.nome = nome;
	}

	/**
	 * @return  the prezzo
	 * @uml.property  name="prezzo"
	 */
	public float[] getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo  the prezzo to set
	 * @uml.property  name="prezzo"
	 */
	public void setPrezzo(float[] prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @uml.property  name="modelloController"
	 * @uml.associationEnd  
	 */
	private ModelloController controller;

	/**
	 * Getter of the property <tt>modelloController</tt>
	 * 
	 * @return Returns the controller.
	 * @uml.property name="modelloController"
	 */
	public ModelloController getModelloController() {
		return controller;
	}

	// ann
	/**
	 * Setter of the property <tt>modelloController</tt>
	 * 
	 * @param modelloController
	 *            The controller to set.
	 * @uml.property name="modelloController"
	 */
	public void setModelloController(ModelloController modelloController) {
		controller = modelloController;
	}

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
		configPanel = new ConfigPanel(comp.getComponente(),
				comp.getConfigurazioneStandard(), preventivoController, type);
		configPanel.setVisible(true);
		setSecondoComputer(comp);
	}

	private void setSecondoComputer(Computer comp) {

		preventivoPanel = new PreventivoPanel(preventivoController);
		preventivoController.setConfigPanel(configPanel);
		preventivoController.setPreventivoPanel(preventivoPanel);
		preventivoController.setComputer(comp);
		preventivoController.setContenutoPanel(getContenutoPanel());
		preventivoPanel.setTotalePreventivo(String.valueOf(comp.getPrezzo()));
		JScrollPane scroller = new JScrollPane(configPanel);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setPreferredSize(new Dimension(550, 400));
		add(scroller, BorderLayout.WEST);
		add(preventivoPanel, BorderLayout.EAST);
	}

	/**
	 * @return  the contenutoPanel
	 * @uml.property  name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel  the contenutoPanel to set
	 * @uml.property  name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * @return
	 * @uml.property  name="computer"
	 */
	public Computer getComputer() {
		return computer;
	}

	/**
	 * @param computer
	 * @uml.property  name="computer"
	 */
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
