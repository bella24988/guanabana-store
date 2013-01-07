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


/** 
 * Classe ConfermaOrdinePanel: Pannello che consente di confermare l'ordine
 * @author Gabriele
 * @author Veronica
 * @version 3.0 Jan 3, 2013.
 */
public class ConfermaOrdinePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/** Pannello contenitore */
	private ContenutoPanel contenutoPanel;
	
	/**
	 * Dati dell'ordine
	 */
	private String nome;
	private float prezzo;
	private float prezzoTotale;
	private Componente[] configurazioneScelta;
	
	/** Controller */
	private ConfermaOrdineController controller;
	
	/**
	 * Grafica
	 */
	private JLabel lblMess;
	private JTable table;
	

	/** Costruttore del pannello di conferma dell'ordine
	 * @param nome
	 * @param prezzo
	 * @param configurazione
	 * @param prezzoTotale
	 * @param content		Pannello contenitore
	 */
	public ConfermaOrdinePanel(String nome, float prezzo,
			Configurazione configurazione, float prezzoTotale,
			ContenutoPanel content) {
		this.prezzo = prezzo;
		this.nome = nome;
		this.setConfigurazioneScelta(configurazione.getComponentiScelti());
		this.prezzoTotale = prezzoTotale;
		this.contenutoPanel = content;
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
		btnContinuaConIl.setIcon(new ImageIcon(ConfermaOrdinePanel.class.getResource("/icons/icon_carrello.jpg")));
		btnContinuaConIl.setSelectedIcon(new ImageIcon(ConfermaOrdinePanel.class.getResource("/icons/icon_carrello.jpg")));
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

	/** Metodo per mostrare un messaggio di errore
	 * @param messaggio		Stringa da mostrare
	 */
	public void mostraMessaggioErrore(String messaggio) {
		lblMess.setText(messaggio);
		lblMess.setVisible(true);

	}

	/** Restituisce il pannello contenitore in uso
	 * @return contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/** Setter del pannello contenitore
	 * @param contenutoPanel		Pannello contenitore da settare
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/** Restituisce il nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/** Setter del nome
	 * @param nome			Nome da settare
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Restituisce il prezzo
	 * @return prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/** Setter del prezzo
	 * @param prezzo		Prezzo da settare
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/** Restituisce il prezzo totale
	 * @return prezzoTotale
	 */
	public float getPrezzoTotale() {
		return prezzoTotale;
	}

	/** Setter del prezzo totale
	 * @param prezzoTotale		Prezzo totale da settare
	 */
	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	/** Restituisce l'array di componenti che costituiscono la configurazione scelta
	 * @return configurazioneScelta
	 */
	public Componente[] getConfigurazioneScelta() {
		return configurazioneScelta;
	}

	/** Setter della configurazione scelta
	 * @param configurazioneScelta		Configurazione da settare
	 */
	public void setConfigurazioneScelta(Componente[] configurazioneScelta) {
		this.configurazioneScelta = configurazioneScelta;
	}

}
