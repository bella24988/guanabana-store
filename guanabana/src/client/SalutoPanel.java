package client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.LogController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class SalutoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione Variabile
	 */
	private JLabel lblSaluto; // Etichette
	public JButton btnLogOut;
	public JButton btnGestioneOrdine;
	private LogController logController;
	private String nome;
	private LogPanel panel;

	// COSTRUTTORE
	public SalutoPanel(String nome, LogPanel panel) {
		setForeground(new Color(0, 100, 0));
		setBackground(Color.WHITE);
		this.setPanel(panel);
		this.setNome(nome);

		// Controller
		logController = new LogController(this, panel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 265, 98, 87, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblSaluto = new JLabel("Ciao " + nome + "!");
		lblSaluto.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblSaluto.setForeground(new Color(0, 100, 0));
		GridBagConstraints gbc_lblSaluto = new GridBagConstraints();
		gbc_lblSaluto.fill = GridBagConstraints.BOTH;
		gbc_lblSaluto.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaluto.gridx = 0;
		gbc_lblSaluto.gridy = 0;
		add(lblSaluto, gbc_lblSaluto);
		btnLogOut = new JButton("Logout");
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogOut.gridx = 1;
		gbc_btnLogOut.gridy = 0;
		add(btnLogOut, gbc_btnLogOut);
		btnLogOut.addActionListener(logController);
		btnGestioneOrdine = new JButton("I tuoi ordini");
		GridBagConstraints gbc_btnGestioneOrdine = new GridBagConstraints();
		gbc_btnGestioneOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestioneOrdine.anchor = GridBagConstraints.WEST;
		gbc_btnGestioneOrdine.gridx = 2;
		gbc_btnGestioneOrdine.gridy = 0;
		add(btnGestioneOrdine, gbc_btnGestioneOrdine);

		btnCarrello = new JButton("Carrello");
		btnCarrello.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_btnCarrello = new GridBagConstraints();
		gbc_btnCarrello.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCarrello.gridwidth = 2;
		gbc_btnCarrello.insets = new Insets(0, 0, 0, 5);
		gbc_btnCarrello.gridx = 1;
		gbc_btnCarrello.gridy = 1;
		add(btnCarrello, gbc_btnCarrello);
		btnCarrello.addActionListener(logController);
		btnGestioneOrdine.addActionListener(logController);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the lblSaluto
	 */
	public JLabel getLblSaluto() {
		return lblSaluto;
	}

	/**
	 * @param lblSaluto
	 *            the lblSaluto to set
	 */
	public void setLblSaluto(JLabel lblSaluto) {
		this.lblSaluto = lblSaluto;
	}

	/**
	 * @return the panel
	 */
	public LogPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public void setPanel(LogPanel panel) {
		this.panel = panel;
	}

	/**
	 * @uml.property name="logController1"
	 * @uml.associationEnd inverse="salutoPanel:client.LogController"
	 * @uml.association name="controllato"
	 */
	private LogController logController1;

	/**
	 * Getter of the property <tt>logController1</tt>
	 * 
	 * @return Returns the logController1.
	 * @uml.property name="logController1"
	 */
	public LogController getLogController1() {
		return logController1;
	}

	/**
	 * Setter of the property <tt>logController1</tt>
	 * 
	 * @param logController1
	 *            The logController1 to set.
	 * @uml.property name="logController1"
	 */
	public void setLogController1(LogController logController1) {
		this.logController1 = logController1;
	}

	/**
	 * @uml.property name="logPanel"
	 * @uml.associationEnd inverse="salutoPanel:client.LogPanel"
	 * @uml.association name="si mostra in"
	 */
	private LogPanel logPanel;
	private JButton btnCarrello;

	/**
	 * Getter of the property <tt>logPanel</tt>
	 * 
	 * @return Returns the logPanel.
	 * @uml.property name="logPanel"
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}

	/**
	 * Setter of the property <tt>logPanel</tt>
	 * 
	 * @param logPanel
	 *            The logPanel to set.
	 * @uml.property name="logPanel"
	 */
	public void setLogPanel(LogPanel logPanel) {
		this.logPanel = logPanel;
	}

}
