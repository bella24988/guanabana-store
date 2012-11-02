package azienda;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import modello.Ordine;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class VenditaDaGestirePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordine[] ordini;
	private VenditaDaGestireController venGestireController;
	private JCheckBox[] conferma;
	private JButton[] btnAnnullaOrdine;

	/**
	 * Create the panel.
	 */
	public VenditaDaGestirePanel(Ordine[] ordini,
			VenditaDaGestireController veDaGestireController) {
		this.venGestireController = veDaGestireController;
		this.ordini = ordini;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("Ordini da gestire");
		lblITuoiOrdini.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblITuoiOrdini = new GridBagConstraints();
		gbc_lblITuoiOrdini.insets = new Insets(0, 0, 5, 0);
		gbc_lblITuoiOrdini.gridwidth = 7;
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

		JLabel lblStato = new JLabel("Stato");
		lblStato.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblStato = new GridBagConstraints();
		gbc_lblStato.insets = new Insets(0, 0, 5, 5);
		gbc_lblStato.gridx = 3;
		gbc_lblStato.gridy = 1;
		add(lblStato, gbc_lblStato);

		JLabel lblTipoPagamento = new JLabel("Tipo pagamento");
		lblTipoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTipoPagamento = new GridBagConstraints();
		gbc_lblTipoPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoPagamento.gridx = 4;
		gbc_lblTipoPagamento.gridy = 1;
		add(lblTipoPagamento, gbc_lblTipoPagamento);

		JLabel lblconferma = new JLabel("Conferma Pagamento");
		lblconferma.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCon = new GridBagConstraints();
		gbc_lblCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblCon.gridx = 5;
		gbc_lblCon.gridy = 1;
		add(lblconferma, gbc_lblCon);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 7;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		add(separator_1, gbc_separator_1);

		int numRow = 5;
		int maxOrdini = ordini.length;
		conferma = new JCheckBox[maxOrdini];
		btnAnnullaOrdine = new JButton[maxOrdini];
		for (int indiceArray = 0; indiceArray < maxOrdini; indiceArray++) {

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

			JLabel lblStatox = new JLabel(ordini[indiceArray].getStato());
			GridBagConstraints gbc_lblStatox = new GridBagConstraints();
			gbc_lblStatox.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatox.gridx = 3;
			gbc_lblStatox.gridy = numRow;
			add(lblStatox, gbc_lblStatox);

			JLabel lblTipoPagamentox = new JLabel(ordini[indiceArray]
					.getPagamento().getTipoPagamento());
			GridBagConstraints gbc_lblTipoPagamentox = new GridBagConstraints();
			gbc_lblTipoPagamentox.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoPagamentox.gridx = 4;
			gbc_lblTipoPagamentox.gridy = numRow;
			add(lblTipoPagamentox, gbc_lblTipoPagamentox);

			conferma[indiceArray] = new JCheckBox();
			conferma[indiceArray].setSelected(ordini[indiceArray]
					.getPagamento().isConfermato());
			conferma[indiceArray].setMnemonic(indiceArray);
			GridBagConstraints gbc_conferma = new GridBagConstraints();
			gbc_conferma.insets = new Insets(0, 0, 5, 5);
			gbc_conferma.gridx = 5;
			gbc_conferma.gridy = numRow;
			add(conferma[indiceArray], gbc_conferma);

			btnAnnullaOrdine[indiceArray] = new JButton("invia al magazzino");
			btnAnnullaOrdine[indiceArray].setFont(new Font("Tahoma",
					Font.PLAIN, 8));
			btnAnnullaOrdine[indiceArray].setMnemonic(indiceArray);
			GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
			gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnnulla.gridx = 6;
			gbc_btnAnnulla.gridy = numRow;
			add(btnAnnullaOrdine[indiceArray], gbc_btnAnnulla);

			btnAnnullaOrdine[indiceArray]
					.addActionListener(getVenGestireController());
			if (conferma[indiceArray].isSelected()) {
				mostraButtoneInvio(indiceArray);
			} else {
				nascondiButtoneInvio(indiceArray);
			}

			conferma[indiceArray].addItemListener(venGestireController);

			JSeparator separator = new JSeparator();
			separator.setBackground(Color.GRAY);
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.gridwidth = 7;
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.insets = new Insets(0, 0, 0, 5);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = numRow + 1;
			add(separator, gbc_separator);

			numRow = numRow + 2;
		}

	}

	public void mostraButtoneInvio(int indiceArray) {
		ordini[indiceArray].getPagamento().setConfermato(true);
		btnAnnullaOrdine[indiceArray].setEnabled(true);
	}

	public void nascondiButtoneInvio(int indiceArray) {
		ordini[indiceArray].getPagamento().setConfermato(false);
		btnAnnullaOrdine[indiceArray].setEnabled(false);
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

	/**
	 * @return the venGestireController
	 */
	public VenditaDaGestireController getVenGestireController() {
		return venGestireController;
	}

	/**
	 * @param venGestireController
	 *            the venGestireController to set
	 */
	public void setVenGestireController(
			VenditaDaGestireController venGestireController) {
		this.venGestireController = venGestireController;
	}

}
