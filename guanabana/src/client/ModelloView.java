package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import modello.Computer;

public class ModelloView extends JPanel {

	/**
	 * 
	 */
	private JPanel serverPanel;
	/**
	 * 
	 */
	private JPanel laptopPanel;
	/**
	 * 
	 */
	private JPanel desktopPanel;
	private int numButtons;
	private String[] nome;
	private float[] prezzo;
	private JButton[] btnModelli;
	private static final long serialVersionUID = 1L;
	private ModelloController modelloController;
	private ConfServerPanel confServerPanel;
	private PreventivoPanel preventivo;
	private Computer computer;

	/**
	 * Create the panel.
	 */
	public ModelloView() {
		laptopPanel = new JPanel();
		desktopPanel = new JPanel();
		serverPanel = new JPanel();
		laptopPanel.setVisible(false);
		serverPanel.setVisible(false);
		desktopPanel.setVisible(false);
		setBackground(Color.white);
	}

	public void mostraButtons(int num, Computer[] computer, String tipo) {

		int i = 0;
		btnModelli = new JButton[num];
		setNumButtons(num);
		while (i < num) {
			btnModelli[i] = new JButton();
			btnModelli[i].setText(computer[i].getNome() + ", Prezzo: "
					+ String.valueOf(computer[i].getPrezzo()));

			if (tipo == "LAPTOP") {
				laptopPanel.add(btnModelli[i]);
				laptopPanel.setVisible(true);
				add(laptopPanel);
			} else if (tipo == "DESKTOP") {

				desktopPanel.add(btnModelli[i]);
				desktopPanel.setVisible(true);
				add(desktopPanel);
			} else {

				serverPanel.add(btnModelli[i]);
				serverPanel.setVisible(true);
				add(serverPanel);
			}
			this.computer = computer[i];
			modelloController = new ModelloController(computer[i], this);
			btnModelli[i].addActionListener(modelloController);
			i++;
		}
	}

	public void nascondeButtons() {
		setVisible(false);
	}

	/**
	 * @return the numButtons
	 */
	public int getNumButtons() {
		return numButtons;
	}

	/**
	 * @param numButtons
	 *            the numButtons to set
	 */
	public void setNumButtons(int numButtons) {
		this.numButtons = numButtons;
	}

	/**
	 * @return the nome
	 */
	public String[] getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String[] nome) {
		this.nome = nome;
	}

	/**
	 * @return the prezzo
	 */
	public float[] getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo
	 *            the prezzo to set
	 */
	public void setPrezzo(float[] prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @uml.property name="modelloController"
	 * @uml.associationEnd inverse="modelloView:client.ModelloController"
	 * @uml.association name="controllato"
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

	//ann
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

	public void mostraComponente(String tipo) {
		System.out.println(tipo + "Modello view");
		laptopPanel.setVisible(false);
		serverPanel.setVisible(false);
		desktopPanel.setVisible(false);
		if (tipo.compareTo("SERVER") == 0) {
			confServerPanel = new ConfServerPanel(
					computer.getComponente(), computer.getConfigurazioneStandard());
			preventivo = new PreventivoPanel();
			JScrollPane scroller = new JScrollPane(confServerPanel);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroller.setPreferredSize(new Dimension(550, 400));
			add(scroller, BorderLayout.WEST);
			add(preventivo, BorderLayout.EAST);
			confServerPanel.setVisible(true);
		}
	}
}
