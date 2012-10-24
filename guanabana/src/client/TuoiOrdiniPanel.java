package client;

import javax.swing.JPanel;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modello.Ordine;
import java.awt.Color;

public class TuoiOrdiniPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Ordine[] ordini;

	/**
	 * Create the panel.
	 */
	public TuoiOrdiniPanel(Ordine[] ordini) {
		setBackground(Color.WHITE);
		this.setOrdini(ordini);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("I tuoi Ordini");
		GridBagConstraints gbc_lblITuoiOrdini = new GridBagConstraints();
		gbc_lblITuoiOrdini.insets = new Insets(0, 0, 5, 0);
		gbc_lblITuoiOrdini.gridwidth = 2;
		gbc_lblITuoiOrdini.gridx = 1;
		gbc_lblITuoiOrdini.gridy = 0;
		add(lblITuoiOrdini, gbc_lblITuoiOrdini);

		Button btnAnnullaOrdine = new Button("Annulla");
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowVerticalLines(false);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[ordini.length + 1][6],
				new String[] { "Data", "Numero Ordine", "Computer ordinato",
						"Tipo Pagamento", "Stato", "Annulla Ordine" }));
		table.setValueAt("Data", 0, 0);
		table.setValueAt("Numero Ordine", 0, 1);
		table.setValueAt("Computer ordinato", 0, 2);
		table.setValueAt("Tipo pagamento", 0, 3);
		table.setValueAt("Stato", 0, 4);

		for (int numRow = 2; numRow < ordini.length; numRow++) {
			table.setValueAt(ordini[numRow - 2].getData(), numRow, 0);
			table.setValueAt(ordini[numRow - 2].getNumeroOrdine(), numRow, 1);
			table.setValueAt(ordini[numRow - 2].getComputer().getNome(),
					numRow, 2);
			table.setValueAt(ordini[numRow - 2].getPagamento()
					.getTipoPagamento(), numRow, 3);
			table.setValueAt(ordini[numRow - 2].getStato(), numRow, 4);
			table.setValueAt(btnAnnullaOrdine, numRow, 5);
			btnAnnullaOrdine.setActionCommand(String.valueOf(ordini[numRow - 2]
					.getNumeroOrdine()));
		}

		table.setRowSelectionAllowed(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);
	}

	/**
	 * @return the ordini
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * @param ordini
	 *            the ordini to set
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

}
