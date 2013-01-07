package client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.LogController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


/**
 * Classe SalutoPanel: Pannello che conferma l'avvenuto login,
 * salutando il cliente e restando visibile nella parte superiore del sito.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013. 
 */
public class SalutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione delle variabili
	 */
	private JLabel lblSaluto; // Etichette
	public JButton btnLogOut;
	public JButton btnGestioneOrdine;
	private JButton btnCarrello;
	private JSeparator separator;
	
	private String nome;

	private LogController logController;
	private LogPanel logPanel;

	/**
	 * Costruttore del pannello di saluto
	 * @param nome
	 * @param logPanel
	 */
	public SalutoPanel(String nome, LogPanel logPanel) {
		setForeground(new Color(0, 100, 0));
		setBackground(Color.WHITE);
		this.setLogPanel(logPanel);
		this.setNome(nome);

		// Controller
		logController = new LogController(this, logPanel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0,100, 140, 176, 100, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblSaluto = new JLabel("Ciao " + nome + "!");
		lblSaluto.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblSaluto.setForeground(new Color(0, 100, 0));
		GridBagConstraints gbc_lblSaluto = new GridBagConstraints();
		gbc_lblSaluto.gridwidth = 2;
		gbc_lblSaluto.fill = GridBagConstraints.BOTH;
		gbc_lblSaluto.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaluto.gridx = 0;
		gbc_lblSaluto.gridy = 0;
		add(lblSaluto, gbc_lblSaluto);
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(SalutoPanel.class.getResource("/icons/logout-icon.png")));
		btnLogOut.setToolTipText("Logout");
		btnLogOut.setActionCommand("Logout");
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.gridheight = 2;
		gbc_btnLogOut.fill = GridBagConstraints.BOTH;
		gbc_btnLogOut.gridx = 6;
		gbc_btnLogOut.gridy = 0;
		add(btnLogOut, gbc_btnLogOut);
		btnGestioneOrdine = new JButton("I tuoi ordini");
		btnGestioneOrdine.setIcon(new ImageIcon(SalutoPanel.class.getResource("/icons/order-history.png")));
		GridBagConstraints gbc_btnGestioneOrdine = new GridBagConstraints();
		gbc_btnGestioneOrdine.gridheight = 2;
		gbc_btnGestioneOrdine.fill = GridBagConstraints.BOTH;
		gbc_btnGestioneOrdine.insets = new Insets(0, 0, 0, 5);
		gbc_btnGestioneOrdine.gridx = 4;
		gbc_btnGestioneOrdine.gridy = 0;
		add(btnGestioneOrdine, gbc_btnGestioneOrdine);
		btnGestioneOrdine.addActionListener(logController);
		btnGestioneOrdine.setCursor(Cursor
				.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnCarrello = new JButton("Carrello");
		btnCarrello.setIcon(new ImageIcon(SalutoPanel.class.getResource("/icons/img_icon.gif.png")));
		btnCarrello.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_btnCarrello = new GridBagConstraints();
		gbc_btnCarrello.gridheight = 2;
		gbc_btnCarrello.fill = GridBagConstraints.BOTH;
		gbc_btnCarrello.insets = new Insets(0, 0, 0, 5);
		gbc_btnCarrello.gridx = 5;
		gbc_btnCarrello.gridy = 0;
		add(btnCarrello, gbc_btnCarrello);
		btnCarrello.addActionListener(logController);
		btnLogOut.addActionListener(logController);

		btnCarrello.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridheight = 2;
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 3;
		gbc_separator.gridy = 0;
		add(separator, gbc_separator);
	}

	/**
	 * Getter of nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter of nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Getter of lblSaluto
	 * @return lblSaluto
	 */
	public JLabel getLblSaluto() {
		return lblSaluto;
	}

	/**
	 * Setter of lblSaluto
	 * @param lblSaluto
	 */
	public void setLblSaluto(JLabel lblSaluto) {
		this.lblSaluto = lblSaluto;
	}

	/**
	 * Getter of logPanel
	 * @return logPanel
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}

	/**
	 * Setter of logPanel
	 * @param logPanel
	 */
	public void setLogPanel(LogPanel panel) {
		this.logPanel = panel;
	}

}
