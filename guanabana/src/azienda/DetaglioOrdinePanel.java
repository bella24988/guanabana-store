package azienda;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class DetaglioOrdinePanel extends JPanel {
	private JTextField txtNroordine;
	private JTextField txtData;
	private JTextField txtNomeComputer;

	/**
	 * Create the panel.
	 */
	public DetaglioOrdinePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0,
				1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNumeroOrdine = new JLabel("Numero ordine:");
		GridBagConstraints gbc_lblNumeroOrdine = new GridBagConstraints();
		gbc_lblNumeroOrdine.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroOrdine.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroOrdine.gridx = 0;
		gbc_lblNumeroOrdine.gridy = 1;
		add(lblNumeroOrdine, gbc_lblNumeroOrdine);

		txtNroordine = new JTextField();
		txtNroordine.setEditable(false);
		GridBagConstraints gbc_txtNroordine = new GridBagConstraints();
		gbc_txtNroordine.insets = new Insets(0, 0, 5, 5);
		gbc_txtNroordine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroordine.gridx = 1;
		gbc_txtNroordine.gridy = 1;
		add(txtNroordine, gbc_txtNroordine);
		txtNroordine.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 2;
		gbc_lblData.gridy = 1;
		add(lblData, gbc_lblData);

		txtData = new JTextField();
		txtData.setEditable(false);
		GridBagConstraints gbc_txtData = new GridBagConstraints();
		gbc_txtData.insets = new Insets(0, 0, 5, 5);
		gbc_txtData.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtData.gridx = 3;
		gbc_txtData.gridy = 1;
		add(txtData, gbc_txtData);
		txtData.setColumns(10);

		JLabel lblComputer = new JLabel("Computer richiesto:");
		GridBagConstraints gbc_lblComputer = new GridBagConstraints();
		gbc_lblComputer.anchor = GridBagConstraints.EAST;
		gbc_lblComputer.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputer.gridx = 4;
		gbc_lblComputer.gridy = 1;
		add(lblComputer, gbc_lblComputer);

		txtNomeComputer = new JTextField();
		txtNomeComputer.setEditable(false);
		GridBagConstraints gbc_txtNomeComputer = new GridBagConstraints();
		gbc_txtNomeComputer.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeComputer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeComputer.gridx = 5;
		gbc_txtNomeComputer.gridy = 1;
		add(txtNomeComputer, gbc_txtNomeComputer);
		txtNomeComputer.setColumns(10);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 6;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		add(separator, gbc_separator);

		JLabel lblComponentiRichiesti = new JLabel("Componenti richiesti");
		lblComponentiRichiesti.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblComponentiRichiesti = new GridBagConstraints();
		gbc_lblComponentiRichiesti.insets = new Insets(0, 0, 5, 0);
		gbc_lblComponentiRichiesti.gridwidth = 6;
		gbc_lblComponentiRichiesti.gridx = 0;
		gbc_lblComponentiRichiesti.gridy = 3;
		add(lblComponentiRichiesti, gbc_lblComponentiRichiesti);

		JLabel lblCodice = new JLabel("Codice");
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.gridwidth = 2;
		gbc_lblCodice.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodice.gridx = 0;
		gbc_lblCodice.gridy = 4;
		add(lblCodice, gbc_lblCodice);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.gridwidth = 2;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 2;
		gbc_lblNome.gridy = 4;
		add(lblNome, gbc_lblNome);

		JLabel lblConferma = new JLabel("Conferma");
		GridBagConstraints gbc_lblConferma = new GridBagConstraints();
		gbc_lblConferma.insets = new Insets(0, 0, 5, 0);
		gbc_lblConferma.gridwidth = 2;
		gbc_lblConferma.gridx = 4;
		gbc_lblConferma.gridy = 4;
		add(lblConferma, gbc_lblConferma);

		JCheckBox chckbxTrovato = new JCheckBox("trovato");
		GridBagConstraints gbc_chckbxTrovato = new GridBagConstraints();
		gbc_chckbxTrovato.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxTrovato.gridwidth = 2;
		gbc_chckbxTrovato.gridx = 4;
		gbc_chckbxTrovato.gridy = 5;
		add(chckbxTrovato, gbc_chckbxTrovato);

		JButton btnConfermaAssamblaggioPronto = new JButton(
				"Conferma Assamblaggio/ Pronto per la spedizione");
		GridBagConstraints gbc_btnConfermaAssamblaggioPronto = new GridBagConstraints();
		gbc_btnConfermaAssamblaggioPronto.gridwidth = 6;
		gbc_btnConfermaAssamblaggioPronto.gridx = 0;
		gbc_btnConfermaAssamblaggioPronto.gridy = 7;
		add(btnConfermaAssamblaggioPronto, gbc_btnConfermaAssamblaggioPronto);

	}

}
