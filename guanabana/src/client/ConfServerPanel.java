package client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import modello.Componente;
import modello.Configurazione;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ConfServerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4215414321261368512L;
	private Componente[] componenti;
	private PreventivoController preventivoController;
	private Configurazione[] configurazione;
	static int maxElementiConfig = 10;

	/**
	 * Create the panel.
	 */
	/**
	 * @param componenti
	 */
	public ConfServerPanel(Componente[] componenti, String[] configStandard,
			PreventivoController preventivoController) {
		this.setComponenti(componenti);

		// Definisco un array di configurazione
		configurazione = new Configurazione[maxElementiConfig];

		// Definizione generale della finestra
		setBackground(Color.WHITE); // Colore di sfondo

		// Griglia generale
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 147, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 25, 25, 25, 25, 25, 25,
				25, 0, 25 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Il tipo della finestra. Orientation Info
		JLabel lblServer = new JLabel("Acquista Server: scegli configurazione");
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
				// Setta la configurazione di default
				rdbtnRam[i] = configButtons(rdbtnRam[i], componenti[i],
						configStandard[0]);

				rdbtnRam[i].setActionCommand("RAM" + i);

				// Griglia, nettamente grafico
				GridBagConstraints gbc_rdbtnRam = new GridBagConstraints();
				gbc_rdbtnRam.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnRam.gridx = 1;
				gbc_rdbtnRam.gridy = ultimo++;
				add(rdbtnRam[i], gbc_rdbtnRam);

				// Ragruppamento dei buttons
				groupRam.add(rdbtnRam[i]);

				// Controller
				rdbtnRam[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[0].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(0,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}

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
				// Configurazione della lista dei button radio
				rdbtnCpu[i] = configButtons(rdbtnCpu[i], componenti[i],
						configStandard[1]);
				rdbtnCpu[i].setActionCommand("CPU" + i);

				GridBagConstraints gbc_rdbtnCpu = new GridBagConstraints();
				gbc_rdbtnCpu.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnCpu.gridx = 1;
				gbc_rdbtnCpu.gridy = ultimo++;
				add(rdbtnCpu[i], gbc_rdbtnCpu);
				groupCpuBtn.add(rdbtnCpu[i]);
				// Controller
				rdbtnCpu[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[1].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(1,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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
				rdbtnPci[i] = configButtons(rdbtnPci[i], componenti[i],
						configStandard[2]);
				rdbtnPci[i].setActionCommand("PCI" + i);

				GridBagConstraints gbc_rdbtnPci = new GridBagConstraints();
				gbc_rdbtnPci.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnPci.gridx = 1;
				gbc_rdbtnPci.gridy = ultimo++;
				add(rdbtnPci[i], gbc_rdbtnPci);
				groupPci.add(rdbtnPci[i]);
				rdbtnPci[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[2].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(2,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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

				rdbtnMon[i] = configButtons(rdbtnMon[i], componenti[i],
						configStandard[3]);
				rdbtnMon[i].setActionCommand("MLC" + i);

				GridBagConstraints gbc_rdbtnMon = new GridBagConstraints();
				gbc_rdbtnMon.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnMon.gridx = 1;
				gbc_rdbtnMon.gridy = ultimo++;
				add(rdbtnMon[i], gbc_rdbtnMon);
				groupMon.add(rdbtnMon[i]);

				rdbtnMon[i].addActionListener(preventivoController);
				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[3].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(3,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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

			if (componenti[i].getTipo().compareTo("HD0") == 0
					&& componenti[i].getNome().compareTo("Nessuno") != 0) {
				rdbtnHdd[i] = configButtons(rdbtnHdd[i], componenti[i],
						configStandard[4]);

				rdbtnHdd[i].setActionCommand("HDD" + i);

				GridBagConstraints gbc_rdbtnHdd = new GridBagConstraints();
				gbc_rdbtnHdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd.gridx = 1;
				gbc_rdbtnHdd.gridy = ultimo++;
				add(rdbtnHdd[i], gbc_rdbtnHdd);
				groupHdd.add(rdbtnHdd[i]);

				rdbtnHdd[i].addActionListener(preventivoController);
				if (configStandard[4].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(4,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());

				}
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
				rdbtnHdd1[i] = configButtons(rdbtnHdd1[i], componenti[i],
						configStandard[5]);

				rdbtnHdd1[i].setActionCommand("HD1" + i);

				GridBagConstraints gbc_rdbtnHdd1 = new GridBagConstraints();
				gbc_rdbtnHdd1.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd1.gridx = 1;
				gbc_rdbtnHdd1.gridy = ultimo++;
				add(rdbtnHdd1[i], gbc_rdbtnHdd1);
				groupHdd1.add(rdbtnHdd1[i]);
				rdbtnHdd1[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[5].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(5,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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
				rdbtnHdd2[i] = configButtons(rdbtnHdd2[i], componenti[i],
						configStandard[6]);

				rdbtnHdd2[i].setActionCommand("HD2" + i);

				GridBagConstraints gbc_rdbtnHdd2 = new GridBagConstraints();
				gbc_rdbtnHdd2.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd2.gridx = 1;
				gbc_rdbtnHdd2.gridy = ultimo++;
				add(rdbtnHdd2[i], gbc_rdbtnHdd2);
				groupHdd2.add(rdbtnHdd2[i]);
				rdbtnHdd2[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[6].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(6,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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
				rdbtnHdd3[i] = configButtons(rdbtnHdd3[i], componenti[i],
						configStandard[7]);

				rdbtnHdd3[i].setActionCommand("HD3" + i);

				GridBagConstraints gbc_rdbtnHdd3 = new GridBagConstraints();
				gbc_rdbtnHdd3.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnHdd3.gridx = 1;
				gbc_rdbtnHdd3.gridy = ultimo++;
				add(rdbtnHdd3[i], gbc_rdbtnHdd3);
				groupHdd3.add(rdbtnHdd3[i]);
				rdbtnHdd3[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[7].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(7,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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
				rdbtnDvd[i] = configButtons(rdbtnDvd[i], componenti[i],
						configStandard[8]);

				rdbtnDvd[i].setActionCommand("DVD" + i);

				GridBagConstraints gbc_rdbtnDvd = new GridBagConstraints();
				gbc_rdbtnDvd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnDvd.gridx = 1;
				gbc_rdbtnDvd.gridy = ultimo++;
				add(rdbtnDvd[i], gbc_rdbtnDvd);
				groupDvd.add(rdbtnDvd[i]);
				rdbtnDvd[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[8].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(8,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
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
				rdbtnWar[i] = configButtons(rdbtnHdd[i], componenti[i],
						configStandard[9]);

				rdbtnWar[i].setActionCommand("WAR" + i);

				GridBagConstraints gbc_rdbtnWar = new GridBagConstraints();
				gbc_rdbtnWar.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnWar.gridx = 1;
				gbc_rdbtnWar.gridy = ultimo++;
				add(rdbtnWar[i], gbc_rdbtnWar);
				groupWar.add(rdbtnWar[i]);
				rdbtnWar[i].addActionListener(preventivoController);

				// Mettilo più bello io non c'è l'ho fatta
				if (configStandard[9].compareTo(componenti[i].getCodice()) == 0) {
					preventivoController.setElementiConfigurazione(9,
							componenti[i].getCodice(), componenti[i].getNome(),
							componenti[i].getPrezzo());
				}
			}
		}

	}

	private JRadioButton configButtons(JRadioButton rdbtn,
			Componente componente, String configStandard) {
		if (configStandard.compareTo(componente.getCodice()) == 0) {
			componente.setPrezzo(0);
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
			rdbtn.setSelected(true);
		} else {
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
		}
		rdbtn.setBackground(Color.WHITE);
		rdbtn.setFont(new Font("Toledo", Font.PLAIN, 11));

		return rdbtn;
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

	/**
	 * @return the configurazione
	 */
	public Configurazione[] getConfigurazione() {
		return configurazione;
	}

	/**
	 * @param configurazione
	 *            the configurazione to set
	 */
	public void setConfigurazione(Configurazione[] configurazione) {
		this.configurazione = configurazione;
	}

}
