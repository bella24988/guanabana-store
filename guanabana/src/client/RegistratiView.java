package client;

import javax.swing.JPanel;
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

public class RegistratiView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtCf;
	private JTextField txtEmail;
	private JTextField txtVia;
	private JTextField txtTelefono;
	private JTextField txtCap;
	private JTextField txtPassword;
	private JTextField txtPasswordConferma;
	private ContenutoPanel panelContenitore;
	private RegistratiController controller;
	private JTextField txtCitta;
	private JTextField txtProvincia;
	private JTextField txtStato;
	JTextPane txaMessaggioErrore;
	private LogPanel logPanel;

	/**
	 * Create the panel.
	 */
	public RegistratiView(ContenutoPanel panelContenitore) {
		this.setPanelContenitore(panelContenitore);
		setForeground(new Color(0, 102, 51));
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

		JLabel lblRegistrati = new JLabel("REGISTRATI");
		lblRegistrati.setForeground(new Color(0, 102, 0));
		lblRegistrati.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblRegistrati = new GridBagConstraints();
		gbc_lblRegistrati.gridwidth = 3;
		gbc_lblRegistrati.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistrati.gridx = 1;
		gbc_lblRegistrati.gridy = 0;
		add(lblRegistrati, gbc_lblRegistrati);

		JLabel lblCF = new JLabel("C.F.");
		GridBagConstraints gbc_lblCF = new GridBagConstraints();
		gbc_lblCF.anchor = GridBagConstraints.EAST;
		gbc_lblCF.insets = new Insets(0, 0, 5, 5);
		gbc_lblCF.gridx = 1;
		gbc_lblCF.gridy = 1;
		add(lblCF, gbc_lblCF);

		txtCf = new JTextField();
		txtCf.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtCf = new GridBagConstraints();
		gbc_txtCf.insets = new Insets(0, 0, 5, 5);
		gbc_txtCf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCf.gridx = 2;
		gbc_txtCf.gridy = 1;
		add(txtCf, gbc_txtCf);
		txtCf.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		txtNome.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 2;
		gbc_txtNome.gridy = 2;
		add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblCognome = new JLabel("Cognome:");
		GridBagConstraints gbc_lblCognome = new GridBagConstraints();
		gbc_lblCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblCognome.anchor = GridBagConstraints.EAST;
		gbc_lblCognome.gridx = 1;
		gbc_lblCognome.gridy = 3;
		add(lblCognome, gbc_lblCognome);

		txtCognome = new JTextField();
		txtCognome.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtCognome = new GridBagConstraints();
		gbc_txtCognome.insets = new Insets(0, 0, 5, 5);
		gbc_txtCognome.anchor = GridBagConstraints.NORTH;
		gbc_txtCognome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCognome.gridx = 2;
		gbc_txtCognome.gridy = 3;
		add(txtCognome, gbc_txtCognome);
		txtCognome.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 4;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblIndirizzo = new JLabel("INDIRIZZO");
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.gridwidth = 3;
		gbc_lblIndirizzo.insets = new Insets(0, 0, 5, 0);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 5;
		add(lblIndirizzo, gbc_lblIndirizzo);

		JLabel lblVia = new JLabel("Via:");
		GridBagConstraints gbc_lblVia = new GridBagConstraints();
		gbc_lblVia.anchor = GridBagConstraints.EAST;
		gbc_lblVia.insets = new Insets(0, 0, 5, 5);
		gbc_lblVia.gridx = 1;
		gbc_lblVia.gridy = 6;
		add(lblVia, gbc_lblVia);

		txtVia = new JTextField();
		txtVia.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtVia = new GridBagConstraints();
		gbc_txtVia.insets = new Insets(0, 0, 5, 5);
		gbc_txtVia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVia.gridx = 2;
		gbc_txtVia.gridy = 6;
		add(txtVia, gbc_txtVia);
		txtVia.setColumns(10);

		JLabel lblCitta = new JLabel("Citt\u00E0:");
		GridBagConstraints gbc_lblCitta = new GridBagConstraints();
		gbc_lblCitta.anchor = GridBagConstraints.EAST;
		gbc_lblCitta.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitta.gridx = 1;
		gbc_lblCitta.gridy = 7;
		add(lblCitta, gbc_lblCitta);

		txtCitta = new JTextField();
		GridBagConstraints gbc_txtCitta = new GridBagConstraints();
		gbc_txtCitta.anchor = GridBagConstraints.NORTH;
		gbc_txtCitta.insets = new Insets(0, 0, 5, 5);
		gbc_txtCitta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCitta.gridx = 2;
		gbc_txtCitta.gridy = 7;
		add(txtCitta, gbc_txtCitta);
		txtCitta.setColumns(10);

		JLabel lblProvincia = new JLabel("Provincia:");
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.anchor = GridBagConstraints.EAST;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 8;
		add(lblProvincia, gbc_lblProvincia);

		txtProvincia = new JTextField();
		GridBagConstraints gbc_txtProvincia = new GridBagConstraints();
		gbc_txtProvincia.anchor = GridBagConstraints.NORTH;
		gbc_txtProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_txtProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProvincia.gridx = 2;
		gbc_txtProvincia.gridy = 8;
		add(txtProvincia, gbc_txtProvincia);
		txtProvincia.setColumns(10);

		JLabel lblCap = new JLabel("C.A.P.");
		GridBagConstraints gbc_lblCap = new GridBagConstraints();
		gbc_lblCap.anchor = GridBagConstraints.EAST;
		gbc_lblCap.insets = new Insets(0, 0, 5, 5);
		gbc_lblCap.gridx = 1;
		gbc_lblCap.gridy = 9;
		add(lblCap, gbc_lblCap);

		txtCap = new JTextField();
		txtCap.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtCap = new GridBagConstraints();
		gbc_txtCap.anchor = GridBagConstraints.NORTH;
		gbc_txtCap.insets = new Insets(0, 0, 5, 5);
		gbc_txtCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCap.gridx = 2;
		gbc_txtCap.gridy = 9;
		add(txtCap, gbc_txtCap);
		txtCap.setColumns(10);

		JLabel lblStato = new JLabel("Stato:");
		GridBagConstraints gbc_lblStato = new GridBagConstraints();
		gbc_lblStato.insets = new Insets(0, 0, 5, 5);
		gbc_lblStato.anchor = GridBagConstraints.EAST;
		gbc_lblStato.gridx = 1;
		gbc_lblStato.gridy = 10;
		add(lblStato, gbc_lblStato);

		txtStato = new JTextField();
		GridBagConstraints gbc_txtStato = new GridBagConstraints();
		gbc_txtStato.anchor = GridBagConstraints.NORTH;
		gbc_txtStato.insets = new Insets(0, 0, 5, 5);
		gbc_txtStato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStato.gridx = 2;
		gbc_txtStato.gridy = 10;
		add(txtStato, gbc_txtStato);
		txtStato.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 11;
		add(lblTelefono, gbc_lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 102, 51));
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 11;
		add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 13;
		add(lblPassword, gbc_lblPassword);

		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 13;
		add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		JLabel lblConfermaPassword = new JLabel("Conferma Password:");
		GridBagConstraints gbc_lblConfermaPassword = new GridBagConstraints();
		gbc_lblConfermaPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfermaPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfermaPassword.gridx = 1;
		gbc_lblConfermaPassword.gridy = 14;
		add(lblConfermaPassword, gbc_lblConfermaPassword);

		txtPasswordConferma = new JTextField();
		GridBagConstraints gbc_txtPasswordConferma = new GridBagConstraints();
		gbc_txtPasswordConferma.insets = new Insets(0, 0, 5, 5);
		gbc_txtPasswordConferma.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPasswordConferma.gridx = 2;
		gbc_txtPasswordConferma.gridy = 14;
		add(txtPasswordConferma, gbc_txtPasswordConferma);
		txtPasswordConferma.setColumns(10);

		txaMessaggioErrore = new JTextPane();
		txaMessaggioErrore.setForeground(Color.RED);
		txaMessaggioErrore.setBackground(new Color(204, 255, 153));
		txaMessaggioErrore.setEditable(false);
		GridBagConstraints gbc_txaMessaggioErrore = new GridBagConstraints();
		gbc_txaMessaggioErrore.anchor = GridBagConstraints.EAST;
		gbc_txaMessaggioErrore.gridwidth = 2;
		gbc_txaMessaggioErrore.insets = new Insets(0, 0, 5, 5);
		gbc_txaMessaggioErrore.fill = GridBagConstraints.VERTICAL;
		gbc_txaMessaggioErrore.gridx = 1;
		gbc_txaMessaggioErrore.gridy = 15;
		add(txaMessaggioErrore, gbc_txaMessaggioErrore);

		JButton btnAnnulla = new JButton("Annulla");
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnnulla.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 16;
		add(btnAnnulla, gbc_btnAnnulla);

		JButton btnRegistrati = new JButton("Conferma Registrazione");
		GridBagConstraints gbc_btnRegistrati = new GridBagConstraints();
		gbc_btnRegistrati.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrati.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrati.gridx = 2;
		gbc_btnRegistrati.gridy = 16;
		add(btnRegistrati, gbc_btnRegistrati);

		inizializza();

		controller = new RegistratiController(this);

		btnAnnulla.addActionListener(controller);
		btnRegistrati.addActionListener(controller);
	}

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

	public String getTxtStato() {
		return txtStato.getText();
	}

	public void setTxtStato(String txtStato) {
		this.txtStato.setText(txtStato);
	}

	/**
	 * @return the panelContenitore
	 */
	public ContenutoPanel getPanelContenitore() {
		return panelContenitore;
	}

	/**
	 * @param panelContenitore
	 *            the panelContenitore to set
	 */
	public void setPanelContenitore(ContenutoPanel panelContenitore) {
		this.panelContenitore = panelContenitore;
	}

	public void dehabilitaRegistrati() {
		panelContenitore.getRegistratiView().setVisible(false);
	}

	public String getTxtNome() {
		return txtNome.getText();
	}

	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);
	}

	public String getTxtCognome() {
		return txtCognome.getText();
	}

	public void setTxtCognome(String txtCognome) {
		this.txtCognome.setText(txtCognome);
	}

	public String getTxtCf() {
		return txtCf.getText();
	}

	public void setTxtCf(String txtCf) {
		this.txtCf.setText(txtCf);
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	public String getTxtVia() {
		return txtVia.getText();
	}

	public void setTxtVia(String string) {
		this.txtVia.setText(string);
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

	public String getTxtCap() {
		return txtCap.getText();
	}

	public void setTxtCap(String txtCap) {
		this.txtCap.setText(txtCap);
	}

	public String getTxtPassword() {
		return txtPassword.getText();
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

	public String getTxtPasswordConferma() {
		return txtPasswordConferma.getText();
	}

	public void setTxtPasswordConferma(String txtPasswordConferma) {
		this.txtPasswordConferma.setText(txtPasswordConferma);
	}

	public String getTxtCitta() {
		return txtCitta.getText();
	}

	public void setTxtCitta(String txtCitta) {
		this.txtCitta.setText(txtCitta);
	}

	public String getTxtProvincia() {
		return txtProvincia.getText();
	}

	public void setTxtProvincia(String txtProvincia) {
		this.txtProvincia.setText(txtProvincia);
	}

	public String getTxaMessaggioErrore() {
		return txaMessaggioErrore.getText();
	}

	public void setTxaMessaggioErrore(String txaMessaggioErrore) {
		this.txaMessaggioErrore.setText(txaMessaggioErrore);
	}

	public void togliMessaggio() {
		setTxaMessaggioErrore("");
		txaMessaggioErrore.setVisible(false);
	}

	public void mostraMessaggio(String msn) {

		setTxaMessaggioErrore(msn);
		txaMessaggioErrore.setVisible(true);

	}

	/**
	 * @return the logPanel
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}

	/**
	 * @param logPanel
	 *            the logPanel to set
	 */
	public void setLogPanel(LogPanel logPanel) {
		this.logPanel = logPanel;
	}

	public void conoscePanel(LogPanel logPanel) {
		this.setLogPanel(logPanel);
	}

	public void ocultaFinestra() {
		logPanel.loginFatto(getTxtNome(), getTxtCognome());

	}

	/**
	 * @uml.property  name="registratiController"
	 * @uml.associationEnd  inverse="registratiView:client.RegistratiController"
	 * @uml.association  name="controlllato"
	 */
	private RegistratiController registratiController;

	/**
	 * Getter of the property <tt>registratiController</tt>
	 * @return  Returns the registratiController.
	 * @uml.property  name="registratiController"
	 */
	public RegistratiController getRegistratiController() {
		return registratiController;
	}

	/**
	 * Setter of the property <tt>registratiController</tt>
	 * @param registratiController  The registratiController to set.
	 * @uml.property  name="registratiController"
	 */
	public void setRegistratiController(
			RegistratiController registratiController) {
				this.registratiController = registratiController;
			}

	/**
	 * @uml.property  name="logPanel1"
	 * @uml.associationEnd  inverse="registratiView:client.LogPanel"
	 * @uml.association  name="si mostra in"
	 */
	private LogPanel logPanel1;

	/**
	 * Getter of the property <tt>logPanel1</tt>
	 * @return  Returns the logPanel1.
	 * @uml.property  name="logPanel1"
	 */
	public LogPanel getLogPanel1() {
		return logPanel1;
	}

	/**
	 * Setter of the property <tt>logPanel1</tt>
	 * @param logPanel1  The logPanel1 to set.
	 * @uml.property  name="logPanel1"
	 */
	public void setLogPanel1(LogPanel logPanel1) {
		this.logPanel1 = logPanel1;
	}

}
