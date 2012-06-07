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

/**
 * @author Lele Classe LogPanel: contiene un pannello panelLogin che contiene i
 *         campi di testo per inserire username e password, con i tasti login e
 *         registrati, nel caso in cui non sia stato effettuato il login. In
 *         caso di login effettuato contiene il pannello di saluto. La classe
 *         contiene inoltre un TextArea dove vengono visualizzati i messaggi
 *         ricevuti dal server.
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
	public JTextField txtUser; // Campo di testo email
	public JTextField txtPassword; // Campo di testo password
	private LogController logController; // Controllore per il bottone login
	private RegistratiController registratiController; // Controllore per il
														// bottone registrati
	private SalutoPanel salutoPanel; // Pannello di saluto
	private JPanel panelLogin; // Pannello che contiene gli elementi per fare il
								// login
	private JTextArea txaMessaggio; // Box per i messaggi ricevuti dal server
									// (errori ecc..)
	private ContenutoPanel contenuto; // Pannello contenuto

	/**
	 * @param contenuto
	 *            Costruttore: crea il pannello con il pannello login
	 */
	public LogPanel(ContenutoPanel contenuto) {

		this.setContenuto(contenuto); // associa il pannello contenuto
		setBackground(Color.WHITE); // colore di sfondo

		lblUser = new JLabel("Email: "); // inizializza l'etichetta Email
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT); // allineamento
																// testo
		lblPassword = new JLabel("Password: "); // inizializza l'etichetta
												// password
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT); // allineamento
																	// testo
		txtUser = new JTextField(15); // inizializza campo di testo Email
		txtPassword = new JTextField(15); // inizializza campo di testo password
		lblUser.setLabelFor(txtUser); // associa etichetta a campo di testo
		lblPassword.setLabelFor(txtPassword); // associa etichetta a campo di
												// testo

		// inizializza bottoni login e registrati
		btnLog = new JButton("Login");
		btnRegistrati = new JButton("Registrati");

		// inizializza, definisce aspetto e aggiunge gli elementi al pannello
		// panelLogin
		panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		panelLogin.add(lblUser);
		panelLogin.add(txtUser);
		panelLogin.add(lblPassword);
		panelLogin.add(txtPassword, BorderLayout.SOUTH);
		panelLogin.add(btnLog, BorderLayout.WEST);
		panelLogin.add(btnRegistrati, BorderLayout.EAST);

		add(panelLogin, BorderLayout.NORTH); // aggiunge panelLogin a LogPanel
		txaMessaggio = new JTextArea(""); // inizializza il messaggio vuoto
		txaMessaggio.setFont(new Font("Comic Sans MS", Font.BOLD, 13)); // aspetto
		txaMessaggio.setForeground(Color.RED);
		txaMessaggio.setEditable(false);
		add(txaMessaggio, BorderLayout.CENTER); // aggiunge campo per il
												// messaggio sotto panelLogin

		// Controllori
		logController = new LogController(this); // controllore tasto login
		btnLog.addActionListener(logController);
		registratiController = new RegistratiController(this, contenuto); // controllore
																			// tasto
																			// registrati
		btnRegistrati.addActionListener(registratiController);

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
	 * @param nome
	 * @param cognome
	 *            Mostra salutoPanel una volta fatto il login
	 */
	public void loginFatto(String nome) {
		// Nasconde gli elementi
		nascondiFormRegistrazione();
		panelLogin.setVisible(false);
		setTxaMessaggio("");
		// Inizializzazione e posizionamento di salutoPanel
		salutoPanel = new SalutoPanel(nome, this);
		add(salutoPanel, BorderLayout.NORTH);

	}

	public void nascondiFormRegistrazione() {
		contenuto.getRegistratiView().setVisible(false);
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
	 * @uml.property name="logController1"
	 * @uml.associationEnd inverse="logPanel1:client.LogController"
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
	// fine getters and setters

}
