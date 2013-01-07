package client;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

import client.RegistratiController;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import modello.Cliente;

/**
 * Classe RegistratiView: Crea il pannello che contiene il form per la registrazione,
 * con tutti i campi validati e con i pulsanti per confermare o annullare la registrazione.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013. 
 */
public class RegistratiView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Dichiarazione delle variabili
	 */
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtCf;
	private JTextField txtEmail;
	private JTextField txtCitta;
	private JTextField txtVia;
	private JTextField txtProvincia;
	private JTextField txtCap;
	private JTextField txtStato;
	private JTextField txtTelefono;
	private JPasswordField txtPassword;
	private JPasswordField txtPasswordConferma;

	private JTextField[] txtArray = { txtNome, txtCognome, txtCf, txtEmail,
			txtCitta, txtVia, txtProvincia, txtCap, txtStato, txtTelefono };

	private static String[] labels = { "Nome:", "Cognome:", "C.F.:", "Email:",
			"Cittˆ:", "Via:", "Provincia:", "CAP:", "Stato:", "Telefono:",
			"Password:", "Conferma Password:" };

	JTextPane txaMessaggioErrore;

	private LogPanel logPanel;
	private ContenutoPanel panelContenitore;
	private RegistratiController controller;
	
	/**
	 * Costruttore del pannello di registrazione
	 * @param panelContenitore
	 */
	public RegistratiView(ContenutoPanel panelContenitore) {

		setBackground(Color.WHITE);
		setForeground(Color.BLACK);

		this.setPanelContenitore(panelContenitore);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 122, 125, 40, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblRegistrati = new JLabel("Registrati");
		lblRegistrati.setForeground(new Color(0, 102, 0));
		lblRegistrati.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblRegistrati = new GridBagConstraints();
		gbc_lblRegistrati.gridwidth = 3;
		gbc_lblRegistrati.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistrati.gridx = 1;
		gbc_lblRegistrati.gridy = 0;
		add(lblRegistrati, gbc_lblRegistrati);

		for (int i = 1; i < 13; i++) {

			JLabel lblReg = new JLabel(labels[i - 1]);
			GridBagConstraints lblGrid = new GridBagConstraints();
			lblGrid.anchor = GridBagConstraints.EAST;
			lblGrid.insets = new Insets(0, 0, 5, 5);
			lblGrid.gridx = 1;
			lblGrid.gridy = i;
			add(lblReg, lblGrid);
		}

		for (int j = 0; j < 10; j++) {

			txtArray[j] = new JTextField();
			txtArray[j].setForeground(new Color(0, 102, 51));
			GridBagConstraints txtGrid = new GridBagConstraints();
			txtGrid.insets = new Insets(0, 0, 5, 5);
			txtGrid.fill = GridBagConstraints.HORIZONTAL;
			txtGrid.gridx = 2;
			txtGrid.gridy = j + 1;
			add(txtArray[j], txtGrid);
			txtArray[j].setColumns(10);
		}

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 11;
		add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		txtPasswordConferma = new JPasswordField();
		GridBagConstraints gbc_txtPasswordConferma = new GridBagConstraints();
		gbc_txtPasswordConferma.insets = new Insets(0, 0, 5, 5);
		gbc_txtPasswordConferma.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasswordConferma.gridx = 2;
		gbc_txtPasswordConferma.gridy = 12;
		add(txtPasswordConferma, gbc_txtPasswordConferma);
		txtPasswordConferma.setColumns(10);

		txaMessaggioErrore = new JTextPane();
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		txaMessaggioErrore.setParagraphAttributes(attribs, true);
		txaMessaggioErrore.setForeground(Color.RED);
		txaMessaggioErrore.setBackground(new Color(204, 255, 153));
		txaMessaggioErrore.setEditable(false);
		GridBagConstraints gbc_txaMessaggioErrore = new GridBagConstraints();
		gbc_txaMessaggioErrore.anchor = GridBagConstraints.EAST;
		gbc_txaMessaggioErrore.gridwidth = 2;
		gbc_txaMessaggioErrore.insets = new Insets(0, 0, 5, 5);
		gbc_txaMessaggioErrore.fill = GridBagConstraints.VERTICAL;
		gbc_txaMessaggioErrore.gridx = 1;
		gbc_txaMessaggioErrore.gridy = 13;
		add(txaMessaggioErrore, gbc_txaMessaggioErrore);

		JButton btnAnnulla = new JButton("Annulla");
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnnulla.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 14;
		add(btnAnnulla, gbc_btnAnnulla);

		JButton btnRegistrati = new JButton("Conferma Registrazione");
		GridBagConstraints gbc_btnRegistrati = new GridBagConstraints();
		gbc_btnRegistrati.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrati.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrati.gridx = 2;
		gbc_btnRegistrati.gridy = 14;
		add(btnRegistrati, gbc_btnRegistrati);

		inizializza();

		controller = new RegistratiController(this);

		btnAnnulla.addActionListener(controller);
		btnRegistrati.addActionListener(controller);
	}

	/**
	 * Metodo che inizializza il form, svuotando tutti i campi
	 */
	public void inizializza() {
		setTxtCap("");
		setTxtCf("");
		setTxtCitta("");
		setTxtCognome("");
		setTxtNome("");
		setTxtEmail("");
		setTxtPassword("");
		setTxtPasswordConferma("");
		setTxtVia("");
		setTxtProvincia("");
		setTxtStato("");
		togliMessaggio();
	}
	
	/**
	 * Nasconde il pannello di registrazione
	 */
	public void disabilitaRegistrati() {
		panelContenitore.getRegistratiView().setVisible(false);
	}
	
	/**
	 * Nasconde il messaggio d'errore
	 */
	public void togliMessaggio() {
		setTxaMessaggioErrore("");
		txaMessaggioErrore.setVisible(false);
	}

	/**
	 * Mostra il messaggio d'errore passato come parametro
	 * @param msn
	 */
	public void mostraMessaggio(String msn) {

		setTxaMessaggioErrore(msn);
		txaMessaggioErrore.setVisible(true);

	}

	/**
	 * Associa il pannello di login
	 * @param logPanel
	 */
	public void associaPanel(LogPanel logPanel) {
		this.setLogPanel(logPanel);
	}

	/**
	 * Nasconde la finestra di registrazione una volta che
	 * il cliente ha effettuato il login
	 * @param cliente
	 */
	public void nascondiFinestra(Cliente cliente) {
		this.setVisible(false);
		logPanel.loginFatto(cliente);
	}
	
	/**
	 * Setter of panelContenitore
	 * @param panelContenitore
	 */
	public void setPanelContenitore(ContenutoPanel panelContenitore) {
		this.panelContenitore = panelContenitore;
	}

	/**
	 * Getter of panelContenitore
	 * @return panelContenitore
	 */
	public ContenutoPanel getPanelContenitore() {
		return panelContenitore;
	}

	/**
	 * Getter of txtNome
	 * @return txtNome
	 */
	public String getTxtNome() {
		return txtArray[0].getText();
	}

	/**
	 * Setter of txtNome
	 * @param txtNome
	 */
	public void setTxtNome(String txtNome) {
		this.txtArray[0].setText(txtNome);
	}

	/**
	 * Getter of txtCognome
	 * @return txtCognome
	 */
	public String getTxtCognome() {
		return txtArray[1].getText();
	}

	/**
	 * Setter of txtCognome
	 * @param txtCognome
	 */
	public void setTxtCognome(String txtCognome) {
		this.txtArray[1].setText(txtCognome);
	}

	/**
	 * Getter of txtCf
	 * @return txtCf
	 */
	public String getTxtCf() {
		return txtArray[2].getText();
	}

	/**
	 * Setter of txtCf
	 * @param txtCf
	 */
	public void setTxtCf(String txtCf) {
		this.txtArray[2].setText(txtCf);
	}

	/**
	 * Getter of txtEmail
	 * @return txtEmail
	 */
	public String getTxtEmail() {
		return txtArray[3].getText();
	}

	/**
	 * Setter of txtEmail
	 * @param txtEmail
	 */
	public void setTxtEmail(String txtEmail) {
		this.txtArray[3].setText(txtEmail);
	}

	/**
	 * Getter of txtCitta
	 * @return txtCitta
	 */
	public String getTxtCitta() {
		return txtArray[4].getText();
	}

	/**
	 * Setter of txtCitta
	 * @param txtCitta
	 */
	public void setTxtCitta(String txtCitta) {
		this.txtArray[4].setText(txtCitta);
	}

	/**
	 * Getter of txtVia
	 * @return txtVia
	 */
	public String getTxtVia() {
		return txtArray[5].getText();
	}

	/**
	 * Setter of txtVia
	 * @param string
	 */
	public void setTxtVia(String string) {
		this.txtArray[5].setText(string);
	}

	/**
	 * Getter of txtProvincia
	 * @return txtProvincia
	 */
	public String getTxtProvincia() {
		return txtArray[6].getText();
	}

	/**
	 * Setter of txtProvincia
	 * @param txtProvincia
	 */
	public void setTxtProvincia(String txtProvincia) {
		this.txtArray[6].setText(txtProvincia);
	}

	/**
	 * Getter of txtCap
	 * @return txtCap
	 */
	public String getTxtCap() {
		return txtArray[7].getText();
	}

	/**
	 * Setter of txtCap
	 * @param txtCap
	 */
	public void setTxtCap(String txtCap) {
		this.txtArray[7].setText(txtCap);
	}

	/**
	 * Getter of txtStato
	 * @return txtStato
	 */
	public String getTxtStato() {
		return txtArray[8].getText();
	}

	/**
	 * Setter of txtStato
	 * @param txtStato
	 */
	public void setTxtStato(String txtStato) {
		this.txtArray[8].setText(txtStato);
	}

	/**
	 * Getter of txtTelefono
	 * @return txtTelefono
	 */
	public String getTxtTelefono() {
		return txtArray[9].getText();
	}

	/**
	 * Setter of txtTelefono
	 * @param txtTelefono
	 */
	public void setTxtTelefono(String txtTelefono) {
		this.txtArray[9].setText(txtTelefono);
	}

	/**
	 * Getter of txtPassword
	 * @return txtPassword
	 */
	public char[] getTxtPassword() {
		return txtPassword.getPassword();
	}

	/**
	 * Setter of txtPassword
	 * @param txtPassword
	 */
	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

	/**
	 * Getter of txtPasswordConferma
	 * @return txtPasswordConferma
	 */
	public char[] getTxtPasswordConferma() {
		return txtPasswordConferma.getPassword();
	}

	/**
	 * Setter of txtPasswordConferma
	 * @param txtPasswordConferma
	 */
	public void setTxtPasswordConferma(String txtPasswordConferma) {
		this.txtPasswordConferma.setText(txtPasswordConferma);
	}

	/**
	 * Getter of txaMessaggioErrore
	 * @return txaMessaggioErrore
	 */
	public String getTxaMessaggioErrore() {
		return txaMessaggioErrore.getText();
	}

	/**
	 * Setter of txaMessaggioErrore
	 * @param txaMessaggioErrore
	 */
	public void setTxaMessaggioErrore(String txaMessaggioErrore) {
		this.txaMessaggioErrore.setText(txaMessaggioErrore);
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
	public void setLogPanel(LogPanel logPanel) {
		this.logPanel = logPanel;
	}

}
