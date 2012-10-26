package azienda;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogAzienda extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private GestioneOrdine gestioneOrdine;
	private LogControllerAzienda logControllerAzienda;

	/**
	 * Create the panel.
	 */
	public LogAzienda(GestioneOrdine gestioneOrdine2) {
		this.setGestioneOrdine(gestioneOrdine2);
		logControllerAzienda = new LogControllerAzienda(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCodiceUtente = new JLabel("Codice utente:");
		GridBagConstraints gbc_lblCodiceUtente = new GridBagConstraints();
		gbc_lblCodiceUtente.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodiceUtente.gridx = 0;
		gbc_lblCodiceUtente.gridy = 0;
		add(lblCodiceUtente, gbc_lblCodiceUtente);

		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(0, 0, 5, 0);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.anchor = GridBagConstraints.NORTH;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		add(txtPassword, gbc_txtPassword);

		JButton btnEntra = new JButton("Entra");
		GridBagConstraints gbc_btnEntra = new GridBagConstraints();
		gbc_btnEntra.fill = GridBagConstraints.BOTH;
		gbc_btnEntra.gridwidth = 2;
		gbc_btnEntra.gridx = 0;
		gbc_btnEntra.gridy = 2;
		add(btnEntra, gbc_btnEntra);

		btnEntra.addActionListener(logControllerAzienda);

	}

	/**
	 * @return the gestioneOrdine
	 */
	public GestioneOrdine getGestioneOrdine() {
		return gestioneOrdine;
	}

	/**
	 * @param gestioneOrdine
	 *            the gestioneOrdine to set
	 */
	public void setGestioneOrdine(GestioneOrdine gestioneOrdine) {
		this.gestioneOrdine = gestioneOrdine;
	}

	/**
	 * @return the logControllerAzienda
	 */
	public LogControllerAzienda getLogControllerAzienda() {
		return logControllerAzienda;
	}

	/**
	 * @param logControllerAzienda
	 *            the logControllerAzienda to set
	 */
	public void setLogControllerAzienda(
			LogControllerAzienda logControllerAzienda) {
		this.logControllerAzienda = logControllerAzienda;
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	public char[] getTxtPassword() {
		return txtPassword.getPassword();
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

}
