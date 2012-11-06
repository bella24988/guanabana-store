package client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import modello.Componente;
import modello.Configurazione;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class ConfermaOrdinePanel extends JPanel {

	/**
	 * @uml.property name="contenutoPanel"
	 * @uml.associationEnd
	 */
	private ContenutoPanel contenutoPanel;
	private static final long serialVersionUID = 1L;
	private JLabel lblMess;
	/**
	 * Create the panel.
	 * 
	 * @uml.property name="nome"
	 */
	private String nome;
	/**
	 * @uml.property name="prezzo"
	 */
	private float prezzo;
	/**
	 * @uml.property name="prezzoTotale"
	 */
	private float prezzoTotale;
	/**
	 * @uml.property name="configurazioneScelta"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 */
	private Componente[] configurazioneScelta;
	private JTable table;
	/**
	 * @uml.property name="controller"
	 * @uml.associationEnd
	 */
	private ConfermaOrdineController controller;

	public ConfermaOrdinePanel(String nome, float prezzo,
			Configurazione configurazione, float prezzoTotale,
			ContenutoPanel contenutoPanel2) {
		this.prezzo = prezzo;
		this.nome = nome;
		this.setConfigurazioneScelta(configurazione.getComponentiScelti());
		this.prezzoTotale = prezzoTotale;
		this.contenutoPanel = contenutoPanel2;
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 241, 230, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 27, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblConfermaOrdine = new JLabel("Conferma Ordine");
		lblConfermaOrdine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfermaOrdine.setForeground(new Color(0, 153, 51));
		GridBagConstraints gbc_lblConfermaOrdine = new GridBagConstraints();
		gbc_lblConfermaOrdine.gridwidth = 2;
		gbc_lblConfermaOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_lblConfermaOrdine.gridx = 0;
		gbc_lblConfermaOrdine.gridy = 0;
		add(lblConfermaOrdine, gbc_lblConfermaOrdine);
		int maxComponentiScelti = configurazione.getMaxComponentiScelti() + 2;
		table = new JTable();
		table.setEnabled(false);
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(
				new Object[maxComponentiScelti + 2][3], new String[] {
						"Codice", "Descrizione", "Prezzo" }));

		table.setValueAt("Codice", 0, 0);
		table.setValueAt("Descrizione", 0, 1);
		table.setValueAt("Prezzo", 0, 2);
		table.setValueAt(nome, 1, 1);
		table.setValueAt(prezzo, 1, 2);

		for (int numRow = 2; numRow < maxComponentiScelti; numRow++) {
			table.setValueAt(configurazione.getComponentiScelti()[numRow - 2]
					.getCodice(), numRow, 0);
			table.setValueAt(
					configurazione.getComponentiScelti()[numRow - 2].getNome(),
					numRow, 1);
			table.setValueAt(configurazione.getComponentiScelti()[numRow - 2]
					.getPrezzo(), numRow, 2);
		}

		table.setBorder(new LineBorder(new Color(0, 153, 51)));
		table.setRowSelectionAllowed(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(table, gbc_table);

		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.anchor = GridBagConstraints.EAST;
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 0;
		gbc_lblTotale.gridy = 2;
		add(lblTotale, gbc_lblTotale);

		JLabel lblPrezzototale = new JLabel(String.valueOf(prezzoTotale));
		lblPrezzototale.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPrezzototale = new GridBagConstraints();
		gbc_lblPrezzototale.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrezzototale.gridx = 1;
		gbc_lblPrezzototale.gridy = 2;
		add(lblPrezzototale, gbc_lblPrezzototale);

		JButton btnContinuaConIl = new JButton("Aggiunge al carrello");
		btnContinuaConIl.setBackground(Color.WHITE);
		//btnContinuaConIl.setIcon(new ImageIcon(ConfermaOrdinePanel.class.getResource("/icons/icon_carrello.jpg")));
		//btnContinuaConIl.setSelectedIcon(new ImageIcon(ConfermaOrdinePanel.class.getResource("/icons/icon_carrello.jpg")));
		GridBagConstraints gbc_btnContinuaConIl = new GridBagConstraints();
		gbc_btnContinuaConIl.fill = GridBagConstraints.BOTH;
		gbc_btnContinuaConIl.gridheight = 2;
		gbc_btnContinuaConIl.insets = new Insets(0, 0, 5, 0);
		gbc_btnContinuaConIl.gridx = 1;
		gbc_btnContinuaConIl.gridy = 3;
		add(btnContinuaConIl, gbc_btnContinuaConIl);
		setVisible(true);

		lblMess = new JLabel();
		lblMess.setForeground(Color.RED);
		lblMess.setBackground(Color.white);
		lblMess.setVisible(false);

		GridBagConstraints gbc_lblErrore = new GridBagConstraints();
		gbc_lblErrore.insets = new Insets(0, 0, 0, 5);
		gbc_lblErrore.gridx = 0;
		gbc_lblErrore.gridy = 5;
		add(lblMess, gbc_lblErrore);

		controller = new ConfermaOrdineController(this);

		btnContinuaConIl.addActionListener(controller);

	}

	public void mostraMessaggioErrore(String messaggio) {
		lblMess.setText(messaggio);
		lblMess.setVisible(true);

	}

	/**
	 * @return the contenutoPanel
	 * @uml.property name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel
	 *            the contenutoPanel to set
	 * @uml.property name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * @return the nome
	 * @uml.property name="nome"
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 * @uml.property name="nome"
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the prezzo
	 * @uml.property name="prezzo"
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo
	 *            the prezzo to set
	 * @uml.property name="prezzo"
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the prezzoTotale
	 * @uml.property name="prezzoTotale"
	 */
	public float getPrezzoTotale() {
		return prezzoTotale;
	}

	/**
	 * @param prezzoTotale
	 *            the prezzoTotale to set
	 * @uml.property name="prezzoTotale"
	 */
	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	/*
	 * public int getProgressBar() { return progressBar.getValue(); }
	 * 
	 * public void setProgressBar(int value) {
	 * this.progressBar.setVisible(true); this.progressBar.setValue(value); }
	 */

	/**
	 * @return the configurazioneScelta
	 */
	public Componente[] getConfigurazioneScelta() {
		return configurazioneScelta;
	}

	/**
	 * @param configurazioneScelta
	 *            the configurazioneScelta to set
	 */
	public void setConfigurazioneScelta(Componente[] configurazioneScelta) {
		this.configurazioneScelta = configurazioneScelta;
	}

}
