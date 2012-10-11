package client;

import javax.swing.JPanel;

public class ConfermaOrdinePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private String nome;
	private String prezzo;

	public ConfermaOrdinePanel(String nome, String prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
		setVisible(true);
	}

}
