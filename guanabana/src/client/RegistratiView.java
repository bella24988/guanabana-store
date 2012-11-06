package client;

import javax.swing.JFormattedTextField;
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

import modello.Cliente;


public class RegistratiView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @uml.property  name="txtNome"
	 */
	private JFormattedTextField txtNome;
	/**
	 * @uml.property  name="txtCognome"
	 */
	private JFormattedTextField txtCognome;
	/**
	 * @uml.property  name="txtCf"
	 */
	private JFormattedTextField txtCf;
	/**
	 * @uml.property  name="txtEmail"
	 */
	private JFormattedTextField txtEmail;
	/**
	 * @uml.property  name="txtCitta"
	 */
	private JFormattedTextField txtCitta;
	/**
	 * @uml.property  name="txtVia"
	 */
	private JFormattedTextField txtVia;
	/**
	 * @uml.property  name="txtProvincia"
	 */
	private JFormattedTextField txtProvincia;
	/**
	 * @uml.property  name="txtCap"
	 */
	private JFormattedTextField txtCap;
	/**
	 * @uml.property  name="txtStato"
	 */
	private JFormattedTextField txtStato;
	/**
	 * @uml.property  name="txtTelefono"
	 */
	private JFormattedTextField txtTelefono;
	/**
	 * @uml.property  name="txtPassword"
	 */
	private JPasswordField txtPassword;
	/**
	 * @uml.property  name="txtPasswordConferma"
	 */
	private JPasswordField txtPasswordConferma;
	
	private JFormattedTextField[] txtArray ={txtNome, txtCognome, txtCf, txtEmail, txtCitta, txtVia, 
			txtProvincia, txtCap, txtStato, txtTelefono };
	
	
	private static String[] labels = { "Nome:", "Cognome:", "C.F.:", "Email:", "Cittˆ:", "Via:", 
			"Provincia:", "CAP:", "Stato:", "Telefono:", "Password:", "Conferma Password:" };
	
	/**
	 * @uml.property  name="txaMessaggioErrore"
	 */
	JTextPane txaMessaggioErrore;
	
	/**
	 * @uml.property  name="logPanel"
	 * @uml.associationEnd  
	 */
	private LogPanel logPanel;
	/**
	 * @uml.property  name="panelContenitore"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel panelContenitore;
	/**
	 * @uml.property  name="controller"
	 * @uml.associationEnd  
	 */
	private RegistratiController controller;
	

	/**
	 * Create the panel.
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
		
		for(int i = 1; i<13; i++){
				
				JLabel lblReg = new JLabel(labels[i-1]);
				GridBagConstraints lblGrid = new GridBagConstraints();
				lblGrid.anchor = GridBagConstraints.EAST;
				lblGrid.insets = new Insets(0, 0, 5, 5);
				lblGrid.gridx = 1;
				lblGrid.gridy = i;
				add(lblReg, lblGrid);
		}
		
		for(int j = 0; j<10; j++){
			
			txtArray[j] = new JFormattedTextField();
			txtArray[j].setForeground(new Color(0, 102, 51));
			GridBagConstraints txtGrid = new GridBagConstraints();
			txtGrid.insets = new Insets(0, 0, 5, 5);
			txtGrid.fill = GridBagConstraints.HORIZONTAL;
			txtGrid.gridx = 2;
			txtGrid.gridy = j+1;
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
	 * @param panelContenitore
	 * @uml.property  name="panelContenitore"
	 */
	public void setPanelContenitore(ContenutoPanel panelContenitore) {
		this.panelContenitore = panelContenitore;
	}

	public void disabilitaRegistrati() {
		panelContenitore.getRegistratiView().setVisible(false);
	}


	

	/**
	 * @return  the panelContenitore
	 * @uml.property  name="panelContenitore"
	 */
	public ContenutoPanel getPanelContenitore() {
		return panelContenitore;
	}

	/**
	 * @param panelContenitore  the panelContenitore to set
	 * @uml.property  name="txtNome"
	 */
	
	public String getTxtNome() {
		return txtArray[0].getText();
	}

	public void setTxtNome(String txtNome) {
		this.txtArray[0].setText(txtNome);
	}

	/**
	 * @return
	 * @uml.property  name="txtCognome"
	 */
	public String getTxtCognome() {
		return txtArray[1].getText();
	}

	public void setTxtCognome(String txtCognome) {
		this.txtArray[1].setText(txtCognome);
	}

	/**
	 * @return
	 * @uml.property  name="txtCf"
	 */
	public String getTxtCf() {
		return txtArray[2].getText();
	}

	public void setTxtCf(String txtCf) {
		this.txtArray[2].setText(txtCf);
	}

	/**
	 * @return
	 * @uml.property  name="txtEmail"
	 */
	public String getTxtEmail() {
		return txtArray[3].getText();
	}

	public void setTxtEmail(String txtEmail) {
		this.txtArray[3].setText(txtEmail);
	}
	
	/**
	 * @return
	 * @uml.property  name="txtCitta"
	 */
	public String getTxtCitta() {
		return txtArray[4].getText();
	}

	public void setTxtCitta(String txtCitta) {
		this.txtArray[4].setText(txtCitta);
	}

	/**
	 * @return
	 * @uml.property  name="txtVia"
	 */
	public String getTxtVia() {
		return txtArray[5].getText();
	}

	public void setTxtVia(String string) {
		this.txtArray[5].setText(string);
	}
	
	/**
	 * @return
	 * @uml.property  name="txtProvincia"
	 */
	public String getTxtProvincia() {
		return txtArray[6].getText();
	}

	public void setTxtProvincia(String txtProvincia) {
		this.txtArray[6].setText(txtProvincia);
	}
	
	/**
	 * @return
	 * @uml.property  name="txtCap"
	 */
	public String getTxtCap() {
		return txtArray[7].getText();
	}

	public void setTxtCap(String txtCap) {
		this.txtArray[7].setText(txtCap);
	}
	
	/**
	 * @return
	 * @uml.property  name="txtStato"
	 */
	public String getTxtStato() {
		return txtArray[8].getText();
	}

	public void setTxtStato(String txtStato) {
		this.txtArray[8].setText(txtStato);
	}

	/**
	 * @return
	 * @uml.property  name="txtTelefono"
	 */
	public String getTxtTelefono() {
		return txtArray[9].getText();
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtArray[9].setText(txtTelefono);
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
	 * @return
	 * @uml.property  name="txtPasswordConferma"
	 */
	public char[] getTxtPasswordConferma() {
		return txtPasswordConferma.getPassword();
	}

	public void setTxtPasswordConferma(String txtPasswordConferma) {
		this.txtPasswordConferma.setText(txtPasswordConferma);
	}

	

	

	/**
	 * @return
	 * @uml.property  name="txaMessaggioErrore"
	 */
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
	 * @return  the logPanel
	 * @uml.property  name="logPanel"
	 */
	public LogPanel getLogPanel() {
		return logPanel;
	}

	/**
	 * @param logPanel  the logPanel to set
	 * @uml.property  name="logPanel"
	 */
	public void setLogPanel(LogPanel logPanel) {
		this.logPanel = logPanel;
	}

	public void conoscePanel(LogPanel logPanel) {
		this.setLogPanel(logPanel);
	}

	public void ocultaFinestra(Cliente cliente) {
		this.setVisible(false);
		logPanel.loginFatto(cliente);
	}

	/**
	 * @uml.property  name="registratiController"
	 * @uml.associationEnd  
	 */
	private RegistratiController registratiController;

	/**
	 * Getter of the property <tt>registratiController</tt>
	 * 
	 * @return Returns the registratiController.
	 * @uml.property name="registratiController"
	 */
	public RegistratiController getRegistratiController() {
		return registratiController;
	}

	/**
	 * Setter of the property <tt>registratiController</tt>
	 * 
	 * @param registratiController
	 *            The registratiController to set.
	 * @uml.property name="registratiController"
	 */
	public void setRegistratiController(
			RegistratiController registratiController) {
		this.registratiController = registratiController;
	}

	/**
	 * @uml.property  name="logPanel1"
	 * @uml.associationEnd  
	 */
	private LogPanel logPanel1;

	/**
	 * Getter of the property <tt>logPanel1</tt>
	 * 
	 * @return Returns the logPanel1.
	 * @uml.property name="logPanel1"
	 */
	public LogPanel getLogPanel1() {
		return logPanel1;
	}

	/**
	 * Setter of the property <tt>logPanel1</tt>
	 * 
	 * @param logPanel1
	 *            The logPanel1 to set.
	 * @uml.property name="logPanel1"
	 */
	public void setLogPanel1(LogPanel logPanel1) {
		this.logPanel1 = logPanel1;
	}

}
