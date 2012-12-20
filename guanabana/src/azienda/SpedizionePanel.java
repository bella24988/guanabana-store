package azienda;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import modello.Ordine;
import java.awt.Insets;

public class SpedizionePanel extends JPanel{
	/**
	 * Create the panel.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property name="ordini"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 */
	private Ordine[] ordini;

	private SpedizioneController spedizioneController;

	public SpedizionePanel(Ordine[] ordini, SpedizioneController spedizioneController) {
		this.setOrdini(ordini);
		this.setSpedizioneController(spedizioneController);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[5];
		gridBagLayout.rowHeights = new int[ordini.length * 2];
		gridBagLayout.columnWeights = new double[4];
		gridBagLayout.rowWeights = new double[ordini.length + 2];
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("Ordini da assamblare");
		lblITuoiOrdini.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblITuoiOrdini = new GridBagConstraints();
		gbc_lblITuoiOrdini.insets = new Insets(0, 0, 5, 0);
		gbc_lblITuoiOrdini.gridwidth = 6;
		gbc_lblITuoiOrdini.gridx = 0;
		gbc_lblITuoiOrdini.gridy = 0;
		add(lblITuoiOrdini, gbc_lblITuoiOrdini);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 1;
		add(lblData, gbc_lblData);

		JLabel lblNOrdine = new JLabel("N\u00B0 Ordine");
		lblNOrdine.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNOrdine = new GridBagConstraints();
		gbc_lblNOrdine.insets = new Insets(0, 0, 5, 5);
		gbc_lblNOrdine.gridx = 1;
		gbc_lblNOrdine.gridy = 1;
		add(lblNOrdine, gbc_lblNOrdine);

		JLabel lblComputer = new JLabel("Computer");
		lblComputer.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblComputer = new GridBagConstraints();
		gbc_lblComputer.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputer.gridx = 2;
		gbc_lblComputer.gridy = 1;
		add(lblComputer, gbc_lblComputer);

		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		add(separator_1, gbc_separator_1);

		int numRow = 5;
		for (int indiceArray = 0; indiceArray < ordini.length; indiceArray++) {

			JLabel lblDatax = new JLabel(ordini[indiceArray].getData());
			GridBagConstraints gbc_lblDatax = new GridBagConstraints();
			gbc_lblDatax.insets = new Insets(0, 0, 5, 5);
			gbc_lblDatax.gridx = 0;
			gbc_lblDatax.gridy = numRow;
			add(lblDatax, gbc_lblDatax);

			JLabel lblNOrdinex = new JLabel(String.valueOf(ordini[indiceArray]
					.getNumeroOrdine()));
			GridBagConstraints gbc_lblNOrdinex = new GridBagConstraints();
			gbc_lblNOrdinex.insets = new Insets(0, 0, 5, 5);
			gbc_lblNOrdinex.gridx = 1;
			gbc_lblNOrdinex.gridy = numRow;
			add(lblNOrdinex, gbc_lblNOrdinex);

			JLabel lblComputerx = new JLabel(ordini[indiceArray].getComputer()
					.getNome());
			GridBagConstraints gbc_lblComputerx = new GridBagConstraints();
			gbc_lblComputerx.insets = new Insets(0, 0, 5, 5);
			gbc_lblComputerx.gridx = 2;
			gbc_lblComputerx.gridy = numRow;
			add(lblComputerx, gbc_lblComputerx);

			JButton btnAssembla = new JButton("Stampa Fattura");
			btnAssembla.setFont(new Font("Tahoma", Font.PLAIN, 8));
			GridBagConstraints gbc_btnAssembla = new GridBagConstraints();
			gbc_btnAssembla.insets = new Insets(0, 0, 5, 5);
			gbc_btnAssembla.gridx = 3;
			gbc_btnAssembla.gridy = numRow;
			add(btnAssembla, gbc_btnAssembla);
			btnAssembla.setActionCommand("Fatt" + indiceArray);
			btnAssembla.addActionListener(spedizioneController);
			

			JButton btnAnnullaOrdine = new JButton("Spedice");
			btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
			GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
			gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnnulla.gridx = 5;
			gbc_btnAnnulla.gridy = numRow;
			add(btnAnnullaOrdine, gbc_btnAnnulla);
			btnAnnullaOrdine.setActionCommand("Sped" + indiceArray);
			btnAnnullaOrdine.addActionListener(spedizioneController);

			JSeparator separator = new JSeparator();
			separator.setBackground(Color.GRAY);
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.gridwidth = 6;
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.insets = new Insets(0, 0, 0, 5);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = numRow + 1;
			add(separator, gbc_separator);

			numRow = numRow + 2;
		}
		
		}

	public Ordine[] getOrdini() {
		return ordini;
	}

	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

	public SpedizioneController getSpedizioneController() {
		return spedizioneController;
	}

	public void setSpedizioneController(SpedizioneController spedizioneController) {
		this.spedizioneController = spedizioneController;
	}
	
}
