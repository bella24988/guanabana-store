package client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Color;

/**
 * Classe RingraziamentiPanel: semplice pannello di ringraziamento
 * che conferma il successo della transazione dopo un acquisto.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013. 
 */
public class RigraziamentiPanel extends JPanel {

	/**
	 * Serializzazione
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore del pannello di ringraziamento
	 */
	public RigraziamentiPanel() {
		setLayout(new BorderLayout(0, 0));

		JTextPane txtpnGraziePerLacquisto = new JTextPane();
		txtpnGraziePerLacquisto.setBackground(Color.WHITE);
		txtpnGraziePerLacquisto.setEditable(false);
		txtpnGraziePerLacquisto.setText("Grazie per l'acquisto!");
		add(txtpnGraziePerLacquisto, BorderLayout.CENTER);

	}

}
