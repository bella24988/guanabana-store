package client;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modello.Ordine;
import java.awt.Color;
import javax.swing.JButton;

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
		gridBagLayout.columnWidths = new int[4];
		gridBagLayout.rowHeights = new int[ordini.length + 10];
		gridBagLayout.columnWeights = new double[4];
		gridBagLayout.rowWeights = new double[ordini.length + 10];
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("I tuoi Ordini");
		GridBagConstraints gbc_lblITuoiOrdini = new GridBagConstraints();
		gbc_lblITuoiOrdini.insets = new Insets(0, 0, 5, 0);
		gbc_lblITuoiOrdini.gridwidth = 3;
		gbc_lblITuoiOrdini.gridx = 0;
		gbc_lblITuoiOrdini.gridy = 0;
		add(lblITuoiOrdini, gbc_lblITuoiOrdini);

		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(new Object[ordini.length + 1][5],
				new String[] { "Data", "Numero Ordine", "Computer ordinato",
						"Tipo Pagamento", "Stato" }));
		table.setValueAt("Data", 0, 0);
		table.setValueAt("Numero Ordine", 0, 1);
		table.setValueAt("Computer ordinato", 0, 2);
		table.setValueAt("Tipo pagamento", 0, 3);
		table.setValueAt("Stato", 0, 4);

		for (int numRow = 1; numRow < ordini.length + 1; numRow++) {
			table.setValueAt(ordini[numRow - 1].getData(), numRow, 0);
			table.setValueAt(ordini[numRow - 1].getNumeroOrdine(), numRow, 1);
			table.setValueAt(ordini[numRow - 1].getComputer().getNome(),
					numRow, 2);
			table.setValueAt(ordini[numRow - 1].getPagamento()
					.getTipoPagamento(), numRow, 3);
			table.setValueAt(ordini[numRow - 1].getStato(), numRow, 4);

			JButton btnAnnullaOrdine = new JButton("Annulla");
			btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
			GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
			gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnnulla.gridx = 2;
			gbc_btnAnnulla.gridy = numRow + 1;
			add(btnAnnullaOrdine, gbc_btnAnnulla);
			btnAnnullaOrdine.setActionCommand(String.valueOf(ordini[numRow - 1]
					.getNumeroOrdine()));
			gridBagLayout.rowHeights[numRow] = 17;
			table.setRowHeight(23);
		}

		table.setRowSelectionAllowed(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = ordini.length + 1;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
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
