package client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import client.LogController;

import java.awt.Color;
import java.awt.Font;

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

		lblSaluto = new JLabel("Ciao " + nome + "!");
		lblSaluto.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		lblSaluto.setForeground(new Color(0, 100, 0));
		btnLogOut = new JButton("Logout");
		btnGestioneOrdine = new JButton("I tuoi ordini");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblSaluto, GroupLayout.PREFERRED_SIZE,
								265, GroupLayout.PREFERRED_SIZE)
						.addGap(64)
						.addComponent(btnGestioneOrdine)
						.addGap(18)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE,
								98, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(39, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(9)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSaluto,
																GroupLayout.DEFAULT_SIZE,
																54,
																Short.MAX_VALUE)
														.addComponent(btnLogOut)
														.addComponent(
																btnGestioneOrdine))
										.addContainerGap()));
		setLayout(groupLayout);

		// Controller
		logController = new LogController(this, panel);
		btnLogOut.addActionListener(logController);
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
