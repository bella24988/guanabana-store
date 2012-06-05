package client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import client.LogController;
import client.RegistratiController;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;

public class LogPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione Variabile
	 */
	private JLabel lblUser; // Etichette
	/**
	 * Dichiarazione Variabile
	 */
	private JLabel lblPassword;
	public JButton btnRegistrati;
	public JButton btnLog;
	public JTextField txtUser;
	public JTextField txtPassword;
	private LogController logController;
	private RegistratiController registratiController;
	private SalutoPanel logFatto;
	private JTextArea txaMessaggio;
	private JPanel panelLogin;
	private ContenutoPanel contenuto;

	// COSTRUTTORE
	public LogPanel(ContenutoPanel contenuto) {
		this.setContenuto(contenuto);
		setBackground(Color.WHITE);
		lblUser = new JLabel("Email: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPassword = new JTextField(15);
		txtUser = new JTextField(15);
		lblUser.setLabelFor(txtUser);

		lblPassword = new JLabel("Password: ");
		lblPassword.setLabelFor(txtPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLog = new JButton("Login");
		btnRegistrati = new JButton("Registrati");
		panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		panelLogin.add(lblUser);
		panelLogin.add(txtUser);
		panelLogin.add(lblPassword);
		panelLogin.add(txtPassword, BorderLayout.SOUTH);
		panelLogin.add(btnLog, BorderLayout.WEST);
		panelLogin.add(btnRegistrati, BorderLayout.EAST);

		add(panelLogin, BorderLayout.NORTH);
		txaMessaggio = new JTextArea("");
		txaMessaggio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txaMessaggio.setForeground(Color.RED);
		txaMessaggio.setEditable(false);
		add(txaMessaggio, BorderLayout.CENTER);

		// Controllers
		logController = new LogController(this);
		btnLog.addActionListener(logController);
		registratiController = new RegistratiController(this, contenuto);
		btnRegistrati.addActionListener(registratiController);

	}

	public void bloccareInserzione() {
		btnLog.setEnabled(false);
		txtPassword.setEditable(false);
		txtUser.setEnabled(false);
		btnRegistrati.setEnabled(false);
	}

	public void loginFatto(String nome, String cognome) {
		// Non visibilita degli elementi
		deshabilitaRegistrazione();
		btnLog.setVisible(false);
		btnRegistrati.setVisible(false);
		txtPassword.setVisible(false);
		txtUser.setVisible(false);
		lblPassword.setVisible(false);
		lblUser.setVisible(false);
		setTxaMessaggio("");
		// instancia del nuovo panel
		logFatto = new SalutoPanel(nome, cognome, this);
		add(logFatto, BorderLayout.NORTH);

	}

	public void deshabilitaRegistrazione() {
		contenuto.getRegistratiView().setVisible(false);
	}

	public void SbloccareInserzione() {
		btnLog.setVisible(true);
		btnRegistrati.setVisible(true);
		txtPassword.setVisible(true);
		txtUser.setVisible(true);
		lblPassword.setVisible(true);
		lblUser.setVisible(true);
		btnLog.setEnabled(true);
		txtPassword.setEditable(true);
		txtUser.setEnabled(true);
		btnRegistrati.setEnabled(true);
		setTxtUser("");
		setTxtPassword("");
	}

	public void logoutFatto() {
		logFatto.setVisible(false);
		SbloccareInserzione();
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	public String getTxtPassword() {
		return txtPassword.getText();
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

	/**
	 * @return the txaMessaggio
	 */
	public String getTxaMessaggio() {
		return txaMessaggio.getText();
	}

	/**
	 * @param txaMessaggio
	 *            the txaMessaggio to set
	 */
	public void setTxaMessaggio(String txaMessaggio) {
		this.txaMessaggio.setText(txaMessaggio);
	}

	public void mostraMessagio(String messaggio) {
		txaMessaggio.setVisible(true);
		setTxaMessaggio(messaggio);
	}

	public void togliereMessaggio() {
		if (txaMessaggio.isVisible() == true) {
			txaMessaggio.setVisible(false);
		}
	}

	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto
	 *            the contenuto to set
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @uml.property  name="logController1"
	 * @uml.associationEnd  inverse="logPanel1:client.LogController"
	 * @uml.association  name="controllato"
	 */
	private LogController logController1;

	/**
	 * Getter of the property <tt>logController1</tt>
	 * @return  Returns the logController1.
	 * @uml.property  name="logController1"
	 */
	public LogController getLogController1() {
		return logController1;
	}

	/**
	 * Setter of the property <tt>logController1</tt>
	 * @param logController1  The logController1 to set.
	 * @uml.property  name="logController1"
	 */
	public void setLogController1(LogController logController1) {
		this.logController1 = logController1;
	}

}
