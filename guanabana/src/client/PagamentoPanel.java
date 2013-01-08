package client;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

/**
 * Classe PagamentoPanel: pannello che permette di selezionare le modalita' di pagamento
 * (carta di credito, bonifico o contrassegno) e di procedere effettivamente al pagamento.
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class PagamentoPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Dichiarazione delle variabili
	 */
	private int tipoPagamentoScelto;

	private JTextField txtNumordine;
	private JTextField txtTotale;
	private JTextField txtCarta;
	private JTextField txtIntestatario;
	private JTextField txtCodSicurezza;
	private JTextField txtCodiceBonifico;
	private JTextField txtBanca;
	
	private JTextArea txtErrore;
	
	private JComboBox cmbMesi;
	private JComboBox cmbAnni;
	
	private static String[] anni;
	private static String[] mesi = { "", "Gennaio", "Febbraio", "Marzo",
		"Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre",
		"Ottobre", "Novembre", "Dicembre" };
	
	private JPanel tipoPagamento;
	private JPanel panelCartaCredito;
	private JPanel panelBonifico;
	private JPanel panelContrassegno;
	private ContenutoPanel contenutoPanel;
	private PagamentoController pagamentoController;

	/**
	 * Costruttore del pannello di pagamento
	 * @param contenutoPanel
	 */
	public PagamentoPanel(ContenutoPanel contenutoPanel) {
		pagamentoController = new PagamentoController(this);
		this.setContenutoPanel(contenutoPanel);
		this.setTipoPagamentoScelto(0);

		setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 92, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblOrdineN = new JLabel("Ordine N\u00B0");
		GridBagConstraints gbc_lblOrdineN = new GridBagConstraints();
		gbc_lblOrdineN.anchor = GridBagConstraints.EAST;
		gbc_lblOrdineN.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrdineN.gridx = 0;
		gbc_lblOrdineN.gridy = 0;
		add(lblOrdineN, gbc_lblOrdineN);

		txtNumordine = new JTextField(String.valueOf(contenutoPanel.getOrdine()
				.getNumeroOrdine()));
		txtNumordine.setEditable(false);
		GridBagConstraints gbc_txtNumordine = new GridBagConstraints();
		gbc_txtNumordine.gridwidth = 2;
		gbc_txtNumordine.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumordine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumordine.gridx = 1;
		gbc_txtNumordine.gridy = 0;
		add(txtNumordine, gbc_txtNumordine);
		txtNumordine.setColumns(10);

		JLabel lblTotale = new JLabel("Totale:");
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.anchor = GridBagConstraints.EAST;
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 0;
		gbc_lblTotale.gridy = 1;
		add(lblTotale, gbc_lblTotale);

		txtTotale = new JTextField(String.valueOf(contenutoPanel.getOrdine()
				.getPrezzo()));
		txtTotale.setEditable(false);
		GridBagConstraints gbc_txtTotale = new GridBagConstraints();
		gbc_txtTotale.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotale.gridx = 1;
		gbc_txtTotale.gridy = 1;
		add(txtTotale, gbc_txtTotale);
		txtTotale.setColumns(10);

		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 1;
		add(textArea, gbc_textArea);

		JLabel lblScegliIlTipo = new JLabel("Scegli il tipo di pagamento");
		lblScegliIlTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblScegliIlTipo = new GridBagConstraints();
		gbc_lblScegliIlTipo.gridwidth = 3;
		gbc_lblScegliIlTipo.insets = new Insets(0, 0, 5, 0);
		gbc_lblScegliIlTipo.gridx = 0;
		gbc_lblScegliIlTipo.gridy = 2;
		add(lblScegliIlTipo, gbc_lblScegliIlTipo);

		JRadioButton rdbtnCartaDiCredito = new JRadioButton("Carta di credito");
		rdbtnCartaDiCredito.setActionCommand("carta di credito");
		rdbtnCartaDiCredito.addActionListener(pagamentoController);
		rdbtnCartaDiCredito.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnCartaDiCredito = new GridBagConstraints();
		gbc_rdbtnCartaDiCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCartaDiCredito.gridx = 0;
		gbc_rdbtnCartaDiCredito.gridy = 3;
		add(rdbtnCartaDiCredito, gbc_rdbtnCartaDiCredito);

		JRadioButton rdbtnBonifico = new JRadioButton("Bonifico");
		rdbtnBonifico.setActionCommand("bonifico");
		rdbtnBonifico.addActionListener(pagamentoController);
		rdbtnBonifico.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnBonifico = new GridBagConstraints();
		gbc_rdbtnBonifico.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBonifico.gridx = 1;
		gbc_rdbtnBonifico.gridy = 3;
		add(rdbtnBonifico, gbc_rdbtnBonifico);

		JRadioButton rdbtnContrasegno = new JRadioButton("Contrassegno");
		rdbtnContrasegno.setActionCommand("contrassegno");
		rdbtnContrasegno.addActionListener(pagamentoController);
		rdbtnContrasegno.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnContrasegno = new GridBagConstraints();
		gbc_rdbtnContrasegno.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnContrasegno.gridx = 2;
		gbc_rdbtnContrasegno.gridy = 3;
		add(rdbtnContrasegno, gbc_rdbtnContrasegno);

		tipoPagamento = new JPanel();
		tipoPagamento.setBackground(Color.WHITE);
		GridBagConstraints gbc_tipoPagamento = new GridBagConstraints();
		gbc_tipoPagamento.insets = new Insets(0, 0, 5, 0);
		gbc_tipoPagamento.gridwidth = 3;
		gbc_tipoPagamento.fill = GridBagConstraints.BOTH;
		gbc_tipoPagamento.gridx = 0;
		gbc_tipoPagamento.gridy = 4;
		add(tipoPagamento, gbc_tipoPagamento);
		tipoPagamento.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelCartaCredito = new JPanel();
		tipoPagamentoReset(panelCartaCredito);
		mostraCampiCarta(panelCartaCredito);
		panelBonifico = new JPanel();
		tipoPagamentoReset(panelBonifico);
		mostraCampiBonifico(panelBonifico);
		panelContrassegno = new JPanel();
		tipoPagamentoReset(panelContrassegno);
		mostraCampiContrassegno(panelContrassegno);

		tipoPagamento.setVisible(true);

		JButton btnPagaEAccetta = new JButton("Paga e Accetta");
		btnPagaEAccetta.setIcon(new ImageIcon(PagamentoPanel.class.getResource("/icons/payment_icon.png")));
		btnPagaEAccetta.setActionCommand("accetta");
		btnPagaEAccetta.addActionListener(pagamentoController);

		txtErrore = new JTextArea();
		txtErrore.setEditable(false);
		txtErrore.setForeground(Color.RED);

		GridBagConstraints gbc_txtrDeveSelezionareUn = new GridBagConstraints();
		gbc_txtrDeveSelezionareUn.insets = new Insets(0, 0, 0, 5);
		gbc_txtrDeveSelezionareUn.fill = GridBagConstraints.BOTH;
		gbc_txtrDeveSelezionareUn.gridx = 0;
		gbc_txtrDeveSelezionareUn.gridy = 5;
		add(txtErrore, gbc_txtrDeveSelezionareUn);
		GridBagConstraints gbc_btnPagaEAccetta = new GridBagConstraints();
		gbc_btnPagaEAccetta.gridwidth = 2;
		gbc_btnPagaEAccetta.insets = new Insets(0, 0, 0, 5);
		gbc_btnPagaEAccetta.gridx = 1;
		gbc_btnPagaEAccetta.gridy = 5;
		add(btnPagaEAccetta, gbc_btnPagaEAccetta);

		ButtonGroup gruppoPagamento = new ButtonGroup();

		gruppoPagamento.add(rdbtnCartaDiCredito);
		gruppoPagamento.add(rdbtnContrasegno);
		gruppoPagamento.add(rdbtnBonifico);

		txtErrore.setVisible(false);
	}

	/**
	 * Permette di mostrare i campi del form per il pagamento
	 * con carta di credito, quando l'utente lo seleziona
	 * @param panel
	 */
	public void mostraCampiCarta(JPanel panel) {

		JLabel lblNumeroDeLa = new JLabel("Numero Carta:");
		GridBagConstraints gbc_lblNumeroDeLa = new GridBagConstraints();
		gbc_lblNumeroDeLa.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeLa.gridx = 0;
		gbc_lblNumeroDeLa.gridy = 0;
		panel.add(lblNumeroDeLa, gbc_lblNumeroDeLa);

		txtCarta = new JTextField();
		GridBagConstraints gbc_txtCarta = new GridBagConstraints();
		gbc_txtCarta.gridwidth = 2;
		gbc_txtCarta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCarta.anchor = GridBagConstraints.NORTH;
		gbc_txtCarta.insets = new Insets(0, 0, 5, 0);
		gbc_txtCarta.gridx = 1;
		gbc_txtCarta.gridy = 0;
		panel.add(txtCarta, gbc_txtCarta);
		txtCarta.setColumns(10);

		JLabel lblIntestatario = new JLabel("Intestatario:");
		GridBagConstraints gbc_lblIntestatario = new GridBagConstraints();
		gbc_lblIntestatario.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntestatario.anchor = GridBagConstraints.EAST;
		gbc_lblIntestatario.gridx = 0;
		gbc_lblIntestatario.gridy = 1;
		panel.add(lblIntestatario, gbc_lblIntestatario);

		txtIntestatario = new JTextField();
		GridBagConstraints gbc_txtIntestatario = new GridBagConstraints();
		gbc_txtIntestatario.gridwidth = 2;
		gbc_txtIntestatario.insets = new Insets(0, 0, 5, 0);
		gbc_txtIntestatario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIntestatario.gridx = 1;
		gbc_txtIntestatario.gridy = 1;
		panel.add(txtIntestatario, gbc_txtIntestatario);
		txtIntestatario.setColumns(10);

		JLabel lblDataScadenza = new JLabel("Data Scadenza:");
		GridBagConstraints gbc_lblDataScadenza = new GridBagConstraints();
		gbc_lblDataScadenza.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataScadenza.anchor = GridBagConstraints.EAST;
		gbc_lblDataScadenza.gridx = 0;
		gbc_lblDataScadenza.gridy = 2;
		panel.add(lblDataScadenza, gbc_lblDataScadenza);

		cmbMesi = new JComboBox(mesi);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel.add(cmbMesi, gbc_comboBox);

		cmbAnni = new JComboBox(getAnni());
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panel.add(cmbAnni, gbc_comboBox_1);

		JLabel lblCodiceSicurezza = new JLabel("Codice Sicurezza:");
		GridBagConstraints gbc_lblCodiceSicurezza = new GridBagConstraints();
		gbc_lblCodiceSicurezza.insets = new Insets(0, 0, 0, 5);
		gbc_lblCodiceSicurezza.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceSicurezza.gridx = 0;
		gbc_lblCodiceSicurezza.gridy = 3;
		panel.add(lblCodiceSicurezza, gbc_lblCodiceSicurezza);

		txtCodSicurezza = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panel.add(txtCodSicurezza, gbc_textField);
		txtCodSicurezza.setColumns(10);

	}
	
	/**
	 * Permette di mostrare i campi del form per il pagamento
	 * con bonifico, quando l'utente lo seleziona
	 * @param panel
	 */
	public void mostraCampiBonifico(JPanel panel) {

		JLabel lblCodiceBonifico = new JLabel("Codice bonifico:");
		GridBagConstraints gbc_lblCodiceBonifico = new GridBagConstraints();
		gbc_lblCodiceBonifico.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceBonifico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodiceBonifico.gridx = 0;
		gbc_lblCodiceBonifico.gridy = 0;
		panel.add(lblCodiceBonifico, gbc_lblCodiceBonifico);

		txtCodiceBonifico = new JTextField();
		GridBagConstraints gbc_txtCodiceBonifico = new GridBagConstraints();
		gbc_txtCodiceBonifico.gridwidth = 2;
		gbc_txtCodiceBonifico.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodiceBonifico.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodiceBonifico.gridx = 1;
		gbc_txtCodiceBonifico.gridy = 0;
		panel.add(txtCodiceBonifico, gbc_txtCodiceBonifico);
		txtCodiceBonifico.setColumns(10);

		JLabel lblBanca = new JLabel("Banca:");
		GridBagConstraints gbc_lblBanca = new GridBagConstraints();
		gbc_lblBanca.anchor = GridBagConstraints.EAST;
		gbc_lblBanca.insets = new Insets(0, 0, 5, 5);
		gbc_lblBanca.gridx = 0;
		gbc_lblBanca.gridy = 1;
		panel.add(lblBanca, gbc_lblBanca);

		txtBanca = new JTextField();
		GridBagConstraints gbc_txtBanca = new GridBagConstraints();
		gbc_txtBanca.gridwidth = 2;
		gbc_txtBanca.insets = new Insets(0, 0, 5, 5);
		gbc_txtBanca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBanca.gridx = 1;
		gbc_txtBanca.gridy = 1;
		panel.add(txtBanca, gbc_txtBanca);
		txtBanca.setColumns(10);

	}
	
	/**
	 * Permette di mostrare i campi per il pagamento
	 * con contrassegno, quando l'utente lo seleziona
	 * @param panel
	 */
	public void mostraCampiContrassegno(JPanel panel) {

		JTextArea txtrMancatoPagamento = new JTextArea();
		txtrMancatoPagamento
				.setText("Il mancato pagamento il giorno della consegna \r\ncomporter\u00E0 una sanzione pari alle spese di\r\nspezione pi\u00F9 100 Euro per aggravante.");
		GridBagConstraints gbc_txtrMancatoPagamento = new GridBagConstraints();
		gbc_txtrMancatoPagamento.gridheight = 4;
		gbc_txtrMancatoPagamento.gridwidth = 3;
		gbc_txtrMancatoPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_txtrMancatoPagamento.fill = GridBagConstraints.BOTH;
		gbc_txtrMancatoPagamento.gridx = 0;
		gbc_txtrMancatoPagamento.gridy = 0;
		panel.add(txtrMancatoPagamento, gbc_txtrMancatoPagamento);

	}
	
	/**
	 * Permette di resettare e riportare alla situazione iniziale
	 * il pannello di pagamento
	 * @param panel
	 */
	private void tipoPagamentoReset(JPanel panel) {
		tipoPagamento.add(panel);
		panel.setBackground(Color.white);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		panel.setVisible(false);
	}
	
	/**
	 * Mostra a video un messaggio d'errore
	 * @param s			Stringa da mostrare a video
	 */
	public void mostraMessaggioErrore(String s) {
		txtErrore.setText(s);
		txtErrore.setVisible(true);

	}
	
	/**
	 * Getter of anni
	 * @return anni
	 */
	private String[] getAnni() {
		anni = new String[11];
		int annoAct = 2012;
		anni[0] = "";
		for (int i = 1; i < 10; i++) {
			anni[i] = String.valueOf(annoAct + i);
		}
		return anni;
	}

	
	/**
	 * Getter of pagamentoController
	 * @return pagamentoController
	 */
	public PagamentoController getPagamentoController() {
		return pagamentoController;
	}

	/**
	 * Setter of pagamentoController
	 * @param pagamentoController
	 */
	public void setPagamentoController(PagamentoController pagamentoController) {
		this.pagamentoController = pagamentoController;
	}
	
	/**
	 * Getter of panelCartaCredito
	 * @return panelCartaCredito
	 */
	public JPanel getPanelCartaCredito() {
		return panelCartaCredito;
	}

	/**
	 * Setter of panelCartaCredito
	 * @param panelCartaCredito
	 */
	public void setPanelCartaCredito(JPanel panelCartaCredito) {
		this.panelCartaCredito = panelCartaCredito;
	}

	/**
	 * Getter of panelBonifico
	 * @return panelBonifico
	 */
	public JPanel getPanelBonifico() {
		return panelBonifico;
	}

	/**
	 * Setter of panelBonifico
	 * @param panelBonifico
	 */
	public void setPanelBonifico(JPanel panelBonifico) {
		this.panelBonifico = panelBonifico;
	}

	/**
	 * Getter of panelContrassegno
	 * @return panelContrassegno
	 */
	public JPanel getPanelContrassegno() {
		return panelContrassegno;
	}

	/**
	 * Setter of panelContrassegno
	 * @param panelContr
	 */
	public void setPanelContrassegno(JPanel panelContr) {
		this.panelContrassegno = panelContr;
	}

	/**
	 * Getter of contenutoPanel
	 * @return contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * Setter of contenutoPanel
	 * @param contenutoPanel
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * Getter del mese selezionato
	 * @return mese selezionato dall'utente
	 */
	public int getMeseSelezionato() {
		return cmbMesi.getSelectedIndex();
	}

	/**
	 * Getter dell'anno selezionato
	 * @return anno selezionato dall'utente
	 */
	public int getAnnoSelezionato() {
		return cmbAnni.getSelectedIndex();
	}

	/**
	 * Getter of txtCarta
	 * @return txtCarta
	 */
	public String getTxtCarta() {
		return txtCarta.getText();
	}

	/**
	 * Setter of txtCarta
	 * @param txtCarta
	 */
	public void setTxtCarta(String txtCarta) {
		this.txtCarta.setText(txtCarta);
	}

	/**
	 * Getter of txtIntestatario
	 * @return txtIntestatario
	 */
	public String getTxtIntestatario() {
		return txtIntestatario.getText();
	}

	/**
	 * Setter of txtIntestatario
	 * @param txtIntestatario
	 */
	public void setTxtIntestatario(String txtIntestatario) {
		this.txtIntestatario.setText(txtIntestatario);
	}

	/**
	 * Getter of txtCodSicurezza
	 * @return txtCodSicurezza
	 */
	public String getTxtCodSicurezza() {
		return txtCodSicurezza.getText();
	}

	/**
	 * Setter of txtCodSicurezza
	 * @param txtCodSicurezza
	 */
	public void setTxtCodSicurezza(String txtCodSicurezza) {
		this.txtCodSicurezza.setText(txtCodSicurezza);
	}

	/**
	 * Getter of txtCodiceBonifico
	 * @return txtCodiceBonifico
	 */
	public String getTxtCodiceBonifico() {
		return txtCodiceBonifico.getText();
	}

	/**
	 * Setter of txtCodiceBonifico
	 * @param txtCodiceBonifico
	 */
	public void setTxtCodiceBonifico(String txtCodiceBonifico) {
		this.txtCodiceBonifico.setText(txtCodiceBonifico);
	}

	/**
	 * Getter of txtBanca
	 * @return txtBanca
	 */
	public String getTxtBanca() {
		return txtBanca.getText();
	}

	/**
	 * Setter of txtBanca
	 * @param txtBanca
	 */
	public void setTxtBanca(String txtBanca) {
		this.txtBanca.setText(txtBanca);
	}

	/**
	 * Getter of tipoPagamentoScelto
	 * @return tipoPagamentoScelto
	 */
	public int getTipoPagamentoScelto() {
		return tipoPagamentoScelto;
	}

	/**
	 * Setter of tipoPagamentoScelto
	 * @param tipoPagamentoScelto
	 */
	public void setTipoPagamentoScelto(int tipoPagamentoScelto) {
		this.tipoPagamentoScelto = tipoPagamentoScelto;
	}

}
