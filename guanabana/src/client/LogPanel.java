package client;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import client.LogController;
import client.RegistratiController;
import javax.swing.SwingConstants;

import modello.Cliente;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * @author  Lele Classe LogPanel: contiene un pannello panelLogin che contiene i  campi di testo per inserire username e password, con i tasti login e  registrati, nel caso in cui non sia stato effettuato il login. In  caso di login effettuato contiene il pannello di saluto. La classe  contiene inoltre un TextArea dove vengono visualizzati i messaggi  ricevuti dal server.
 */
public class LogPanel extends JPanel {

	private static final long serialVersionUID = 1L; // serializzazione
	/**
	 * Dichiarazione delle variabili
	 */
	private JLabel lblUser; // Etichetta email
	private JLabel lblPassword; // Etichetta password
	public JButton btnRegistrati; // Bottone registrati
	public JButton btnLog; // Bottone login
	/**
	 * @uml.property  name="txtUser"
	 */
	public JTextField txtUser; // Campo di testo email
	/**
	 * @uml.property  name="txtPassword"
	 */
	public JPasswordField txtPassword; // Campo di testo password
	/**
	 * @uml.property  name="logController"
	 * @uml.associationEnd  
	 */
	private LogController logController; // Controllore per il bottone login
	/**
	 * @uml.property  name="registratiController"
	 * @uml.associationEnd  
	 */
	private RegistratiController registratiController; // Controllore per il
														// bottone registrati
	/**
	 * @uml.property  name="salutoPanel"
	 * @uml.associationEnd  
	 */
	private SalutoPanel salutoPanel; // Pannello di saluto
	private JPanel panelLogin; // Pannello che contiene gli elementi per fare il
								// login
	/**
	 * @uml.property  name="txaMessaggio"
	 */
	private JTextArea txaMessaggio; // Box per i messaggi ricevuti dal server
									// (errori ecc..)
	/**
	 * @uml.property  name="contenuto"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel contenuto; // Pannello contenuto

	/**
	 * @param contenuto
	 *            Costruttore: crea il pannello con il pannello login
	 */
	public LogPanel(ContenutoPanel contenuto) {
		// Controllori
		logController = new LogController(this); // controllore tasto login
		registratiController = new RegistratiController(this, contenuto); // controllore
		this.setContenuto(contenuto); // associa il pannello contenuto
		setBackground(Color.WHITE); // colore di sfondo

		// inizializza, definisce aspetto e aggiunge gli elementi al pannello
		// panelLogin
		panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] { 72, 127, 126, 0, 0, 53, 0 };
		gbl_panelLogin.rowHeights = new int[] { 0, 0 };
		gbl_panelLogin.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panelLogin.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelLogin.setLayout(gbl_panelLogin);

		lblUser = new JLabel("Email: "); // inizializza l'etichetta Email
		lblUser.setHorizontalAlignment(SwingConstants.LEFT); // allineamento

		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 0, 5);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		panelLogin.add(lblUser, gbc_lblUser);
		// password
		lblUser.setLabelFor(txtUser); // associa etichetta a campo di testo
		// testo
		txtUser = new JTextField(15); // inizializza campo di testo Email
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.anchor = GridBagConstraints.WEST;
		gbc_txtUser.insets = new Insets(0, 0, 0, 5);
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		panelLogin.add(txtUser, gbc_txtUser);
		// testo
		lblPassword = new JLabel("Password: "); // inizializza l'etichetta
		// password
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT); // allineamento
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 0;
		panelLogin.add(lblPassword, gbc_lblPassword);
		lblPassword.setLabelFor(txtPassword); // associa etichetta a campo di
		txtPassword = new JPasswordField(15); // inizializza campo di testo
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.anchor = GridBagConstraints.WEST;
		gbc_txtPassword.insets = new Insets(0, 0, 0, 5);
		gbc_txtPassword.gridx = 3;
		gbc_txtPassword.gridy = 0;
		panelLogin.add(txtPassword, gbc_txtPassword);
		// testo

		// inizializza bottoni login e registrati
		btnLog = new JButton("Login");
		GridBagConstraints gbc_btnLog = new GridBagConstraints();
		gbc_btnLog.fill = GridBagConstraints.BOTH;
		gbc_btnLog.insets = new Insets(0, 0, 0, 5);
		gbc_btnLog.gridx = 4;
		gbc_btnLog.gridy = 0;
		panelLogin.add(btnLog, gbc_btnLog);
		btnLog.addActionListener(logController);
		btnRegistrati = new JButton("Registrati");
		GridBagConstraints gbc_btnRegistrati = new GridBagConstraints();
		gbc_btnRegistrati.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrati.gridx = 5;
		gbc_btnRegistrati.gridy = 0;
		panelLogin.add(btnRegistrati, gbc_btnRegistrati);
		// tasto
		// registrati
		btnRegistrati.addActionListener(registratiController);

		add(panelLogin, BorderLayout.NORTH); // aggiunge panelLogin a LogPanel
		txaMessaggio = new JTextArea(""); // inizializza il messaggio vuoto
		txaMessaggio.setFont(new Font("Comic Sans MS", Font.BOLD, 13)); // aspetto
		txaMessaggio.setForeground(Color.RED);
		txaMessaggio.setEditable(false);
		add(txaMessaggio, BorderLayout.CENTER); // aggiunge campo per il
												// messaggio sotto panelLogin

	}

	/**
	 * Blocca l'inserimento nei campi di testo e blocca i bottoni
	 */
	public void bloccareInserimento() {
		btnLog.setEnabled(false);
		txtPassword.setEnabled(false);
		txtUser.setEnabled(false);
		btnRegistrati.setEnabled(false);
	}

	/**
	 * @param cliente
	 * @param cognome
	 *            Mostra salutoPanel una volta fatto il login
	 */
	public void loginFatto(Cliente cliente) {
		logController.setCliente(cliente);
		// Nasconde gli elementi
		nascondiFormRegistrazione();
		panelLogin.setVisible(false);
		setTxaMessaggio("");
		// Inizializzazione e posizionamento di salutoPanel
		salutoPanel = new SalutoPanel(cliente.getNome() + " "
				+ cliente.getCognome(), this);
		add(salutoPanel, BorderLayout.NORTH);

		if (contenuto.getAttessaCompra() == true) {
			contenuto.setClienteLogato(cliente);
			contenuto.continuaOperazione();
		}
	}

	public void nascondiFormRegistrazione() {
		contenuto.pulisceSchermo();
		contenuto.setClienteLogato(logController.getCliente());
	}

	/**
	 * Permette inserimento nei campi di testo Email e Password ed attiva i
	 * bottoni login e registrati
	 */
	public void sbloccareInserimento() {
		panelLogin.setVisible(true);
		btnLog.setEnabled(true);
		txtPassword.setEnabled(true);
		txtUser.setEnabled(true);
		btnRegistrati.setEnabled(true);
		setTxtUser("");
		setTxtPassword("");
	}

	public void logoutFatto() {
		salutoPanel.setVisible(false);
		sbloccareInserimento();
		contenuto.setClienteLogato(null);
		contenuto.removeAll();
		contenuto.pulisceSchermo();
	}

	public void mostraMessaggioErrore(String messaggio) {
		txaMessaggio.setVisible(true);
		setTxaMessaggio(messaggio);
	}

	public void nascondiMessaggioErrore() {
		if (txaMessaggio.isVisible() == true) {
			txaMessaggio.setVisible(false);
		}
	}

	// inizio getters and setters
	/**
	 * @return
	 * @uml.property  name="txtUser"
	 */
	public String getTxtUser() {
		return txtUser.getText();
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	/**
	 * @return
	 * @uml.property  name="txtPassword"
	 */
	public char[] getTxtPassword() {
		return txtPassword.getPassword();
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

	/**
	 * @return  the txaMessaggio
	 * @uml.property  name="txaMessaggio"
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

	/**
	 * @return
	 * @uml.property  name="contenuto"
	 */
	public ContenutoPanel getContenuto() {
		return contenuto;
	}

	/**
	 * @param contenuto  the contenuto to set
	 * @uml.property  name="contenuto"
	 */
	public void setContenuto(ContenutoPanel contenuto) {
		this.contenuto = contenuto;
	}

	/**
	 * @uml.property  name="logController1"
	 * @uml.associationEnd  
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
	// fine getters and setters

}
