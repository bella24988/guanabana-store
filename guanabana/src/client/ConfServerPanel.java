package client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import modello.Componente;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ConfServerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4215414321261368512L;
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
		gridBagLayout.columnWidths = new int[] { 147, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 25, 25, 25, 25, 25, 25,
				25, 0, 25 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblServer = new JLabel("Server");
		lblServer.setForeground(new Color(0, 153, 0));
		lblServer.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lblServer = new GridBagConstraints();
		gbc_lblServer.gridwidth = 2;
		gbc_lblServer.insets = new Insets(0, 0, 5, 0);
		gbc_lblServer.gridx = 0;
		gbc_lblServer.gridy = 0;
		add(lblServer, gbc_lblServer);

		JLabel lblMemoriaRam = new JLabel("Memoria RAM");
		lblMemoriaRam.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblMemoriaRam = new GridBagConstraints();
		gbc_lblMemoriaRam.anchor = GridBagConstraints.EAST;
		gbc_lblMemoriaRam.insets = new Insets(0, 0, 5, 5);
		gbc_lblMemoriaRam.gridx = 0;
		gbc_lblMemoriaRam.gridy = 2;
		add(lblMemoriaRam, gbc_lblMemoriaRam);
		// Radio Button della memoria RAM
		int i;
		int ultimo = 2;
		ButtonGroup groupRam = new ButtonGroup();
		JRadioButton[] rdbtnRam = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("RAM") == 0) {
				rdbtnRam[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnRam[i].setBackground(Color.WHITE);
				rdbtnRam[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnRam = new GridBagConstraints();
				gbc_rdbtnRam.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnRam.gridx = 1;
				gbc_rdbtnRam.gridy = ultimo++;
				add(rdbtnRam[i], gbc_rdbtnRam);
				groupRam.add(rdbtnRam[i]);
			}
		}

		ultimo++;
		JLabel lblProcessore = new JLabel("Processore");
		lblProcessore.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblProcessore = new GridBagConstraints();
		gbc_lblProcessore.anchor = GridBagConstraints.EAST;
		gbc_lblProcessore.insets = new Insets(0, 0, 5, 5);
		gbc_lblProcessore.gridx = 0;
		gbc_lblProcessore.gridy = ultimo;
		add(lblProcessore, gbc_lblProcessore);

		ButtonGroup groupCpuBtn = new ButtonGroup();
		JRadioButton[] rdbtnCpu = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("CPU") == 0) {
				rdbtnCpu[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnCpu[i].setBackground(Color.WHITE);
				rdbtnCpu[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				rdbtnCpu[i].setAlignmentX(LEFT_ALIGNMENT);
				GridBagConstraints gbc_rdbtnCpu = new GridBagConstraints();
				gbc_rdbtnCpu.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnCpu.gridx = 1;
				gbc_rdbtnCpu.gridy = ultimo++;
				add(rdbtnCpu[i], gbc_rdbtnCpu);
				groupCpuBtn.add(rdbtnCpu[i]);
			}
		}

		ultimo++;
		JLabel lblMonitoraggioFacile = new JLabel("Monitoraggio facile");
		lblMonitoraggioFacile.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblMonitoraggioFacile = new GridBagConstraints();
		gbc_lblMonitoraggioFacile.anchor = GridBagConstraints.EAST;
		gbc_lblMonitoraggioFacile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitoraggioFacile.gridx = 0;
		gbc_lblMonitoraggioFacile.gridy = ultimo;
		add(lblMonitoraggioFacile, gbc_lblMonitoraggioFacile);

		ButtonGroup groupMon = new ButtonGroup();
		JRadioButton[] rdbtnMon = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("MLC") == 0) {
				rdbtnMon[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnMon[i].setBackground(Color.WHITE);
				rdbtnMon[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnMon = new GridBagConstraints();
				gbc_rdbtnMon.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnMon.gridx = 1;
				gbc_rdbtnMon.gridy = ultimo++;
				add(rdbtnMon[i], gbc_rdbtnMon);
				groupMon.add(rdbtnMon[i]);
			}
		}

		ultimo++;
		JLabel lblSchedaPci = new JLabel("Scheda PCI");
		lblSchedaPci.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblSchedaPci = new GridBagConstraints();
		gbc_lblSchedaPci.anchor = GridBagConstraints.EAST;
		gbc_lblSchedaPci.insets = new Insets(0, 0, 5, 5);
		gbc_lblSchedaPci.gridx = 0;
		gbc_lblSchedaPci.gridy = ultimo;
		add(lblSchedaPci, gbc_lblSchedaPci);

		ButtonGroup groupPci = new ButtonGroup();
		JRadioButton[] rdbtnPci = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("PCI") == 0) {
				rdbtnMon[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnMon[i].setBackground(Color.WHITE);
				rdbtnMon[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnPci = new GridBagConstraints();
				gbc_rdbtnPci.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnPci.gridx = 1;
				gbc_rdbtnPci.gridy = ultimo++;
				add(rdbtnPci[i], gbc_rdbtnPci);
				groupPci.add(rdbtnPci[i]);
			}
		}
		ultimo++;

		JLabel lblCapacitDiscoRigido = new JLabel(
				"Capacit\u00E0 disco rigido 1 \n(obbligatorio)");
		lblCapacitDiscoRigido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCapacitDiscoRigido.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido.anchor = GridBagConstraints.WEST;
		gbc_lblCapacitDiscoRigido.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido.gridx = 0;
		gbc_lblCapacitDiscoRigido.gridy = ultimo;
		add(lblCapacitDiscoRigido, gbc_lblCapacitDiscoRigido);

		ButtonGroup groupHdd = new ButtonGroup();
		JRadioButton[] rdbtnHdd = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			System.out.println(componenti[i].getNome() + " - Prezzo: "
					+ componenti[i].getPrezzo() + componenti[i].getTipo());
			if (componenti[i].getTipo().compareTo("HDD") == 0) {
				rdbtnHdd[i] = new JRadioButton(componenti[i].getNome()
						+ "\n  Prezzo: " + componenti[i].getPrezzo());
				rdbtnHdd[i].setBackground(Color.WHITE);
				rdbtnHdd[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnHdd = new GridBagConstraints();
				gbc_rdbtnHdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd.gridx = 1;
				gbc_rdbtnHdd.gridy = ultimo++;
				add(rdbtnHdd[i], gbc_rdbtnHdd);
				groupHdd.add(rdbtnHdd[i]);
			}
		}

		ultimo++;
		JLabel lblCapacitDiscoRigido_1 = new JLabel(
				"Capacit\u00E0 disco rigido 2");
		lblCapacitDiscoRigido_1.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_1 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_1.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_1.gridx = 0;
		gbc_lblCapacitDiscoRigido_1.gridy = ultimo;
		add(lblCapacitDiscoRigido_1, gbc_lblCapacitDiscoRigido_1);

		ButtonGroup groupHdd1 = new ButtonGroup();
		JRadioButton[] rdbtnHdd1 = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("HDD") == 0) {
				rdbtnHdd1[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnHdd1[i].setBackground(Color.WHITE);
				rdbtnHdd1[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnHdd1 = new GridBagConstraints();
				gbc_rdbtnHdd1.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd1.gridx = 1;
				gbc_rdbtnHdd1.gridy = ultimo++;
				add(rdbtnHdd1[i], gbc_rdbtnHdd1);
				groupHdd1.add(rdbtnHdd1[i]);
			}
		}

		ultimo++;
		JLabel lblCapacitDiscoRigido_2 = new JLabel(
				"Capacit\u00E0 disco rigido 3");
		lblCapacitDiscoRigido_2.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_2 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_2.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_2.gridx = 0;
		gbc_lblCapacitDiscoRigido_2.gridy = ultimo;
		add(lblCapacitDiscoRigido_2, gbc_lblCapacitDiscoRigido_2);

		ButtonGroup groupHdd2 = new ButtonGroup();
		JRadioButton[] rdbtnHdd2 = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("HDD") == 0) {
				rdbtnHdd2[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnHdd2[i].setBackground(Color.WHITE);
				rdbtnHdd2[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnHdd2 = new GridBagConstraints();
				gbc_rdbtnHdd2.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd2.gridx = 1;
				gbc_rdbtnHdd2.gridy = ultimo++;
				add(rdbtnHdd2[i], gbc_rdbtnHdd2);
				groupHdd2.add(rdbtnHdd2[i]);
			}
		}

		ultimo++;
		JLabel lblCapacitDiscoRigido_3 = new JLabel(
				"Capacit\u00E0 disco rigido 4");
		lblCapacitDiscoRigido_3.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblCapacitDiscoRigido_3 = new GridBagConstraints();
		gbc_lblCapacitDiscoRigido_3.anchor = GridBagConstraints.EAST;
		gbc_lblCapacitDiscoRigido_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacitDiscoRigido_3.gridx = 0;
		gbc_lblCapacitDiscoRigido_3.gridy = ultimo;
		add(lblCapacitDiscoRigido_3, gbc_lblCapacitDiscoRigido_3);

		ButtonGroup groupHdd3 = new ButtonGroup();
		JRadioButton[] rdbtnHdd3 = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("HDD") == 0) {
				rdbtnHdd3[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnHdd3[i].setBackground(Color.WHITE);
				rdbtnHdd3[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnHdd3 = new GridBagConstraints();
				gbc_rdbtnHdd3.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd3.gridx = 1;
				gbc_rdbtnHdd3.gridy = ultimo++;
				add(rdbtnHdd3[i], gbc_rdbtnHdd3);
				groupHdd3.add(rdbtnHdd3[i]);
			}
		}

		ultimo++;
		JLabel lblUnitOtticaCddvd = new JLabel(
				"Unit\u00E0 Ottica CD/DVD Masterizzatore");
		lblUnitOtticaCddvd.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblUnitOtticaCddvd = new GridBagConstraints();
		gbc_lblUnitOtticaCddvd.anchor = GridBagConstraints.EAST;
		gbc_lblUnitOtticaCddvd.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnitOtticaCddvd.gridx = 0;
		gbc_lblUnitOtticaCddvd.gridy = ultimo;
		add(lblUnitOtticaCddvd, gbc_lblUnitOtticaCddvd);

		ButtonGroup groupDvd = new ButtonGroup();
		JRadioButton[] rdbtnDvd = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("DVD") == 0) {
				rdbtnDvd[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnDvd[i].setBackground(Color.WHITE);
				rdbtnDvd[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnDvd = new GridBagConstraints();
				gbc_rdbtnDvd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnDvd.gridx = 1;
				gbc_rdbtnDvd.gridy = ultimo++;
				add(rdbtnDvd[i], gbc_rdbtnDvd);
				groupDvd.add(rdbtnDvd[i]);
			}
		}

		ultimo++;
		JLabel lblEstenzioneGaranzia = new JLabel("Estenzione Garanzia");
		lblEstenzioneGaranzia.setFont(new Font("Toledo", Font.BOLD, 11));
		GridBagConstraints gbc_lblEstenzioneGaranzia = new GridBagConstraints();
		gbc_lblEstenzioneGaranzia.anchor = GridBagConstraints.EAST;
		gbc_lblEstenzioneGaranzia.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstenzioneGaranzia.gridx = 0;
		gbc_lblEstenzioneGaranzia.gridy = ultimo;
		add(lblEstenzioneGaranzia, gbc_lblEstenzioneGaranzia);

		ButtonGroup groupWar = new ButtonGroup();
		JRadioButton[] rdbtnWar = new JRadioButton[componenti.length];
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo("WAR") == 0) {
				rdbtnWar[i] = new JRadioButton(componenti[i].getNome()
						+ "\n Prezzo: " + componenti[i].getPrezzo());
				rdbtnWar[i].setBackground(Color.WHITE);
				rdbtnWar[i].setFont(new Font("Toledo", Font.PLAIN, 11));
				GridBagConstraints gbc_rdbtnWar = new GridBagConstraints();
				gbc_rdbtnWar.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnWar.gridx = 1;
				gbc_rdbtnWar.gridy = ultimo++;
				add(rdbtnWar[i], gbc_rdbtnWar);
				groupWar.add(rdbtnWar[i]);
			}
		}

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
