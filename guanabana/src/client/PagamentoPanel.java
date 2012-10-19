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

public class PagamentoPanel extends JPanel {

	/**
	 * 
	 */
	ContenutoPanel contenutoPanel;

	private static final long serialVersionUID = 1L;

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
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 158, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblScegliIlTipo = new JLabel("Scegli il tipo di pagamento");
		lblScegliIlTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblScegliIlTipo = new GridBagConstraints();
		gbc_lblScegliIlTipo.gridwidth = 3;
		gbc_lblScegliIlTipo.insets = new Insets(0, 0, 5, 0);
		gbc_lblScegliIlTipo.gridx = 0;
		gbc_lblScegliIlTipo.gridy = 1;
		add(lblScegliIlTipo, gbc_lblScegliIlTipo);

		JRadioButton rdbtnCartaDiCredito = new JRadioButton("Carta di credito");
		rdbtnCartaDiCredito.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnCartaDiCredito = new GridBagConstraints();
		gbc_rdbtnCartaDiCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCartaDiCredito.gridx = 0;
		gbc_rdbtnCartaDiCredito.gridy = 2;
		add(rdbtnCartaDiCredito, gbc_rdbtnCartaDiCredito);

		JRadioButton rdbtnBonifico = new JRadioButton("Bonifico");
		rdbtnBonifico.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnBonifico = new GridBagConstraints();
		gbc_rdbtnBonifico.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBonifico.gridx = 1;
		gbc_rdbtnBonifico.gridy = 2;
		add(rdbtnBonifico, gbc_rdbtnBonifico);

		JRadioButton rdbtnContrasegno = new JRadioButton("Contrasegno");
		rdbtnContrasegno.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnContrasegno = new GridBagConstraints();
		gbc_rdbtnContrasegno.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnContrasegno.gridx = 2;
		gbc_rdbtnContrasegno.gridy = 2;
		add(rdbtnContrasegno, gbc_rdbtnContrasegno);

		JPanel tipoPagamento = new JPanel();
		tipoPagamento.setBackground(Color.WHITE);
		GridBagConstraints gbc_tipoPagamento = new GridBagConstraints();
		gbc_tipoPagamento.insets = new Insets(0, 0, 5, 0);
		gbc_tipoPagamento.gridwidth = 3;
		gbc_tipoPagamento.fill = GridBagConstraints.BOTH;
		gbc_tipoPagamento.gridx = 0;
		gbc_tipoPagamento.gridy = 3;
		add(tipoPagamento, gbc_tipoPagamento);

		JButton btnPagaEAccetta = new JButton("Paga e Accetta");
		GridBagConstraints gbc_btnPagaEAccetta = new GridBagConstraints();
		gbc_btnPagaEAccetta.insets = new Insets(0, 0, 0, 5);
		gbc_btnPagaEAccetta.gridx = 1;
		gbc_btnPagaEAccetta.gridy = 4;
		add(btnPagaEAccetta, gbc_btnPagaEAccetta);

		ButtonGroup gruppoPagamento = new ButtonGroup();

		gruppoPagamento.add(rdbtnCartaDiCredito);
		gruppoPagamento.add(rdbtnContrasegno);
		gruppoPagamento.add(rdbtnBonifico);

	}

}
