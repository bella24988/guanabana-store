package azienda;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import modello.Ordine;

/**
 * Classe VenditeEvasePanel: Pannello rivolto al reparto
 * vendite, che si occupa degli ordini evasi.
 * @author Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class VenditeEvasePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Dichiarazione delle variabili
	 */
	private Ordine[] ordini;
	private VenditeEvaseController veEvaseController;
	private JCheckBox[] conferma;
	
	/**
	 * Costruttore del pannello degli ordini evasi.
	 * @param ordini
	 * @param veEvaseController
	 */
	public VenditeEvasePanel(Ordine[] ordini,
			VenditeEvaseController veEvaseController) {
		this.setVeEvaseController(veEvaseController);
		this.setOrdini(ordini);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE, 0.0,
				1.0 };
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("Ordini Evasi");
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
		lblTipoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblconferma = new JLabel("Conferma Pagamento");
		lblconferma.setFont(new Font("Tahoma", Font.BOLD, 11));
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
			if (ordini[indiceArray].getPagamento().getTipoPagamento()
					.compareTo("Contrassegno") == 0
					&& conferma[indiceArray].isSelected() == false) {
				conferma[indiceArray].setEnabled(true);
				conferma[indiceArray].addItemListener(veEvaseController);
			} else {
				conferma[indiceArray].setEnabled(false);
			}
			GridBagConstraints gbc_conferma = new GridBagConstraints();
			gbc_conferma.insets = new Insets(0, 0, 5, 5);
			gbc_conferma.gridx = 5;
			gbc_conferma.gridy = numRow;
			add(conferma[indiceArray], gbc_conferma);

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

	/**
	 * Metodo che permette di disabilitare il checkbox di conferma pagamento
	 * @param index
	 */
	public void disabilitaConferma(int index) {
		conferma[index].setEnabled(false);
	}

	/**
	 * Getter of ordini
	 * @return ordini
	 */
	public Ordine[] getOrdini() {
		return ordini;
	}

	/**
	 * Setter of ordini
	 * @param ordini
	 */
	public void setOrdini(Ordine[] ordini) {
		this.ordini = ordini;
	}

	/**
	 * Getter of veEvaseController
	 * @return veEvaseController
	 */
	public VenditeEvaseController getVeEvaseController() {
		return veEvaseController;
	}

	/**
	 * Setter of veEvaseController
	 * @param veEvaseController
	 */
	public void setVeEvaseController(VenditeEvaseController veEvaseController) {
		this.veEvaseController = veEvaseController;
	}

}
