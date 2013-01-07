package client;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import modello.Ordine;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;

/**
 * Classe TuoiOrdiniPanel: Pannello che riporta tutti gli ordini effettuati
 * dal cliente che ha effettuato il login fino a quel momento.
 * @author  Veronica
 * @author Gabriele
 * @version 3.0 Jan 3, 2013.
 */
public class TuoiOrdiniPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Dichiarazione delle variabili
	 */
	private Ordine[] ordini;
	private boolean carrello;
	
	private ContenutoPanel contenutoPanel;
	private TuoiOrdiniController tOrdinicontroller;

	/**
	 * Costruttore del pannello "I tuoi ordini"
	 * @param ordini
	 * @param carr
	 */
	public TuoiOrdiniPanel(Ordine[] ordini, boolean carr) {
		this.carrello = carr;
		setBackground(Color.WHITE);
		this.setOrdini(ordini);
		tOrdinicontroller = new TuoiOrdiniController(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[5];
		gridBagLayout.rowHeights = new int[ordini.length * 2];
		gridBagLayout.columnWeights = new double[4];
		gridBagLayout.rowWeights = new double[ordini.length + 2];
		setLayout(gridBagLayout);

		JLabel lblITuoiOrdini = new JLabel("I tuoi Ordini");
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

		JLabel lblStato = new JLabel("Stato");
		lblStato.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblStato = new GridBagConstraints();
		gbc_lblStato.insets = new Insets(0, 0, 5, 5);
		gbc_lblStato.gridx = 3;
		gbc_lblStato.gridy = 1;
		add(lblStato, gbc_lblStato);

		if (carrello == false) {
			JLabel lblTipoPagamento = new JLabel("Tipo pagamento");
			lblTipoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblTipoPagamento = new GridBagConstraints();
			gbc_lblTipoPagamento.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoPagamento.gridx = 4;
			gbc_lblTipoPagamento.gridy = 1;
			add(lblTipoPagamento, gbc_lblTipoPagamento);
		}

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.insets = new Insets(0, 0, 0, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 2;
		add(separator_1, gbc_separator_1);

		int numRow = 3;
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

			JLabel lblStatox = new JLabel(ordini[indiceArray].getStato());
			GridBagConstraints gbc_lblStatox = new GridBagConstraints();
			gbc_lblStatox.insets = new Insets(0, 0, 5, 5);
			gbc_lblStatox.gridx = 3;
			gbc_lblStatox.gridy = numRow;
			add(lblStatox, gbc_lblStatox);

			if (carrello == false) {
				JLabel lblTipoPagamentox = new JLabel(ordini[indiceArray]
						.getPagamento().getTipoPagamento());
				GridBagConstraints gbc_lblTipoPagamentox = new GridBagConstraints();
				gbc_lblTipoPagamentox.insets = new Insets(0, 0, 5, 5);
				gbc_lblTipoPagamentox.gridx = 4;
				gbc_lblTipoPagamentox.gridy = numRow;
				add(lblTipoPagamentox, gbc_lblTipoPagamentox);
			}

			if (ordini[indiceArray].getStato().compareTo("SPEDITO") != 0
					&& carrello == false) {
				JButton btnAnnullaOrdine = new JButton("Annulla");
				btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
				GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
				gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
				gbc_btnAnnulla.gridx = 5;
				gbc_btnAnnulla.gridy = numRow;
				add(btnAnnullaOrdine, gbc_btnAnnulla);
				btnAnnullaOrdine.setActionCommand("Annu" + indiceArray);
				btnAnnullaOrdine.addActionListener(tOrdinicontroller);
			}else if (ordini[indiceArray].getStato().compareTo("SPEDITO") == 0
					&& carrello == false && ordini[indiceArray].getPagamento().isConfermato()==true){
				JButton btnAnnullaOrdine = new JButton("Vedi fattura");
				btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
				GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
				gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
				gbc_btnAnnulla.gridx = 5;
				gbc_btnAnnulla.gridy = numRow;
				add(btnAnnullaOrdine, gbc_btnAnnulla);
				btnAnnullaOrdine.setActionCommand("Fatt" + indiceArray);
				btnAnnullaOrdine.addActionListener(tOrdinicontroller);
			}

			if (carrello == true) {
				JButton btnAnnullaOrdine = new JButton("Paga");
				btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
				GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
				gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
				gbc_btnAnnulla.gridx = 5;
				gbc_btnAnnulla.gridy = numRow;
				add(btnAnnullaOrdine, gbc_btnAnnulla);
				btnAnnullaOrdine.setActionCommand("Paga" + indiceArray);
				btnAnnullaOrdine.addActionListener(tOrdinicontroller);
			}

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
	 * Getter of carrello
	 * @return carrello
	 */
	public boolean isCarrello() {
		return carrello;
	}

	/**
	 * Setter of carrello
	 * @param carrello
	 */
	public void setCarrello(boolean carrello) {
		this.carrello = carrello;
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
	 * Getter of tOrdiniController
	 * @return tOrdinicontroller
	 */
	public TuoiOrdiniController gettOrdinicontroller() {
		return tOrdinicontroller;
	}

	/**
	 * Setter of tOrdiniController
	 * @param tOrdinicontroller
	 */
	public void settOrdinicontroller(TuoiOrdiniController tOrdinicontroller) {
		this.tOrdinicontroller = tOrdinicontroller;
	}

}
