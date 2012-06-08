package client;

import javax.swing.JPanel;
import javax.swing.JButton;

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

	/**
	 * Create the panel.
	 */
	public ModelloView() {

	}

	public void mostraButtons(int num, String[] nome, float[] prezzo,
			String tipo) {

		int i = 0;
		btnModelli = new JButton[num];
		setNumButtons(num);
		while (i < num) {
			btnModelli[i] = new JButton();
			btnModelli[i].setText(nome[i] + ", Prezzo: "
					+ String.valueOf(prezzo[i]));

			if (tipo == "LAPTOP") {
				laptopPanel = new JPanel();
				laptopPanel.add(btnModelli[i]);
				laptopPanel.setVisible(true);
				add(laptopPanel);
			} else if (tipo == "DESKTOP") {
				desktopPanel = new JPanel();
				desktopPanel.add(btnModelli[i]);
				desktopPanel.setVisible(true);
				add(desktopPanel);
			} else {
				serverPanel = new JPanel();
				serverPanel.add(btnModelli[i]);
				serverPanel.setVisible(true);
				add(serverPanel);
			}
			modelloController = new ModelloController(nome[i],this);
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

}
