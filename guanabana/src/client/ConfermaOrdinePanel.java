package client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import modello.Configurazione;

public class ConfermaOrdinePanel extends JPanel {

	/**
	 * 
	 */
	private ContenutoPanel contenutoPanel;
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private String nome;
	private float prezzo;
	private float prezzoTotale;
	private Configurazione configurazioneScelta;
	private JTable table;

	public ConfermaOrdinePanel(String nome, float prezzo,
			Configurazione configurazione) {
		this.prezzo = prezzo;
		this.nome = nome;
		this.configurazioneScelta = configurazione;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 241, 230, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 27, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblConfermaOrdine = new JLabel("Conferma Ordine");
		GridBagConstraints gbc_lblConfermaOrdine = new GridBagConstraints();
		gbc_lblConfermaOrdine.gridwidth = 2;
		gbc_lblConfermaOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_lblConfermaOrdine.gridx = 0;
		gbc_lblConfermaOrdine.gridy = 0;
		add(lblConfermaOrdine, gbc_lblConfermaOrdine);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "Codice", "Nome", "Prezzo" }, { null, nome, prezzo },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"Codice", "Descrizione", "Prezzo" }));
		table.setBorder(new LineBorder(new Color(0, 153, 51)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		add(table, gbc_table);
		setVisible(true);
	}

	/**
	 * @return the contenutoPanel
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel
	 *            the contenutoPanel to set
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the prezzo
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo
	 *            the prezzo to set
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the codice
	 */
	public Configurazione getConfigurazione() {
		return configurazioneScelta;
	}

	/**
	 * @param codice
	 *            the codice to set
	 */
	public void setConfigurazione(Configurazione codice) {
		this.configurazioneScelta = codice;
	}

	/**
	 * @return the prezzoTotale
	 */
	public float getPrezzoTotale() {
		return prezzoTotale;
	}

	/**
	 * @param prezzoTotale the prezzoTotale to set
	 */
	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

}
