package client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import modello.Configurazione;

public class PreventivoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField totalePreventivo;
	private PreventivoController preventivoController;

	/**
	 * Create the panel.
	 */
	public PreventivoPanel(PreventivoController preventivoController) {
		setBorder(new LineBorder(new Color(0, 153, 0), 2, true));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 63, 102, 28, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblPreventivo = new JLabel("Preventivo:");
		lblPreventivo.setForeground(new Color(0, 153, 0));
		lblPreventivo.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lblPreventivo = new GridBagConstraints();
		gbc_lblPreventivo.anchor = GridBagConstraints.WEST;
		gbc_lblPreventivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreventivo.gridx = 1;
		gbc_lblPreventivo.gridy = 1;
		GridBagConstraints gbc_lblPreventivo1 = new GridBagConstraints();
		gbc_lblPreventivo1.gridwidth = 3;
		gbc_lblPreventivo1.gridx = 0;
		gbc_lblPreventivo1.gridy = 0;
		gbc_lblPreventivo1.insets = new Insets(0, 0, 5, 0);
		add(lblPreventivo, gbc_lblPreventivo1);
		GridBagConstraints gbc_lblTotale_1_1 = new GridBagConstraints();
		gbc_lblTotale_1_1.anchor = GridBagConstraints.WEST;

		gbc_lblTotale_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale_1_1.gridx = 0;
		gbc_lblTotale_1_1.gridy = 1;

		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setFont(new Font("Toledo", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotale_1_11 = new GridBagConstraints();
		gbc_lblTotale_1_11.gridx = 0;
		gbc_lblTotale_1_11.gridy = 1;
		gbc_lblTotale_1_11.insets = new Insets(0, 0, 5, 5);
		add(lblTotale, gbc_lblTotale_1_11);
		GridBagConstraints gbc_textField_1_2 = new GridBagConstraints();
		gbc_textField_1_2.fill = GridBagConstraints.BOTH;
		gbc_textField_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1_2.gridx = 1;
		gbc_textField_1_2.gridy = 1;
		GridBagConstraints gbc_textField_1_1 = new GridBagConstraints();
		gbc_textField_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1_1.gridx = 1;
		gbc_textField_1_1.gridy = 1;

		totalePreventivo = new JTextField();
		totalePreventivo.setHorizontalAlignment(SwingConstants.RIGHT);
		totalePreventivo.setText("0,0");
		totalePreventivo.setForeground(Color.WHITE);
		totalePreventivo.setBackground(Color.BLACK);
		totalePreventivo.setEditable(false);
		totalePreventivo.setFont(new Font("Toledo", Font.BOLD, 11));
		add(totalePreventivo, gbc_textField_1_1);
		totalePreventivo.setColumns(10);

		JLabel lblEur = new JLabel("EUR");
		lblEur.setFont(new Font("Toledo", Font.BOLD, 12));
		GridBagConstraints gbc_lblEur = new GridBagConstraints();
		gbc_lblEur.insets = new Insets(0, 0, 5, 0);
		gbc_lblEur.gridx = 2;
		gbc_lblEur.gridy = 1;
		add(lblEur, gbc_lblEur);

		JButton btnContinuaConilPagamento = new JButton("Conferma Ordine");
		btnContinuaConilPagamento.setForeground(new Color(0, 153, 0));
		btnContinuaConilPagamento.setFont(new Font("Toledo", Font.BOLD, 12));
		GridBagConstraints gbc_btnContinuaConilPagamento = new GridBagConstraints();
		gbc_btnContinuaConilPagamento.fill = GridBagConstraints.VERTICAL;
		gbc_btnContinuaConilPagamento.gridwidth = 3;
		gbc_btnContinuaConilPagamento.gridx = 0;
		gbc_btnContinuaConilPagamento.gridy = 2;
		add(btnContinuaConilPagamento, gbc_btnContinuaConilPagamento);

		// Listener di Conferma Ordine
		btnContinuaConilPagamento.addActionListener(preventivoController);

	}

	public String getTotalePreventivo() {
		return totalePreventivo.getText();
	}

	public void setTotalePreventivo(String totalePreventivo) {
		this.totalePreventivo.setText(totalePreventivo);
	}

	/**
	 * @return the preventivoController
	 */
	public PreventivoController getPreventivoController() {
		return preventivoController;
	}

	/**
	 * @param preventivoController
	 *            the preventivoController to set
	 */
	public void setPreventivoController(
			PreventivoController preventivoController) {
		this.preventivoController = preventivoController;
	}

}
