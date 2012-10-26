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

public class PanelPrincipalGestione extends JPanel {

	/**
	 * Create the panel.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordine[] ordini;
	private GestioneOrdine gestioneOrdine;

	public PanelPrincipalGestione(Ordine[] ordini, GestioneOrdine gestioneOrdine) {
		this.setGestioneOrdine(gestioneOrdine);
		this.setOrdini(ordini);
		PrincipalGestioneController controller = new PrincipalGestioneController(
				this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[5];
		gridBagLayout.rowHeights = new int[ordini.length * 2];
		gridBagLayout.columnWeights = new double[4];
		gridBagLayout.rowWeights = new double[ordini.length + 2];
		setLayout(gridBagLayout);

		JLabel lblUtente = new JLabel("Utente:");
		GridBagConstraints gbc_lblUtente = new GridBagConstraints();
		gbc_lblUtente.anchor = GridBagConstraints.EAST;
		gbc_lblUtente.gridwidth = 2;
		gbc_lblUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtente.gridx = 0;
		gbc_lblUtente.gridy = 0;
		add(lblUtente, gbc_lblUtente);

		JLabel lblNomeUtente = new JLabel(gestioneOrdine.getImpiegato()
				.getNome() + " " + gestioneOrdine.getImpiegato().getCognome());
		GridBagConstraints gbc_lblNomeUtente = new GridBagConstraints();
		gbc_lblNomeUtente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeUtente.gridwidth = 3;
		gbc_lblNomeUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeUtente.gridx = 2;
		gbc_lblNomeUtente.gridy = 0;
		add(lblNomeUtente, gbc_lblNomeUtente);

		JButton btnLogout = new JButton("Logout");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 6;
		gbc_btnLogout.gridy = 0;
		add(btnLogout, gbc_btnLogout);
		btnLogout.addActionListener(controller);

		JLabel lblITuoiOrdini = new JLabel("I tuoi Ordini");
		lblITuoiOrdini.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblITuoiOrdini = new GridBagConstraints();
		gbc_lblITuoiOrdini.insets = new Insets(0, 0, 5, 5);
		gbc_lblITuoiOrdini.gridwidth = 6;
		gbc_lblITuoiOrdini.gridx = 0;
		gbc_lblITuoiOrdini.gridy = 1;
		add(lblITuoiOrdini, gbc_lblITuoiOrdini);

		JButton btnAggiorna = new JButton("Aggiorna");
		GridBagConstraints gbc_btnAggiorna = new GridBagConstraints();
		gbc_btnAggiorna.insets = new Insets(0, 0, 5, 0);
		gbc_btnAggiorna.gridx = 6;
		gbc_btnAggiorna.gridy = 1;
		add(btnAggiorna, gbc_btnAggiorna);
		btnAggiorna.addActionListener(controller);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 2;
		add(lblData, gbc_lblData);

		JLabel lblNOrdine = new JLabel("N\u00B0 Ordine");
		lblNOrdine.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNOrdine = new GridBagConstraints();
		gbc_lblNOrdine.insets = new Insets(0, 0, 5, 5);
		gbc_lblNOrdine.gridx = 1;
		gbc_lblNOrdine.gridy = 2;
		add(lblNOrdine, gbc_lblNOrdine);

		JLabel lblComputer = new JLabel("Computer");
		lblComputer.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblComputer = new GridBagConstraints();
		gbc_lblComputer.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputer.gridx = 2;
		gbc_lblComputer.gridy = 2;
		add(lblComputer, gbc_lblComputer);

		JLabel lblStato = new JLabel("Stato");
		lblStato.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblStato = new GridBagConstraints();
		gbc_lblStato.insets = new Insets(0, 0, 5, 5);
		gbc_lblStato.gridx = 3;
		gbc_lblStato.gridy = 2;
		add(lblStato, gbc_lblStato);

		JLabel lblTipoPagamento = new JLabel("Tipo pagamento");
		lblTipoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTipoPagamento = new GridBagConstraints();
		gbc_lblTipoPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoPagamento.gridx = 4;
		gbc_lblTipoPagamento.gridy = 2;
		add(lblTipoPagamento, gbc_lblTipoPagamento);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 0, 5);
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
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

			JLabel lblTipoPagamentox = new JLabel(ordini[indiceArray]
					.getPagamento().getTipoPagamento());
			GridBagConstraints gbc_lblTipoPagamentox = new GridBagConstraints();
			gbc_lblTipoPagamentox.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoPagamentox.gridx = 4;
			gbc_lblTipoPagamentox.gridy = numRow;
			add(lblTipoPagamentox, gbc_lblTipoPagamentox);

			JButton btnAnnullaOrdine = new JButton("Spedire");
			btnAnnullaOrdine.setFont(new Font("Tahoma", Font.PLAIN, 8));
			GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
			gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
			gbc_btnAnnulla.gridx = 5;
			gbc_btnAnnulla.gridy = numRow;
			add(btnAnnullaOrdine, gbc_btnAnnulla);
			btnAnnullaOrdine.setActionCommand("Sped" + indiceArray);
			btnAnnullaOrdine.addActionListener(controller);

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
	 * @return the gestioneOrdine
	 */
	public GestioneOrdine getGestioneOrdine() {
		return gestioneOrdine;
	}

	/**
	 * @param gestioneOrdine
	 *            the gestioneOrdine to set
	 */
	public void setGestioneOrdine(GestioneOrdine gestioneOrdine) {
		this.gestioneOrdine = gestioneOrdine;
	}

}
