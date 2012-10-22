package client;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class PagamentoPanel extends JPanel {

	/**
	 * 
	 */
	ContenutoPanel contenutoPanel;

	private static final long serialVersionUID = 1L;
	private JTextField txtNumordine;
	private JTextField txtTotale;

	/**
	 * Create the panel.
	 * 
	 * @param contenutoPanel
	 */
	public PagamentoPanel(ContenutoPanel contenutoPanel) {

		this.contenutoPanel = contenutoPanel;
		setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 158, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblOrdineN = new JLabel("Ordine N\u00B0");
		GridBagConstraints gbc_lblOrdineN = new GridBagConstraints();
		gbc_lblOrdineN.anchor = GridBagConstraints.EAST;
		gbc_lblOrdineN.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrdineN.gridx = 0;
		gbc_lblOrdineN.gridy = 0;
		add(lblOrdineN, gbc_lblOrdineN);

		txtNumordine = new JTextField(String.valueOf(contenutoPanel.getOrdine()
				.getNumeroOrdine()));
		txtNumordine.setEditable(false);
		GridBagConstraints gbc_txtNumordine = new GridBagConstraints();
		gbc_txtNumordine.gridwidth = 2;
		gbc_txtNumordine.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumordine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumordine.gridx = 1;
		gbc_txtNumordine.gridy = 0;
		add(txtNumordine, gbc_txtNumordine);
		txtNumordine.setColumns(10);

		JLabel lblTotale = new JLabel("Totale:");
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.anchor = GridBagConstraints.EAST;
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 0;
		gbc_lblTotale.gridy = 1;
		add(lblTotale, gbc_lblTotale);

		txtTotale = new JTextField(String.valueOf(contenutoPanel.getOrdine()
				.getPrezzo()));
		txtTotale.setEditable(false);
		GridBagConstraints gbc_txtTotale = new GridBagConstraints();
		gbc_txtTotale.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotale.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotale.gridx = 1;
		gbc_txtTotale.gridy = 1;
		add(txtTotale, gbc_txtTotale);
		txtTotale.setColumns(10);

		JLabel lblScegliIlTipo = new JLabel("Scegli il tipo di pagamento");
		lblScegliIlTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblScegliIlTipo = new GridBagConstraints();
		gbc_lblScegliIlTipo.gridwidth = 3;
		gbc_lblScegliIlTipo.insets = new Insets(0, 0, 5, 0);
		gbc_lblScegliIlTipo.gridx = 0;
		gbc_lblScegliIlTipo.gridy = 2;
		add(lblScegliIlTipo, gbc_lblScegliIlTipo);

		JRadioButton rdbtnCartaDiCredito = new JRadioButton("Carta di credito");
		rdbtnCartaDiCredito.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnCartaDiCredito = new GridBagConstraints();
		gbc_rdbtnCartaDiCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCartaDiCredito.gridx = 0;
		gbc_rdbtnCartaDiCredito.gridy = 3;
		add(rdbtnCartaDiCredito, gbc_rdbtnCartaDiCredito);

		JRadioButton rdbtnBonifico = new JRadioButton("Bonifico");
		rdbtnBonifico.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnBonifico = new GridBagConstraints();
		gbc_rdbtnBonifico.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBonifico.gridx = 1;
		gbc_rdbtnBonifico.gridy = 3;
		add(rdbtnBonifico, gbc_rdbtnBonifico);

		JRadioButton rdbtnContrasegno = new JRadioButton("Contrasegno");
		rdbtnContrasegno.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnContrasegno = new GridBagConstraints();
		gbc_rdbtnContrasegno.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnContrasegno.gridx = 2;
		gbc_rdbtnContrasegno.gridy = 3;
		add(rdbtnContrasegno, gbc_rdbtnContrasegno);

		JPanel tipoPagamento = new JPanel();
		tipoPagamento.setBackground(Color.WHITE);
		GridBagConstraints gbc_tipoPagamento = new GridBagConstraints();
		gbc_tipoPagamento.insets = new Insets(0, 0, 5, 0);
		gbc_tipoPagamento.gridwidth = 3;
		gbc_tipoPagamento.fill = GridBagConstraints.BOTH;
		gbc_tipoPagamento.gridx = 0;
		gbc_tipoPagamento.gridy = 4;
		add(tipoPagamento, gbc_tipoPagamento);

		JButton btnPagaEAccetta = new JButton("Paga e Accetta");
		GridBagConstraints gbc_btnPagaEAccetta = new GridBagConstraints();
		gbc_btnPagaEAccetta.insets = new Insets(0, 0, 0, 5);
		gbc_btnPagaEAccetta.gridx = 1;
		gbc_btnPagaEAccetta.gridy = 5;
		add(btnPagaEAccetta, gbc_btnPagaEAccetta);

		ButtonGroup gruppoPagamento = new ButtonGroup();

		gruppoPagamento.add(rdbtnCartaDiCredito);
		gruppoPagamento.add(rdbtnContrasegno);
		gruppoPagamento.add(rdbtnBonifico);

	}

}
