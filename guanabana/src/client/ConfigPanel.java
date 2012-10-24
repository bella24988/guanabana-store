package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modello.Componente;
import modello.Configurazione;

public class ConfigPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Componente[] componenti;
	private PreventivoController preventivoController;
	private Configurazione[] configurazione;
	//numero massimo di componenti configurabili rispettivamente per laptop, desktop e server
	private static int[] maxElementiConfig = {6,10,10};
	//doppi array contenente i tipi di componenti configurabili rispettivamente per laptop, desktop e server
	private static String[] lblComp = {"Laptop","Desktop","Server"};
	private static String[][] tipoComponenti = {
		{"RAM", "CPU", "HD0", "GPU", "DVD", "WAR" },
		{"RAM", "CPU", "MOU", "HD0", "HDD", "GPU", "DVD", "WAR", "KEY", "MON"},
		{"RAM", "CPU", "MLC", "HD0", "HDD", "HDD", "HDD", "DVD", "PCI", "WAR"}
	};
	private static String[][] labels = {
		{"Memoria RAM:", "Processore:", "Hard Disk (obbligatorio):", 
			"Scheda Grafica:", "Unitˆ ottica:", "Garanzia:"},
		{"Memoria RAM:", "Processore:", "Mouse:",
			"Hard Disk (obbligatorio):", "Hard Disk (opzionale):",
			"Scheda Grafica:", "Unitˆ ottica:", "Garanzia:", "Tastiera:",
			"Monitor:" },
		{"Memoria RAM:", "Processore:", "Multilevel Cell:",
			"Hard Disk (obbligatorio):", "Hard Disk (opzionale 1):", "Hard Disk (opzionale2):", 
			"Hard Disk (opzionale 3):", "Unitˆ ottica:", "Scheda PCI:", "Garanzia:"}
	};

	public ConfigPanel(Componente[] componenti, String[] configStandard,
			PreventivoController preventivoController, int computerType) {
		super();
		this.setComponenti(componenti);
		this.setPreventivoController(preventivoController);

		for (int k = 0; k < configStandard.length; k++) {
			System.out.print("Conf " + k + " - " + configStandard[k]);
		}
		// Definisco un array di configurazione
		configurazione = new Configurazione[maxElementiConfig[computerType]];

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

		// window style
		JLabel lblTitle = new JLabel("Acquista " + lblComp[computerType] + ": scegli configurazione");
		lblTitle.setForeground(new Color(0, 153, 0));
		lblTitle.setFont(new Font("Toledo", Font.BOLD, 14));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.gridwidth = 2;
		gbc_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 0;
		add(lblTitle, gbc_lbl);
		int ultimo = 2;
		System.out.println("Lunghezza componenti" + tipoComponenti[computerType].length);
		ButtonGroup[] group = new ButtonGroup[tipoComponenti[computerType].length];
		for (int indiceComponenti = 0; indiceComponenti < tipoComponenti[computerType].length; indiceComponenti++) {

			JLabel lblComponents = new JLabel(labels[computerType][indiceComponenti]);
			lblComponents.setFont(new Font("Toledo", Font.BOLD, 11));
			GridBagConstraints gbc_lblComponents = new GridBagConstraints();
			gbc_lblComponents.anchor = GridBagConstraints.EAST;
			gbc_lblComponents.insets = new Insets(0, 0, 5, 5);
			gbc_lblComponents.gridx = 0;
			gbc_lblComponents.gridy = ultimo;
			add(lblComponents, gbc_lblComponents);
			// Radio Button
			int i;

			ButtonGroup groupComponents = new ButtonGroup();
			JRadioButton[] rdbtnComponents = new JRadioButton[componenti.length];
			for (i = 0; i < componenti.length; i++) {
				if (componenti[i].getTipo().compareTo(
						tipoComponenti[computerType][indiceComponenti]) == 0) {
					// Setta la configurazione di default
					rdbtnComponents[i] = configButtons(rdbtnComponents[i], componenti[i],
							configStandard[indiceComponenti]);

					rdbtnComponents[i].setActionCommand(tipoComponenti[computerType][indiceComponenti] + i);

					// Griglia, nettamente grafico
					GridBagConstraints grid_radio = new GridBagConstraints();
					grid_radio.insets = new Insets(0, 0, 5, 5);
					grid_radio.gridx = 1;
					grid_radio.gridy = ultimo++;
					add(rdbtnComponents[i], grid_radio);

					// Ragruppamento dei buttons
					groupComponents.add(rdbtnComponents[i]);

					// Controller
					rdbtnComponents[i].addActionListener(preventivoController);

					// Mettilo più bello io non c'è l'ho fatta
					if (configStandard[indiceComponenti]
							.compareTo(componenti[i].getCodice()) == 0) {
						preventivoController.setElementiConfigurazione(
								indiceComponenti, componenti[i].getCodice(),
								componenti[i].getNome(),
								componenti[i].getPrezzo());
					}

				}
			}
			ultimo++;
		}

	}

	private JRadioButton configButtons(JRadioButton rdbtn,
			Componente componente, String configStandard) {
		System.out.println("configurazionestandard " + configStandard
				+ "getcodice " + componente.getCodice());
		if (configStandard.compareTo(componente.getCodice()) == 0) {
			componente.setPrezzo(0);
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
			rdbtn.setSelected(true);
			System.out.println("prova in configButtons" + componente.getNome()
					+ "\n Prezzo: " + componente.getPrezzo());
		} else {
			rdbtn = new JRadioButton(componente.getNome() + "\n Prezzo: "
					+ componente.getPrezzo());
		}
		rdbtn.setBackground(Color.WHITE);
		rdbtn.setFont(new Font("Toledo", Font.PLAIN, 11));

		return rdbtn;
	}

	private int contaComponentiGruppo(String tipo, Componente[] componenti) {
		int i, num = 0;
		for (i = 0; i < componenti.length; i++) {
			if (componenti[i].getTipo().compareTo(tipo) == 0) {
				num++;
			}

		}
		return num;

	}

	public Componente[] getComponenti() {
		return componenti;
	}

	public void setComponenti(Componente[] componenti) {
		this.componenti = componenti;
	}

	public PreventivoController getPreventivoController() {
		return preventivoController;
	}

	public void setPreventivoController(
			PreventivoController preventivoController) {
		this.preventivoController = preventivoController;
	}

	public Configurazione[] getConfigurazione() {
		return configurazione;
	}

	public void setConfigurazione(Configurazione[] configurazione) {
		this.configurazione = configurazione;
	}

}
