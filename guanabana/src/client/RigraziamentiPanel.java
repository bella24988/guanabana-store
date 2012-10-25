package client;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Color;

public class RigraziamentiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
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
