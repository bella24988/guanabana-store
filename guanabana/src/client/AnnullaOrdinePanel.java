package client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import modello.Ordine;

import java.awt.Color;

/**
 * @author  Veronica
 */
public class AnnullaOrdinePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNroOrdine;
	private JTextField txtData;
	private JTextField txtComputer;
	private JTextField txtStato;
	/**
	 * @uml.property  name="ordine"
	 * @uml.associationEnd  
	 */
	private Ordine ordine;
	/**
	 * @uml.property  name="contenutoPanel"
	 * @uml.associationEnd  
	 */
	private ContenutoPanel contenutoPanel;

	/**
	 * Create the panel.
	 */
	public AnnullaOrdinePanel(Ordine ordine) {
		this.ordine = ordine;
		AnnullaOrdineController annullaController = new AnnullaOrdineController(
				this);
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 106, 269, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNumeroOrdine = new JLabel("Numero Ordine:");
		GridBagConstraints gbc_lblNumeroOrdine = new GridBagConstraints();
		gbc_lblNumeroOrdine.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroOrdine.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroOrdine.gridx = 0;
		gbc_lblNumeroOrdine.gridy = 0;
		add(lblNumeroOrdine, gbc_lblNumeroOrdine);

		txtNroOrdine = new JTextField(String.valueOf(ordine.getNumeroOrdine()));
		txtNroOrdine.setEditable(false);
		GridBagConstraints gbc_txtNroOrdine = new GridBagConstraints();
		gbc_txtNroOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_txtNroOrdine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroOrdine.gridx = 1;
		gbc_txtNroOrdine.gridy = 0;
		add(txtNroOrdine, gbc_txtNroOrdine);
		txtNroOrdine.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 1;
		add(lblData, gbc_lblData);

		txtData = new JTextField(ordine.getData());
		txtData.setEditable(false);
		GridBagConstraints gbc_txtData = new GridBagConstraints();
		gbc_txtData.insets = new Insets(0, 0, 5, 0);
		gbc_txtData.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtData.gridx = 1;
		gbc_txtData.gridy = 1;
		add(txtData, gbc_txtData);
		txtData.setColumns(10);

		JLabel lblComputerComprato = new JLabel("Computer comprato:");
		GridBagConstraints gbc_lblComputerComprato = new GridBagConstraints();
		gbc_lblComputerComprato.insets = new Insets(0, 0, 5, 5);
		gbc_lblComputerComprato.anchor = GridBagConstraints.EAST;
		gbc_lblComputerComprato.gridx = 0;
		gbc_lblComputerComprato.gridy = 2;
		add(lblComputerComprato, gbc_lblComputerComprato);

		txtComputer = new JTextField(ordine.getComputer().getNome());
		txtComputer.setEditable(false);
		GridBagConstraints gbc_txtComputer = new GridBagConstraints();
		gbc_txtComputer.insets = new Insets(0, 0, 5, 0);
		gbc_txtComputer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComputer.gridx = 1;
		gbc_txtComputer.gridy = 2;
		add(txtComputer, gbc_txtComputer);
		txtComputer.setColumns(10);

		JLabel lblStato = new JLabel("Stato:");
		GridBagConstraints gbc_lblStato = new GridBagConstraints();
		gbc_lblStato.insets = new Insets(0, 0, 5, 5);
		gbc_lblStato.anchor = GridBagConstraints.EAST;
		gbc_lblStato.gridx = 0;
		gbc_lblStato.gridy = 3;
		add(lblStato, gbc_lblStato);

		txtStato = new JTextField(ordine.getStato());
		txtStato.setEditable(false);
		GridBagConstraints gbc_txtStato = new GridBagConstraints();
		gbc_txtStato.insets = new Insets(0, 0, 5, 0);
		gbc_txtStato.anchor = GridBagConstraints.NORTH;
		gbc_txtStato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStato.gridx = 1;
		gbc_txtStato.gridy = 3;
		add(txtStato, gbc_txtStato);
		txtStato.setColumns(10);

		JTextPane txtpnSarRimborsatoLimporto = new JTextPane();
		txtpnSarRimborsatoLimporto
				.setText("Sar\u00E0 rimborsato l'importo versato.\r\n\u00E8 sicuro che vuole annullare l'ordine?");
		GridBagConstraints gbc_txtpnSarRimborsatoLimporto = new GridBagConstraints();
		gbc_txtpnSarRimborsatoLimporto.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnSarRimborsatoLimporto.gridwidth = 2;
		gbc_txtpnSarRimborsatoLimporto.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnSarRimborsatoLimporto.gridx = 0;
		gbc_txtpnSarRimborsatoLimporto.gridy = 4;
		add(txtpnSarRimborsatoLimporto, gbc_txtpnSarRimborsatoLimporto);

		JButton btnSi = new JButton("Si");
		GridBagConstraints gbc_btnSi = new GridBagConstraints();
		gbc_btnSi.insets = new Insets(0, 0, 0, 5);
		gbc_btnSi.gridx = 0;
		gbc_btnSi.gridy = 5;
		add(btnSi, gbc_btnSi);
		btnSi.addActionListener(annullaController);

		JButton btnNo = new JButton("No");
		GridBagConstraints gbc_btnNo = new GridBagConstraints();
		gbc_btnNo.gridx = 1;
		gbc_btnNo.gridy = 5;
		add(btnNo, gbc_btnNo);
		btnNo.addActionListener(annullaController);

	}

	/**
	 * @return  the ordine
	 * @uml.property  name="ordine"
	 */
	public Ordine getOrdine() {
		return ordine;
	}

	/**
	 * @param ordine  the ordine to set
	 * @uml.property  name="ordine"
	 */
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	/**
	 * @return  the contenutoPanel
	 * @uml.property  name="contenutoPanel"
	 */
	public ContenutoPanel getContenutoPanel() {
		return contenutoPanel;
	}

	/**
	 * @param contenutoPanel  the contenutoPanel to set
	 * @uml.property  name="contenutoPanel"
	 */
	public void setContenutoPanel(ContenutoPanel contenutoPanel) {
		this.contenutoPanel = contenutoPanel;
	}

}
