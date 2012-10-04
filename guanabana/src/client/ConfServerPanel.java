package client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modello.Componente;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ConfServerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4215414321261368512L;
	private JTextField textField;
	private Componente[] componenti;

	/**
	 * Create the panel.
	 */
	/**
	 * @param componenti
	 */
	public ConfServerPanel(Componente[] componenti) {
		this.setComponenti(componenti);
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblServer = new JLabel("Server");
		lblServer.setForeground(new Color(0, 153, 0));
		lblServer.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lblServer = new GridBagConstraints();
		gbc_lblServer.gridwidth = 4;
		gbc_lblServer.insets = new Insets(0, 0, 5, 0);
		gbc_lblServer.gridx = 0;
		gbc_lblServer.gridy = 0;
		add(lblServer, gbc_lblServer);
		JLabel lblPreventivo = new JLabel("Preventivo:");
		lblPreventivo.setForeground(new Color(0, 153, 0));
		lblPreventivo.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lblPreventivo = new GridBagConstraints();
		gbc_lblPreventivo.gridwidth = 2;
		gbc_lblPreventivo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPreventivo.gridx = 2;
		gbc_lblPreventivo.gridy = 1;
		add(lblPreventivo, gbc_lblPreventivo);

		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setFont(new Font("Toledo", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotale = new GridBagConstraints();
		gbc_lblTotale.anchor = GridBagConstraints.EAST;
		gbc_lblTotale.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotale.gridx = 2;
		gbc_lblTotale.gridy = 2;
		add(lblTotale, gbc_lblTotale);

		textField = new JTextField();
		textField.setFont(new Font("Toledo", Font.PLAIN, 11));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		// Mostra i componenti della memoria RAM
		JLabel lblMemoriaRam = new JLabel("Memoria RAM");
		lblMemoriaRam.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblMemoriaRam = new GridBagConstraints();
		gbc_lblMemoriaRam.anchor = GridBagConstraints.EAST;
		gbc_lblMemoriaRam.insets = new Insets(0, 0, 5, 5);
		gbc_lblMemoriaRam.gridx = 0;
		gbc_lblMemoriaRam.gridy = 3;
		add(lblMemoriaRam, gbc_lblMemoriaRam);
		// Radio Button della memoria RAM
		JRadioButton[] rdbtnRam = new JRadioButton[componenti.length];
		int i;
		int ultimo = 3;
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("RAM") == 0) {
				rdbtnRam[i] = new JRadioButton(componenti[i].getNome()
						+ " - Prezzo: " + componenti[i].getPrezzo());
				rdbtnRam[i].setBackground(Color.WHITE);
				rdbtnRam[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnRam = new GridBagConstraints();
				gbc_rdbtnRam.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnRam.gridx = 1;
				gbc_rdbtnRam.gridy = ultimo++;
				add(rdbtnRam[i], gbc_rdbtnRam);
			}
		}

		JLabel lblProcessore = new JLabel("Processore");
		lblProcessore.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblProcessore = new GridBagConstraints();
		gbc_lblProcessore.anchor = GridBagConstraints.EAST;
		gbc_lblProcessore.insets = new Insets(0, 0, 5, 5);
		gbc_lblProcessore.gridx = 0;
		gbc_lblProcessore.gridy = ultimo;
		add(lblProcessore, gbc_lblProcessore);

		JRadioButton[] rdbtnCpu = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("CPU") == 0) {
				rdbtnCpu[i] = new JRadioButton(componenti[i].getNome()
						+ " - Prezzo: " + componenti[i].getPrezzo());
				rdbtnCpu[i].setBackground(Color.WHITE);
				rdbtnCpu[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnCpu = new GridBagConstraints();
				gbc_rdbtnCpu.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnCpu.gridx = 1;
				gbc_rdbtnCpu.gridy = ultimo++;
				add(rdbtnCpu[i], gbc_rdbtnCpu);
			}
		}

		JLabel lblMonitoraggioFacile = new JLabel("Monitoraggio facile");
		lblMonitoraggioFacile.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblMonitoraggioFacile = new GridBagConstraints();
		gbc_lblMonitoraggioFacile.anchor = GridBagConstraints.EAST;
		gbc_lblMonitoraggioFacile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitoraggioFacile.gridx = 0;
		gbc_lblMonitoraggioFacile.gridy = ultimo;
		add(lblMonitoraggioFacile, gbc_lblMonitoraggioFacile);

		JRadioButton[] rdbtnMon = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("MON") == 0) {
				rdbtnMon[i] = new JRadioButton(componenti[i].getNome()
						+ " - Prezzo: " + componenti[i].getPrezzo());
				rdbtnMon[i].setBackground(Color.WHITE);
				rdbtnMon[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnMon = new GridBagConstraints();
				gbc_rdbtnMon.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnMon.gridx = 1;
				gbc_rdbtnMon.gridy = ultimo++;
				add(rdbtnMon[i], gbc_rdbtnMon);
			}
		}

		JLabel lblSchedaPci = new JLabel("Scheda PCI");
		lblSchedaPci.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblSchedaPci = new GridBagConstraints();
		gbc_lblSchedaPci.anchor = GridBagConstraints.EAST;
		gbc_lblSchedaPci.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchedaPci.gridx = 0;
		gbc_lblSchedaPci.gridy = ultimo;
		add(lblSchedaPci, gbc_lblSchedaPci);

		JRadioButton[] rdbtnPci = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("PCI") == 0) {
				rdbtnMon[i] = new JRadioButton(componenti[i].getNome()
						+ " - Prezzo: " + componenti[i].getPrezzo());
				rdbtnMon[i].setBackground(Color.WHITE);
				rdbtnMon[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnPci = new GridBagConstraints();
				gbc_rdbtnPci.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnPci.gridx = 1;
				gbc_rdbtnPci.gridy = ultimo++;
				add(rdbtnPci[i], gbc_rdbtnPci);
			}
			ultimo++;
		}

		JLabel lblCapacitDiscoRigido = new JLabel(
				"Capacit\u00E0 disco rigido 1 (obbligatorio)");
		lblCapacitDiscoRigido.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido.gridx = 0;
		gbc_lblCapacitDiscoRigido.gridy = ultimo;
		add(lblCapacitDiscoRigido, gbc_lblCapacitDiscoRigido);

		JRadioButton[] rdbtnHdd = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			System.out.println(componenti[i].getNome() + " - Prezzo: "
					+ componenti[i].getPrezzo() + componenti[i].getTipo());
			if (componenti[i].getTipo().compareTo("HDD") == 0) {
				rdbtnHdd[i] = new JRadioButton(componenti[i].getNome()
						+ " - Prezzo: " + componenti[i].getPrezzo());
				rdbtnHdd[i].setBackground(Color.WHITE);
				rdbtnHdd[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnHdd = new GridBagConstraints();
				gbc_rdbtnHdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd.gridx = 1;
				gbc_rdbtnHdd.gridy = ultimo++;
				add(rdbtnHdd[i], gbc_rdbtnHdd);
			}
		}

		JLabel lblCapacitDiscoRigido_1 = new JLabel(
				"Capacit\u00E0 disco rigido 2");
		lblCapacitDiscoRigido_1.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_1 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_1.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_1.gridx = 0;
		gbc_lblCapacitDiscoRigido_1.gridy = ultimo++;
		add(lblCapacitDiscoRigido_1, gbc_lblCapacitDiscoRigido_1);

		JLabel lblCapacitDiscoRigido_2 = new JLabel(
				"Capacit\u00E0 disco rigido 3");
		lblCapacitDiscoRigido_2.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_2 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_2.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_2.gridx = 0;
		gbc_lblCapacitDiscoRigido_2.gridy = ultimo++;
		add(lblCapacitDiscoRigido_2, gbc_lblCapacitDiscoRigido_2);

		JLabel lblCapacitDiscoRigido_3 = new JLabel(
				"Capacit\u00E0 disco rigido 4");
		lblCapacitDiscoRigido_3.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_3 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_3.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_3.gridx = 0;
		gbc_lblCapacitDiscoRigido_3.gridy = ultimo++;
		add(lblCapacitDiscoRigido_3, gbc_lblCapacitDiscoRigido_3);

		JLabel lblUnitOtticaCddvd = new JLabel(
				"Unit\u00E0 Ottica CD/DVD Masterizzatore");
		lblUnitOtticaCddvd.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblUnitOtticaCddvd = new GridBagConstraints();
		gbc_lblUnitOtticaCddvd.anchor = GridBagConstraints.EAST;
		gbc_lblUnitOtticaCddvd.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnitOtticaCddvd.gridx = 0;
		gbc_lblUnitOtticaCddvd.gridy = ultimo++;
		add(lblUnitOtticaCddvd, gbc_lblUnitOtticaCddvd);

		JLabel lblEstenzioneGaranzia = new JLabel("Estenzione Garanzia");
		lblEstenzioneGaranzia.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblEstenzioneGaranzia = new GridBagConstraints();
		gbc_lblEstenzioneGaranzia.anchor = GridBagConstraints.EAST;
		gbc_lblEstenzioneGaranzia.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstenzioneGaranzia.gridx = 0;
		gbc_lblEstenzioneGaranzia.gridy = ultimo++;
		add(lblEstenzioneGaranzia, gbc_lblEstenzioneGaranzia);

	}

	/**
	 * @return the componenti
	 */
	public Componente[] getComponenti() {
		return componenti;
	}

	/**
	 * @param componenti
	 *            the componenti to set
	 */
	public void setComponenti(Componente[] componenti) {
		this.componenti = componenti;
	}

}
